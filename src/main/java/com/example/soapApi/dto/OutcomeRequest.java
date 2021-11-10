package com.example.soapApi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.cxf.common.util.StringUtils;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Outcome")
@XmlType(name = "OutcomeRequest", namespace = "http://r1ptide.com/soap")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@Data
public class OutcomeRequest {

    @XmlElement(name = "color", required = true, namespace = "http://r1ptide.com/soap")
    private String color;

    @XmlElement(name = "cottonPart", required = true, namespace = "http://r1ptide.com/soap")
    private Integer cottonPart;

    @XmlElement(name = "amount", required = true, namespace = "http://r1ptide.com/soap")
    private Integer amount;

    public boolean isValid() {
        return (!StringUtils.isEmpty(color) &&
                cottonPart >= 0 &&
                amount > 0);
    }

}
