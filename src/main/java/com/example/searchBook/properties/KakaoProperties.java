package com.example.searchBook.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ConfigurationProperties(prefix = "kakao")
@Component
@Getter
@Setter
@ToString
public class KakaoProperties {
	
	private String host;
	private String apikey;
	private String bookpath;

}
