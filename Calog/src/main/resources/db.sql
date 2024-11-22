DROP DATABASE IF EXISTS calog;

CREATE DATABASE IF NOT EXISTS calog;

USE calog;

# 유저 테이블
CREATE TABLE user (
	id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(20),
    user_pw VARCHAR(60),
    nickname VARCHAR(30)
);
INSERT INTO user (user_id,user_pw,nickname)VALUES
('abc','123','짱우'),
('ssafy','123','혜만');


# 이벤트 테이블
CREATE TABLE event (
	id INT AUTO_INCREMENT PRIMARY KEY,
    event_name VARCHAR(100),
	sport VARCHAR(10), #마라톤, 배드민턴 등 종목
    event_date DATETIME,
    address VARCHAR(200),
    city VARCHAR(20),
    registration_start DATETIME,
    registration_deadline DATETIME,
    img LONGTEXT
);


# 참가 대회 목록 테이블
CREATE TABLE participation (
		id INT AUTO_INCREMENT PRIMARY KEY,
		memo VARCHAR(255),
        completion_time TIME,
        ranking INT,
        img LONGTEXT,
        detail VARCHAR(60),
        updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
        event_id INT,
        user_id INT,
        FOREIGN KEY (event_id) REFERENCES event(id),
	    FOREIGN KEY (user_id) REFERENCES user(id)
);

# 상세 대회 정보 테이블
CREATE TABLE detail (
	id INT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(50), -- 세부종목 (ex. 5km, 10km)
    event_id INT,
    FOREIGN KEY (event_id) REFERENCES event(id)
);

INSERT INTO event (event_name,sport,event_date,address,city,registration_start,registration_deadline)VALUES
('자유민주 마라톤','마라톤','2024-11-10','서울 광장','서울','2024-09-10','2024-10-31'),
('서울국제철인3종대회', '철인3종', '2024-11-10', '평화의공원 평화광장', '서울', '2024-09-01', '2024-11-09'),
('섬섬여수 그랑폰도', '그랑폰도', '2024-11-01', '여의도한강공원 이벤트광장', '서울', '2024-09-15', '2024-11-25'),
('양산테니스대회', '테니스', '2024-12-01', '양산종합운동장', '경상', '2024-10-11', '2024-12-01'),
('진주배드민턴대회', '배드민턴', '2024-12-08', '진주노을공원', '경상', '2024-10-11', '2024-12-01');



INSERT INTO detail (category,event_id) VALUES
('10km',1),
('6.10km',1),
('10km',2),
('5km',2),
('Half',3),
('10km',3),
('5km',3),
('Half',4),
('10km',4),
('5km',4),
('Full',5),
('Half',5),
('10km',5),
('5km',5);



INSERT INTO participation (memo,completion_time,event_id,user_id) VALUES
('오늘 완주 성공!','04:52:26',1,1),
('오늘 두 번째 완주 성공!','01:02:10',2,1),
('세번째 완주 성공!','04:52:26',3,1),
('이제 그만 뛸래!!','01:02:10',4,1),
('힘들어!','01:32:16',5,1),
('화이팅해보자..!', '01:32:15', 1, 2);

