package com.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.User;
@Repository
public interface Userrepo extends JpaRepository<User, Integer> {

}
