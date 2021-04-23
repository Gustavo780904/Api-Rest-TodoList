package com.santos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.domain.TodoList;
import com.santos.domain.TodoListItem;
import com.santos.repository.TodoListItemRepository;

@Service
public class TodoListItemService {
	@Autowired
	TodoListItemRepository repository;
	
//	public List<TodoListItem> item(){
//		return repository.saveAll();
//	}
//	public TodoListItem novo (TodoListItem item) {
//		return repository.All(item);
//	}
}
