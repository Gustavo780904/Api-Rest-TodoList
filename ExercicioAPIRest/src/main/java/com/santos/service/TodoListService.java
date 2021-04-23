package com.santos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.santos.domain.TodoList;
import com.santos.repository.TodoListRepository;

@Service
public class TodoListService {
	@Autowired
	TodoListRepository repository;
	
	public List<TodoList> getAll(){
		return repository.findAll();
	}
	public TodoList insert (TodoList items) {
		return repository.save(items);
	}
	public TodoList getById(Integer id) {
		return repository.findById(id).orElseThrow(()->new ListaNaoEncontradaException(id));
	}
	
	public TodoList update (TodoList items) {
		return repository.save(items);
	}
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
}
