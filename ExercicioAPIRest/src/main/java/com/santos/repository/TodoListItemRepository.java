package com.santos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santos.domain.TodoList;

public interface TodoListItemRepository extends JpaRepository<TodoList, Integer>{

}
