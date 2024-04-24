package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.classDetails;

@Repository
public interface classDetailRepository extends JpaRepository<classDetails, Long>{

}
