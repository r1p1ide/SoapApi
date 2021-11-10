package com.example.soapApi.dto;

import com.example.soapApi.resources.SoapState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Outcome")
@XmlType(name = "OutcomeResponseDto", namespace = "http://r1ptide.com/soap")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@Data
public class OutcomeResponseDto {

    @XmlElement(namespace = "http://r1ptide.com/soap")
    private String code;
    @XmlElement(namespace = "http://r1ptide.com/soap")
    private String message;

    public OutcomeResponseDto(SoapState state) {
        this.code = state.getCode();
        this.message = state.getDescription();
    }

}
