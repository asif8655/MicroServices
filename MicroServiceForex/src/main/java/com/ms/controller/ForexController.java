package com.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ms.model.CurrencyExcchange;
import com.ms.repository.ExchangeRepository;

@RestController
public class ForexController {

	@Autowired
	ExchangeRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExcchange retrieveExchangeValue
            (@PathVariable String from, @PathVariable String to){

    	System.out.println(repository.count());
    	CurrencyExcchange exchangeValue =
                repository.findByFromAndTo(from, to);

        return exchangeValue;
    }
    
    @GetMapping("/home")
	public String home() {
		return "home";
	}

}

