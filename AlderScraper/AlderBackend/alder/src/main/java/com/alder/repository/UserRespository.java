package com.alder.repository;
import org.springframework.stereotype.Repository;

import com.alder.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRespository extends JpaRepository <User, String>{

}
