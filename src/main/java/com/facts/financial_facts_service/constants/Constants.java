package com.facts.financial_facts_service.constants;

public interface Constants {
    String EMPTY = "";
    String V1_DISCOUNT = "v1/discount";
    String CIK_PATH_PARAM = "/{cik}";
    String DISCOUNT_NOT_FOUND = "Discount with cik %s not found";
    String FACTS_NOT_FOUND = "Facts with cik %s not found";
    String IDENTITY_NOT_FOUND = "Identity with cik %s not found";
    String DATA_NOT_FOUND = "Data not found for cik %s";
    String DISCOUNT_EXISTS = "Discount with cik %s already exists";
    String DISCOUNT_OPERATION_ERROR = "Error occurred performing %s operation on CIK %s";
    String V1_FACTS = "v1/facts";
    String V1_IDENTITY = "v1/identity";
    String CIK = "CIK";
    String ZERO = "0";
    String FINANCIAL_FACTS = "financial_facts";
    String CIK_REGEX = "^[Cc][Ii][Kk]\\d{10}$";
    String DISCOUNT_ADDED = "Success: Discount added";
    String DISCOUNT_UPDATED = "Success: Discount updated";
    String DISCOUNT_DELETED = "Success: Discount deleted";
    String SLASH = "/";
    String FACTS_FILENAME = "%s.json";
}
