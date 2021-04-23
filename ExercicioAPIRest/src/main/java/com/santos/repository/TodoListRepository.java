package com.santos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santos.domain.TodoList;
@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Integer>{

}
