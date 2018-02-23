-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Фев 08 2018 г., 14:39
-- Версия сервера: 5.7.16
-- Версия PHP: 7.1.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `NetCrackerFirst`
--

-- --------------------------------------------------------

--
-- Структура таблицы `Company`
--

CREATE TABLE `Company` (
  `ID` int(11) NOT NULL,
  `Director_ID` int(11) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `FocusArea` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Company`
--

INSERT INTO `Company` (`ID`, `Director_ID`, `Name`, `FocusArea`) VALUES
(1, NULL, 'Oracle', 'USA'),
(2, NULL, 'Microsoft', 'USA'),
(3, NULL, 'Samsung', 'China'),
(4, NULL, 'Bandai', 'Japan'),
(5, NULL, 'BMW', 'Germany'),
(6, NULL, 'Gazprom', 'Russia');

-- --------------------------------------------------------

--
-- Структура таблицы `Filial`
--

CREATE TABLE `Filial` (
  `ID` int(11) NOT NULL,
  `Company_ID` int(11) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Filial`
--

INSERT INTO `Filial` (`ID`, `Company_ID`, `Name`) VALUES
(1, 1, 'Oracle Ger'),
(2, 3, 'Samsung Eng'),
(3, NULL, 'Canon RU');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `Company`
--
ALTER TABLE `Company`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `Filial`
--
ALTER TABLE `Filial`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Company_ID` (`Company_ID`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `Company`
--
ALTER TABLE `Company`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT для таблицы `Filial`
--
ALTER TABLE `Filial`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `Filial`
--
ALTER TABLE `Filial`
  ADD CONSTRAINT `filial_ibfk_1` FOREIGN KEY (`Company_ID`) REFERENCES `Company` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
