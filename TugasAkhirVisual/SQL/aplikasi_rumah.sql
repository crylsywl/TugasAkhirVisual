-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 21 Jun 2025 pada 01.44
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
  `Id Client` varchar(20) NOT NULL,
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
('CLN0001', '807975023', 'Cryl Syawal', '3845377020', 'Jl. Sukabumi No. 706, Padang, NT 60880', '731075', 'Asuransi Swasta AIA', 8000000),
('CLN0002', '441300765', 'Abiyu Sofyan', '2228187392', 'Gg. Sadang Serang No. 3, Palembang, JK 05994', '7390', 'Prudential', 15000000),
('CLN0003', '143195702', 'Roy Natanael', '5443820956', 'Gang Soekarno Hatta No. 2, Surabaya, Jambi 14730', '27854', 'BPJS Ketenagakerjaan', 15000000),
('CLN0004', '65903999', 'Bambang Sutrisna', '2789168343', 'Gg. Bangka Raya No. 32, Cilegon, YO 56344', '757257', 'Asuransi Swasta AIA', 10000000),
('CLN0005', '356259883', 'Aditya Muhijriawan', '7494347841', 'Gg. Kutisari Selatan No. 647, Padangpanjang, Maluku Utara 10641', '286355', 'BPJS Kelas 2', 7000000),
('CLN0006', '819509925', 'Robby Biantoro', '9211765848', 'Jalan Cikapayang No. 7, Lubuklinggau, Sumatera Utara 44227', '867092', 'BPJS Kelas 1', 12000000),
('CLN0007', '965246172', 'Muhamad Raihan Mubina', '4850572419', 'Jalan Cikapayang No. 97, Pekalongan, Papua 44630', '797348', 'BPJS Kelas 3', 12000000),
('CLN0008', '737963593', 'Lintang Fauzan', '3692693200', 'Gang KH Amin Jasuta No. 003, Blitar, BT 53286', '66333', 'Asuransi Swasta AIA', 15000000),
('CLN0009', '770654895', 'Gilda', '3536521240', 'Jalan Rajawali Timur No. 880, Palangkaraya, Nusa Tenggara Barat 16081', '959894', 'Prudential', 12000000),
('CLN0010', '478681947', 'Kasim', '222450930', 'Gang R.E Martadinata No. 027, Kota Administrasi Jakarta Timur, Maluku Utara 13471', '468632', 'BPJS Kelas 2', 7000000),
('CLN0011', '276795690', 'Pangestu', '9045558686', 'Gg. Setiabudhi No. 3, Dumai, Sumatera Utara 29345', '180418', 'BPJS Kelas 2', 12000000),
('CLN0012', '271183678', 'Tania', '5292044683', 'Gg. Rajawali Timur No. 5, Sabang, Jawa Barat 25498', '830996', 'BPJS Kelas 1', 12000000),
('CLN0013', '245535525', 'Atmaja', '7072975916', 'Jalan Sadang Serang No. 882, Surabaya, Bali 60054', '83059', 'Asuransi Swasta AIA', 12000000),
('CLN0014', '294967784', 'Prayogo', '4284811800', 'Gg. Dr. Djunjunan No. 283, Bandung, YO 41454', '512007', 'BPJS Kelas 1', 12000000),
('CLN0015', '525475712', 'Kezia', '3909384193', 'Gang Kutisari Selatan No. 079, Lhokseumawe, SU 18774', '839416', 'BPJS Kelas 2', 8000000),
('CLN0016', '872953321', 'Wage', '1883463745', 'Jalan Rajawali Timur No. 2, Singkawang, BA 40389', '1540', 'Asuransi Swasta AIA', 12000000),
('CLN0017', '824125102', 'Lutfan', '742813893', 'Gg. Ahmad Dahlan No. 598, Subulussalam, Kalimantan Barat 68044', '504926', 'Asuransi Swasta AIA', 7000000),
('CLN0018', '393739965', 'Zelda', '7924869666', 'Jalan Rajiman No. 68, Sukabumi, KU 68870', '622749', 'Asuransi Swasta AIA', 12000000),
('CLN0019', '243489639', 'Lamar', '9494721014', 'Gg. Cihampelas No. 631, Kota Administrasi Jakarta Selatan, Jawa Barat 83111', '704218', 'BPJS Kelas 1', 7000000),
('CLN0020', '298745693', 'Jail', '7888585826', 'Gang Cikutra Timur No. 868, Padangpanjang, KB 79538', '506647', 'BPJS Kelas 1', 10000000),
('CLN0021', '439211039', 'Dwi', '5648056012', 'Jalan Ciumbuleuit No. 102, Kediri, PA 01716', '243024', 'BPJS Kelas 1', 10000000),
('CLN0022', '810938990', 'Michelle', '2046132254', 'Jalan Gedebage Selatan No. 92, Bandung, SN 23994', '769918', 'BPJS Kelas 1', 7000000),
('CLN0023', '412443636', 'Kani', '262555564', 'Gang Asia Afrika No. 1, Sabang, RI 03331', '785074', 'Prudential', 8000000),
('CLN0024', '621646321', 'Ajeng', '9505093362', 'Gg. Bangka Raya No. 738, Tarakan, KU 14124', '83043', 'Prudential', 15000000),
('CLN0025', '288028420', 'Salimah', '3735783686', 'Jl. Jend. Sudirman No. 724, Bukittinggi, NB 45650', '282994', 'BPJS Kelas 2', 7000000),
('CLN0026', '945205105', 'Dina', '132718368', 'Gg. R.E Martadinata No. 28, Kotamobagu, Nusa Tenggara Timur 46740', '238517', 'BPJS Kelas 1', 8000000),
('CLN0027', '975074443', 'Natalia', '7196907098', 'Jl. Surapati No. 0, Batam, KR 00328', '594497', 'BPJS Ketenagakerjaan', 5000000),
('CLN0028', '424819746', 'Tasdik', '5362949183', 'Gang Medokan Ayu No. 52, Makassar, DI Yogyakarta 85157', '304482', 'BPJS Kelas 1', 5000000),
('CLN0029', '22457825', 'Gaduh', '9100234193', 'Gang Kutisari Selatan No. 768, Langsa, SB 50276', '583877', 'BPJS Kelas 3', 10000000),
('CLN0030', '593494567', 'Eva', '5613737567', 'Jl. PHH. Mustofa No. 473, Dumai, Kalimantan Tengah 40068', '351130', 'BPJS Ketenagakerjaan', 10000000),
('CLN0031', '454262227', 'Cecep', '702126600', 'Jl. BKR No. 9, Pontianak, Kepulauan Riau 84305', '482444', 'Prudential', 7000000),
('CLN0032', '300656097', 'Citra', '1415820393', 'Jl. PHH. Mustofa No. 630, Mataram, KI 56234', '562852', 'Asuransi Swasta AIA', 12000000),
('CLN0033', '864597302', 'Salwa', '3105326205', 'Jl. PHH. Mustofa No. 828, Jayapura, Sulawesi Utara 47683', '418247', 'BPJS Ketenagakerjaan', 7000000),
('CLN0034', '981942695', 'Eko', '3780701264', 'Gang Dipatiukur No. 71, Jayapura, Maluku 64695', '934996', 'Asuransi Swasta AIA', 12000000),
('CLN0035', '235184174', 'Ade', '5962789835', 'Gang Gedebage Selatan No. 6, Kota Administrasi Jakarta Utara, Nusa Tenggara Timur 61154', '503814', 'Prudential', 8000000),
('CLN0036', '130917773', 'Kenes', '3450612819', 'Gg. Gegerkalong Hilir No. 84, Pasuruan, Riau 19093', '859262', 'BPJS Kelas 2', 8000000),
('CLN0037', '107248134', 'Paiman', '5369415585', 'Jl. Kutai No. 1, Gorontalo, Kalimantan Utara 59166', '387046', 'Prudential', 15000000),
('CLN0038', '209350776', 'Prasetyo', '1183460873', 'Jalan Jakarta No. 919, Tomohon, MU 98527', '97078', 'Asuransi Swasta AIA', 8000000),
('CLN0039', '58899804', 'Taufik', '5203700294', 'Jalan Gardujati No. 5, Pematangsiantar, Jawa Timur 39252', '38993', 'Prudential', 5000000),
('CLN0040', '24475783', 'Lasmono', '9650961398', 'Jalan Wonoayu No. 10, Madiun, KS 88049', '882577', 'Prudential', 15000000),
('CLN0041', '305079554', 'Hafshah', '5903474309', 'Jalan Wonoayu No. 96, Lubuklinggau, JA 74865', '100200', 'BPJS Kelas 2', 12000000),
('CLN0042', '444199369', 'Liman', '8903336394', 'Jl. Otto Iskandardinata No. 2, Serang, JA 64913', '784149', 'BPJS Kelas 2', 12000000),
('CLN0043', '800393279', 'Mustofa', '1972820476', 'Jl. Erlangga No. 0, Kupang, Sulawesi Tengah 08494', '442452', 'BPJS Ketenagakerjaan', 12000000),
('CLN0044', '418738603', 'Baktiono', '5348833772', 'Jl. Bangka Raya No. 6, Dumai, KU 53491', '807305', 'Prudential', 12000000),
('CLN0045', '850801952', 'Unggul', '2688723875', 'Jalan Medokan Ayu No. 62, Batam, SB 00781', '615841', 'Asuransi Swasta AIA', 10000000),
('CLN0046', '100106142', 'Eva', '6816612002', 'Jl. Ir. H. Djuanda No. 44, Binjai, Sumatera Utara 06904', '148784', 'BPJS Ketenagakerjaan', 8000000),
('CLN0047', '150865557', 'Slamet', '5423629842', 'Jl. S. Parman No. 308, Malang, BT 17284', '274286', 'Prudential', 7000000),
('CLN0048', '407846646', 'Jamil', '6043754085', 'Gg. Ir. H. Djuanda No. 721, Parepare, KT 79989', '875013', 'BPJS Kelas 1', 12000000),
('CLN0049', '633767522', 'Queen', '3119574153', 'Jl. Asia Afrika No. 787, Kendari, Sulawesi Utara 41192', '408643', 'BPJS Kelas 2', 10000000),
('CLN0050', '972344125', 'Drajat', '425206231', 'Jalan Gardujati No. 9, Mojokerto, KS 07518', '364684', 'Prudential', 8000000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `gajikaryawan`
--

CREATE TABLE `gajikaryawan` (
  `id_gaji` int(11) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `id_karyawan` varchar(20) DEFAULT NULL,
  `nama_karyawan` varchar(100) DEFAULT NULL,
  `jabatan` varchar(100) DEFAULT NULL,
  `gaji_pokok` double DEFAULT NULL,
  `bonus` double DEFAULT NULL,
  `rumah_terjual` int(100) DEFAULT NULL,
  `total_gaji` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `gajikaryawan`
--

INSERT INTO `gajikaryawan` (`id_gaji`, `timestamp`, `id_karyawan`, `nama_karyawan`, `jabatan`, `gaji_pokok`, `bonus`, `rumah_terjual`, `total_gaji`) VALUES
(9, '2025-06-20 09:12:27', 'USR0001', 'Cryl Syawal', 'Marketing Properti', 8000000, 50400000, 4, 58400000),
(10, '2025-06-20 09:12:35', 'USR0003', 'Roy Natanael', 'Sales Property', 7000000, 24000000, 2, 31000000),
(11, '2025-06-20 09:12:44', 'USR0002', 'Abiyu Sofyan', 'Marketing Properti', 8000000, 34200000, 3, 42200000),
(12, '2025-06-20 09:12:55', 'USR0004', 'Bambang Sutrisna', 'Site Engineer', 10000000, 6000000, 1, 16000000),
(13, '2025-06-20 09:13:17', 'USR0031', 'Gatra Hariyah', 'Surveyor Lokasi', 6500000, 9000000, 1, 15500000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `jabatan`
--

CREATE TABLE `jabatan` (
  `Id Jabatan` varchar(20) NOT NULL,
  `Jabatan` varchar(100) NOT NULL,
  `Gaji Pokok` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `jabatan`
--

INSERT INTO `jabatan` (`Id Jabatan`, `Jabatan`, `Gaji Pokok`) VALUES
('DIV0001', 'Sales Property', 7000000),
('DIV0002', 'Marketing Properti', 8000000),
('DIV0003', 'Sales Property', 7000000),
('DIV0004', 'Marketing Properti', 8000000),
('DIV0005', 'Manajer Proyek', 15000000),
('DIV0006', 'Site Engineer', 10000000),
('DIV0007', 'Arsitek', 12000000),
('DIV0008', 'Drafter Bangunan', 6000000),
('DIV0009', 'Legal Properti', 11000000),
('DIV0010', 'Administrasi Proyek', 5000000),
('DIV0011', 'Surveyor Lokasi', 6500000),
('DIV0012', 'Customer Relation Officer', 7000000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `karyawan`
--

CREATE TABLE `karyawan` (
  `Id karyawan` varchar(20) NOT NULL,
  `Nama Karyawan` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `karyawan`
--

INSERT INTO `karyawan` (`Id karyawan`, `Nama Karyawan`, `password`) VALUES
('USR0001', 'Cryl Syawal', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0002', 'Abiyu Sofyan', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0003', 'Roy Natanael', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0004', 'Bambang Sutrisna', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0005', 'Aditya Muhijriawan', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0006', 'Robby Biantoro', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0007', 'Muhamad Raihan Mubina', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0008', 'Lintang Fauzan', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0009', 'Taufik Sudiati', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0010', 'Umar Sihotang, S.IP', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0011', 'Indah Rajasa', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0012', 'Belinda Hardiansyah, M.Kom.', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0013', 'Ihsan Utami', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0014', 'Paramita Wibisono', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0015', 'Cager Ramadan', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0016', 'Ira Hartati', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0017', 'R.A. Puput Mulyani', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0018', 'dr. Kenzie Zulkarnain, S.Sos', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0019', 'Paulin Marbun', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0020', 'KH. Kacung Mulyani, M.Pd', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0021', 'Wage Namaga', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0022', 'Irma Damanik', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0023', 'Paramita Wasita', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0024', 'Ratih Uwais, S.Farm', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0025', 'Nadia Jailani', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0026', 'Abyasa Permata', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0027', 'Ilsa Yolanda', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0028', 'Hj. Yuliana Mansur', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0029', 'Keisha Nurdiyanti', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0030', 'Bakti Agustina', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0031', 'Gatra Hariyah', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0032', 'Tgk. Dina Januar', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0033', 'R. Uli Waskita', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0034', 'Banawi Pudjiastuti', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0035', 'Drs. Malika Nuraini, S.H.', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0036', 'Puti Fitria Simanjuntak, M.Kom.', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0037', 'Elvina Uyainah', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0038', 'Titin Laksmiwati', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0039', 'Uli Wasita', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0040', 'Putu Irawan', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0041', 'Malika Marpaung', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0042', 'Drs. Maimunah Hidayat', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0043', 'Faizah Prasetyo', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0044', 'Nrima Firmansyah', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0045', 'dr. Cahyadi Putra', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0046', 'Kasiran Winarsih', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0047', 'Ghani Sirait', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0048', 'Rika Wibisono', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0049', 'R. Gangsar Maheswara', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
('USR0050', 'T. Karna Maulana, S.Pt', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4');

-- --------------------------------------------------------

--
-- Struktur dari tabel `rab`
--

CREATE TABLE `rab` (
  `Id RAB` varchar(20) NOT NULL,
  `Tipe` varchar(100) NOT NULL,
  `Keterangan` text NOT NULL,
  `Harga` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `rab`
--

INSERT INTO `rab` (`Id RAB`, `Tipe`, `Keterangan`, `Harga`) VALUES
('AGR0001', 'A5', 'Atap Genteng Beton', 29340294),
('AGR0002', 'A2', 'Upah Tukang Dinding', 17367879),
('AGR0003', 'A1', 'Kusen Pintu dan Jendela', 17233150),
('AGR0004', 'A4', 'Pipa PVC Air Bersih', 18582970),
('AGR0005', 'A2', 'Cor Dak', 35011537),
('AGR0006', 'A2', 'Upah Pasang Atap', 19818922),
('AGR0007', 'A3', 'Kitchen Set', 21927036),
('AGR0008', 'A5', 'Kusen Pintu dan Jendela', 13457135),
('AGR0009', 'A3', 'Upah Pasang Atap', 34390372),
('AGR0010', 'A1', 'Instalasi Listrik', 17393567),
('AGR0011', 'A5', 'Struktur Beton Bertulang', 38112275),
('AGR0012', 'A3', 'Semen Struktur', 39265646),
('AGR0013', 'A5', 'Keramik Lantai', 27259843),
('AGR0014', 'A1', 'Pekerjaan Galian Tanah', 5100849),
('AGR0015', 'A2', 'Plesteran dan Acian', 5470626),
('AGR0016', 'A2', 'Penggunaan Hebel', 5042506),
('AGR0017', 'A3', 'Closet Duduk', 7571804),
('AGR0018', 'A2', 'Upah Tukang Interior', 14518235),
('AGR0019', 'A4', 'Kitchen Set', 12327856),
('AGR0020', 'A2', 'Pasir Struktur', 42777837),
('AGR0021', 'A2', 'Upah Tukang Struktur', 21658853),
('AGR0022', 'A2', 'Penggunaan Hebel', 16838964),
('AGR0023', 'A5', 'Upah Tukang Struktur', 40885836),
('AGR0024', 'A2', 'Ventilasi', 8974558),
('AGR0025', 'A4', 'Stop Kontak dan Saklar', 5600992),
('AGR0026', 'A4', 'Pengukuran Lahan', 6369155),
('AGR0027', 'A4', 'Upah Tukang Struktur', 39107635),
('AGR0028', 'A2', 'Cor Beton Pondasi', 24085852),
('AGR0029', 'A3', 'Tangga Beton', 17801397),
('AGR0030', 'A3', 'Talang Air', 10528942),
('AGR0031', 'A1', 'Pipa PVC Air Bersih', 15574303),
('AGR0032', 'A5', 'Upah Tukang Pondasi', 22757219),
('AGR0033', 'A2', 'Sekat Ruangan', 6553803),
('AGR0034', 'A5', 'Pelat Lantai', 5268089),
('AGR0035', 'A3', 'Pipa PVC Air Bersih', 15677036),
('AGR0036', 'A3', 'Plesteran dan Acian', 10910367),
('AGR0037', 'A4', 'Upah Tukang Interior', 9154003),
('AGR0038', 'A5', 'Struktur Beton Bertulang', 47575858),
('AGR0039', 'A4', 'Lampu Taman', 17636574),
('AGR0040', 'A3', 'Struktur Beton Bertulang', 29654337),
('AGR0041', 'A4', 'Pengukuran Lahan', 6767245),
('AGR0042', 'A2', 'Besi Beton', 13633655),
('AGR0043', 'A4', 'Pekerjaan Cat Dinding', 14113956),
('AGR0044', 'A5', 'Pekerjaan Cat Dinding', 17328000),
('AGR0045', 'A4', 'Ventilasi', 14034302),
('AGR0046', 'A2', 'Upah Tukang Interior', 8451964),
('AGR0047', 'A4', 'Pembesian Pondasi', 24996669),
('AGR0048', 'A5', 'Washtafel', 14560795),
('AGR0049', 'A5', 'Rangka Atap Baja Ringan', 28250639),
('AGR0050', 'A5', 'List Plafon', 13624351),
('AGR0051', 'A5', 'Tangga Beton', 16991462),
('AGR0052', 'A5', 'Plafon PVC', 15172841),
('AGR0053', 'A2', 'Lisplang Kayu', 15177790),
('AGR0054', 'A2', 'Atap Genteng Beton', 27727726),
('AGR0055', 'A1', 'Pemadatan Tanah', 11460285),
('AGR0056', 'A1', 'Ventilasi', 10151977),
('AGR0057', 'A4', 'Cor Beton Pondasi', 35911880),
('AGR0058', 'A3', 'Transportasi Material', 11773623),
('AGR0059', 'A2', 'Lampu Taman', 5081933),
('AGR0060', 'A4', 'Atap Genteng Beton', 30558181),
('AGR0061', 'A4', 'Washtafel', 6878593),
('AGR0062', 'A5', 'Transportasi Material', 16487906),
('AGR0063', 'A1', 'Pasir Urug', 6852814),
('AGR0064', 'A5', 'Tangki Air', 6914919),
('AGR0065', 'A5', 'Pasir Struktur', 36449672),
('AGR0066', 'A4', 'Cor Beton Pondasi', 40344332),
('AGR0067', 'A5', 'Lem Perekat Hebel', 11695951),
('AGR0068', 'A3', 'Semen Struktur', 44366711),
('AGR0069', 'A3', 'Pasir Urug', 14756466),
('AGR0070', 'A5', 'Pasir Struktur', 37626063),
('AGR0071', 'A5', 'Ventilasi', 11008260),
('AGR0072', 'A5', 'Closet Duduk', 15465906),
('AGR0073', 'A2', 'Semen Struktur', 37318345),
('AGR0074', 'A3', 'Pondasi Batu Kali', 30886723),
('AGR0075', 'A1', 'Pemadatan Tanah', 12405647),
('AGR0076', 'A1', 'Lampu Taman', 12121876),
('AGR0077', 'A5', 'Penggunaan Hebel', 6522975),
('AGR0078', 'A4', 'Semen Struktur', 23949035),
('AGR0079', 'A4', 'Closet Duduk', 14056187),
('AGR0080', 'A1', 'Pekerjaan Cat Dinding', 11475521),
('AGR0081', 'A1', 'Pengukuran Lahan', 14733029),
('AGR0082', 'A2', 'Keramik Lantai', 29176890),
('AGR0083', 'A5', 'Pondasi Batu Kali', 29402612),
('AGR0084', 'A5', 'Plafon PVC', 23519914),
('AGR0085', 'A3', 'Rangka Atap Baja Ringan', 16052108),
('AGR0086', 'A2', 'Lem Perekat Hebel', 10920039),
('AGR0087', 'A4', 'Ventilasi', 15230979),
('AGR0088', 'A4', 'Lisplang Kayu', 12787644),
('AGR0089', 'A3', 'Keramik Lantai', 15731356),
('AGR0090', 'A3', 'Pelat Lantai', 13939917),
('AGR0091', 'A5', 'Washtafel', 7653798),
('AGR0092', 'A4', 'Tangki Air', 5090961),
('AGR0093', 'A4', 'Pemadatan Tanah', 6576122),
('AGR0094', 'A1', 'Ring Balok', 10818971),
('AGR0095', 'A5', 'Keramik Lantai', 12434532),
('AGR0096', 'A2', 'Rangka Atap Baja Ringan', 30619420),
('AGR0097', 'A2', 'Ventilasi', 6922068),
('AGR0098', 'A1', 'Pekerjaan Galian Tanah', 14080371),
('AGR0099', 'A5', 'Pengukuran Lahan', 9473153),
('AGR0100', 'A5', 'Atap Genteng Beton', 15048272);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tipe_rumah`
--

CREATE TABLE `tipe_rumah` (
  `Id Rumah` varchar(20) NOT NULL,
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
('RMH0001', 'A1', 159402360, 100, 110, 4, 'Jl. Sukabumi No. 706, Padang, NT 60880', 2, 1, '200', 'PAM', 200000000, 6000000),
('RMH0002', 'A2', 403149402, 400, 420, 5, 'Gg. Sadang Serang No. 3, Palembang, JK 05994', 3, 2, '220', 'Air Sumur', 500000000, 15000000),
('RMH0003', 'A3', 335233841, 300, 350, 4, 'Gang Soekarno Hatta No. 2, Surabaya, Jambi 14730', 2, 1, '210', 'PAM', 420000000, 12600000),
('RMH0004', 'A4', 360075271, 300, 380, 5, 'Jalan Cikapayang No. 7, Lubuklinggau, Sumatera Utara 44227', 3, 2, '250', 'PAM', 450000000, 9000000),
('RMH0005', 'A5', 570288570, 500, 510, 6, 'Gang R.E Martadinata No. 027, Kota Administrasi Jakarta Timur', 3, 2, '400', 'PAM', 680000000, 20400000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id` int(20) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp(),
  `client_id` varchar(20) DEFAULT NULL,
  `tipe_rumah_id` varchar(20) NOT NULL,
  `karyawan_id` varchar(20) DEFAULT NULL,
  `harga_rumah` double DEFAULT NULL,
  `total_bonus` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id`, `timestamp`, `client_id`, `tipe_rumah_id`, `karyawan_id`, `harga_rumah`, `total_bonus`) VALUES
(31, '2025-06-20 09:07:58', 'CLN0020', 'RMH0001', 'USR0001', 200000000, 6000000),
(32, '2025-06-20 09:08:18', 'CLN0002', 'RMH0002', 'USR0001', 500000000, 15000000),
(33, '2025-06-20 09:08:42', 'CLN0016', 'RMH0003', 'USR0002', 420000000, 12600000),
(34, '2025-06-20 09:09:00', 'CLN0023', 'RMH0004', 'USR0002', 450000000, 9000000),
(35, '2025-06-20 09:09:15', 'CLN0005', 'RMH0004', 'USR0003', 450000000, 9000000),
(36, '2025-06-20 09:09:26', 'CLN0020', 'RMH0005', 'USR0001', 680000000, 20400000),
(37, '2025-06-20 09:09:38', 'CLN0033', 'RMH0003', 'USR0002', 420000000, 12600000),
(38, '2025-06-20 09:09:49', 'CLN0029', 'RMH0004', 'USR0031', 450000000, 9000000),
(39, '2025-06-20 09:10:03', 'CLN0035', 'RMH0001', 'USR0004', 200000000, 6000000),
(40, '2025-06-20 09:10:17', 'CLN0029', 'RMH0005', 'USR0006', 680000000, 20400000),
(41, '2025-06-20 09:10:27', 'CLN0015', 'RMH0002', 'USR0003', 500000000, 15000000),
(42, '2025-06-20 09:10:38', 'CLN0032', 'RMH0004', 'USR0001', 450000000, 9000000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`Id Client`);

--
-- Indeks untuk tabel `gajikaryawan`
--
ALTER TABLE `gajikaryawan`
  ADD PRIMARY KEY (`id_gaji`);

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
-- AUTO_INCREMENT untuk tabel `gajikaryawan`
--
ALTER TABLE `gajikaryawan`
  MODIFY `id_gaji` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

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
