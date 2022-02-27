package com.controlinterno.controlinterno.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id_rol")
    private Long id_rol;
    @Getter @Setter @Column(name="nombre_rol")
    private String nombre_rol;
}
