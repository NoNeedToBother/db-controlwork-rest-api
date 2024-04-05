package ru.kpfu.itis.paramonov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.paramonov.model.PaymentType;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {
}
