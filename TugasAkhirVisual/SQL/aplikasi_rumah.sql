-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 30 Apr 2025 pada 02.45
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aplikasi_rumah`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `client`
--

CREATE TABLE `client` (
  `Id Client` int(11) NOT NULL,
  `NIK` varchar(20) NOT NULL,
  `Nama Client` varchar(100) NOT NULL,
  `Nomor KK` varchar(20) NOT NULL,
  `Alamat` text NOT NULL,
  `NPWP` varchar(20) DEFAULT NULL,
  `Asuransi` varchar(100) DEFAULT NULL,
  `Gaji` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `client`
--

INSERT INTO `client` (`Id Client`, `NIK`, `Nama Client`, `Nomor KK`, `Alamat`, `NPWP`, `Asuransi`, `Gaji`) VALUES
(6, '123456789', 'Wahuy ', '123456789', 'samping depok', '123456789', 'BPJS kelas 3', 90000000),
(7, '122', 'jejeng', '166', 'samping bogor', '144', 'BPJS Kelas 3', 200000),
(11, '123123123123', 'Hanif', '123123123', 'jl keadilan raya no. 114 rt 03/05 kalibata citeureup, kota Bandung', '22211344', 'BPJS Ketenagakerjaan', 20000000),
(12, '12121212', 'Ridwan', '21212121', 'Jogja', '112211', 'AIA', 30000000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `jabatan`
--

CREATE TABLE `jabatan` (
  `Id Jabatan` int(11) NOT NULL,
  `Jabatan` varchar(100) NOT NULL,
  `Gaji Pokok` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `jabatan`
--

INSERT INTO `jabatan` (`Id Jabatan`, `Jabatan`, `Gaji Pokok`) VALUES
(7, 'UI/UX', 2000000),
(8, 'Cyber Security Consultant', 8000000),
(9, 'Android Dev', 6000000),
(11, 'Marketing', 9000000),
(12, 'Digital Agensi', 13000),
(15, 'Marketing Galery', 3500000),
(21, 'Akuntan', 10000000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `karyawan`
--

CREATE TABLE `karyawan` (
  `Id karyawan` int(11) NOT NULL,
  `Nama Karyawan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `karyawan`
--

INSERT INTO `karyawan` (`Id karyawan`, `Nama Karyawan`) VALUES
(7, 'Cryl Syahwal'),
(8, 'Bambang Sutrisna'),
(9, 'Abiyu'),
(17, 'roy natanael'),
(27, 'Aditya');

-- --------------------------------------------------------

--
-- Struktur dari tabel `rab`
--

