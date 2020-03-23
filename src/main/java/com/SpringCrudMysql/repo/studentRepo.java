package com.SpringCrudMysql.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringCrudMysql.controller.model.studentModel;

@Repository
public interface studentRepo extends JpaRepository<studentModel, Integer>{

}
