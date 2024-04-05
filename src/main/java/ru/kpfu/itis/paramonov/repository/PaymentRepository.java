package ru.kpfu.itis.paramonov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.paramonov.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
