package com.techgatha.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techgatha.model.UserCatalog;
import com.techgatha.service.BookCatalogService;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResource {

	@Autowired
	private BookCatalogService service;
	
	@GetMapping("/{email}")
	public List<UserCatalog> getBooksPurchased(@PathVariable String email)
	{
		return service.getBooksOrdered(email);
	}
	
}
