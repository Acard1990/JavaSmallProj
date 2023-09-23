package integrationTest;

import com.stormwind.scottOnboarding.entity.AppUser;
import com.stormwind.scottOnboarding.service.appUserService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import com.stormwind.scottOnboarding.controller.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.springframework.boot.test.web.server.LocalServerPort;
import java.util.UUID;

public class AppUserSteps {

    @Autowired
    private appUserService appUserService;

    @Autowired
    private AppUserController appUserController;

    private Response response;
    private static String jsonString;

    @LocalServerPort
    private int port;

    UUID userUUID = UUID.fromString("2b95a194-91e2-4a40-b605-d49034311347");
    UUID userUUID1 = UUID.fromString("2b95a194-91e2-4a40-b605-d49034311348");
    UUID userUUID2 = UUID.fromString("2b95a194-91e2-4a40-b605-d49034311349");
    AppUser testUser = new AppUser(userUUID,"test","user","test.user@email.com");
    AppUser testUser1 = new AppUser(userUUID1,"test1","user","test1.user@email.com");
    AppUser testUser2 = new AppUser(userUUID2,"test2","user","test2.user@email.com");

    @Given("a user exist")
    public void userExist() {
        appUserService.saveAppUser(testUser);
    }

    @Given("Three users exist")
    public void threeUsersExist() {
        appUserService.saveAppUser(testUser);
        appUserService.saveAppUser(testUser1);
        appUserService.saveAppUser(testUser2);
    }

    @When("the {word} returns a 200")
    public void makeSpecifiedRequestToController(String request) throws JSONException {
        if (request.equals("createUser")) {
            // step setup
            JSONObject userReqBody = new JSONObject();
            userReqBody.put("id", userUUID1);
            userReqBody.put("firstName", "test");
            userReqBody.put("lastName", "user");
            userReqBody.put("email", "test.user@email.com");
            String reqBody = userReqBody.toString();
            given()
                    .contentType(ContentType.JSON)
                    .body(reqBody).
                    port(port).
            when().post("/appUsers").
                    then().statusCode(200);
        }
        if  (request.equals("fetchAppUsersList")) {
            given()
                    .contentType(ContentType.JSON)
                    .port(port).
                    when().

                    get("/appUsers").
            then().
                    statusCode(200);
        }
        if  (request.equals("updateAppUser")) {
            JSONObject userReqBody = new JSONObject();
            userReqBody.put("id", userUUID);
            userReqBody.put("firstName", "updatedTest1");
            userReqBody.put("lastName", "user");
            userReqBody.put("email", "test.user@email.com");
            String reqBody = userReqBody.toString();
            given()
                    .contentType(ContentType.JSON)
                    .port(port)
                    .body(reqBody).
            when().
                    put("/appUsers/update/" + userUUID).
            then().
                    statusCode(200);
        }
        if  (request.equals("deleteAppUserById")) {
            given()
                    .contentType(ContentType.JSON)
                    .port(port).
            when().
                    delete("/appUsers/delete/" + userUUID).
            then().
                    statusCode(200);
        }
    }

    @Given("a user is created the values are correct")
    public void saveUserValidateInputs() throws JSONException {
        JSONObject userReqBody = new JSONObject();
        userReqBody.put("id", userUUID1);
        userReqBody.put("firstName", "test");
        userReqBody.put("lastName", "user");
        userReqBody.put("email", "test.user@email.com");
        String reqBody = userReqBody.toString();
        given()
                .contentType(ContentType.JSON)
                .port(port)
                .body(reqBody).
        when()
                .post("/appUsers")
        .then()
                .statusCode(200)
                .assertThat()
                .body("firstName", equalTo("test"))
                .body("lastName", equalTo("user"))
                .body("email", equalTo("test.user@email.com"));
    }
    @Then("the fetchAppUsersList request returns 3 results")
    public void fetchAppUsersListForThree() {
        given()
                .contentType(ContentType.JSON)
                .port(port).
        when()
                .get("/appUsers")
                .then()
                .statusCode(200)
                .assertThat()
                .body("size()", is(3));
        }


    @Then("the updateAppUser will update the firstName")
    public void updateAppUserFirstName() throws JSONException {
        JSONObject userReqBody = new JSONObject();
        userReqBody.put("id", userUUID);
        userReqBody.put("firstName", "updatedTest1");
        userReqBody.put("lastName", "user");
        userReqBody.put("email", "test.user@email.com");
        String reqBody = userReqBody.toString();
        given()
                .contentType(ContentType.JSON)
                .port(port)
                .body(reqBody).
        when()
                .put("/appUsers/update/" + userUUID)
                .then()
                .statusCode(200)
                .assertThat()
                .body("firstName", equalTo("updatedTest1")).log();

    }

    @Then("the deleteAppUserById will remove the user")
    public void deleteAppUserById() {
        RestAssured.registerParser("text/plain", Parser.TEXT);
        given()
                .contentType(ContentType.JSON)
                .port(port).
        when()
                .delete("/appUsers/delete/" + userUUID)
        .then()
                .statusCode(200)
                .assertThat()
                .body(containsString("Deleted Successfully"));
    }
}

