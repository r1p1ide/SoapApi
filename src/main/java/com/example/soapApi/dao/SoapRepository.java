package com.example.soapApi.dao;

import com.example.soapApi.dto.IncomeRequest;
import com.example.soapApi.dto.OutcomeRequest;

public interface SoapRepository {

    void income(IncomeRequest income);

    void outcome(OutcomeRequest outcome);

}
