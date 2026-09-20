package modelo;

/**
 * Especialización de Libro para recursos digitales.
 *
 * SOLID - OCP/LSP: añade comportamiento específico sin romper el contrato
 * general de Libro y puede utilizarse donde se espera un Libro.
 */
public class LibroDigital extends Libro {
    private String formato;
    private Float tamanoMB;

    public LibroDigital(String titulo, String isbn, Autor autor, String formato, Float tamanoMB) {
        super(titulo, isbn, autor);
        setFormato(formato);
        setTamanoMB(tamanoMB);
    }

    public String getFormato() {
        return formato;
    }

    public final void setFormato(String formato) {
        if (formato == null || formato.isBlank()) {
            throw new IllegalArgumentException("El formato es obligatorio.");
        }
        this.formato = formato.trim().toLowerCase();
    }

    public Float getTamanoMB() {
        return tamanoMB;
    }

    public final void setTamanoMB(Float tamanoMB) {
        if (tamanoMB == null || tamanoMB <= 0) {
            throw new IllegalArgumentException("El tamaño debe ser mayor que cero.");
        }
        this.tamanoMB = tamanoMB;
    }

    public void descargar() {
        if (!isDisponible()) {
            throw new IllegalStateException("El recurso digital no está disponible.");
        }
        System.out.println("Descarga habilitada: " + getTitulo() + " [" + formato + "]");
    }

    public void leerEnLinea() {
        System.out.println("Lectura en línea habilitada: " + getTitulo());
    }

    @Override
    public String obtenerTipoRecurso() {
        return "Libro digital (" + formato.toUpperCase() + ")";
    }

    @Override
    public String toString() {
        return "LibroDigital{" +
                "titulo='" + getTitulo() + '\'' +
                ", isbn='" + getIsbn() + '\'' +
                ", formato='" + formato + '\'' +
                ", tamanoMB=" + tamanoMB +
                ", disponible=" + isDisponible() +
                '}';
    }
}