CREATE TABLE `rab` (
  `Id RAB` int(11) NOT NULL,
  `Tipe` varchar(100) NOT NULL,
  `Keterangan` text NOT NULL,
  `Harga` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `rab`
--

INSERT INTO `rab` (`Id RAB`, `Tipe`, `Keterangan`, `Harga`) VALUES
(5, 'A1', 'kanopi', 200000),
(7, 'A1', 'Struktur', 345000),
(8, 'A2', 'Batu bata', 2000000),
(9, 'A2', 'Semen', 3000000),
(10, 'A2', 'Struktur', 500000),
(14, 'A3', 'Pondasi', 300000000),
(16, 'A4', 'Pondasi', 120000000),
(17, 'A4', 'Semen', 30000000),
(18, 'A4', 'Pasir', 20000000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tipe_rumah`
--

CREATE TABLE `tipe_rumah` (
  `Id Rumah` int(11) NOT NULL,
  `Tipe` varchar(100) NOT NULL,
  `Harga Pokok` double NOT NULL,
  `Luas Bangunan` double NOT NULL,
  `Luas Tanah` double NOT NULL,
  `Kamar Tidur` int(11) NOT NULL,
  `Deskripsi` text NOT NULL,
  `Kamar Mandi` int(11) NOT NULL,
  `Lantai` int(11) NOT NULL,
  `Listrik` varchar(100) NOT NULL,
  `Sumber Air` varchar(100) NOT NULL,
  `Harga Rumah` double NOT NULL,
  `Total Bonus` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tipe_rumah`
--

INSERT INTO `tipe_rumah` (`Id Rumah`, `Tipe`, `Harga Pokok`, `Luas Bangunan`, `Luas Tanah`, `Kamar Tidur`, `Deskripsi`, `Kamar Mandi`, `Lantai`, `Listrik`, `Sumber Air`, `Harga Rumah`, `Total Bonus`) VALUES
(6, 'Multifungsi', 900000000, 500, 600, 50, 'rumah tahan tsunami', 90, 890, '3000000', 'sudekat', 7000000000, 700000),
(7, 'lalala', 40000000, 900, 200, 3, 'anjay', 2, 2, '4000', 'sudekat', 400000000, 800000),
(8, 'A2', 5500000, 2000, 2000, 2, 'Daerah Depok', 2, 2, '2000', 'PAM', 90000000, 9000000),
(10, 'A1', 545000, 1000, 1200, 4, 'Keren bngt', 5, 3, '2300', 'Air Tanah', 230000000, 6900000),
(11, 'A3', 300000000, 2000, 2500, 4, 'Dekat Kolam Ikan', 3, 2, '3000', 'PAM', 1000000000, 30000000),
(12, 'A2', 5500000, 3000, 2300, 4, 'Daerah Pesisir', 2, 2, '20000', 'PAM', 900000000, 27000000),
(13, 'A3', 300000000, 2000, 2300, 4, 'Daerah Pesisir', 2, 2, '20000', 'PAM', 900000000, 27000000),
(14, 'A2', 5500000, 3300, 2300, 4, 'Daerah Pesisir', 5, 5, '20000', 'PAM', 900000000, 27000000),
(16, 'A4', 170000000, 1200, 1500, 4, 'Bandung', 2, 2, '15000', 'PAM', 1200000000, 12000000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id` int(11) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp(),
  `client_id` int(11) NOT NULL,
  `tipe_rumah_id` int(11) NOT NULL,
  `karyawan_id` int(11) NOT NULL,
  `harga_rumah` double DEFAULT NULL,
  `total_bonus` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id`, `timestamp`, `client_id`, `tipe_rumah_id`, `karyawan_id`, `harga_rumah`, `total_bonus`) VALUES
(17, '2025-03-24 08:16:27', 6, 6, 8, 7000000000, 700000),
(18, '2025-03-24 14:15:17', 7, 7, 8, 400000000, 800000),
(19, '2025-03-25 13:45:58', 7, 6, 7, 7000000000, 700000),
(20, '2025-04-29 10:40:55', 6, 8, 17, 90000000, 9000000),
(21, '2025-04-29 10:42:10', 7, 11, 9, 1000000000, 30000000),
(22, '2025-04-29 10:47:25', 6, 11, 9, 1000000000, 30000000),
(23, '2025-04-29 13:16:39', 11, 16, 7, 1200000000, 12000000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`Id Client`);

--
-- Indeks untuk tabel `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`Id Jabatan`);

--
-- Indeks untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`Id karyawan`);

--
-- Indeks untuk tabel `rab`
--
ALTER TABLE `rab`
  ADD PRIMARY KEY (`Id RAB`);

--
-- Indeks untuk tabel `tipe_rumah`
--
ALTER TABLE `tipe_rumah`
  ADD PRIMARY KEY (`Id Rumah`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `client_id` (`client_id`),
  ADD KEY `tipe_rumah_id` (`tipe_rumah_id`),
  ADD KEY `karyawan_id` (`karyawan_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `client`
--
ALTER TABLE `client`
  MODIFY `Id Client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT untuk tabel `jabatan`
--
ALTER TABLE `jabatan`
  MODIFY `Id Jabatan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `Id karyawan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT untuk tabel `rab`
--
ALTER TABLE `rab`
  MODIFY `Id RAB` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT untuk tabel `tipe_rumah`
--
ALTER TABLE `tipe_rumah`
  MODIFY `Id Rumah` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`Id Client`),
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`tipe_rumah_id`) REFERENCES `tipe_rumah` (`Id Rumah`),
  ADD CONSTRAINT `transaksi_ibfk_3` FOREIGN KEY (`karyawan_id`) REFERENCES `karyawan` (`Id karyawan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
