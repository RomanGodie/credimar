package com.controlinterno.controlinterno.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id_persona")
    private Long id_persona;
    @Getter @Setter @Column(name="numero_identificacion")
    private String numero_identificacion;
    @Getter @Setter @Column(name="nombres")
    private String nombres;
    @Getter @Setter @Column(name="primer_apellido")
    private String primer_apellido;
    @Getter @Setter @Column(name="segundo_apellido")
    private String segundo_apellido;
    @Getter @Setter @Column(name="correo_electronico")
    private String correo_electronico;
    @Getter @Setter @Column(name="direccion_residencia")
    private String direccion_residencia;
    @Getter @Setter @Column(name="telefono1")
    private String telefono1;
    @Getter @Setter @Column(name="telefono2")
    private String telefono2;
}
