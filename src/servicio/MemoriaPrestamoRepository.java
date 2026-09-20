package servicio;

import modelo.Prestamo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Implementación en memoria para fines académicos y de demostración. */
public class MemoriaPrestamoRepository implements PrestamoRepository {
    private final List<Prestamo> prestamos = new ArrayList<>();

    @Override
    public void guardar(Prestamo prestamo) {
        if (prestamo == null) {
            throw new IllegalArgumentException("El préstamo no puede ser nulo.");
        }
        if (!prestamos.contains(prestamo)) {
            prestamos.add(prestamo);
        }
    }

    @Override
    public List<Prestamo> listar() {
        return Collections.unmodifiableList(prestamos);
    }
}
