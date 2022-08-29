package com.example.pagaassgn.kgs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeyRepository extends CrudRepository<Key, String> {

    List<Key> findByIdIn(List<String> ids);
}
