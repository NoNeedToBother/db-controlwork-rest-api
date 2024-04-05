package ru.kpfu.itis.paramonov.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "payment")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int status;

    @Column(name = "terminal_id")
    private int terminalId;

    @OneToMany
    @JoinColumn(name = "payment")
    private List<Client> clientList;

    @ManyToOne
    private PaymentType paymentType;

    @ManyToOne
    private PaymentMethod paymentMethod;

    @ManyToOne
    private Country country;
}
