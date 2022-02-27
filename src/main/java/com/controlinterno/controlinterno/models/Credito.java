package com.controlinterno.controlinterno.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "credito")
public class Credito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id_credito")
    private Long id_credito;
    @Getter @Setter @Column(name="articulo_credito")
    private String articulo_credito;
    @Getter @Setter @Column(name="valor_credito")
    private Long valor_credito;
    @Getter @Setter @Column(name="numero_cuotas")
    private Long numero_cuotas;
    @Getter @Setter @Column(name="id_cliente1")
    private Long id_cliente1;
}
