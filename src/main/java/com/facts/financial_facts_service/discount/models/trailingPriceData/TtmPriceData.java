package com.facts.financial_facts_service.discount.models.trailingPriceData;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ttm_price_data", schema = "financial_facts")
public class TtmPriceData extends AbstractTrailingPriceData {
}
