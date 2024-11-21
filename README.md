# NaeZuO
E-Commerce Project  
MSA... 근데 이제... spring cloud를 곁들이지 않은...  
나야.. **nginx**

# build the project
root directory 에서 다음 명령어를 실행하여 모든 서브프로젝트를 빌드합니다.  
빌드 시에 test는 제외하고 빌드. 이유는 application.properties상의 db url은 docker의 url이므로
```bash
./gradlew build -x test
```
각 서비스별로 build 디렉토리가 생성되며, 해당 디렉토리 안에 JAR 파일이 생성됩니다.

도커에 compose up을 할때는 --build 옵션을 넣어야 코드의 변경사항이 반영됩니다.
```bash
docker compose up --build -d
docker compose down -v
```



# database
aws instance 사용 이전까지는 mysql을 docker에 띄워 사용합니다.  
init.sql 파일을 이용하여 database와 table을 생성합니다. (docker-compose.yml에서 mount하여 사용)  

database : naezuo  
username : naezuo_developer  
password : passw0rd  
url : jdbc:mysql://mysql:3306/naezuo -> 로컬에서 디비를 등록할때는 localhost를 호스트로 작성해야함
  
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
