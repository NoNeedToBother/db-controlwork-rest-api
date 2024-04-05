package ru.kpfu.itis.paramonov.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
public class CurrencyDto {
    private Integer id;

    @Column(name = "code", length = 2)
    private String code;
}
