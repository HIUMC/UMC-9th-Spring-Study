-- =====================================================
-- data.sql (MySQL) : 여러 번 실행해도 안전한 Seed Script
-- =====================================================

-- ------------------------
-- 1) Region (BaseEntity X)
-- ------------------------
INSERT INTO region (region_id, area)
VALUES
    (1, '서울'),
    (2, '경기'),
    (3, '인천')
    ON DUPLICATE KEY UPDATE
                         area = VALUES(area);

-- ------------------------
-- 2) Food (BaseEntity X)
-- ------------------------
INSERT INTO food (id, name)
VALUES
    (1, '마라탕'),
    (2, '파스타'),
    (3, '피자')
    ON DUPLICATE KEY UPDATE
                         name = VALUES(name);

-- ------------------------
-- 3) Member (BaseEntity O)
-- ------------------------
INSERT INTO member (member_id, name, gender, social_id, social_pw, nickname, email, password, role, created_at, updated_at)
VALUES
    (1, '김토마토', 'NONE', 'tomato_social', 'pw_tomato', '김토마토', 'tomato@gmail.com', '1234', 'ROLE_ADMIN',NOW(), NOW()),
    (2, '이파스타', 'NONE', 'pasta_social',  'pw_pasta',  '이파스타', 'pasta@gmail.com', '5678', 'ROLE_USER',NOW(), NOW()),
    (3, '박피자',   'NONE', 'pizza_social',  'pw_pizza',  '박피자',   'pizza@gmail.com', 'abcd', 'ROLE_USER',NOW(), NOW())
    ON DUPLICATE KEY UPDATE
                         name      = VALUES(name),
                         gender    = VALUES(gender),
                         social_id = VALUES(social_id),
                         social_pw = VALUES(social_pw),
                         nickname  = VALUES(nickname),
                         updated_at = VALUES(updated_at);

-- ------------------------
-- 4) Store (BaseEntity O)
-- ------------------------
INSERT INTO store (store_id, region_id, name, address, created_at, updated_at)
VALUES
    (1, 1, '반이학생마라탕마라반', '서울 마포구 어딘가 1', NOW(), NOW()),
    (2, 1, '홍대파스타집',         '서울 마포구 어딘가 2', NOW(), NOW()),
    (3, 2, '수원피자',             '경기 수원시 어딘가 3', NOW(), NOW())
    ON DUPLICATE KEY UPDATE
                         region_id = VALUES(region_id),
                         name      = VALUES(name),
                         address   = VALUES(address),
                         updated_at = VALUES(updated_at);

-- ------------------------
-- 5) Mission (BaseEntity O)
-- ------------------------
INSERT INTO mission (mission_id, store_id, status, point, created_at, updated_at)
VALUES
    (1, 1, 'STBY', 1000, NOW(), NOW()),
    (2, 1, 'STBY',  500, NOW(), NOW()),
    (3, 2, 'STBY',  800, NOW(), NOW())
    ON DUPLICATE KEY UPDATE
                         store_id  = VALUES(store_id),
                         status    = VALUES(status),
                         point     = VALUES(point),
                         updated_at = VALUES(updated_at);

-- ------------------------
-- 6) MemberFood (BaseEntity X)
-- ------------------------
INSERT INTO member_food (member_food_id, member_id, food_id)
VALUES
    (1, 1, 1),
    (2, 1, 2),
    (3, 2, 2),
    (4, 3, 3)
    ON DUPLICATE KEY UPDATE
                         member_id = VALUES(member_id),
                         food_id   = VALUES(food_id);

-- ------------------------
-- 7) MemberMission (BaseEntity X)
-- ------------------------
INSERT INTO member_mission (member_mission_id, member_id, mission_id)
VALUES
    (1, 1, 1),
    (2, 1, 2),
    (3, 2, 3)
    ON DUPLICATE KEY UPDATE
                         member_id  = VALUES(member_id),
                         mission_id = VALUES(mission_id);

-- ------------------------
-- 8) Review (BaseEntity O)
-- ------------------------
INSERT INTO review (review_id, store_id, member_id, title, body, rating, created_at, updated_at)
VALUES
    (1, 1, 1, '마라탕 국물 미쳤다', '국물이 진하고 재료도 신선해요.', 'NONE', NOW(), NOW()),
    (2, 2, 1, '파스타 맛있음',     '치즈가 많고 면이 알단테에요.',     'NONE', NOW(), NOW()),
    (3, 3, 2, '피자 배달 좋음',    '도우가 쫄깃하고 토핑도 많아요.',   'NONE', NOW(), NOW())
    ON DUPLICATE KEY UPDATE
                         store_id   = VALUES(store_id),
                         member_id  = VALUES(member_id),
                         title      = VALUES(title),
                         body       = VALUES(body),
                         rating     = VALUES(rating),
                         updated_at = VALUES(updated_at);

-- ------------------------
-- 9) ReviewPhoto (BaseEntity O)
-- ------------------------
INSERT INTO review_photo (review_photo_id, review_id, created_at, updated_at)
VALUES
    (1, 1, NOW(), NOW()),
    (2, 1, NOW(), NOW()),
    (3, 2, NOW(), NOW())
    ON DUPLICATE KEY UPDATE
                         review_id  = VALUES(review_id),
                         updated_at = VALUES(updated_at);

-- ------------------------
-- (선택) 댓글 테이블은 실제 테이블명 확정 후 적용
-- ------------------------
-- INSERT INTO review_comments (...) VALUES (...)
-- ON DUPLICATE KEY UPDATE ...
