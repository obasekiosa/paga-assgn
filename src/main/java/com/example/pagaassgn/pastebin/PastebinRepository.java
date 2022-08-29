package com.example.pagaassgn.pastebin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface PastebinRepository extends CrudRepository<Pastebin, String> {

    Optional<Pastebin> findByIdIgnoreCaseAndExpiryIsGreaterThanEqual(String id, Date expiryDate);

    default Optional<Pastebin> findNonExpiredById(String id, Date expiryDate) {
        return findByIdIgnoreCaseAndExpiryIsGreaterThanEqual(id, expiryDate);
    }
}
