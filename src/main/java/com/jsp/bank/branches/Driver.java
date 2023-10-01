package com.jsp.bank.branches;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Driver {
public static void main(String[] args) {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vishu");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	Bank bank=new Bank();
	bank.setName("HDFC");
	
	Branch b1=new Branch();
	b1.setAddress("NERUL");
	
	Branch b2=new Branch();
	b2.setAddress("VASHI");
	
	Branch b3=new Branch();
	b3.setAddress("KHARGHAR");
	
	Branch b4=new Branch();
	b4.setAddress("BELAPUR");
	
	List<Branch> branches=new ArrayList<Branch>();
	
    branches.add(b1);
    branches.add(b2);
    branches.add(b3);
    branches.add(b4);
    
    bank.setBranches(branches);
    b1.setBank(bank);
    b2.setBank(bank);
    b3.setBank(bank);
    b4.setBank(bank);
    
    entityTransaction.begin();
    entityManager.persist(bank);
    entityManager.persist(b1);
    entityManager.persist(b2);
    entityManager.persist(b3);
    entityManager.persist(b4);
    entityTransaction.commit();


}
}
