package com.restapi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.app.entity.Component;

public interface ComponentRepository extends JpaRepository<Component, Long>{

}
