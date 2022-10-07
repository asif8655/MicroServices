package com.techgatha;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.techgatha.model.Book;
import com.techgatha.repository.BookRepository;

@SpringBootApplication
public class BookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner runner(BookRepository repository)
	{
		return args->{
				Stream.of(new Book("B1", "HarryPotter", "Adventure Book", 123.23),
						new Book("B2", "Adventures of Sherlock Homes", "Adventure Book", 400),
						new Book("B3", "nancy Drew", "Suspense Book", 250.50)
						)
				.forEach(book-> repository.save(book));
				repository.findAll().forEach(System.out::println);				
			};
	}

}
