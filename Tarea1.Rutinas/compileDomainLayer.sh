#!/bin/bash
javac -cp "universidad/WEB-INF/classes";"universidad/WEB-INF/lib/*.jar" -d universidad/WEB-INF/classes src/domain/ListaProfesores.java src/domain/DetalleProfesor.java src/domain/ActualizarProfesor.java
