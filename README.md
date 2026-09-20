
# Sistema de Biblioteca - Programación Orientada a Objetos

Proyecto Java basado en el diagrama de clases UML elaborado en la Actividad 1 de la asignatura **Programación Orientada a Objetos**.

## Clases del modelo

- Autor
- Libro
- LibroDigital
- Usuario
- Prestamo
- Biblioteca

La implementación sigue las clases y relaciones visibles en el diagrama de la Actividad 1. El documento fuente plantea `Ejemplar` como una entidad opcional/recomendada en la explicación, pero la captura UML final utilizada para este proyecto no la contiene; por ello no se agrega como clase del modelo final.

## Relaciones UML implementadas

 Relación | Implementación 

| Asociación Autor-Libro | `Libro` mantiene un `Autor` y `Autor` mantiene una `List<Libro>`. |
| Agregación Biblioteca-Libro | `Biblioteca` mantiene `List<Libro>`. |
| Agregación Biblioteca-Autor | `Biblioteca` mantiene `List<Autor>`. |
| Composición Prestamo-Libro | `Prestamo` contiene una referencia final a un único `Libro`. |
| Herencia | `LibroDigital extends Libro`. |
| Asociación Usuario-Prestamo | `Prestamo` referencia al `Usuario` que lo realiza. |

## Pilares de POO

- **Encapsulamiento:** atributos privados y acceso mediante getters/setters.
- **Abstracción:** cada clase representa una responsabilidad del dominio.
- **Herencia:** `LibroDigital` reutiliza y especializa `Libro`.
- **Polimorfismo:** una `List<Libro>` contiene objetos `Libro` y `LibroDigital`.
- **Sobrescritura:** `LibroDigital` sobrescribe `obtenerTipoRecurso()` y `toString()`.
- **Sobrecarga:** `Biblioteca.buscarPorTitulo(String)` y `buscarPorTitulo(String, boolean)`.

## Principios SOLID evidenciados

1. **SRP - Single Responsibility Principle:** las entidades y servicios tienen responsabilidades separadas.
2. **OCP - Open/Closed Principle:** `LibroDigital` extiende `Libro` sin modificar la clase base.
3. **LSP - Liskov Substitution Principle:** `LibroDigital` puede utilizarse donde se espera un `Libro`.
4. **DIP - Dependency Inversion Principle:** `BibliotecaService` depende de `PrestamoRepository`, una abstracción.



>>>>>>> 1cb1eea11c3ea9a9f711d055e7d183623daa27b8
