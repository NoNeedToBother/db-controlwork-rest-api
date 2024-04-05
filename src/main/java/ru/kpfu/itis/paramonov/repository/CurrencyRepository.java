package ru.kpfu.itis.paramonov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.paramonov.model.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
