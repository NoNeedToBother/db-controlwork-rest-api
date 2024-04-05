package ru.kpfu.itis.paramonov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.paramonov.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
