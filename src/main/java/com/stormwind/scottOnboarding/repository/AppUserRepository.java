package com.stormwind.scottOnboarding.repository;
import java.util.List;
import java.util.UUID;

import com.stormwind.scottOnboarding.entity.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, UUID>{

}


