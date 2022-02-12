package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MyEntityRepository extends JpaRepository<MyEntity, Long>, QuerydslPredicateExecutor<MyEntity>{

}