package com.santos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santos.domain.TodoList;

public interface TodoListRepository extends JpaRepository<TodoList, Integer>{

}
