package ru.kpfu.itis.paramonov.mappers;

import lombok.AllArgsConstructor;
import ru.kpfu.itis.paramonov.dto.TransactionDto;
import ru.kpfu.itis.paramonov.model.Transaction;

@AllArgsConstructor
public class TransactionMapper implements Mapper<Transaction, TransactionDto> {

    private CurrencyMapper currencyMapper;

    private ClientMapper clientMapper;

    private PaymentMapper paymentMapper;

    private ProcessingStatusMapper processingStatusMapper;

    @Override
    public TransactionDto map(Transaction model) {
        return new TransactionDto(
                model.getId(),
                model.getConductionDate(),
                model.getMoneyAmount(),
                processingStatusMapper.map(model.getProcessingStatus()),
                model.getRiskValue(),
                currencyMapper.map(model.getCurrency()),
                clientMapper.map(model.getClient()),
                paymentMapper.map(model.getPayment())
        );
    }
}
