package com.mtarrillo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "providers")//provedor
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne //un provedor tiene un usuario
    private User user;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)//
    private List<Availability> disponibilidad = new ArrayList<>();

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<Appointment> citas = new ArrayList<>();


}
