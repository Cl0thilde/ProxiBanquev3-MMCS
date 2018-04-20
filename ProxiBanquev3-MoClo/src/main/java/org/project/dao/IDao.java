package org.project.dao;

import java.util.List;

public interface IDao<T> {

	public int create(T element);

	public int update(T element);

	public int delete(T element);

	public T readById(int id);

	public List<T> readAll();

}
