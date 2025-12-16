SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE user_mission;
TRUNCATE TABLE review;
TRUNCATE TABLE member_food;
TRUNCATE TABLE mission;
TRUNCATE TABLE store;
TRUNCATE TABLE member;
TRUNCATE TABLE foods;

SET FOREIGN_KEY_CHECKS = 1;

-- 가게 데이터 삽입
INSERT INTO store (store_name, detail_address, manager_number)
VALUES ( '맘스터치', '서울시 강남구 역삼동', 1);

INSERT INTO store (store_name, detail_address, manager_number)
VALUES ( '피자헛', '서울시 서초구 방배동', 2);

-- 음식 카테고리 데이터 삽입
INSERT INTO foods (food_name) VALUES ('KOREAN');
INSERT INTO foods (food_name) VALUES ('JAPANESE');
INSERT INTO foods (food_name) VALUES ('CHINESE');
INSERT INTO foods (food_name) VALUES ('WERTERNCUISINE');
INSERT INTO foods (food_name) VALUES ('CHICKEN');
INSERT INTO foods (food_name) VALUES ('KOREANSNACKS');
INSERT INTO foods (food_name) VALUES ('GRILLEDMEAT');
INSERT INTO foods (food_name) VALUES ('LUNCHBOX');
INSERT INTO foods (food_name) VALUES ('LATENIGHTFOOD');
INSERT INTO foods (food_name) VALUES ('FASTFOOD');
INSERT INTO foods (food_name) VALUES ('DESSERT');
INSERT INTO foods (food_name) VALUES ('ASIANCUISINE');

-- 사용자 데이터 삽입 (password, role 추가)
-- 주의: 여기 들어간 비밀번호는 암호화되지 않은 평문이므로, 실제 로그인 시에는 BCrypt로 암호화된 해시값을 넣어야 로그인이 가능합니다.
-- 테스트를 위해 임시로 평문을 넣습니다. 이 계정들로 로그인하려면 DB에서 비밀번호를 암호화된 값으로 업데이트해야 합니다.
INSERT INTO member (name, email, password, role, gender, date_of_birth, address, detail_address, social_uid, login_type, point, phone, created_at, updated_at) 
VALUES ('홍길동', 'gildong@example.com', 'temp_password', 'ROLE_USER', 'MALE', '1990-01-01', '서울시 강남구', '101호', 'kakao_1234', 'KAKAO', 1000, '010-1234-5678', NOW(), NOW());

INSERT INTO member (name, email, password, role, gender, date_of_birth, address, detail_address, social_uid, login_type, point, phone, created_at, updated_at) 
VALUES ('김철수', 'chulsu@example.com', 'temp_password', 'ROLE_USER', 'MALE', '1995-05-05', '서울시 서초구', '202호', 'naver_5678', 'NAVER', 500, '010-5678-1234', NOW(), NOW());

