package com.example.soapApi.service;

import com.example.soapApi.dao.SoapRepository;
import com.example.soapApi.dto.IncomeRequest;
import com.example.soapApi.dto.IncomeResponseDto;
import com.example.soapApi.dto.OutcomeRequest;
import com.example.soapApi.dto.OutcomeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.ws.WebServiceProvider;
import java.util.logging.Logger;

import static com.example.soapApi.resources.LoggerResources.EXIT;
import static com.example.soapApi.resources.LoggerResources.THROW;
import static com.example.soapApi.resources.SoapState.*;
import static java.util.logging.Level.INFO;

@Service
@WebServiceProvider(portName = "SoapPort")
@RequiredArgsConstructor
public class SoapApiServiceImpl implements SoapApiService{

    private final static Logger LOG = Logger.getLogger(SoapApiServiceImpl.class.getCanonicalName());

    private final SoapRepository repository;

    @Override
    public IncomeResponseDto income(IncomeRequest income) {
        LOG.log(INFO, EXIT);
        if (income == null) {
            LOG.log(INFO, EXIT);
            return new IncomeResponseDto(OUT_OF_INPUT_VALUE);
        }
        if (!income.isValid()) {
            LOG.log(INFO, EXIT);
            return new IncomeResponseDto(EMPTY_OF_INPUT_VALUE);
        }
        try {
            repository.income(income);
        } catch (Exception ex) {
            LOG.log(INFO, THROW, ex);
            LOG.log(INFO, EXIT);
            return new IncomeResponseDto(SAVE_TO_DB_FAILED);
        }
        LOG.log(INFO, EXIT);
        return new IncomeResponseDto(SUCCESSFUL);
    }

    @Override
    public OutcomeResponseDto outcome(OutcomeRequest outcome) {
        LOG.log(INFO, EXIT);
        if (outcome == null) {
            LOG.log(INFO, EXIT);
            return new OutcomeResponseDto(OUT_OF_INPUT_VALUE);
        }
        if (!outcome.isValid()) {
            LOG.log(INFO, EXIT);
            return new OutcomeResponseDto(EMPTY_OF_INPUT_VALUE);
        }
        try {
            repository.outcome(outcome);
        } catch (Exception ex) {
            LOG.log(INFO, THROW, ex);
            LOG.log(INFO, EXIT);
            return new OutcomeResponseDto(SAVE_TO_DB_FAILED);
        }
        LOG.log(INFO, EXIT);
        return new OutcomeResponseDto(SUCCESSFUL);
    }
}
