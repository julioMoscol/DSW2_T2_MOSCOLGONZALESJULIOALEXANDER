create database T2_DSW2_MOSCOLGONZALESJULIOALEXANDER;

use t2_dsw2_moscolgonzalesjulioalexander;

CREATE TABLE `Proveedores` (
  `ProveedorID` int(11) NOT NULL AUTO_INCREMENT,
  `NombreProveedor` varchar(40) NOT NULL,
  `Contacto` varchar(40) DEFAULT NULL,
  `Direccion` varchar(100) DEFAULT NULL,
  `Telefono` varchar(20) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ProveedorID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT INTO `Proveedores` VALUES 
(1, 'TechWorld S.A.', 'Juan Pérez', 'Av. Tecnología 123, Ciudad', '123456789', 'contacto@techworld.com'),
(2, 'Innovatech S.L.', 'Ana García', 'Calle Innovación 45, Madrid', '987654321', 'ventas@innovatech.com'),
(3, 'CompuGlobal S.A.', 'Luis Ramírez', 'Calle de la Computación 789, Barcelona', '456123789', 'info@compuglobal.com'),
(4, 'MegaPeriféricos Ltda.', 'Marta López', 'Carrera 15 #56-78, Bogotá', '321654987', 'soporte@megaperifericos.com');

CREATE TABLE `Clientes` (
  `ClienteID` int(11) NOT NULL AUTO_INCREMENT,
  `NombreCliente` varchar(60) NOT NULL,
  `Contacto` varchar(40) DEFAULT NULL,
  `Direccion` varchar(100) DEFAULT NULL,
  `Telefono` varchar(20) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ClienteID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

INSERT INTO `Clientes` VALUES 
(1, 'Corporación ABC', 'Carlos Gómez', 'Calle Empresarial 456, Lima', '555123456', 'cgomez@corporacionabc.com'),
(2, 'Sistemas Integrados SRL', 'María Fernández', 'Av. Central 789, Buenos Aires', '555987654', 'maria@sistemasintegrados.com'),
(3, 'Redes Globales Ltda.', 'Pedro Rodríguez', 'Carrera 9 #12-34, Medellín', '555654123', 'prodriguez@redesglobales.com'),
(4, 'Tecnología Avanzada SAC', 'Rosa Morales', 'Jr. Industrial 321, Santiago', '555321789', 'rmorales@tecnologiaavanzada.com'),
(5, 'Usuario Final', 'Juan Sánchez', 'Calle Personal 123, Ciudad', '555111222', 'juan.sanchez@gmail.com');

CREATE TABLE `Categorias` (
  `CategoriaID` int(11) NOT NULL AUTO_INCREMENT,
  `NombreCategoria` varchar(15) NOT NULL,
  `Descripcion` mediumtext,
  PRIMARY KEY (`CategoriaID`),
  KEY `NombreCategoria` (`NombreCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Insertar datos en la tabla Categorias
INSERT INTO `Categorias` VALUES 
(1,'Laptops','Laptops y portátiles de diferentes marcas y configuraciones'),
(2,'Periféricos','Teclados, ratones, y otros periféricos para computadoras'),
(3,'Monitores','Monitores de diversas pulgadas y resoluciones'),
(4,'Componentes','Componentes como procesadores, tarjetas gráficas, y memorias RAM'),
(5,'Almacenamiento','Discos duros y unidades de estado sólido'),
(6,'Software','Software para sistemas operativos y aplicaciones'),
(7,'Accesorios','Accesorios diversos para computadoras');

CREATE TABLE `Productos` (
  `ProductoID` int(11) NOT NULL AUTO_INCREMENT,
  `NombreProducto` varchar(40) NOT NULL,
  `ProveedorID` int(11) DEFAULT NULL,
  `CategoriaID` int(11) DEFAULT NULL,
  `CantidadPorUnidad` varchar(20) DEFAULT NULL,
  `PrecioUnitario` decimal(10,4) DEFAULT '0.0000',
  `UnidadesEnStock` smallint(2) DEFAULT '0',
  `UnidadesEnPedido` smallint(2) DEFAULT '0',
  `NivelReorden` smallint(2) DEFAULT '0',
  `Descontinuado` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`ProductoID`),
  KEY `NombreProducto` (`NombreProducto`),
  KEY `FK_Productos_Categorias` (`CategoriaID`),
  KEY `FK_Productos_Proveedores` (`ProveedorID`),
  CONSTRAINT `FK_Productos_Proveedores` FOREIGN KEY (`ProveedorID`) REFERENCES `Proveedores` (`ProveedorID`),
  CONSTRAINT `FK_Productos_Categorias` FOREIGN KEY (`CategoriaID`) REFERENCES `Categorias` (`CategoriaID`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

INSERT INTO `Productos` VALUES 
(1,'Laptop Lenovo ThinkPad',1,1,'1 unidad',1200.0000,20,0,5,'\0'),
(2,'Monitor Samsung 27 pulgadas',1,3,'1 unidad',300.0000,50,10,15,'\0'),
(3,'Teclado mecánico Corsair',2,2,'1 unidad',80.0000,100,0,20,'\0'),
(4,'Procesador Intel Core i7',2,4,'1 unidad',350.0000,30,0,10,'\0'),
(5,'Disco Duro SSD 1TB',3,5,'1 unidad',150.0000,80,20,30,''),
(6,'Licencia Windows 10 Pro',3,6,'1 unidad',100.0000,150,0,50,'\0'),
(7,'Funda para laptop',4,7,'1 unidad',25.0000,200,0,50,'\0');

CREATE TABLE `Ventas` (
  `VentaID` int(11) NOT NULL AUTO_INCREMENT,
  `ClienteID` int(11) NOT NULL,
  `ProductoID` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `FechaVenta` date NOT NULL,
  `Total` decimal(10,2) NOT NULL,
  PRIMARY KEY (`VentaID`),
  KEY `FK_Ventas_Clientes` (`ClienteID`),
  KEY `FK_Ventas_Productos` (`ProductoID`),
  CONSTRAINT `FK_Ventas_Clientes` FOREIGN KEY (`ClienteID`) REFERENCES `Clientes` (`ClienteID`),
  CONSTRAINT `FK_Ventas_Productos` FOREIGN KEY (`ProductoID`) REFERENCES `Productos` (`ProductoID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `Ventas` (`ClienteID`, `ProductoID`, `Cantidad`, `FechaVenta`, `Total`) VALUES 
(1, 1, 5, '2024-10-01', 6000.00),
(2, 3, 10, '2024-10-02', 800.00),
(3, 2, 2, '2024-10-03', 600.00),
(4, 5, 1, '2024-10-04', 1200.00);

