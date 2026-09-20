package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Representa al autor de una o varias obras.
 *
 * SOLID - SRP: su responsabilidad se limita a los metadatos del autor y
 * la relación con sus libros.
 */
public class Autor {
    private String nombre;
    private String nacionalidad;
    private final List<Libro> libros;

    public Autor(String nombre, String nacionalidad) {
        setNombre(nombre);
        setNacionalidad(nacionalidad);
        this.libros = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public final void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del autor es obligatorio.");
        }
        this.nombre = nombre.trim();
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public final void setNacionalidad(String nacionalidad) {
        if (nacionalidad == null || nacionalidad.isBlank()) {
            throw new IllegalArgumentException("La nacionalidad es obligatoria.");
        }
        this.nacionalidad = nacionalidad.trim();
    }

    public void agregarLibro(Libro lib) {
        Objects.requireNonNull(lib, "El libro no puede ser nulo.");
        if (!libros.contains(lib)) {
            libros.add(lib);
        }
    }

    public List<Libro> getLibros() {
        return Collections.unmodifiableList(libros);
    }

    @Override
    public String toString() {
        return nombre + " (" + nacionalidad + ")";
    }
}
