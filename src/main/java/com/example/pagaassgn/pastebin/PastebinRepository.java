package com.example.pagaassgn.pastebin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PastebinRepository extends CrudRepository<Pastebin, String> {

    Optional<Pastebin> findByIdIgnoreCaseAndExpiryIsNullOrExpiryGreaterThanEqual(String id, Date expiryDate);

    default Optional<Pastebin> findNonExpiredById(String id, Date expiryDate) {
        return findByIdIgnoreCaseAndExpiryIsNullOrExpiryGreaterThanEqual(id, expiryDate);
    }

    List<Pastebin> deleteAllByExpiryLessThan(Date expiryDate);
    default List<Pastebin> deleteExpiredBins(Date expiryDate) {
        return deleteAllByExpiryLessThan(expiryDate);
    }
}
