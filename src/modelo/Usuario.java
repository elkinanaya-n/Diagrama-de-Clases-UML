package modelo;

import java.util.Objects;

/**
 * Usuario que solicita y devuelve préstamos.
 */
public class Usuario {
    private String idUsuario;
    private String nombre;
    private String email;

    public Usuario(String idUsuario, String nombre, String email) {
        setIdUsuario(idUsuario);
        setNombre(nombre);
        setEmail(email);
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public final void setIdUsuario(String idUsuario) {
        if (idUsuario == null || idUsuario.isBlank()) {
            throw new IllegalArgumentException("El ID del usuario es obligatorio.");
        }
        this.idUsuario = idUsuario.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public final void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del usuario es obligatorio.");
        }
        this.nombre = nombre.trim();
    }

    public String getEmail() {
        return email;
    }

    public final void setEmail(String email) {
        if (email == null || email.isBlank() || !email.contains("@")) {
            throw new IllegalArgumentException("El correo electrónico no es válido.");
        }
        this.email = email.trim();
    }

    public Prestamo solicitarPrestamo(Libro lib) {
        Objects.requireNonNull(lib, "El libro no puede ser nulo.");
        lib.prestar();
        return new Prestamo(this, lib);
    }

    public void devolverLibro(Prestamo prestamo) {
        Objects.requireNonNull(prestamo, "El préstamo no puede ser nulo.");
        if (prestamo.getUsuario() != this) {
            throw new IllegalArgumentException("El préstamo no pertenece a este usuario.");
        }
        prestamo.devolver();
    }

    @Override
    public String toString() {
        return idUsuario + " - " + nombre + " <" + email + ">";
    }
}
