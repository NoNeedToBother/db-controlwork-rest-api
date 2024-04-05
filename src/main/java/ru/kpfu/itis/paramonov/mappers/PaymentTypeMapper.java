package ru.kpfu.itis.paramonov.mappers;

import ru.kpfu.itis.paramonov.dto.PaymentTypeDto;
import ru.kpfu.itis.paramonov.model.PaymentType;

public class PaymentTypeMapper implements Mapper<PaymentType, PaymentTypeDto> {
    @Override
    public PaymentTypeDto map(PaymentType model) {
        return new PaymentTypeDto(
                model.getId(),
                model.getValue()
        );
    }
}
