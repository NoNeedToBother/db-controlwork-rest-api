package ru.kpfu.itis.paramonov.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "payment_type")
@Getter
@NoArgsConstructor
public class PaymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value", length = 15)
    private String value;

    @OneToMany
    @JoinColumn(name = "payment_type")
    private List<Payment> paymentList;
}
