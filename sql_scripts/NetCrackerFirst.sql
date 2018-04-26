-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Апр 26 2018 г., 09:03
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
(5, 1, 'Tesla', 'Germany'),
(8, 1, 'NetCracker', 'Samara'),
(10, NULL, 'qq', 'ww');

-- --------------------------------------------------------

--
-- Структура таблицы `Department`
--

CREATE TABLE `Department` (
  `id` int(11) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `id_director` int(11) DEFAULT NULL,
  `id_company` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Department`
--

INSERT INTO `Department` (`id`, `Name`, `id_director`, `id_company`) VALUES
(1, 'name1', 1, NULL),
(2, 'name2', 2, NULL),
(3, 'name3', 1, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `Employee`
--

CREATE TABLE `Employee` (
  `id` int(11) NOT NULL,
  `Fistname` varchar(255) DEFAULT NULL,
  `Secondname` varchar(255) DEFAULT NULL,
  `Phonenumber` varchar(255) DEFAULT NULL,
  `Salary` int(11) DEFAULT NULL,
  `id_department` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Employee`
--

INSERT INTO `Employee` (`id`, `Fistname`, `Secondname`, `Phonenumber`, `Salary`, `id_department`) VALUES
(1, 'petr', 'ivanov', '124', 11550, NULL),
(2, 'oleg', 'ivanov', '124', 11550, NULL),
(3, 'kirill', 'voylov', '12423', 11550, NULL),
(4, 'artem', 'belov', '128743', 11550, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `Filial`
--

CREATE TABLE `Filial` (
  `ID` int(11) NOT NULL,
  `Company_ID` int(11) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Coordinates` varchar(255) DEFAULT NULL,
  `StartOfWork` time DEFAULT NULL,
  `EndOfWork` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Filial`
--

INSERT INTO `Filial` (`ID`, `Company_ID`, `Name`, `Coordinates`, `StartOfWork`, `EndOfWork`) VALUES
(1, 1, 'Karavan', NULL, '08:00:00', '22:00:00'),
(2, 8, 'NetCrackerSamara', '53.2033946:50.1469459', '06:00:00', '20:00:00'),
(4, NULL, 'Kosmoport', '53.2077892:50.2008167', '11:00:00', '23:00:00'),
(8, NULL, 'PSUTI', '53.2257154:50.1941782', '12:00:00', '00:00:00'),
(9, 1, 'SSAU', '53.2245481:50.1877731', '04:00:00', '17:00:00'),
(10, 8, 'NetSSAU', '53.2009879:50.1084709', '07:00:00', '22:00:00');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `Company`
--
ALTER TABLE `Company`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Director_ID` (`Director_ID`);

--
-- Индексы таблицы `Department`
--
ALTER TABLE `Department`
  ADD PRIMARY KEY (`id`),
  ADD KEY `department_ibfk_1` (`id_company`),
  ADD KEY `department_ibfk_2` (`id_director`);

--
-- Индексы таблицы `Employee`
--
ALTER TABLE `Employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_department` (`id_department`);

--
-- Индексы таблицы `Filial`
--
ALTER TABLE `Filial`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `filial_ibfk_1` (`Company_ID`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `Company`
--
ALTER TABLE `Company`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT для таблицы `Department`
--
ALTER TABLE `Department`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `Employee`
--
ALTER TABLE `Employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT для таблицы `Filial`
--
ALTER TABLE `Filial`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `Company`
--
ALTER TABLE `Company`
  ADD CONSTRAINT `company_ibfk_1` FOREIGN KEY (`Director_ID`) REFERENCES `Employee` (`id`) ON DELETE SET NULL;

--
-- Ограничения внешнего ключа таблицы `Department`
--
ALTER TABLE `Department`
  ADD CONSTRAINT `department_ibfk_1` FOREIGN KEY (`id_company`) REFERENCES `Company` (`ID`) ON DELETE SET NULL,
  ADD CONSTRAINT `department_ibfk_2` FOREIGN KEY (`id_director`) REFERENCES `Employee` (`id`) ON DELETE SET NULL;

--
-- Ограничения внешнего ключа таблицы `Employee`
--
ALTER TABLE `Employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`id_department`) REFERENCES `Department` (`id`) ON DELETE SET NULL;

--
-- Ограничения внешнего ключа таблицы `Filial`
--
ALTER TABLE `Filial`
  ADD CONSTRAINT `filial_ibfk_1` FOREIGN KEY (`Company_ID`) REFERENCES `Company` (`ID`) ON DELETE SET NULL;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
