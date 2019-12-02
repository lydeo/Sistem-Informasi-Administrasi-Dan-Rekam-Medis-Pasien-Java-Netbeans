-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 13, 2018 at 11:52 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `klinik`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_antrian`
--

CREATE TABLE `tb_antrian` (
  `no_antrian` varchar(3) NOT NULL,
  `no_rm` int(3) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `tanggal_periksa` date NOT NULL,
  `keluhan` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_dokter`
--

CREATE TABLE `tb_dokter` (
  `id_dokter` varchar(7) NOT NULL,
  `nama_dokter` varchar(25) NOT NULL,
  `alamat_dokter` varchar(40) NOT NULL,
  `telepon_dokter` varchar(12) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `jadwal_praktek` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_dokter`
--

INSERT INTO `tb_dokter` (`id_dokter`, `nama_dokter`, `alamat_dokter`, `telepon_dokter`, `username`, `password`, `jadwal_praktek`) VALUES
('0318002', 'Paramintha', 'Jalan Raya Bogor', '085256534356', 'dokter', 'qwe', 'Sabut 08.00-18.00'),
('0318004', 'Cherryl Lumentut', 'jl. Bahu', '081210261202', 'dokter2', 'qwe', 'Selasa-Kamis 09-00-18.00'),
('0318005', 'Petra Rantung', 'Kampus Kleak', '085256534356', 'petra', 'qwe', 'Senin-Jumat 08-00-15.00');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pasien`
--

CREATE TABLE `tb_pasien` (
  `no_rm` int(3) NOT NULL,
  `nama_pasien` varchar(25) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `jenis_kelamin` varchar(1) NOT NULL,
  `gol_darah` varchar(2) NOT NULL,
  `pekerjaan_pasien` varchar(15) NOT NULL,
  `alamat_pasien` varchar(40) NOT NULL,
  `telepon` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pasien`
--

INSERT INTO `tb_pasien` (`no_rm`, `nama_pasien`, `tanggal_lahir`, `jenis_kelamin`, `gol_darah`, `pekerjaan_pasien`, `alamat_pasien`, `telepon`) VALUES
(6, 'Letare Deo Politon', '2018-08-09', 'L', 'A', 'k', 'Srengseng Sawah', '081210261292'),
(7, 'Yakobus Politon', '1997-12-28', 'L', 'O', 'Mahasiswa', 'Perum Paniki II', '085256534356'),
(8, 'Nadya Tuna', '1996-10-06', 'P', 'O', 'Pendeta', 'Kampus Kleak', '081210020033'),
(9, 'Clifert Walandow', '1996-08-14', 'L', 'AB', 'Mahasiswa', 'Perkamil Jaya', '085534334356');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pegawai`
--

CREATE TABLE `tb_pegawai` (
  `id_pegawai` varchar(7) NOT NULL,
  `nama_pegawai` varchar(25) NOT NULL,
  `alamat_pegawai` varchar(40) NOT NULL,
  `telepon_pegawai` varchar(12) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `jabatan` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pegawai`
--

INSERT INTO `tb_pegawai` (`id_pegawai`, `nama_pegawai`, `alamat_pegawai`, `telepon_pegawai`, `username`, `password`, `jabatan`) VALUES
('0118001', 'Sintia Rakian', 'Tebet Barat', '082110290933', 'resep', 'qwe', 'Resepsionis'),
('0118002', 'Deo Politon', 'srengseng sawah', '081210261292', 'admin', 'qwe', 'Admin'),
('0118003', 'Trini Batargoa', 'Manibang', '085256534355', 'nino', 'qwe', 'Resepsionis'),
('0118004', 'Eva Kodongan', 'Jl.SEA', '085256534354', 'eva', 'qwe', 'Admin'),
('0118005', 'Rian Ratag', 'Karimbow', '085256534353', 'resep1', 'qwe', 'Resepsionis'),
('0118006', 'Letare Yakobus', 'Jl Mawar III', '085240455560', 'admin1', 'qwe', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `tb_riwayat`
--

CREATE TABLE `tb_riwayat` (
  `no_periksa` varchar(9) NOT NULL,
  `no_rm` int(3) NOT NULL,
  `tanggal_periksa` date NOT NULL,
  `tindakan` varchar(500) NOT NULL,
  `diagnosa` varchar(500) NOT NULL,
  `resep` varchar(500) NOT NULL,
  `tekanan_darah` varchar(7) NOT NULL,
  `keluhan` varchar(500) NOT NULL,
  `nama_dokter` varchar(32) NOT NULL,
  `berat` int(3) NOT NULL,
  `tinggi` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_riwayat`
--

INSERT INTO `tb_riwayat` (`no_periksa`, `no_rm`, `tanggal_periksa`, `tindakan`, `diagnosa`, `resep`, `tekanan_darah`, `keluhan`, `nama_dokter`, `berat`, `tinggi`) VALUES
('180813001', 8, '2018-08-13', 'periksa kornea mata, ambil sampel darah', 'demam berdarah', '1. Obat Panas\n2. Antibiotik', '90/100', 'kepala pusing, meriang', 'DR. Cherryl Lumentut', 63, 160),
('180813002', 9, '2018-08-13', 'periksa THT', 'Flu ringan karena perubaha cuaca', '1. Antibiotik\n2. Obat Batuk\n3. Obat Flu', '70/120', 'Flu, batuk', 'DR. Cherryl Lumentut', 50, 160),
('180813003', 6, '2018-08-13', 'Periksa tenggorokan', 'infeksi amandel', '1. Obat Panas\n2. Antibiotik\n3. Obat Amandel', '90/120', 'Amandel', 'DR. Cherryl Lumentut', 90, 170),
('180813004', 6, '2018-08-13', 'ambil sampel darah, periksa ginjal', 'Asam urat akut', '1. Obat asam urat\n2. Antibiotik', '90/140', 'Asam urat', 'DR. Cherryl Lumentut', 90, 170),
('180813005', 7, '2018-08-13', 'ambil sampel urine', 'keracunan makanan', '1. Antibiotik', '80/120', 'muntah - muntah', 'DR. Cherryl Lumentut', 80, 170);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_antrian`
--
ALTER TABLE `tb_antrian`
  ADD PRIMARY KEY (`no_antrian`),
  ADD KEY `fk_antri_pasien` (`no_rm`);

--
-- Indexes for table `tb_dokter`
--
ALTER TABLE `tb_dokter`
  ADD PRIMARY KEY (`id_dokter`);

--
-- Indexes for table `tb_pasien`
--
ALTER TABLE `tb_pasien`
  ADD PRIMARY KEY (`no_rm`);

--
-- Indexes for table `tb_pegawai`
--
ALTER TABLE `tb_pegawai`
  ADD PRIMARY KEY (`id_pegawai`);

--
-- Indexes for table `tb_riwayat`
--
ALTER TABLE `tb_riwayat`
  ADD PRIMARY KEY (`no_periksa`),
  ADD KEY `fk_rm_dokter` (`no_rm`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_pasien`
--
ALTER TABLE `tb_pasien`
  MODIFY `no_rm` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_antrian`
--
ALTER TABLE `tb_antrian`
  ADD CONSTRAINT `fk_antri_pasien` FOREIGN KEY (`no_rm`) REFERENCES `tb_pasien` (`no_rm`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_riwayat`
--
ALTER TABLE `tb_riwayat`
  ADD CONSTRAINT `fk_rm_dokter` FOREIGN KEY (`no_rm`) REFERENCES `tb_pasien` (`no_rm`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
