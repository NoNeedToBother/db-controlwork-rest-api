package ru.kpfu.itis.paramonov.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "payment_method")
@Getter
@NoArgsConstructor
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value", length = 15)
    private String value;

    @OneToMany
    @JoinColumn(name = "payment_method")
    private List<Payment> paymentList;

}
