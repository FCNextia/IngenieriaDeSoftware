DROP DATABASE IOteayudo;


CREATE DATABASE IOteayudo
   WITH OWNER = postgres
      ENCODING = 'UTF8'
      TABLESPACE = pg_default
      CONNECTION LIMIT = -1;

--Muchos problemas que vi, es que se debe de ingresar a la base
--de datos despues de crearla para insertar las tablas.
--Este comando cambia a la base de datos ioteayudo
\c ioteayudo

--Esta extensión es muy importante para el caso de uso Buscar Tutor
--Si por x o z razón les manda un error favor de buscar como
--instalarla en su computadora.
CREATE EXTENSION IF NOT EXISTS pg_trgm;

CREATE TABLE usuario (
	id_usuario INTEGER NOT NULL,
	correo_usuario VARCHAR(255) NOT NULL CHECK(correo_usuario SIMILAR TO '[0-9A-Za-z -_.áéíóúñü]+@%.%'),
	nombre_usuario VARCHAR(255) NOT NULL CHECK(nombre_usuario SIMILAR TO '[A-Za-z]+'),
	apellido_paterno_usuario VARCHAR(255) NOT NULL CHECK(apellido_paterno_usuario SIMILAR TO '[A-Za-záéíóúñü]+'),
	apellido_materno_usuario VARCHAR(255) NOT NULL CHECK(apellido_materno_usuario SIMILAR TO '[A-Za-záéíóúñü]+'),
	contrasenia_usuario VARCHAR(15) NOT NULL,
	telefono_usuario BIGINT NOT NULL CHECK(telefono_usuario <= 9999999999),
	acerca_de_usuario VARCHAR(255) NOT NULL,
	PRIMARY KEY(id_usuario));
	
create sequence usuario_pass
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;

CREATE TABLE alumno (
	id_usuario INTEGER NOT NULL,
	fecha_nacimiento_alumno DATE CHECK ( date_part('year',age(fecha_nacimiento_alumno)) >= 15 ),
	FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
	PRIMARY KEY(id_usuario));

CREATE TABLE estudios (
    nivel_estudios_tutor VARCHAR(255) NOT NULL PRIMARY KEY);


--Con respecto al problema de los tutores, bastaba con quitarle
--la nularidad a la columna nivel_estudios_tutor
CREATE TABLE tutor (
	id_usuario INTEGER NOT NULL PRIMARY KEY,
	nivel_estudios_tutor VARCHAR(255),
	FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY(nivel_estudios_tutor) REFERENCES estudios(nivel_estudios_tutor));

CREATE TABLE materia (
	id_materia INTEGER NOT NULL PRIMARY KEY,
	nombre_materia VARCHAR(255) NOT NULL,
	area_materia INTEGER,
	CHECK(area_materia >= 1 and area_materia <= 4));

CREATE TABLE tutor_materia (
	id_usuario INTEGER NOT NULL,
	id_materia INTEGER NOT NULL,
	FOREIGN KEY(id_usuario) REFERENCES tutor(id_usuario),
	FOREIGN KEY(id_materia) REFERENCES materia(id_materia));

INSERT INTO estudios (nivel_estudios_tutor) VALUES 
('Bachillerato'),
('Licenciatura'),
('Maestría'),
('Posgrado');
                                                    
--Función que regresa todos los tutores dada un nombre de una materia.
CREATE OR REPLACE FUNCTION buscartutor(varchar)
RETURNS SETOF usuario
AS $$
SELECT a.*
FROM
usuario as a
INNER JOIN tutor as b ON (a.id_usuario = b.id_usuario)
INNER JOIN tutor_materia as c ON (a.id_usuario = c.id_usuario)
INNER JOIN materia as d ON (c.id_materia = d.id_materia)
WHERE
nombre_materia = $1;
$$
LANGUAGE SQL;

