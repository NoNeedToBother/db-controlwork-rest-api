package ru.kpfu.itis.paramonov.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaymentDto {
    private Integer id;

    private int status;

    private int terminalId;

    private PaymentTypeDto paymentType;

    private PaymentMethodDto paymentMethod;

    private CountryDto country;
}
