package com.example.searchBook.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.searchBook.User.model.User;
import com.example.searchBook.book.model.Book;
import com.example.searchBook.properties.KakaoProperties;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/kakao")
@RequiredArgsConstructor
public class KakaoBookController {
	
	private final KakaoProperties kakaoProperties;
	
	@GetMapping("/searchBook")
	@ResponseBody
	public Book search(@RequestParam String query, @RequestParam int size, Model model) {
		
		Mono<Book> mono = WebClient.builder().baseUrl(kakaoProperties.getHost()).build().get()
				.uri(builder -> builder.path(kakaoProperties.getBookpath()).queryParam("query", query).queryParam("size", size).build())
				.header("Authorization", "KakaoAK " + kakaoProperties.getApikey())
				.exchangeToMono(res -> {
					return res.bodyToMono(Book.class);
				});
		return mono.block();
	}
	
	@GetMapping(value = "/search")
	public String search(Model model) {
		return "search/search";
	}

	@GetMapping(value = "/detail")
	public String detail(Model model) {
		return "search/detail";
	}

}
