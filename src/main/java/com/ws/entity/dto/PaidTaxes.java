package com.ws.entity.dto;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PaidTaxes {

    private BigDecimal municipalTax;
    private BigDecimal countyTax;
    private BigDecimal stateTax;
    private BigDecimal federalTax;



}
