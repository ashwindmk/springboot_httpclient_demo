package com.ashwin.java.controller.api;

import com.ashwin.java.domain.model.Quote;
import com.ashwin.java.domain.model.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/quote")
public class QuoteController {
    @Autowired(required = true)
    RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<Value> quote() {
        Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        return ResponseEntity.ok(quote.getValue());
    }
}