-- 미션 데이터 삽입
INSERT INTO mission (deadline, conditional, title, point, store_id, created_at, updated_at) VALUES ('2024-12-31 23:59:59', '리뷰 1개 작성', '첫 리뷰 작성 미션', 100, 1, NOW(), NOW());
INSERT INTO mission (deadline, conditional, title, point, store_id, created_at, updated_at) VALUES ('2024-12-31 23:59:59', '리뷰 2개 작성', '리뷰 더블업 미션', 200, 1, NOW(), NOW());
INSERT INTO mission (deadline, conditional, title, point, store_id, created_at, updated_at) VALUES ('2024-12-31 23:59:59', '리뷰 3개 작성', '리뷰 트리플 미션', 300, 1, NOW(), NOW());
INSERT INTO mission (deadline, conditional, title, point, store_id, created_at, updated_at) VALUES ('2024-12-31 23:59:59', '리뷰 4개 작성', '리뷰 포텐 미션', 400, 1, NOW(), NOW());
INSERT INTO mission (deadline, conditional, title, point, store_id, created_at, updated_at) VALUES ('2024-12-31 23:59:59', '리뷰 5개 작성', '리뷰 마스터 미션', 500, 1, NOW(), NOW());
INSERT INTO mission (deadline, conditional, title, point, store_id, created_at, updated_at) VALUES ('2024-12-31 23:59:59', '별점 5점 리뷰', '최고의 리뷰어 미션', 150, 1, NOW(), NOW());
INSERT INTO mission (deadline, conditional, title, point, store_id, created_at, updated_at) VALUES ('2024-12-31 23:59:59', '포장 주문하기', '포장 주문 미션', 50, 1, NOW(), NOW());
INSERT INTO mission (deadline, conditional, title, point, store_id, created_at, updated_at) VALUES ('2024-12-31 23:59:59', '친구에게 추천하기', '추천왕 미션', 250, 1, NOW(), NOW());
INSERT INTO mission (deadline, conditional, title, point, store_id, created_at, updated_at) VALUES ('2024-12-31 23:59:59', '신메뉴 주문하기', '얼리어답터 미션', 350, 1, NOW(), NOW());
INSERT INTO mission (deadline, conditional, title, point, store_id, created_at, updated_at) VALUES ('2024-12-31 23:59:59', '세트 메뉴 주문', '세트 마니아 미션', 120, 1, NOW(), NOW());
INSERT INTO mission (deadline, conditional, title, point, store_id, created_at, updated_at) VALUES ('2024-12-31 23:59:59', '재방문하기', '단골 인증 미션', 220, 1, NOW(), NOW());
INSERT INTO mission (deadline, conditional, title, point, store_id, created_at, updated_at) VALUES ('2024-12-31 23:59:59', '사장님 칭찬하기', '스윗 리뷰어 미션', 180, 1, NOW(), NOW());
INSERT INTO mission (deadline, conditional, title, point, store_id, created_at, updated_at) VALUES ('2024-12-31 23:59:59', '피자 주문하기', '첫 피자 미션', 100, 2, NOW(), NOW());

-- 사용자-미션 매핑 데이터 삽입
INSERT INTO user_mission (status, member_id, mission_id, created_at, updated_at) VALUES ('CHALLENGING', 1, 1, NOW(), NOW());
INSERT INTO user_mission (status, member_id, mission_id, created_at, updated_at) VALUES ('CHALLENGING', 1, 2, NOW(), NOW());
INSERT INTO user_mission (status, member_id, mission_id, created_at, updated_at) VALUES ('CHALLENGING', 1, 3, NOW(), NOW());
INSERT INTO user_mission (status, member_id, mission_id, created_at, updated_at) VALUES ('CHALLENGING', 1, 4, NOW(), NOW());
INSERT INTO user_mission (status, member_id, mission_id, created_at, updated_at) VALUES ('CHALLENGING', 1, 5, NOW(), NOW());
INSERT INTO user_mission (status, member_id, mission_id, created_at, updated_at) VALUES ('CHALLENGING', 1, 6, NOW(), NOW());
INSERT INTO user_mission (status, member_id, mission_id, created_at, updated_at) VALUES ('CHALLENGING', 1, 7, NOW(), NOW());
INSERT INTO user_mission (status, member_id, mission_id, created_at, updated_at) VALUES ('CHALLENGING', 1, 8, NOW(), NOW());
INSERT INTO user_mission (status, member_id, mission_id, created_at, updated_at) VALUES ('CHALLENGING', 1, 9, NOW(), NOW());
INSERT INTO user_mission (status, member_id, mission_id, created_at, updated_at) VALUES ('CHALLENGING', 1, 10, NOW(), NOW());
INSERT INTO user_mission (status, member_id, mission_id, created_at, updated_at) VALUES ('CHALLENGING', 1, 11, NOW(), NOW());
INSERT INTO user_mission (status, member_id, mission_id, created_at, updated_at) VALUES ('CHALLENGING', 1, 12, NOW(), NOW());
INSERT INTO user_mission (status, member_id, mission_id, created_at, updated_at) VALUES ('COMPLETED', 1, 13, NOW(), NOW());
INSERT INTO user_mission (status, member_id, mission_id, created_at, updated_at) VALUES ('CHALLENGING', 2, 13, NOW(), NOW());