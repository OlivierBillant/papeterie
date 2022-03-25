package model.dal;

import java.util.List;


public interface InterfaceDAO<T> {
	
	public void delete(int id);
	public List<T> selectAll();
	public T selectBy(int id);
	public void update(T t);
	public void insert(T t);
}
