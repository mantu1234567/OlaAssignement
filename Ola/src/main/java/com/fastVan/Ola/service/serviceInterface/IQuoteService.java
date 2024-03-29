package com.fastVan.Ola.service.serviceInterface;

import com.fastVan.Ola.DTO.QuoteResponse;
import com.fastVan.Ola.DTO.QuoteRequest;
import org.springframework.stereotype.Service;

@Service
public interface IQuoteService {
    QuoteResponse getQuote(QuoteRequest quoteRequest);
}
