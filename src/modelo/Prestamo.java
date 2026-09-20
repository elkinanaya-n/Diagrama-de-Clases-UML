package modelo;

import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Representa el vínculo temporal entre un usuario y un libro.
 *
 * La referencia al libro se mantiene como atributo final para representar
 * estructuralmente la composición definida en el UML: un préstamo contiene
 * un único libro asociado a su registro.
 */
public class Prestamo {
    private static final int DIAS_MAXIMO_PRESTAMO = 14;

    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private String estado;
    private final Libro libro;
    private final Usuario usuario;

    public Prestamo(Usuario usuario, Libro libro) {
        this(usuario, libro, new Date(), null, "ACTIVO");
    }

    public Prestamo(Usuario usuario, Libro libro, Date fechaPrestamo, Date fechaDevolucion, String estado) {
        this.usuario = Objects.requireNonNull(usuario, "El usuario es obligatorio.");
        this.libro = Objects.requireNonNull(libro, "El libro es obligatorio.");
        setFechaPrestamo(fechaPrestamo);
        setFechaDevolucion(fechaDevolucion);
        setEstado(estado);
    }

    public Date getFechaPrestamo() {
        return copiaFecha(fechaPrestamo);
    }

    public final void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = copiaFecha(Objects.requireNonNull(fechaPrestamo, "La fecha de préstamo es obligatoria."));
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion == null ? null : copiaFecha(fechaDevolucion);
    }

    public final void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion == null ? null : copiaFecha(fechaDevolucion);
    }

    public String getEstado() {
        return estado;
    }

    public final void setEstado(String estado) {
        if (estado == null || estado.isBlank()) {
            throw new IllegalArgumentException("El estado del préstamo es obligatorio.");
        }
        this.estado = estado.trim().toUpperCase();
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public int calcularDiasPrestamo() {
        Date fechaFin = fechaDevolucion == null ? new Date() : fechaDevolucion;
        long diferencia = fechaFin.getTime() - fechaPrestamo.getTime();
        return (int) TimeUnit.MILLISECONDS.toDays(diferencia);
    }

    public Boolean estaVencido(Date hoy) {
        Objects.requireNonNull(hoy, "La fecha de consulta es obligatoria.");
        long dias = TimeUnit.MILLISECONDS.toDays(hoy.getTime() - fechaPrestamo.getTime());
        return "ACTIVO".equals(estado) && dias > DIAS_MAXIMO_PRESTAMO;
    }

    public void devolver() {
        if ("DEVUELTO".equals(estado)) {
            return;
        }
        libro.devolver();
        fechaDevolucion = new Date();
        estado = "DEVUELTO";
    }

    private static Date copiaFecha(Date fecha) {
        return new Date(fecha.getTime());
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "libro='" + libro.getTitulo() + '\'' +
                ", usuario='" + usuario.getNombre() + '\'' +
                ", estado='" + estado + '\'' +
                ", dias=" + calcularDiasPrestamo() +
                '}';
    }
}
