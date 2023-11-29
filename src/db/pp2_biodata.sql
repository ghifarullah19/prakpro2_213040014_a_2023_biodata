-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 29, 2023 at 01:41 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pp2_biodata`
--

-- --------------------------------------------------------

--
-- Table structure for table `biodata`
--

CREATE TABLE `biodata` (
  `id` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `no_telepon` varchar(255) NOT NULL,
  `jenis_kelamin` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `biodata`
--

INSERT INTO `biodata` (`id`, `nama`, `no_telepon`, `jenis_kelamin`, `alamat`) VALUES
('0769223f-1996-46d1-ad9e-8330ccff6b06', 'Fauzi Ilyas', '081234567891', 'Laki-Laki', 'Pangandaran'),
('1af2b032-b5b1-4b9b-9595-09194e7c3b07', 'Muhammad Lutfi', '081222024097', 'Laki-Laki', 'Sarijadi'),
('424ce75b-7b67-4ed7-9333-ed21303f19ca', 'Gilang Ramadhan', '087896543121', 'Laki-Laki', 'Garut'),
('6153b7dc-a744-4118-9da1-07daa7851b49', 'Gilman Arief', '081987654321', 'Laki-Laki', 'Cimenyan'),
('64a66ed6-483a-465a-b819-4f16232e0193', 'Haykal Alvegio', '081234567891', 'Laki-Laki', 'Baleendah'),
('919eeb1d-64ee-4dd8-a8f7-8ea1237d3633', 'Mohammad Deandra', '081981234567', 'Laki-Laki', 'Cimahi'),
('9a8fe9f8-0a77-4dbc-be0d-9124258fed4d', 'Malwi Hidayat', '084567123891', 'Laki-Laki', 'Bekasi'),
('c4767096-fc4f-4a9b-b8ad-910791f45a60', 'Ainan Ihsan', '08123456789', 'Laki-Laki', 'Lembang'),
('ef9c340e-e4f1-404d-9090-6e491cb46f84', 'Nayanika Salsa', '087654891123', 'Perempuan', 'Malang'),
('efefe9d5-8f6c-493b-96b0-097d2ef2f188', 'Fowaz Amran', '081231987654', 'Laki-Laki', 'Cimahi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `biodata`
--
ALTER TABLE `biodata`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
