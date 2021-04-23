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
import com.santos.domain.TodoListItem;
import com.santos.service.TodoListItemService;
import com.santos.service.TodoListService;

@RestController
@RequestMapping("/lista")
public class TodoListController {
	@Autowired
	private TodoListItemService itemService;
	@Autowired
	private TodoListService todoService;

	@GetMapping
	public List<TodoList> list() {
		return todoService.getAll();
	}

	@PostMapping
	public TodoList create(@RequestBody TodoList todoList) {
		return todoService.insert(todoList);
	}

	@PostMapping("/{listId}/item")
	public TodoListItem createItem(@PathVariable Integer listId, @RequestBody TodoListItem item) {
		TodoList lista = todoService.getById(listId);
		lista.addItem(item);
		return itemService.insert(item);
	}

	@GetMapping("/{id}")
	public TodoList read(@PathVariable Integer id) {
		return todoService.getById(id);
	}

	@PutMapping("/")
	public TodoList update(@RequestBody TodoList todoList) {
		return todoService.update(todoList);
	}
	@PutMapping("/{id}")
	public TodoList update(@PathVariable Integer id, @RequestBody TodoList attrs) {
		TodoList lista = todoService.getById(id);
		lista.setNome(attrs.getNome());
		return  todoService.update(lista);
	}

	@DeleteMapping("/{id}")
	void delete(@PathVariable Integer id) {
		todoService.delete(id);
	}

}
