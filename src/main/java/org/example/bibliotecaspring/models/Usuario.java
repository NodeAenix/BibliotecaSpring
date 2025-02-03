package org.example.bibliotecaspring.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dni", nullable = false, length = 15)
    @NotNull
    @NotBlank(message = "Debe especificar un DNI.")
    @Pattern(regexp = "(^[XYZ]\\d{7}[A-Za-z]$)|(^\\d{8}[A-Za-z]$)",
             message = "Formato de DNI/NIE incorrecto")
    private String dni;

    @Column(name = "nombre", nullable = false, length = 100)
    @NotNull
    @NotBlank(message = "Debe especificar un nombre.")
    @Pattern(regexp = "^[\\w\\sÀ-ÿ]{1,100}$", message = "Incluya solo carácteres alfanuméricos.")
    private String nombre;

    @Column(name = "email", nullable = false, length = 100)
    @NotNull
    @NotBlank(message = "Debe especificar un correo.")
    @Pattern(regexp = "([A-Za-z0-9]{1,50}@gmail\\.com)",
             message = "Incluya solo carácteres alfanuméricos, seguido de '@gmail.com'.")
    private String email;

    @Column(name = "password", nullable = false)
    @NotNull
    @NotBlank(message = "Debe especificar un nombre.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z0-9]{4,12}$",
             message = "La contraseña debe ser alfanumérica entre 4 y 12 carácteres.")
    private String password;

    @Lob
    @Column(name = "tipo", nullable = false)
    @NotNull
    @NotBlank(message = "Debe especificar un tipo de usuario.")
    @Pattern(regexp = "normal|administrador",
             flags = Pattern.Flag.CASE_INSENSITIVE,
             message = "El tipo solo puede ser 'normal' o 'administrador'.")
    private String tipo;

    @Column(name = "penalizacionHasta")
    private LocalDate penalizacionHasta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getPenalizacionHasta() {
        return penalizacionHasta;
    }

    public void setPenalizacionHasta(LocalDate penalizacionHasta) {
        this.penalizacionHasta = penalizacionHasta;
    }

}
