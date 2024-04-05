package ru.kpfu.itis.paramonov.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.paramonov.dto.AggregationResultDto;
import ru.kpfu.itis.paramonov.repository.AggregationRepository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AggregationService {

    private AggregationRepository aggregationRepository;

    public List<AggregationResultDto> aggregateByCountries() {
        List<Object[]> transactions = aggregationRepository.aggregateByCountries();
        return getAggregationResultsWithValueString(transactions);
    }

    public List<AggregationResultDto> aggregateByCurrencies() {
        List<Object[]> transactions = aggregationRepository.aggregateByCurrencies();
        return getAggregationResultsWithValueString(transactions);
    }
    public List<AggregationResultDto> aggregateByStatuses() {
        List<Object[]> transactions = aggregationRepository.aggregateByStatuses();
        return getAggregationResultsWithValueInt(transactions);
    }

    private List<AggregationResultDto> getAggregationResultsWithValueString(List<Object[]> transactions) {
        List<AggregationResultDto> result = new ArrayList<>();
        for (Object[] transaction : transactions) {
            AggregationResultDto aggregationResultDto = new AggregationResultDto();
            aggregationResultDto.setValue((String) transaction[0]);
            aggregationResultDto.setYear((BigDecimal) transaction[1]);
            aggregationResultDto.setMonth((BigDecimal) transaction[2]);
            aggregationResultDto.setCount((BigInteger) transaction[3]);
            result.add(aggregationResultDto);
        }
        return result;
    }

    private List<AggregationResultDto> getAggregationResultsWithValueInt(List<Object[]> transactions) {
        List<AggregationResultDto> result = new ArrayList<>();
        for (Object[] transaction : transactions) {
            AggregationResultDto aggregationResultDto = new AggregationResultDto();
            aggregationResultDto.setValue(String.valueOf(transaction[0]));
            aggregationResultDto.setYear((BigDecimal) transaction[1]);
            aggregationResultDto.setMonth((BigDecimal) transaction[2]);
            aggregationResultDto.setCount((BigInteger) transaction[3]);
            result.add(aggregationResultDto);
        }
        return result;
    }

    public List<AggregationResultDto> aggregateByCountriesAndYearAndMonth(BigDecimal year, BigDecimal month) {
        List<Object[]> transactions = aggregationRepository.aggregateByCountriesAndYearAndMonth(year, month);
        return getAggregationResultsWithValueString(transactions);
    }

    public List<AggregationResultDto> aggregateByCountriesAndYear(BigDecimal year) {
        List<Object[]> transactions = aggregationRepository.aggregateByCountriesAndYear(year);
        return getAggregationResultsWithValueString(transactions);
    }

    public List<AggregationResultDto> aggregateByCurrenciesAndYearAndMonth(BigDecimal year, BigDecimal month) {
        List<Object[]> transactions = aggregationRepository.aggregateByCurrenciesAndYearAndMonth(year, month);
        return getAggregationResultsWithValueString(transactions);
    }

    public List<AggregationResultDto> aggregateByCurrenciesAndYear(BigDecimal year) {
        List<Object[]> transactions = aggregationRepository.aggregateByCurrenciesAndYear(year);
        return getAggregationResultsWithValueString(transactions);
    }

    public List<AggregationResultDto> aggregateByStatusesAndYearAndMonth(BigDecimal year, BigDecimal month) {
        List<Object[]> transactions = aggregationRepository.aggregateByStatusesAndYearAndMonth(year, month);
        return getAggregationResultsWithValueInt(transactions);
    }

    public List<AggregationResultDto> aggregateByStatusesAndYear(BigDecimal year) {
        List<Object[]> transactions = aggregationRepository.aggregateByStatusesAndYear(year);
        return getAggregationResultsWithValueInt(transactions);
    }
}
