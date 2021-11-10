package com.example.soapApi.service;

import com.example.soapApi.dto.IncomeRequest;
import com.example.soapApi.dto.IncomeResponseDto;
import com.example.soapApi.dto.OutcomeRequest;
import com.example.soapApi.dto.OutcomeResponseDto;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.namespace.QName;

@WebService(
        portName = "SoapPort",
        serviceName = "SoapApiService",
        targetNamespace = "http://r1ptide.com/soap",
        endpointInterface = "com.example.soapApi.service.SoapApiService"
)
public interface SoapApiService {

    public static final QName SERVICE_QNAME =
            new QName("http://r1ptide.com/soap", "SoapPort");

    @WebMethod
    IncomeResponseDto income(
            @WebParam(name = "Income") @XmlElement(required = true) IncomeRequest income);

    @WebMethod
    OutcomeResponseDto outcome(
            @WebParam(name = "Income") @XmlElement(required = true) OutcomeRequest outcome);

}
