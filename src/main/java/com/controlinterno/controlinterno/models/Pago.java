package com.controlinterno.controlinterno.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id_pago")
    private Long id_pago;
    @Getter @Setter @Column(name="valor_pago")
    private Long valor_pago;
    @Getter @Setter @Column(name="id_cliente2")
    private Long id_cliente2;
    @Getter @Setter @Column(name="id_credito1")
    private Long id_credito1;
    @Getter @Setter @Column(name="id_agente1")
    private Long id_agente1;
    @Getter @Setter @Column(name="fecha_pago")
    private Timestamp fecha_pago;

}
