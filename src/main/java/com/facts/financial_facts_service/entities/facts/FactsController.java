package com.facts.financial_facts_service.entities.facts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "v1/facts")
public class FactsController {

    Logger logger = LoggerFactory.getLogger(FactsController.class);

    private final FactsService factsService;

    @Autowired
    public FactsController(FactsService factsService) {
        this.factsService = factsService;
    }

    @GetMapping(path = "/{cik}")
    public CompletableFuture<ResponseEntity<String>> getFacts(@PathVariable String cik) {
        logger.info("In facts controller getting facts for cik {}", cik);
        return factsService
                .getFactsByCik(cik.toUpperCase())
                .toFuture();
    }
}
