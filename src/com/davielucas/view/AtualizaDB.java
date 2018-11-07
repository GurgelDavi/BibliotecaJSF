package com.davielucas.view;

import javax.persistence.EntityManager;

import com.davielucas.controller.ResourcePersistence;

public class AtualizaDB {
	public static void main(String[] args) {
		EntityManager em = ResourcePersistence.getEntityManager();
		PopulateBank pop = new PopulateBank();
		pop.populate();
	}
}
