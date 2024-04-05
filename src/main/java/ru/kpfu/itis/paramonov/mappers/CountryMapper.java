package ru.kpfu.itis.paramonov.mappers;

import ru.kpfu.itis.paramonov.dto.CountryDto;
import ru.kpfu.itis.paramonov.model.Country;

public class CountryMapper implements Mapper<Country, CountryDto> {

    @Override
    public CountryDto map(Country model) {
        return new CountryDto(
                model.getId(),
                model.getCode()
        );
    }
}
