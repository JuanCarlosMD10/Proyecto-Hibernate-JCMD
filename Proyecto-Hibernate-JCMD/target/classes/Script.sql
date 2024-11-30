-- Crear usuario
CREATE USER 'juancarlos'@'localhost' IDENTIFIED BY 'juancarlos';
-- Dar privilegios específicos
GRANT ALL PRIVILEGES ON proyectohibernatejcmd.* TO 'juancarlos'@'localhost';
-- Verificar los privilegios
SHOW GRANTS FOR 'juancarlos'@'localhost';
-- Eliminar base de datos existente
DROP DATABASE IF EXISTS proyectohibernatejcmd;
-- Crear base de datos
CREATE DATABASE proyectohibernatejcmd;
-- Usar base de datos
USE proyectohibernatejcmd;