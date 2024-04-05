package ru.kpfu.itis.paramonov.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
@Getter
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", length = 2)
    private String code;

    @OneToMany
    @JoinColumn(name = "country")
    private List<Payment> paymentList;
}
