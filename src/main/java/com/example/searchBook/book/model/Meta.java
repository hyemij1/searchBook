package com.example.searchBook.book.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Meta {

	private String isEnd;
	private int pageableCount;
	private int totalCount;

}