package com.controlinterno.controlinterno.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "agente")
public class Agente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id_agente")
    private Long id_agente;
    @Getter @Setter @Column(name="id_persona2")
    private Long id_persona2;
    @Getter @Setter @Column(name="id_rol1")
    private Long id_rol1;
    @Getter @Setter @Column(name="correo_electronico")
    private String correo_electronico;
    @Getter @Setter @Column(name="password")
    private String password;

}
