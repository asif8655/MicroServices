package com.ms.repository;

import org.springframework.data.repository.CrudRepository;

import com.ms.model.CurrencyExcchange;

public interface ExchangeRepository extends CrudRepository<CurrencyExcchange, Long>{

	public CurrencyExcchange findByFromAndTo(String from,String to);
}
