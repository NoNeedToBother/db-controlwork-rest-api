package ru.kpfu.itis.paramonov.mappers;

import lombok.AllArgsConstructor;
import ru.kpfu.itis.paramonov.dto.PaymentDto;
import ru.kpfu.itis.paramonov.model.Payment;

@AllArgsConstructor
public class PaymentMapper implements Mapper<Payment, PaymentDto> {

    private PaymentTypeMapper paymentTypeMapper;

    private PaymentMethodMapper paymentMethodMapper;

    private CountryMapper countryMapper;

    @Override
    public PaymentDto map(Payment model) {
        return new PaymentDto(
                model.getId(),
                model.getStatus(),
                model.getTerminalId(),
                paymentTypeMapper.map(model.getPaymentType()),
                paymentMethodMapper.map(model.getPaymentMethod()),
                countryMapper.map(model.getCountry())
        );
    }
}
