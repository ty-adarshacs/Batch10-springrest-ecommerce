package com.te.springrest.dao;

import java.util.List;

import com.te.springrest.beans.Items_info;



public interface AmazonDao {
public Items_info getData(Integer id);
		
public boolean addItem(Items_info item);
	
	public boolean removeItem(Integer id);
	
	public Items_info searchItem(Integer id);
	
	public List<Items_info> getAllItems();
	
	public boolean updateItem(Items_info item);
}
