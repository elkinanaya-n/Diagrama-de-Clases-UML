# Sistema de Biblioteca - Programación Orientada a Objetos

Proyecto Java basado en el diagrama de clases UML elaborado en la Actividad 1 de la asignatura **Programación Orientada a Objetos**.

## Clases del modelo

- `Autor`
- `Libro`
- `LibroDigital`
- `Usuario`
- `Prestamo`
- `Biblioteca`

La implementación sigue las clases y relaciones visibles en el diagrama de la Actividad 1. El documento fuente plantea `Ejemplar` como una entidad opcional/recomendada en la explicación, pero la captura UML final utilizada para este proyecto no la contiene; por ello no se agrega como clase del modelo final.

## Relaciones UML implementadas

| Relación | Implementación |
|---|---|
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

## Ejecución

### Opción 1: compilación directa

```bash
javac -d out $(find src -name "*.java")
java -cp out main.Main
```

En Windows PowerShell se puede usar:

```powershell
Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { $_.FullName } | Set-Content sources.txt
javac -d out @sources.txt
java -cp out main.Main
```

### Opción 2: IDE

Importar el directorio como proyecto Java y ejecutar `src/main/Main.java`.

## Control de versiones

Cada integrante debe crear al menos un commit con su propia cuenta de GitHub. Se recomienda distribuir el trabajo y usar mensajes como:

- `Implementa clase Libro con encapsulamiento`
- `Implementa herencia y polimorfismo de LibroDigital`
- `Implementa Usuario y Prestamo`
- `Implementa Biblioteca y consultas`
- `Agrega Main y documentación SOLID`

Después, todos deben hacer `git push` al repositorio grupal. La entrega exige que el docente pueda identificar los aportes individuales en el historial.

## Sustentación

El video debe mostrar el UML, el código de cada integrante, la relación entre UML y Java, la evidencia de SOLID y la ejecución de `Main`. Se incluye un guion sugerido en `docs/guion-sustentacion.md`.

## Datos de la Actividad 1

- Estudiante registrado en la fuente UML: **Elkin Darío Anaya Montaño**
- Grupo: **PREICA2602B010093**
- Docente: **Boris Alberto Salleg Royero**
- Universidad: **Institución Universitaria Digital de Antioquia - IU Digital**
- Año: **2026**
- Repositorio de referencia reportado en la Actividad 1: `https://github.com/elkinanaya-n/Diagrama-de-Clases-UML/tree/main#`

> Nota: el repositorio y los permisos de acceso deben ser verificados por el equipo antes de la entrega final.
