package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Agrega las colecciones de libros y autores de la biblioteca.
 *
 * La agregación se representa mediante List: los libros y autores pueden
 * existir de forma independiente de la biblioteca.
 *
 * Sobrecarga: buscarPorTitulo(String) y buscarPorTitulo(String, boolean)
 * ofrecen el mismo servicio con distintos parámetros.
 */
public class Biblioteca {
    private String nombre;
    private String direccion;
    private final List<Libro> libros;
    private final List<Autor> autores;
    private final List<Prestamo> prestamos;

    public Biblioteca(String nombre, String direccion) {
        setNombre(nombre);
        setDireccion(direccion);
        this.libros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public final void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la biblioteca es obligatorio.");
        }
        this.nombre = nombre.trim();
    }

    public String getDireccion() {
        return direccion;
    }

    public final void setDireccion(String direccion) {
        if (direccion == null || direccion.isBlank()) {
            throw new IllegalArgumentException("La dirección es obligatoria.");
        }
        this.direccion = direccion.trim();
    }

    public void registrarAutor(Autor autor) {
        Objects.requireNonNull(autor, "El autor no puede ser nulo.");
        if (!autores.contains(autor)) {
            autores.add(autor);
        }
    }

    public void registrarLibro(Libro libro) {
        Objects.requireNonNull(libro, "El libro no puede ser nulo.");
        if (!libros.contains(libro)) {
            libros.add(libro);
        }
        if (libro.getAutor() != null) {
            registrarAutor(libro.getAutor());
            libro.getAutor().agregarLibro(libro);
        }
    }

    public List<Libro> buscarPorTitulo(String t) {
        return buscarPorTitulo(t, false);
    }

    public List<Libro> buscarPorTitulo(String t, boolean soloDisponibles) {
        if (t == null || t.isBlank()) {
            return Collections.emptyList();
        }
        String criterio = t.trim().toLowerCase(Locale.ROOT);
        return libros.stream()
                .filter(libro -> libro.getTitulo().toLowerCase(Locale.ROOT).contains(criterio))
                .filter(libro -> !soloDisponibles || Boolean.TRUE.equals(libro.isDisponible()))
                .collect(Collectors.toUnmodifiableList());
    }

    public void registrarPrestamo(Prestamo p) {
        Objects.requireNonNull(p, "El préstamo no puede ser nulo.");
        if (!prestamos.contains(p)) {
            prestamos.add(p);
        }
    }

    public List<Libro> getLibros() {
        return Collections.unmodifiableList(libros);
    }

    public List<Autor> getAutores() {
        return Collections.unmodifiableList(autores);
    }

    public List<Prestamo> getPrestamos() {
        return Collections.unmodifiableList(prestamos);
    }
}
