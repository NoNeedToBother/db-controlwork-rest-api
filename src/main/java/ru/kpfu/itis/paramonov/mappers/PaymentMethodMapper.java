package ru.kpfu.itis.paramonov.mappers;

import ru.kpfu.itis.paramonov.dto.PaymentMethodDto;
import ru.kpfu.itis.paramonov.model.PaymentMethod;

public class PaymentMethodMapper implements Mapper<PaymentMethod, PaymentMethodDto> {
    @Override
    public PaymentMethodDto map(PaymentMethod model) {
        return new PaymentMethodDto(
                model.getId(),
                model.getValue()
        );
    }
}
