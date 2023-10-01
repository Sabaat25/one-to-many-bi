package com.jsp.person.bankacc;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonAcc {
public static void main(String[] args) {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vishu");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	Person person=new Person();
	person.setName("Sabaat");
	person.setEmail("sabaat25@mail.com");
	
	Account a1= new Account();
	a1.setAcc_no(1246790880876l);
	a1.setIfsc("ISHTFJUKHG");
	
	Account a2=new Account();
	a2.setAcc_no(546789543998l);
	a2.setIfsc("EHKJSHJLJ");
	
	Account a3=new Account();
	a3.setAcc_no(8765448965557l);
	a3.setIfsc("GSKKJHYFGH");
	
	List<Account>account= new ArrayList<Account>();
	account.add(a1);
	account.add(a2);
	account.add(a3);
	
	
	person.setAccounts(account);
	a1.setPerson(person);
	a2.setPerson(person);
	a3.setPerson(person);
	
	entityTransaction.begin();
	entityManager.persist(person);
	
	entityTransaction.commit();
}
}
