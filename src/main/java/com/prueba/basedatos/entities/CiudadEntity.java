package com.prueba.basedatos.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ciudad", schema = "public", catalog = "prueba")
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@ciudadId")
public class CiudadEntity {
    private Integer id;
    private String nombre;
    private PaisEntity paisByIdPais;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CiudadEntity that = (CiudadEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @ManyToOne
    @JoinColumn(name = "id_pais", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    public PaisEntity getPaisByIdPais() {
        return paisByIdPais;
    }

    public void setPaisByIdPais(PaisEntity paisByIdPais) {
        this.paisByIdPais = paisByIdPais;
    }
}
