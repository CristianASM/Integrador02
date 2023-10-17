El Proyecto Integrador 2 consiste en desarrolar un sistema DAO para un almacén de productos, y hacer una conexión a una base de datos utilizando Java y Maven.               
Este proyecto incluye las peticiones CRUD: Crear producto, Buscar por ID, Actualizar por ID y Eliminar por ID.       
La lectura del código está en inglés, mientras que la interacción con el usuario se realiza en español.                              
Se implementó el patrón de diseño Singleton.

Se utilizó el motor de base de datos MySQL con la siguiente estructura:   
CREATE DATABASE integrador02;    
USE integrador02;    
CREATE TABLE `integrador02`.`productos` (
  `id_producto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` TEXT NOT NULL,
  `precio` DECIMAL(10,2) NOT NULL,
  `stock` INT NOT NULL,
  `fabricante` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_producto`));

// Productos de prueba    
INSERT INTO `productos` (`nombre`, `descripcion`, `precio`, `stock`, `fabricante`)
VALUES
    ('Agua mineral', 'Bidon de agua mineral sin gas de 6L', 1800, 100, 'Cachantun'),
    ('Galletas KuKy', 'Galletas KuKy clasicas con chips sabor chocolate', 1000, 75, 'McKay'),
    ('Papas fritas Stax', 'Papas fritas Stax clasicas en tarro, 134g', 1250, 50, "Lay's"),
    ('Manjarate', 'Postre Manjarate Receta Original Soprole, 80g', 500, 25, 'Soprole'),
    ('Whisky Botella', 'Whisky Old N°7 Jack Daniels, 750ml', 24000, 10, "Jack Daniel's");
