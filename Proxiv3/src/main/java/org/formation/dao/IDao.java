package org.formation.dao;

import java.util.List;

public interface IDao<T> {

	public void create(T element);

	public void update(T element);

	public void delete(T element);

	public T readById(int id);

	public List<T> readAll();
}
