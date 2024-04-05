package ru.kpfu.itis.paramonov.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.kpfu.itis.paramonov.model.ProcessingStatus;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class TransactionDto {
    private Integer id;

    private Timestamp conductionDate;

    private BigDecimal moneyAmount;

    private ProcessingStatusDto processingStatus;

    private Integer riskValue;

    private CurrencyDto currency;

    private ClientDto client;

    private PaymentDto payment;
}
