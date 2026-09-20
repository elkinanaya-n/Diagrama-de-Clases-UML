package servicio;

import modelo.Prestamo;

import java.util.List;

/**
 * Abstracción mínima para persistir préstamos.
 * SOLID - DIP: los servicios dependen de esta abstracción, no de una
 * implementación concreta de almacenamiento.
 */
public interface PrestamoRepository {
    void guardar(Prestamo prestamo);
    List<Prestamo> listar();
}
