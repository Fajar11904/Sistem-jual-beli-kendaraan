-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 27 Jun 2021 pada 12.20
-- Versi server: 10.4.19-MariaDB
-- Versi PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jual_motor`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbbeli`
--

CREATE TABLE `tbbeli` (
  `idbeli` int(11) NOT NULL,
  `no_nota` varchar(20) NOT NULL,
  `tanggal_beli` date NOT NULL,
  `nama_pembeli` varchar(20) NOT NULL,
  `total` int(11) NOT NULL,
  `tunai` int(11) NOT NULL,
  `kembali` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbdatamotor`
--

CREATE TABLE `tbdatamotor` (
  `idmotor` int(11) NOT NULL,
  `kode_motor` varchar(15) NOT NULL,
  `nama_motor` varchar(30) NOT NULL,
  `satuan` varchar(20) NOT NULL,
  `jumlah_stok` int(4) NOT NULL,
  `harga_kontrak` int(15) NOT NULL,
  `harga_beli` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbdatamotor`
--

INSERT INTO `tbdatamotor` (`idmotor`, `kode_motor`, `nama_motor`, `satuan`, `jumlah_stok`, `harga_kontrak`, `harga_beli`) VALUES
(1, 'A-1', 'Yamaha Aerox 155', 'unit', 20, 10000000, 28000000),
(2, 'A-2', 'Suzuki GSX-R 150 ', 'unit', 20, 10000000, 29000000),
(3, 'A-3', 'Kawasaki Ninja 250 SE', 'unit', 20, 10000000, 66000000),
(4, 'A-4', 'Honda Vario 150', 'unit', 20, 10000000, 24000000),
(5, 'A-5', 'Honda CBR 250RR SP', 'unit', 20, 10000000, 77000000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_login`
--

CREATE TABLE `tbl_login` (
  `username` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbl_login`
--

INSERT INTO `tbl_login` (`username`, `password`) VALUES
('admin', '202cb962ac59075b964b07152d234b70');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbpenjualan`
--

CREATE TABLE `tbpenjualan` (
  `no_nota` varchar(20) NOT NULL,
  `kode_motor` varchar(20) NOT NULL,
  `nama_motor` varchar(20) NOT NULL,
  `harga_jual` int(30) NOT NULL,
  `jumlah_beli` int(30) NOT NULL,
  `total_bayar` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbpenjualan`
--

INSERT INTO `tbpenjualan` (`no_nota`, `kode_motor`, `nama_motor`, `harga_jual`, `jumlah_beli`, `total_bayar`) VALUES
('', 'A-1', 'Yamaha Aerox 155', 28000000, 1, 28000000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbbeli`
--
ALTER TABLE `tbbeli`
  ADD PRIMARY KEY (`idbeli`);

--
-- Indeks untuk tabel `tbdatamotor`
--
ALTER TABLE `tbdatamotor`
  ADD PRIMARY KEY (`idmotor`);

--
-- Indeks untuk tabel `tbl_login`
--
ALTER TABLE `tbl_login`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tbbeli`
--
ALTER TABLE `tbbeli`
  MODIFY `idbeli` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tbdatamotor`
--
ALTER TABLE `tbdatamotor`
  MODIFY `idmotor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
