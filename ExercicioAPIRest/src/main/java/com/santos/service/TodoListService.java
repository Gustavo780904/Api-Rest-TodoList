package com.santos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.santos.domain.TodoList;
import com.santos.repository.TodoListItemRepository;

@Service
public class TodoListService {
	@Autowired
	TodoListItemRepository repository;
	
	public List<TodoList> todos(){
		return repository.findAll();
	}
	public TodoList novo (TodoList items) {
		return repository.save(items);
	}
	public TodoList todoList(Integer id) {
		return repository.findById(id).orElseThrow(()->new ListaNaoEncontradaException(id));
	}
	public TodoList atualiza (TodoList items, Integer id) {
		items.setId(id);
		return repository.save(items);
	}
	public void deleteTodoList(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
}
