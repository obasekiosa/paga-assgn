package com.example.pagaassgn.pastebin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastebinRepository extends CrudRepository<Pastebin, String>{
}
