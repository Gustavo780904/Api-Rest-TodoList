package com.santos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class TodoList implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;

	@OneToMany(mappedBy = "lista")
	@JsonManagedReference
	private List<TodoListItem> items = new ArrayList<TodoListItem>();

	public TodoList() {
	}

	public TodoList(Integer id, String nome, List<TodoListItem> items) {
		super();
		this.id = id;
		this.nome = nome;
		this.items = items;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<TodoListItem> getItems() {
		return items;
	}

	public void addItem(TodoListItem item) {
//		item.setLista();
		item.setLista(this);
		this.items.add(item);
	}

	public void removeItem(TodoListItem item) {
		this.items.remove(item);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TodoList other = (TodoList) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
