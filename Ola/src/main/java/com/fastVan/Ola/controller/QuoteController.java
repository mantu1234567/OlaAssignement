package com.fastVan.Ola.controller;

import com.fastVan.Ola.DTO.QuoteResponse;
import com.fastVan.Ola.DTO.QuoteRequest;
import com.fastVan.Ola.service.serviceInterface.IQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Ola")
public class QuoteController {
    @Autowired
    private IQuoteService quoteService;

    @PostMapping("/quote")
    public ResponseEntity<QuoteResponse> getQuote(@RequestBody QuoteRequest quoteRequest) {
        return ResponseEntity.ok(quoteService.getQuote(quoteRequest));
    }
}
