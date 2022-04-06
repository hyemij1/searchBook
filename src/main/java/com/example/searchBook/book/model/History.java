package com.example.searchBook.book.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "TBL_HIST")
@Getter
@Setter
@ToString
public class History {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "userId")
	private Long userId;
	@Column(name = "keyword")
	private String keyword;
	@Column(name = "inputdate")
	@CreatedDate
	private LocalDateTime inputdate;

}
