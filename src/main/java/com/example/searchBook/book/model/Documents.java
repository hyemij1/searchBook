package com.example.searchBook.book.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Documents {

	private List<String> authors;
	private String contents;
	private String datetime;
	private String isbn;
	private int price;
	private String publisher;
	private int salePrice;
	private String status;
	private String thumbnail;
	private String title;
	private List<String> translators;
	private String url;

}