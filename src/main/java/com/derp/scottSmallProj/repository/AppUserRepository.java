package com.derp.scottSmallProj.repository;
import java.util.UUID;

import com.derp.scottSmallProj.entity.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, UUID>{

}


