DROP DATABASE IF EXISTS elliptic_curves_prueba;
CREATE DATABASE elliptic_curves_prueba;
USE elliptic_curves_prueba;

DROP TABLE IF EXISTS curves;
CREATE TABLE curves
(
numb   smallint    unsigned not null auto_increment comment 'Id autogenerado',
nombre varchar(50) not null comment 'Nombre de la curva',
length_bits int  comment 'Tamaño en bits',
q_p text comment 'Característica del campo primo. ',
a text comment 'Coeﬁciente a de la ecuación de la curva ',
b text comment 'Coeﬁciente b de la ecuación de la curva ',
P text comment 'Punto Base P ( o Q) ',
n text comment 'Orden del grupo cíclico P',
h int comment ' Índice de P',
primary key (numb)
);
