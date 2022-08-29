package com.example.pagaassgn.auth;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredRepository extends CrudRepository<UserCred, Long> {
}
