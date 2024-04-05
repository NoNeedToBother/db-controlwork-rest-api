package ru.kpfu.itis.paramonov.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "currency")
@Getter
@NoArgsConstructor
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", length = 3)
    private String code;

    @OneToMany
    @JoinColumn(name = "currency")
    private List<Transaction> transactionList;
}
