package com.example.soapApi.dto;

import com.example.soapApi.resources.SoapState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Income")
@XmlType(name = "IncomeResponseDto", namespace = "http://r1ptide.com/soap")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@Data
public class IncomeResponseDto {

    @XmlElement(namespace = "http://r1ptide.com/soap")
    private String code;
    @XmlElement(namespace = "http://r1ptide.com/soap")
    private String message;

    public IncomeResponseDto(SoapState state) {
        this.code = state.getCode();
        this.message = state.getDescription();
    }

}
