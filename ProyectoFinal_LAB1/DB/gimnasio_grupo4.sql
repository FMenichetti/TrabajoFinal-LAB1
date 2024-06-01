-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-06-2024 a las 23:53:32
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gimnasio_grupo4`
--
CREATE DATABASE IF NOT EXISTS `gimnasio_grupo4` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `gimnasio_grupo4`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clases`
--

CREATE TABLE `clases` (
  `idClase` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `idEntrenador` int(11) NOT NULL,
  `horario` time(6) NOT NULL,
  `capacidad` int(15) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clases`
--

INSERT INTO `clases` (`idClase`, `nombre`, `idEntrenador`, `horario`, `capacidad`, `estado`) VALUES
(1, 'Fuerza', 1, '08:00:00.000000', 20, 1),
(2, 'Yoga', 2, '09:00:00.000000', 15, 1),
(3, 'Cardio', 3, '10:00:00.000000', 25, 1),
(4, 'Pilates', 4, '11:00:00.000000', 20, 1),
(5, 'Boxeo', 5, '12:00:00.000000', 20, 1),
(6, 'Fuerza', 6, '13:00:00.000000', 20, 1),
(7, 'Yoga', 7, '14:00:00.000000', 15, 1),
(8, 'Cardio', 8, '15:00:00.000000', 25, 1),
(9, 'Pilates', 9, '16:00:00.000000', 20, 1),
(10, 'Boxeo', 10, '17:00:00.000000', 20, 1),
(11, 'Fuerza', 11, '18:00:00.000000', 20, 1),
(12, 'Yoga', 12, '19:00:00.000000', 15, 1),
(13, 'Cardio', 13, '20:00:00.000000', 25, 1),
(14, 'Pilates', 14, '21:00:00.000000', 20, 1),
(15, 'Boxeo', 15, '22:00:00.000000', 20, 1),
(16, 'Fuerza', 16, '06:00:00.000000', 20, 1),
(17, 'Yoga', 17, '07:00:00.000000', 15, 1),
(18, 'Cardio', 18, '08:00:00.000000', 25, 1),
(19, 'Pilates', 19, '09:00:00.000000', 20, 1),
(20, 'Boxeo', 20, '10:00:00.000000', 20, 1),
(21, 'Fuerza', 1, '11:00:00.000000', 20, 1),
(22, 'Yoga', 2, '12:00:00.000000', 15, 1),
(23, 'Cardio', 3, '13:00:00.000000', 25, 1),
(24, 'Pilates', 4, '14:00:00.000000', 20, 1),
(25, 'Boxeo', 5, '15:00:00.000000', 20, 1),
(26, 'Fuerza', 6, '16:00:00.000000', 20, 1),
(27, 'Yoga', 7, '17:00:00.000000', 15, 1),
(28, 'Cardio', 8, '18:00:00.000000', 25, 1),
(29, 'Pilates', 9, '19:00:00.000000', 20, 1),
(30, 'Boxeo', 10, '20:00:00.000000', 20, 1),
(31, 'Fuerza', 11, '21:00:00.000000', 20, 1),
(32, 'Yoga', 12, '22:00:00.000000', 15, 1),
(33, 'Cardio', 13, '06:00:00.000000', 25, 1),
(34, 'Pilates', 14, '07:00:00.000000', 20, 1),
(35, 'Boxeo', 15, '08:00:00.000000', 20, 1),
(36, 'Fuerza', 16, '09:00:00.000000', 20, 1),
(37, 'Yoga', 17, '10:00:00.000000', 15, 1),
(38, 'Cardio', 18, '11:00:00.000000', 25, 1),
(39, 'Pilates', 19, '12:00:00.000000', 20, 1),
(40, 'Boxeo', 20, '13:00:00.000000', 20, 1),
(41, 'Fuerza', 1, '14:00:00.000000', 20, 1),
(42, ' Yoga', 2, '15:00:00.000000', 15, 1),
(43, 'Cardio', 3, '16:00:00.000000', 25, 1),
(44, 'Pilates', 4, '17:00:00.000000', 20, 1),
(45, 'Boxeo', 5, '18:00:00.000000', 20, 1),
(46, 'Fuerza', 6, '19:00:00.000000', 20, 1),
(47, 'Yoga', 7, '20:00:00.000000', 15, 1),
(48, 'Cardio', 8, '21:00:00.000000', 25, 1),
(49, 'Pilates', 9, '22:00:00.000000', 20, 1),
(50, 'Boxeo', 10, '06:00:00.000000', 20, 1),
(51, 'Fuerza', 11, '07:00:00.000000', 20, 1),
(52, 'Yoga', 12, '08:00:00.000000', 15, 1),
(53, 'Cardio', 13, '09:00:00.000000', 25, 1),
(54, 'Pilates', 14, '10:00:00.000000', 20, 1),
(55, 'Boxeo', 15, '11:00:00.000000', 20, 1),
(56, 'Fuerza', 16, '12:00:00.000000', 20, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenadores`
--

CREATE TABLE `entrenadores` (
  `idEntrenador` int(11) NOT NULL,
  `dni` int(15) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `especialidad` varchar(100) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `entrenadores`
--

INSERT INTO `entrenadores` (`idEntrenador`, `dni`, `nombre`, `apellido`, `especialidad`, `estado`) VALUES
(1, 12345678, 'Juan', 'Pérez', 'Entrenamiento de Fuerza', 1),
(2, 87654321, 'Ana', 'Martínez', 'Yoga', 1),
(3, 23456789, 'Carlos', 'González', 'Cardio', 1),
(4, 98765432, 'Laura', 'Sánchez', 'Pilates', 1),
(5, 34567890, 'Luis', 'Rodríguez', 'Boxeo', 1),
(6, 65432109, 'Marta', 'Díaz', 'Spinning', 1),
(7, 19283746, 'Pablo', 'Romero', 'HIIT', 1),
(8, 56473829, 'Raquel', 'Vega', 'Zumba', 1),
(9, 37482910, 'Fernando', 'Castro', 'CrossFit', 1),
(10, 90817263, 'Isabel', 'Ortiz', 'Aquaeróbicos', 1),
(11, 10928374, 'Miguel', 'Hernández', 'Natación', 1),
(12, 64738291, 'Sara', 'Iglesias', 'Kickboxing', 1),
(13, 28475639, 'Javier', 'Muñoz', 'Jiu-Jitsu', 1),
(14, 19384756, 'Cristina', 'Navarro', 'Karate', 1),
(15, 92736481, 'Sergio', 'López', 'Taekwondo', 1),
(16, 63729184, 'Elena', 'Ramos', 'Body Combat', 1),
(17, 37482956, 'David', 'Jiménez', 'Step', 1),
(18, 19283745, 'Patricia', 'Molina', 'Rehabilitación', 1),
(19, 47586920, 'Manuel', 'Moreno', 'Fisioterapia', 1),
(20, 28475698, 'Rocío', 'Gutiérrez', 'Meditación', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcion`
--

CREATE TABLE `inscripcion` (
  `idInscripcion` int(11) NOT NULL,
  `idClase` int(11) NOT NULL,
  `idSocio` int(11) NOT NULL,
  `fechaInscripcion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inscripcion`
--

INSERT INTO `inscripcion` (`idInscripcion`, `idClase`, `idSocio`, `fechaInscripcion`) VALUES
(1, 1, 45, '2023-07-15'),
(2, 7, 32, '2023-10-22'),
(3, 12, 67, '2023-02-05'),
(4, 3, 89, '2023-11-30'),
(5, 5, 14, '2023-09-17'),
(6, 20, 78, '2023-04-09'),
(7, 11, 3, '2023-08-27'),
(8, 18, 50, '2023-06-25'),
(9, 15, 22, '2023-12-04'),
(10, 9, 86, '2023-05-16'),
(11, 8, 74, '2023-01-12'),
(12, 2, 55, '2023-10-03'),
(13, 4, 65, '2023-03-28'),
(14, 6, 28, '2023-11-14'),
(15, 17, 7, '2023-07-09'),
(16, 13, 18, '2023-09-22'),
(17, 14, 88, '2023-12-18'),
(18, 23, 90, '2023-06-01'),
(19, 25, 35, '2023-02-18'),
(20, 21, 12, '2023-10-30'),
(21, 10, 42, '2023-05-02'),
(22, 22, 68, '2023-08-07'),
(23, 19, 1, '2023-04-21'),
(24, 24, 56, '2023-12-08'),
(25, 16, 23, '2023-07-23'),
(26, 25, 67, '2023-12-31'),
(27, 3, 10, '2023-06-09'),
(28, 7, 52, '2023-01-25'),
(29, 11, 74, '2023-09-04'),
(30, 1, 80, '2023-03-12'),
(31, 8, 17, '2023-10-15'),
(32, 4, 38, '2023-04-28'),
(33, 2, 81, '2023-12-19'),
(34, 6, 62, '2023-07-03'),
(35, 13, 19, '2023-01-29'),
(36, 20, 88, '2023-09-15'),
(37, 12, 48, '2023-05-20'),
(38, 9, 2, '2023-12-03'),
(39, 14, 84, '2023-08-26'),
(40, 5, 76, '2023-02-10'),
(41, 17, 25, '2023-10-28'),
(42, 21, 69, '2023-04-16'),
(43, 16, 11, '2023-12-22'),
(44, 24, 83, '2023-07-19'),
(45, 19, 49, '2023-01-06'),
(46, 15, 57, '2023-09-29'),
(47, 23, 82, '2023-05-05'),
(48, 18, 71, '2023-12-12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `membresia`
--

CREATE TABLE `membresia` (
  `idMembresia` int(11) NOT NULL,
  `idSocio` int(11) NOT NULL,
  `cantidadPases` int(11) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `costo` decimal(10,0) NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `membresia`
--

INSERT INTO `membresia` (`idMembresia`, `idSocio`, `cantidadPases`, `fechaInicio`, `fechaFin`, `costo`, `estado`) VALUES
(1, 15, 8, '2024-06-01', '2024-06-30', 50, 1),
(2, 45, 12, '2024-07-01', '2024-07-31', 75, 1),
(3, 30, 20, '2024-08-01', '2024-08-31', 100, 1),
(4, 15, 8, '2024-06-01', '2024-06-30', 50, 1),
(5, 45, 12, '2024-07-01', '2024-07-31', 75, 1),
(6, 30, 20, '2024-08-01', '2024-08-31', 100, 1),
(7, 1, 8, '2024-06-01', '2024-06-30', 80, 1),
(8, 2, 12, '2024-07-01', '2024-07-31', 120, 1),
(9, 3, 20, '2024-08-01', '2024-08-31', 200, 1),
(10, 4, 8, '2024-09-01', '2024-09-30', 80, 1),
(11, 5, 12, '2024-10-01', '2024-10-31', 120, 1),
(12, 6, 20, '2024-11-01', '2024-11-30', 200, 1),
(13, 7, 8, '2024-12-01', '2024-12-31', 80, 1),
(14, 8, 12, '2025-01-01', '2025-01-31', 120, 1),
(15, 9, 20, '2025-02-01', '2025-02-28', 200, 1),
(16, 10, 8, '2025-03-01', '2025-03-31', 80, 1),
(17, 11, 12, '2025-04-01', '2025-04-30', 120, 1),
(18, 12, 20, '2025-05-01', '2025-05-31', 200, 1),
(19, 13, 8, '2025-06-01', '2025-06-30', 80, 1),
(20, 14, 12, '2025-07-01', '2025-07-31', 120, 1),
(21, 15, 20, '2025-08-01', '2025-08-31', 200, 1),
(22, 16, 8, '2025-09-01', '2025-09-30', 80, 1),
(23, 17, 12, '2025-10-01', '2025-10-31', 120, 1),
(24, 18, 20, '2025-11-01', '2025-11-30', 200, 1),
(25, 19, 8, '2025-12-01', '2025-12-31', 80, 1),
(26, 20, 12, '2026-01-01', '2026-01-31', 120, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socios`
--

CREATE TABLE `socios` (
  `idSocio` int(11) NOT NULL,
  `dni` varchar(15) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `edad` int(11) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `socios`
--

INSERT INTO `socios` (`idSocio`, `dni`, `nombre`, `apellido`, `edad`, `correo`, `telefono`, `estado`) VALUES
(1, '123456789A', 'Juan', 'Perez', 30, 'juan@example.com', '123456789', 1),
(2, '987654321B', 'Maria', 'Gomez', 25, 'maria@example.com', '987654321', 1),
(3, '111111111C', 'Carlos', 'Rodriguez', 35, 'carlos@example.com', '111111111', 1),
(4, '222222222D', 'Laura', 'Fernandez', 28, 'laura@example.com', '222222222', 1),
(5, '333333333E', 'Pablo', 'Martinez', 45, 'pablo@example.com', '333333333', 0),
(6, '444444444F', 'Ana', 'Sanchez', 32, 'ana@example.com', '444444444', 1),
(7, '555555555G', 'Diego', 'Lopez', 29, 'diego@example.com', '555555555', 1),
(8, '666666666H', 'Lucia', 'Garcia', 27, 'lucia@example.com', '666666666', 1),
(9, '777777777I', 'Sofia', 'Diaz', 33, 'sofia@example.com', '777777777', 1),
(10, '888888888J', 'Javier', 'Alvarez', 31, 'javier@example.com', '888888888', 0),
(11, '999999999K', 'Elena', 'Moreno', 26, 'elena@example.com', '999999999', 1),
(12, '101010101L', 'Manuel', 'Jimenez', 40, 'manuel@example.com', '101010101', 1),
(13, '121212121M', 'Paula', 'Ruiz', 23, 'paula@example.com', '121212121', 1),
(14, '131313131N', 'Miguel', 'Torres', 36, 'miguel@example.com', '131313131', 1),
(15, '141414141O', 'Sara', 'Navarro', 29, 'sara@example.com', '141414141', 1),
(16, '151515151P', 'Daniel', 'Sanz', 38, 'daniel@example.com', '151515151', 1),
(17, '161616161Q', 'Carmen', 'Iglesias', 24, 'carmen@example.com', '161616161', 1),
(18, '171717171R', 'Jorge', 'Ortega', 42, 'jorge@example.com', '171717171', 0),
(19, '181818181S', 'Eva', 'Gutierrez', 30, 'eva@example.com', '181818181', 1),
(20, '191919191T', 'Alberto', 'Molina', 37, 'alberto@example.com', '191919191', 1),
(21, '202020202U', 'Lorena', 'Ramos', 28, 'lorena@example.com', '202020202', 1),
(22, '212121212V', 'Francisco', 'Blanco', 39, 'francisco@example.com', '212121212', 1),
(23, '222222222W', 'Beatriz', 'Castro', 25, 'beatriz@example.com', '222222222', 1),
(24, '232323232X', 'Antonio', 'Fuentes', 34, 'antonio@example.com', '232323232', 1),
(25, '242424242Y', 'Isabel', 'Hernandez', 27, 'isabel@example.com', '242424242', 1),
(26, '252525252Z', 'Raul', 'Gomez', 41, 'raul@example.com', '252525252', 1),
(27, '262626262A', 'Marina', 'Dominguez', 31, 'marina@example.com', '262626262', 1),
(28, '272727272B', 'Albert', 'Vidal', 29, 'albert@example.com', '272727272', 1),
(29, '282828282C', 'Cristina', 'Pascual', 33, 'cristina@example.com', '282828282', 1),
(30, '292929292D', 'Diego', 'Serrano', 35, 'diego2@example.com', '292929292', 1),
(31, '303030303E', 'Sara', 'Mendez', 26, 'sara2@example.com', '303030303', 1),
(32, '313131313F', 'Pablo', 'Garcia', 30, 'pablo2@example.com', '313131313', 1),
(33, '323232323G', 'Laura', 'Fernandez', 28, 'laura2@example.com', '323232323', 1),
(34, '333333333H', 'Lucia', 'Martin', 32, 'lucia2@example.com', '333333333', 1),
(35, '343434343I', 'Manuel', 'Lopez', 29, 'manuel2@example.com', '343434343', 1),
(36, '353535353J', 'Maria', 'Sanchez', 37, 'maria2@example.com', '353535353', 1),
(37, '363636363K', 'Javier', 'Martinez', 31, 'javier2@example.com', '363636363', 1),
(38, '373737373L', 'Sofia', 'Perez', 26, 'sofia2@example.com', '373737373', 1),
(39, '383838383M', 'Daniel', 'Gomez', 34, 'daniel2@example.com', '383838383', 1),
(40, '393939393N', 'Elena', 'Rodriguez', 30, 'elena2@example.com', '393939393', 1),
(41, '404040404O', 'Paula', 'Hernandez', 28, 'paula2@example.com', '404040404', 1),
(42, '414141414P', 'Miguel', 'Fernandez', 33, 'miguel2@example.com', '414141414', 1),
(43, '424242424Q', 'Ana', 'Jimenez', 27, 'ana2@example.com', '424242424', 1),
(44, '434343434R', 'Sara', 'Garcia', 31, 'sara3@example.com', '434343434', 1),
(45, '444444444S', 'Carlos', 'Perez', 29, 'carlos2@example.com', '444444444', 1),
(46, '464646464U', 'David', 'Alonso', 28, 'david@example.com', '464646464', 1),
(47, '474747474V', 'Patricia', 'Gutierrez', 30, 'patricia@example.com', '474747474', 1),
(48, '484848484W', 'Javier', 'Romero', 34, 'javier3@example.com', '484848484', 1),
(49, '494949494X', 'Elena', 'Rivas', 26, 'elena3@example.com', '494949494', 1),
(50, '505050505Y', 'Mario', 'Sanz', 39, 'mario@example.com', '505050505', 1),
(51, '515151515Z', 'Sara', 'Lopez', 27, 'sara4@example.com', '515151515', 1),
(52, '525252525A', 'Carlos', 'Hernandez', 31, 'carlos3@example.com', '525252525', 1),
(53, '535353535B', 'Lucia', 'Martinez', 29, 'lucia3@example.com', '535353535', 1),
(54, '545454545C', 'Marcos', 'Garcia', 33, 'marcos@example.com', '545454545', 1),
(55, '555555555D', 'Paula', 'Jimenez', 25, 'paula3@example.com', '555555555', 1),
(56, '565656565E', 'Diego', 'Perez', 32, 'diego3@example.com', '565656565', 1),
(57, '575757575F', 'Laura', 'Fernandez', 28, 'laura4@example.com', '575757575', 1),
(58, '585858585G', 'Sergio', 'Rodriguez', 30, 'sergio@example.com', '585858585', 1),
(59, '595959595H', 'Maria', 'Gomez', 36, 'maria3@example.com', '595959595', 1),
(60, '606060606I', 'David', 'Sanchez', 29, 'david2@example.com', '606060606', 1),
(61, '616161616J', 'Eva', 'Gutierrez', 31, 'eva2@example.com', '616161616', 1),
(62, '626262626K', 'Javier', 'Martinez', 27, 'javier4@example.com', '626262626', 1),
(63, '636363636L', 'Cristina', 'Serrano', 34, 'cristina2@example.com', '636363636', 1),
(64, '646464646M', 'Sara', 'Lopez', 30, 'sara5@example.com', '646464646', 1),
(65, '656565656N', 'Juan', 'Hernandez', 28, 'juan2@example.com', '656565656', 1),
(66, '666666666O', 'Laura', 'Jimenez', 32, 'laura5@example.com', '666666666', 1),
(67, '676767676P', 'Marcos', 'Garcia', 26, 'marcos2@example.com', '676767676', 1),
(68, '686868686Q', 'Elena', 'Martin', 33, 'elena4@example.com', '686868686', 1),
(69, '696969696R', 'Diego', 'Perez', 29, 'diego4@example.com', '696969696', 1),
(70, '707070707S', 'Laura', 'Fernandez', 31, 'laura6@example.com', '707070707', 1),
(71, '717171717T', 'Sergio', 'Rodriguez', 27, 'sergio2@example.com', '717171717', 1),
(72, '727272727U', 'Maria', 'Gomez', 35, 'maria4@example.com', '727272727', 1),
(73, '737373737V', 'David', 'Sanchez', 30, 'david3@example.com', '737373737', 1),
(74, '747474747W', 'Eva', 'Gutierrez', 28, 'eva3@example.com', '747474747', 1),
(75, '757575757X', 'Javier', 'Martinez', 34, 'javier5@example.com', '757575757', 1),
(76, '767676767Y', 'Cristina', 'Serrano', 29, 'cristina3@example.com', '767676767', 1),
(77, '777777777Z', 'Sara', 'Lopez', 33, 'sara6@example.com', '777777777', 1),
(78, '787878787A', 'Juan', 'Hernandez', 27, 'juan3@example.com', '787878787', 1),
(79, '797979797B', 'Laura', 'Jimenez', 31, 'laura7@example.com', '797979797', 1),
(80, '808080808C', 'Marcos', 'Garcia', 25, 'marcos3@example.com', '808080808', 1),
(81, '818181818D', 'Elena', 'Martin', 32, 'elena5@example.com', '818181818', 1),
(82, '828282828E', 'Diego', 'Perez', 28, 'diego5@example.com', '828282828', 1),
(83, '838383838F', 'Laura', 'Fernandez', 34, 'laura8@example.com', '838383838', 1),
(84, '848484848G', 'Sergio', 'Rodriguez', 30, 'sergio3@example.com', '848484848', 1),
(85, '858585858H', 'Maria', 'Gomez', 26, 'maria5@example.com', '858585858', 1),
(86, '868686868I', 'David', 'Sanchez', 33, 'david4@example.com', '868686868', 1),
(87, '878787878J', 'Eva', 'Gutierrez', 29, 'eva4@example.com', '878787878', 1),
(88, '888888888K', 'Javier', 'Martinez', 35, 'javier6@example.com', '888888888', 1),
(89, '898989898L', 'Cristina', 'Serrano', 31, 'cristina4@example.com', '898989898', 1),
(90, '909090909M', 'Sara', 'Lopez', 27, 'sara7@example.com', '909090909', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clases`
--
ALTER TABLE `clases`
  ADD PRIMARY KEY (`idClase`),
  ADD KEY `idEntrenador` (`idEntrenador`);

--
-- Indices de la tabla `entrenadores`
--
ALTER TABLE `entrenadores`
  ADD PRIMARY KEY (`idEntrenador`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD PRIMARY KEY (`idInscripcion`),
  ADD KEY `idClase` (`idClase`),
  ADD KEY `idSocio` (`idSocio`);

--
-- Indices de la tabla `membresia`
--
ALTER TABLE `membresia`
  ADD PRIMARY KEY (`idMembresia`),
  ADD KEY `idSocio` (`idSocio`);

--
-- Indices de la tabla `socios`
--
ALTER TABLE `socios`
  ADD PRIMARY KEY (`idSocio`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clases`
--
ALTER TABLE `clases`
  MODIFY `idClase` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT de la tabla `entrenadores`
--
ALTER TABLE `entrenadores`
  MODIFY `idEntrenador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  MODIFY `idInscripcion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT de la tabla `membresia`
--
ALTER TABLE `membresia`
  MODIFY `idMembresia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `socios`
--
ALTER TABLE `socios`
  MODIFY `idSocio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clases`
--
ALTER TABLE `clases`
  ADD CONSTRAINT `clases_ibfk_1` FOREIGN KEY (`idEntrenador`) REFERENCES `entrenadores` (`idEntrenador`);

--
-- Filtros para la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD CONSTRAINT `inscripcion_ibfk_1` FOREIGN KEY (`idClase`) REFERENCES `clases` (`idClase`),
  ADD CONSTRAINT `inscripcion_ibfk_2` FOREIGN KEY (`idSocio`) REFERENCES `socios` (`idSocio`);

--
-- Filtros para la tabla `membresia`
--
ALTER TABLE `membresia`
  ADD CONSTRAINT `membresia_ibfk_1` FOREIGN KEY (`idSocio`) REFERENCES `socios` (`idSocio`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
