package ru.kpfu.itis.paramonov.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.kpfu.itis.paramonov.dto.AggregationResultDto;
import ru.kpfu.itis.paramonov.service.AggregationService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    private AggregationService aggregationService;

    @GetMapping(value = "/aggregate")
    public String aggregate(@RequestParam Map<String, String> params) {
        String by = params.get("by");
        if (by == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        String year = params.get("year");
        String month = params.get("month");
        List<AggregationResultDto> res;
        Result result;
        if (year != null) {
            try {
                return handleDate(by, year, month);
            } catch (NumberFormatException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        } else {
            switch (by) {
                case "countries":
                    res = aggregationService.aggregateByCountries();
                    result = new Result(200, res);
                    return toJson(result);
                case "currencies":
                    res = aggregationService.aggregateByCurrencies();
                    result = new Result(200, res);
                    return toJson(result);
                case "statuses":
                    res = aggregationService.aggregateByStatuses();
                    result = new Result(200, res);
                    return toJson(result);
                default:
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        }
    }

    @Getter
    @AllArgsConstructor
    private static class Result {
        private Integer code;

        private List<AggregationResultDto> result;
    }

    private String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }

    private String handleDate(String by, String year, String month) {
        List<AggregationResultDto> res;
        Result result;
        switch (by) {
            case "countries":
                if (month != null) {
                    res = aggregationService.aggregateByCountriesAndYearAndMonth(
                            new BigDecimal(year), new BigDecimal(month)
                    );
                    result = new Result(200, res);
                    return toJson(result);
                } else {
                    res = aggregationService.aggregateByCountriesAndYear(
                            new BigDecimal(year)
                    );
                    result = new Result(200, res);
                    return toJson(result);
                }
            case "currencies":
                if (month != null) {
                    res = aggregationService.aggregateByCurrenciesAndYearAndMonth(
                            new BigDecimal(year), new BigDecimal(month)
                    );
                    result = new Result(200, res);
                    return toJson(result);
                } else {
                    res = aggregationService.aggregateByCurrenciesAndYear(
                            new BigDecimal(year)
                    );
                    result = new Result(200, res);
                    return toJson(result);
                }
            case "statuses":
                if (month != null) {
                    res = aggregationService.aggregateByStatusesAndYearAndMonth(
                            new BigDecimal(year), new BigDecimal(month)
                    );
                    result = new Result(200, res);
                    return toJson(result);
                } else {
                    res = aggregationService.aggregateByStatusesAndYear(
                            new BigDecimal(year)
                    );
                    result = new Result(200, res);
                    return toJson(result);
                }
            default:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
