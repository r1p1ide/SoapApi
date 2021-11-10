package com.example.soapApi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@XmlRootElement(name = "Income")
@XmlType(name = "IncomeDto", namespace = "http://r1ptide.com/soap")
@XmlAccessorType(XmlAccessType.FIELD)
public class IncomeDto {

    @XmlElement(namespace = "http://r1ptide.com/soap")
    private String color;

    @XmlElement(namespace = "http://r1ptide.com/soap")
    private Integer cottonPart;

    @XmlElement(namespace = "http://r1ptide.com/soap")
    private Integer amount;

}
