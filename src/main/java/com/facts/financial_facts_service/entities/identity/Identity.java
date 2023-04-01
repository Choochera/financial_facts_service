package com.facts.financial_facts_service.entities.identity;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "financial_facts")
public class Identity {

    @Id
    @JsonAlias(value = "cik_str")
    String cik;

    @JsonAlias(value = "ticker")
    String symbol;

    @JsonAlias(value = "title")
    String name;

}