-- 유저 및 권한 설정
CREATE USER 'naezuo_developer'@'%' IDENTIFIED BY 'passw0rd';
GRANT ALL PRIVILEGES ON *.* TO 'naezuo_developer'@'%' WITH GRANT OPTION;

-- 데이터베이스 생성
CREATE DATABASE IF NOT EXISTS naezuo;
USE naezuo;

-- 테이블 생성
CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `user_id` varchar(50) NOT NULL COMMENT '로그인 아이디',
                        `pw` varchar(255) NOT NULL,
                        `age` int NOT NULL,
                        `sex` enum('W','M') NOT NULL,
                        `name` varchar(100) NOT NULL,
                        `role` enum('NORMAL','INFLUENCER') NOT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `goods` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `name` varchar(100) NOT NULL,
                         `cost` decimal(10,2) NOT NULL,
                         `total_amount` decimal(15,2) NOT NULL COMMENT '총 구매금액',
                         `total_count` int NOT NULL COMMENT '총 구매 개수',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `funding` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `user_id` int NOT NULL,
                           `goods_id` int NOT NULL,
                           `amount` decimal(15,2) NOT NULL COMMENT '구매금액',
                           `count` int NOT NULL COMMENT '구매개수',
                           PRIMARY KEY (`id`),
                           KEY `user_id` (`user_id`),
                           KEY `goods_id` (`goods_id`),
                           CONSTRAINT `funding_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
                           CONSTRAINT `funding_ibfk_2` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
