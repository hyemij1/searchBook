package com.example.searchBook.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.searchBook.book.model.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Integer>, HistoryRepositoryCustom {

}
