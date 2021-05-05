package com.te.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springrest.beans.Items_info;
import com.te.springrest.dao.AmazonDaoImpl;

@Service

public class AmazonServiceImpl implements AmazonService {
	@Autowired
	AmazonDaoImpl amazonDao;
	
	

	@Override
	public boolean addItem(Items_info item) {
		boolean result = amazonDao.addItem(item) ;
		return result;
	}

	@Override
	public boolean removeItem(Integer id) {
		boolean result = amazonDao.removeItem(id);
		return result;
	}

	@Override
	public Items_info searchItem(Integer id) {
		Items_info item = amazonDao.searchItem(id);
		return item;
	}

	@Override
	public List<Items_info> getAllItems() {
		List<Items_info> list = amazonDao.getAllItems();
		return list;
	}

	@Override
	public boolean updateItem(Items_info item) {
		boolean result = amazonDao.updateItem(item);
		return result;
	}

	@Override
	public Items_info getData(Integer id) {
		
		return amazonDao.getData(id);
	}

}
