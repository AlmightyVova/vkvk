package com.example.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<JUser, Integer> {
}
