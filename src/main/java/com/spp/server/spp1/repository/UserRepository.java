package com.spp.server.spp1.repository;

import com.spp.server.spp1.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    List<User> findByAgeAfter(int age);
}
