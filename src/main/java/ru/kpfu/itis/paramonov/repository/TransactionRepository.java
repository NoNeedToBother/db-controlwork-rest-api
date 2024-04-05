package ru.kpfu.itis.paramonov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kpfu.itis.paramonov.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
