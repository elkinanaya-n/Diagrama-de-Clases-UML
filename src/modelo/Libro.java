package modelo;

/**
 * Representa el título bibliográfico general.
 *
 * SOLID - SRP: concentra los datos y comportamientos básicos del libro.
 * SOLID - OCP: puede extenderse mediante subclases como LibroDigital sin
 * modificar esta implementación base.
 */
public class Libro {
    private String titulo;
    private String isbn;
    private Boolean estadoDisponibilidad;
    private Autor autor;

    public Libro(String titulo, String isbn, Autor autor) {
        setTitulo(titulo);
        setIsbn(isbn);
        this.estadoDisponibilidad = true;
        if (autor == null) {
            this.autor = null;
        } else {
            this.autor = autor;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public final void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El título es obligatorio.");
        }
        this.titulo = titulo.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public final void setIsbn(String isbn) {
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("El ISBN es obligatorio.");
        }
        this.isbn = isbn.trim();
    }

    public Boolean isDisponible() {
        return estadoDisponibilidad;
    }

    public final void setEstadoDisponibilidad(Boolean estadoDisponibilidad) {
        if (estadoDisponibilidad == null) {
            throw new IllegalArgumentException("El estado de disponibilidad no puede ser nulo.");
        }
        this.estadoDisponibilidad = estadoDisponibilidad;
    }

    public Autor getAutor() {
        return autor;
    }

    public final void setAutor(Autor autor) {
        this.autor = autor;
        if (autor != null) {
            autor.agregarLibro(this);
        }
    }

    public void prestar() {
        if (!isDisponible()) {
            throw new IllegalStateException("El libro '" + titulo + "' no está disponible.");
        }
        estadoDisponibilidad = false;
    }

    public void devolver() {
        estadoDisponibilidad = true;
    }

    /**
     * Método auxiliar para mostrar polimorfismo de forma explícita.
     */
    public String obtenerTipoRecurso() {
        return "Libro físico/general";
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", disponible=" + estadoDisponibilidad +
                ", autor=" + (autor != null ? autor.getNombre() : "Sin autor") +
                '}';
    }
}
