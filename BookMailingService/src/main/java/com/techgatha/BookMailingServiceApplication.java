package com.techgatha;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.techgatha.model.BookOrder;
import com.techgatha.repository.BookOrderRepository;

@SpringBootApplication
public class BookMailingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMailingServiceApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(BookOrderRepository repository)
	{
		return args->{
				Stream.of(new BookOrder(1, "priya@yahoo.com", "B1", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss"))),
						new BookOrder(2, "riya@gmail.com", "B3", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss"))),
						new BookOrder(3, "riya@gmail.com", "B1", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss")))
						)
				.forEach(book-> repository.save(book));
				repository.findAll().forEach(System.out::println);
				
			};
	}
}
