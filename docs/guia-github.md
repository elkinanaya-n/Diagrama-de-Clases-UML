# Guia rápida para subir el proyecto a GitHub

## 1. Crear o clonar el repositorio

```bash
git clone https://github.com/elkinanaya-n/Diagrama-de-Clases-UML.git
cd Diagrama-de-Clases-UML
```

Copiar el contenido de `biblioteca-poo-grupoX` dentro del repositorio.

## 2. Revisar el proyecto

```bash
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out main.Main
```

## 3. Distribuir commits por integrante

Cada estudiante debe configurar su propia identidad de Git y crear un commit con su cuenta.

```bash
git config user.name "Nombre del estudiante"
git config user.email "correo-del-estudiante@example.com"
```

Mensajes sugeridos:

- `Implementa clase Libro con encapsulamiento`
- `Implementa herencia y polimorfismo de LibroDigital`
- `Implementa Usuario y Prestamo`
- `Implementa Biblioteca y consultas`
- `Agrega Main y documentación SOLID`

Luego:

```bash
git add .
git commit -m "Mensaje del commit"
git push origin main
```

## 4. Comprobación final

```bash
git log --oneline --decorate --graph -10
git status
```

El equipo debe comprobar que aparecen los commits de los integrantes y que el docente tiene permisos de acceso.
