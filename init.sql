-- 유저 및 권한 설정
CREATE USER IF NOT EXISTS 'naezuo_developer'@'%' IDENTIFIED BY 'passw0rd';
GRANT ALL PRIVILEGES ON *.* TO 'naezuo_developer'@'%' WITH GRANT OPTION;

-- 데이터베이스 생성
CREATE DATABASE IF NOT EXISTS naezuo;
USE naezuo;

-- 테이블 생성
CREATE TABLE `user` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
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
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `user_id` bigint NOT NULL,
                         `name` varchar(100) NOT NULL UNIQUE,
                         `cost` bigint NOT NULL,
                         `goal_amount` bigint NOT NULL DEFAULT 0 COMMENT '목표금액',
                         `total_amount` bigint NOT NULL DEFAULT 0 COMMENT '총 구매금액',
                         `total_count` int NOT NULL DEFAULT 0 COMMENT '총 구매 개수',
                         `state` enum('ING','END') NOT NULL DEFAULT 'ING' COMMENT '펀딩 진행중 여부',
                         `image_url` varchar(1024) NOT NULL DEFAULT '' COMMENT '상품 이미지 URL',
                         `description` TEXT NOT NULL COMMENT '상품 설명',
                         `category` varchar(100) NOT NULL DEFAULT '' COMMENT '상품 카테고리',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `funding` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `user_id` bigint NOT NULL,
                           `goods_id` bigint NOT NULL,
                           `amount` bigint NOT NULL DEFAULT 0 COMMENT '구매금액',
                           `count` int NOT NULL DEFAULT 0 COMMENT '구매개수',
                           PRIMARY KEY (`id`),
                           KEY `user_id` (`user_id`),
                           KEY `goods_id` (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `user` (`user_id`, `pw`, `age`, `sex`, `name`, `role`)
VALUES
    ('user1', 'password1', 25, 'M', 'User One', 'NORMAL'),
    ('user2', 'password2', 30, 'W', 'User Two', 'NORMAL'),
    ('influencer1', 'password3', 27, 'W', 'Influencer One', 'INFLUENCER'),
    ('influencer2', 'password4', 35, 'M', 'Influencer Two', 'INFLUENCER');

DELIMITER $$

CREATE TRIGGER trg_funding_after_insert
    AFTER INSERT ON funding
    FOR EACH ROW
BEGIN
    UPDATE goods
    SET
        total_amount = total_amount + NEW.amount,
        total_count = total_count + NEW.count
    WHERE id = NEW.goods_id;
END;
$$

CREATE TRIGGER trg_funding_after_update
    AFTER UPDATE ON funding
    FOR EACH ROW
BEGIN
    UPDATE goods
    SET
        total_amount = total_amount - OLD.amount + NEW.amount,
        total_count = total_count - OLD.count + NEW.count
    WHERE id = NEW.goods_id;
END;
$$

DELIMITER ;