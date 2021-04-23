package com.santos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santos.domain.TodoList;
import com.santos.service.TodoListService;

@RestController
@RequestMapping("todoList")
public class TodoListController {
	@Autowired
	private TodoListService service;

	@GetMapping
	public List<TodoList> all() {
		return service.todos();
	}

	@PostMapping
	public TodoList novo(@RequestBody TodoList todoList) {
		return service.novo(todoList);
	}

	@GetMapping("/{id}")
	public TodoList one(@PathVariable Integer id) {
		return service.todoList(id);
	}

	@PutMapping("/{id}")
	public TodoList replaceTodoList(@RequestBody TodoList todoList, @PathVariable Integer id) {
		return service.atualiza(todoList, id);
	}

	@DeleteMapping("/{id}")
	void deleteTodoList(@PathVariable Integer id) {
		service.deleteTodoList(id);
	}
}
