package com.te.springrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import com.te.springrest.beans.Items_info;
@Repository
public class AmazonDaoImpl implements AmazonDao{

	public boolean addItem(Items_info item) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("amazon");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(item);
			transaction.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean removeItem(Integer id) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("amazon");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Items_info item = manager.find(Items_info.class, id);
			manager.remove(item);
			transaction.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Items_info searchItem(Integer id) {
		Items_info item = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("amazon");
			EntityManager manager = factory.createEntityManager();
			item = manager.find(Items_info.class, id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	public List<Items_info> getAllItems() {
		List<Items_info> list = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("amazon");
			EntityManager manager = factory.createEntityManager();
			String sql = "from Item";
			Query query = manager.createQuery(sql);
			list  = query.getResultList();
			return list;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	

	@Override
	public boolean updateItem(Items_info item) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("amazon");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			System.out.println("id "+item.getId());
			Items_info originalItem = manager.find(Items_info.class, item.getId());
			
			if(item.getName() != null && item.getName() != "") {
				originalItem.setName(item.getName());
			}

			transaction.commit();
			return true;
			
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Items_info getData(Integer id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("amazon");
		EntityManager manager = factory.createEntityManager();
		Items_info bean = manager.find(Items_info.class, id);
		return bean;
	}

}
