package com.te.springrest.service;

import java.util.List;

import com.te.springrest.beans.Items_info;



public interface AmazonService {
public boolean addItem(Items_info item);
public Items_info getData(Integer id);
	public boolean removeItem(Integer id);
	
	public Items_info searchItem(Integer id);
	
	public List<Items_info> getAllItems();
	
	public boolean updateItem(Items_info item);

}
