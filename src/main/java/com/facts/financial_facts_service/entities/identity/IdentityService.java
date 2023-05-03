package com.facts.financial_facts_service.entities.identity;

import com.facts.financial_facts_service.components.IdentityMap;
import com.facts.financial_facts_service.constants.ModelType;
import com.facts.financial_facts_service.exceptions.DataNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;


@Service
public class IdentityService {

    Logger logger = LoggerFactory.getLogger(IdentityService.class);

    @Autowired
    IdentityMap identityMap;

    public Mono<ResponseEntity<Identity>> getSymbolFromIdentityMap(String cik) {
        logger.info("In identity service getting identity for cik {}", cik);
        return identityMap.getValue(cik).flatMap(identity -> {
            if (identity.isPresent()) {
                return Mono.just(new ResponseEntity<>(identity.get(), HttpStatus.OK));
            } else {
                logger.error("Identity not found for cik {}", cik);
                throw new DataNotFoundException(ModelType.IDENTITY, cik);
            }
        }).onErrorResume(error -> {
            logger.error("Error occurred while retrieving identity for cik {}: {}", cik, error.getMessage());
            throw new ResponseStatusException(HttpStatus.CONFLICT, error.getMessage());
        });
    }
}
