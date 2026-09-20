package servicio;

import modelo.Biblioteca;
import modelo.Prestamo;

import java.util.List;
import java.util.Objects;

/**
 * Coordina casos de uso relacionados con los préstamos.
 * SOLID - SRP: separa la coordinación de casos de uso de las entidades.
 * SOLID - DIP: recibe PrestamoRepository por abstracción.
 */
public class BibliotecaService {
    private final Biblioteca biblioteca;
    private final PrestamoRepository prestamoRepository;

    public BibliotecaService(Biblioteca biblioteca, PrestamoRepository prestamoRepository) {
        this.biblioteca = Objects.requireNonNull(biblioteca, "La biblioteca es obligatoria.");
        this.prestamoRepository = Objects.requireNonNull(prestamoRepository, "El repositorio es obligatorio.");
    }

    public void registrarPrestamo(Prestamo prestamo) {
        biblioteca.registrarPrestamo(prestamo);
        prestamoRepository.guardar(prestamo);
    }

    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.listar();
    }
}
