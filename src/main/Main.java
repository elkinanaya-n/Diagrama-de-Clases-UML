package main;

import modelo.Autor;
import modelo.Biblioteca;
import modelo.Libro;
import modelo.LibroDigital;
import modelo.Prestamo;
import modelo.Usuario;
import servicio.BibliotecaService;
import servicio.MemoriaPrestamoRepository;
import servicio.PrestamoRepository;

import java.util.Date;
import java.util.List;

/**
 * Punto de entrada para demostrar el funcionamiento del sistema.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("   SISTEMA DE BIBLIOTECA - POO / UML");
        System.out.println("============================================\n");

        Biblioteca biblioteca = new Biblioteca("Biblioteca IU Digital", "Medellín, Antioquia");

        Autor autor1 = new Autor("Gabriel García Márquez", "Colombiana");
        Autor autor2 = new Autor("Isabel Allende", "Chilena");
        biblioteca.registrarAutor(autor1);
        biblioteca.registrarAutor(autor2);

        Libro libro1 = new Libro("Cien años de soledad", "978-0307474728", autor1);
        Libro libro2 = new Libro("El amor en los tiempos del cólera", "978-0307389732", autor1);
        LibroDigital libroDigital = new LibroDigital(
                "La casa de los espíritus",
                "978-1501117015",
                autor2,
                "epub",
                3.5f
        );

        biblioteca.registrarLibro(libro1);
        biblioteca.registrarLibro(libro2);
        biblioteca.registrarLibro(libroDigital);

        System.out.println("[1] REGISTRO DE AUTORES Y LIBROS");
        System.out.println("Autores: " + biblioteca.getAutores().size());
        System.out.println("Libros: " + biblioteca.getLibros().size());
        System.out.println();

        System.out.println("[2] BÚSQUEDA Y SOBRECARGA");
        List<Libro> resultados = biblioteca.buscarPorTitulo("amor");
        System.out.println("Buscar 'amor': " + resultados.size() + " resultado(s)");
        List<Libro> disponibles = biblioteca.buscarPorTitulo("amor", true);
        System.out.println("Buscar 'amor' solo disponibles: " + disponibles.size() + " resultado(s)");
        System.out.println();

        System.out.println("[3] POLIMORFISMO + HERENCIA");
        List<Libro> bibliotecaPolimorfica = List.of(libro1, libroDigital);
        for (Libro libro : bibliotecaPolimorfica) {
            System.out.println("- " + libro.obtenerTipoRecurso() + ": " + libro.getTitulo());
        }
        System.out.println();

        System.out.println("[4] PRÉSTAMO + COMPOSICIÓN");
        Usuario usuario = new Usuario("U001", "Elkin Anaya", "elkin@example.com");
        PrestamoRepository repositorio = new MemoriaPrestamoRepository();
        BibliotecaService servicio = new BibliotecaService(biblioteca, repositorio);

        Prestamo prestamo = usuario.solicitarPrestamo(libro1);
        servicio.registrarPrestamo(prestamo);

        System.out.println("Préstamo registrado: " + prestamo);
        System.out.println("Disponible después del préstamo: " + libro1.isDisponible());
        System.out.println("Días del préstamo: " + prestamo.calcularDiasPrestamo());
        System.out.println("¿Vencido hoy?: " + prestamo.estaVencido(new Date()));
        System.out.println();

        usuario.devolverLibro(prestamo);
        System.out.println("Devolución realizada.");
        System.out.println("Disponible después de devolver: " + libro1.isDisponible());
        System.out.println("Estado del préstamo: " + prestamo.getEstado());
        System.out.println();

        System.out.println("[5] OPERACIONES DE LIBRO DIGITAL");
        libroDigital.descargar();
        libroDigital.leerEnLinea();
        System.out.println();

        System.out.println("[6] SOLID");
        System.out.println("SRP: responsabilidades separadas por clase.");
        System.out.println("OCP/LSP: LibroDigital extiende Libro sin romper su uso polimórfico.");
        System.out.println("DIP: BibliotecaService depende de PrestamoRepository.");
        System.out.println();

        System.out.println("Sistema ejecutado correctamente.");
    }
}
