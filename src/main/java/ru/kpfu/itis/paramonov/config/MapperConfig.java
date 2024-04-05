package ru.kpfu.itis.paramonov.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.kpfu.itis.paramonov.mappers.*;

@Configuration
public class MapperConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ClientMapper clientMapper() {
        return new ClientMapper();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public CountryMapper countryMapper() {
        return new CountryMapper();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public CurrencyMapper currencyMapper() {
        return new CurrencyMapper();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PaymentMethodMapper paymentMethodMapper() {
        return new PaymentMethodMapper();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PaymentTypeMapper paymentTypeMapper() {
        return new PaymentTypeMapper();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PaymentMapper paymentMapper() {
        return new PaymentMapper(
                paymentTypeMapper(), paymentMethodMapper(), countryMapper()
        );
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public TransactionMapper transactionMapper() {
        return new TransactionMapper(
                currencyMapper(), clientMapper(), paymentMapper(), processingStatusMapper()
        );
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ProcessingStatusMapper processingStatusMapper() {
        return new ProcessingStatusMapper();
    }
}
