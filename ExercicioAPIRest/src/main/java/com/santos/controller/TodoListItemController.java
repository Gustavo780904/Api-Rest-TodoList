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

import com.santos.domain.TodoListItem;
import com.santos.service.TodoListItemService;

@RestController
@RequestMapping("/item")
public class TodoListItemController {
	@Autowired
	private TodoListItemService itemService;

	@GetMapping
	public List<TodoListItem> list() {
		return itemService.getAll();
	}

	@PostMapping
	public TodoListItem create(@RequestBody TodoListItem item) {
		return itemService.insert(item);
	}

	@GetMapping("/{id}")
	public TodoListItem read(@PathVariable Integer id) {
		return itemService.getById(id);
	}

	@PutMapping("/{id}")
	public TodoListItem update(@PathVariable Integer id, @RequestBody TodoListItem attrs) {
		TodoListItem item = itemService.getById(id);
		item.setNomeDoItem(attrs.getNomeDoItem());
		return  itemService.update(item);
	}

	@DeleteMapping("/{id}")
	void delete(@PathVariable Integer id) {
		itemService.delete(id);
	}

}
