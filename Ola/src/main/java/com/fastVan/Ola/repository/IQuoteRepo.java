package com.fastVan.Ola.repository;

import com.fastVan.Ola.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuoteRepo extends JpaRepository<Quote, String> {
}
