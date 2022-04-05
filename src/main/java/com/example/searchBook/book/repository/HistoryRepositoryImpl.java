package com.example.searchBook.book.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.example.searchBook.book.model.History;

public class HistoryRepositoryImpl implements HistoryRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<History> findByUserId(Long userId) {
		TypedQuery<History> query = entityManager.createQuery("select h from History h where h.userId = :userId order by h.inputdate desc", History.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}
	
	@Override
	public void saveHistory(History history) {
		entityManager.persist(history);
	}

}
