package ru.kpfu.itis.paramonov.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AggregationResultDto {
    private String value;

    private BigDecimal year;

    private BigDecimal month;

    private BigInteger count;
}
