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

-- member 테이블에 ID가 1인 테스트용 회원 데이터 추가
-- 실제 프로젝트에서는 name, email 외 다른 필수 값들도 채워야 합니다.
INSERT INTO member (id, name, email, created_at, updated_at) VALUES (1, '테스트유저', 'test@example.com', NOW(), NOW()) ON DUPLICATE KEY UPDATE name = name;

-- store 테이블에 ID가 1인 테스트용 가게 데이터 추가
INSERT INTO store (store_id, store_name, detail_address) VALUES (1, '맛있는 파스타집', '서울시 강남구 테헤란로 123') ON DUPLICATE KEY UPDATE store_name = store_name;

-- (선택) 가게를 하나 더 추가해봅시다.
INSERT INTO store (store_id, store_name, detail_address) VALUES (2, '든든한 국밥집', '서울시 종로구 세종대로 456') ON DUPLICATE KEY UPDATE store_name = store_name;

-- mission 테이블에 ID가 1인 가게의 테스트용 미션 데이터 추가
-- 이 미션은 자동으로 ID 1을 갖게 됩니다.
INSERT INTO mission (deadline, conditional, title, point, store_id, created_at, updated_at) VALUES ('2025-12-31', '리뷰 작성하기', '파스타 리뷰 남기기', 50, 1, NOW(), NOW());
