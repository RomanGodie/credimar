package com.controlinterno.controlinterno.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id_cliente")
    private Long id_cliente;
    @Getter @Setter @Column(name="id_persona1")
    private Long id_persona1;
    @Getter @Setter @Column(name="direccion_alterna")
    private String direccion_alterna;
    @Getter @Setter @Column(name="telefono_alterno")
    private String telefono_alterno;
    @Getter @Setter @Column(name="cantidad_creditos")
    private Long cantidad_creditos;
    @Getter @Setter @Column(name="estado_cliente")
    private String estado_cliente;

}
