package com.reactspringbootcrudexample.pkg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reactspringbootcrudexample.pkg.models.User;

public interface UserRepo extends JpaRepository<User, Long>{

}
