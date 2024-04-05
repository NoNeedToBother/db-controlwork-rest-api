package ru.kpfu.itis.paramonov.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "bank_transaction")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "conduction_date")
    @CreationTimestamp
    private Timestamp conductionDate;

    @Column(name = "money_amount")
    private BigDecimal moneyAmount;

    @ManyToOne
    private ProcessingStatus processingStatus;

    @Column(name = "risk_value")
    private Integer riskValue;

    @ManyToOne
    private Currency currency;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Payment payment;

}
