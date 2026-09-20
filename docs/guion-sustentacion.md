# Guion sugerido para video de sustentación (5 a 8 minutos)

## 0:00 - 0:40 | Presentación
- Saludo e identificación del grupo.
- Nombre de la actividad y del sistema.
- Mostrar brevemente el diagrama UML.

## 0:40 - 2:00 | Relación UML -> Java
- Explicar `Autor` y `Libro` como asociación.
- Explicar la agregación de `Biblioteca` con `Libro` y `Autor`.
- Explicar la composición `Prestamo -> Libro`.
- Explicar la asociación `Usuario -> Prestamo`.

## 2:00 - 3:20 | POO
- Encapsulamiento: atributos `private` y métodos de acceso.
- Abstracción: responsabilidades de cada clase.
- Herencia: `LibroDigital extends Libro`.
- Polimorfismo: `List<Libro>` con `Libro` y `LibroDigital`.
- Sobrescritura: `@Override` en `LibroDigital`.
- Sobrecarga: `buscarPorTitulo` con dos firmas.

## 3:20 - 4:40 | SOLID
- SRP: separación entre entidades y servicios.
- OCP/LSP: extensión mediante `LibroDigital`.
- DIP: `BibliotecaService` usa `PrestamoRepository`.

## 4:40 - 6:10 | Ejecución
- Ejecutar `Main`.
- Mostrar registro de autores y libros.
- Mostrar búsqueda.
- Mostrar préstamo, disponibilidad y devolución.
- Mostrar operaciones del libro digital.

## 6:10 - 7:20 | GitHub
- Mostrar el repositorio.
- Mostrar estructura de carpetas.
- Mostrar historial de commits.
- Cada integrante identifica su commit y explica su aporte.

## 7:20 - 8:00 | Cierre
- Relacionar el resultado con los objetivos.
- Mencionar brevemente qué aportó el ejercicio al aprendizaje profesional.
