package com.mtarrillo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Availability")
public class Availability { //disponibilidad
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dia; //lunes , martes , miercoles
    private LocalTime horaInicio;
    private LocalTime horaFin;

    @ManyToOne
    private Provider provider;


}
