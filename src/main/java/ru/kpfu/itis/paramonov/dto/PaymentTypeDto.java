package ru.kpfu.itis.paramonov.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaymentTypeDto {
    private Integer id;

    private String value;
}