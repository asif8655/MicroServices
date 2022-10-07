package com.ms.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ms.model.ConversionBean;
import com.netflix.discovery.converters.Auto;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private RestTemplate template;

	@RequestMapping("/exchange/from/{from}/to/{to}/quantity/{quantity}")
	public ConversionBean calculateAmount(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity)
	{
		
		String uri="http://FOREX-SERVICE/currency-exchange/from/{from}/to/{to}";
		Map<String, String> map=new HashMap<>();
		map.put("from", from);
		map.put("to", to);
		ConversionBean bean = template.getForObject(uri, ConversionBean.class, map);
		bean.setQuantity(quantity);
		bean.setTotalCalculatedAmount(quantity.multiply(bean.getConversionMultiple()));
		return bean;
		
		
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
}
