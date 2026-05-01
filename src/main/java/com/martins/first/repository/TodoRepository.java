package com.martins.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.martins.first.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
