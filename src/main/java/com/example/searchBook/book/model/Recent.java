package com.example.searchBook.book.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Recent {

	private String keyword;
	private long cnt;

	public Recent(String keyword, long cnt) {
		this.keyword = keyword;
		this.cnt = cnt;
	}

}
