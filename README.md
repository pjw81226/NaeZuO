# NaeZuO
E-Commerce Project

# build the project
root directory 에서 다음 명령어를 실행하여 모든 서브프로젝트를 빌드합니다
```bash
./gradlew clean build
```
각 서비스별로 build 디렉토리가 생성되며, 해당 디렉토리 안에 JAR 파일이 생성됩니다.

# database
mysql
aws instance 사용 이전까지는 local mysql을 사용합니다.
database : naezuo
username : naezuo_developer
password : passw0rd
url : jdbc:mysql://localhost:3306/naezuo

구조
### 1. User Table

| Column Name | Data Type       | Description            |
|-------------|-----------------|------------------------|
| id          | INT (PK, AI)    | Primary key, auto-increment |
| user_id     | VARCHAR(50)     | Unique user identifier |
| pw          | VARCHAR(255)    | User password (hashed) |
| age         | INT             | User's age             |
| sex         | ENUM('W', 'M')  | User's gender (W: Female, M: Male) |
| name        | VARCHAR(100)    | User's full name       |
| role        | ENUM('NORMAL', 'INFLUENCER') | User's role type |

### 2. Goods Table

| Column Name   | Data Type          | Description             |
|---------------|--------------------|-------------------------|
| id            | INT (PK, AI)       | Primary key, auto-increment |
| name          | VARCHAR(100)       | Name of the goods       |
| cost          | DECIMAL(10, 2)     | Cost of the goods       |
| total_amount  | DECIMAL(15, 2)     | Total purchase amount (총 구매금액) |
| total_count   | INT                | Total purchase count (총 구매 개수) |

### 3. Funding Table

| Column Name | Data Type          | Description                 |
|-------------|--------------------|-----------------------------|
| id          | INT (PK, AI)       | Primary key, auto-increment |
| user_id     | INT (FK)           | References `user(id)`       |
| goods_id    | INT (FK)           | References `goods(id)`      |
| amount      | DECIMAL(15, 2)     | Purchase amount (구매금액)  |
| count       | INT                | Purchase count (구매개수)   |