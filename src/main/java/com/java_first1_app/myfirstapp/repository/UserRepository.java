package com.java_first1_app.myfirstapp.repository;

import com.java_first1_app.myfirstapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {}
