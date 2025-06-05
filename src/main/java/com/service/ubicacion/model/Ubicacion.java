package com.service.ubicacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ubicacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ubicacion_seq")
    @SequenceGenerator(name = "ubicacion_seq",sequenceName = "UBICACION_SEQ",allocationSize = 1)
    @Column(name = "id_ubicacion")
    private Integer id;

    @Column(name = "region",length = 15)
    private String region;

    @Column(name = "comuna",length = 15)
    private String comuna;

    @Column(name = "esatdo",length = 15)
    private String estado;
}
