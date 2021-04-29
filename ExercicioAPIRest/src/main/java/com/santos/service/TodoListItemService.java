package com.santos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.domain.TodoListItem;
import com.santos.repository.TodoListItemRepository;

@Service
public class TodoListItemService {
	@Autowired
	TodoListItemRepository repository;

	public TodoListItem allFromList(Integer listItem) {
		return (TodoListItem) repository.findAll();
	}

	public TodoListItem novo(TodoListItem nomeDoItem) {

		return repository.save(nomeDoItem);
	}

	public List<TodoListItem> getAll() {
		return repository.findAll();
	}

	public TodoListItem insert(TodoListItem item) {
		return repository.save(item);
	}

	public TodoListItem getById(Integer id) {
//		return repository.findById(id).orElseThrow(()->new ItemNaoEncontradaException(id));
		return null;
	}

	public TodoListItem update(TodoListItem item) {
		return repository.save(item);
	}

	public void delete(Integer id) {
		repository.deleteById(id);

	}
}
