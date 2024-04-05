package ru.kpfu.itis.paramonov.mappers;

import ru.kpfu.itis.paramonov.dto.CurrencyDto;
import ru.kpfu.itis.paramonov.model.Currency;

public class CurrencyMapper implements Mapper<Currency, CurrencyDto> {
    @Override
    public CurrencyDto map(Currency model) {
        return new CurrencyDto(
                model.getId(),
                model.getCode()
        );
    }
}
