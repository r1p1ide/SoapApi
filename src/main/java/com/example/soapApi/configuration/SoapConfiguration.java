package com.example.soapApi.configuration;

import com.example.soapApi.service.SoapApiService;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
@RequiredArgsConstructor
public class SoapConfiguration {

    private final Bus bus;

    @Bean
    public Endpoint endpoint(SoapApiService soapApiServiceEndpoint) {
        EndpointImpl endpoint = new EndpointImpl(bus, soapApiServiceEndpoint);
        endpoint.setServiceName(SoapApiService.SERVICE_QNAME);
        endpoint.publish("/SoapApiService");
        return endpoint;
    }
}
