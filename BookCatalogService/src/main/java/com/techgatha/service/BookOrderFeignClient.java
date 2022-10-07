package com.techgatha.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techgatha.model.OrderWrapper;
import com.techgatha.model.UserCatalog;

@FeignClient(name="BOOK-ORDER-SERVICE")
public interface BookOrderFeignClient {

	
	@RequestMapping("/orders/{email}")
	public List<OrderWrapper> getBookOrderDetails( @PathVariable String email);
}
