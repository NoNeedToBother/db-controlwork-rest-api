package ru.kpfu.itis.paramonov.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.paramonov.dto.CountryDto;
import ru.kpfu.itis.paramonov.dto.CurrencyDto;
import ru.kpfu.itis.paramonov.dto.PaymentMethodDto;
import ru.kpfu.itis.paramonov.dto.PaymentTypeDto;
import ru.kpfu.itis.paramonov.mappers.CountryMapper;
import ru.kpfu.itis.paramonov.mappers.CurrencyMapper;
import ru.kpfu.itis.paramonov.mappers.PaymentMethodMapper;
import ru.kpfu.itis.paramonov.mappers.PaymentTypeMapper;
import ru.kpfu.itis.paramonov.repository.CountryRepository;
import ru.kpfu.itis.paramonov.repository.CurrencyRepository;
import ru.kpfu.itis.paramonov.repository.PaymentMethodRepository;
import ru.kpfu.itis.paramonov.repository.PaymentTypeRepository;

@Service
@AllArgsConstructor
public class DictionaryService {
    private CountryRepository countryRepository;

    private CurrencyRepository currencyRepository;

    private PaymentMethodRepository paymentMethodRepository;

    private PaymentTypeRepository paymentTypeRepository;

    private CountryMapper countryMapper;

    private CurrencyMapper currencyMapper;

    private PaymentMethodMapper paymentMethodMapper;

    private PaymentTypeMapper paymentTypeMapper;

    public CountryDto getCountry(Long id) {
        return countryMapper.map(countryRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    public CurrencyDto getCurrency(Long id) {
        return currencyMapper.map(currencyRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    public PaymentMethodDto getPaymentMethod(Long id) {
        return paymentMethodMapper.map(paymentMethodRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    public PaymentTypeDto getPaymentType(Long id) {
        return paymentTypeMapper.map(paymentTypeRepository.findById(id).orElseThrow(RuntimeException::new));
    }

}
