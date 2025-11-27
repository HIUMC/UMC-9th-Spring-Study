-- ========================================
-- Region 기본 데이터 (BaseEntityX)
-- ========================================
INSERT INTO region (region_id, area) VALUES
                                         (1, '서울'),
                                         (2, '경기'),
                                         (3, '인천');

-- ========================================
-- Store 기본 데이터 (BaseEntityO: created_at, updated_at 필요)
-- Store(store_id, region_id, name, address, created_at, updated_at)
-- ========================================
INSERT INTO store (store_id, region_id, name, address, created_at, updated_at) VALUES
                                                                                   (1, 1, '반이학생마라탕마라반', '서울 마포구 어딘가 1', NOW(), NOW()),
                                                                                   (2, 1, '홍대파스타집',         '서울 마포구 어딘가 2', NOW(), NOW()),
                                                                                   (3, 2, '수원피자',             '경기 수원시 어딘가 3', NOW(), NOW());

-- ========================================
-- Food 기본 데이터 (BaseEntityX)
-- Food(id, name)
-- ========================================
INSERT INTO food (id, name) VALUES
                                (1, '마라탕'),
                                (2, '파스타'),
                                (3, '피자');

-- ========================================
-- Member 기본 데이터 (BaseEntityO)
-- Member(member_id, name, gender, social_id, social_pw, nickname, created_at, updated_at)
-- ========================================
INSERT INTO member (member_id, name, gender, social_id, social_pw, nickname, created_at, updated_at) VALUES
                                                                                                         (1, '김토마토', 'NONE', 'tomato_social', 'pw_tomato', '김토마토', NOW(), NOW()),
                                                                                                         (2, '이파스타', 'NONE', 'pasta_social',  'pw_pasta',  '이파스타', NOW(), NOW()),
                                                                                                         (3, '박피자',   'NONE', 'pizza_social',  'pw_pizza',  '박피자',   NOW(), NOW());

-- ========================================
-- Mission 기본 데이터 (BaseEntityO)
-- Mission(mission_id, store_id, status, point, created_at, updated_at)
-- ========================================
INSERT INTO mission (mission_id, store_id, status, point, created_at, updated_at) VALUES
                                                                                      (1, 1, 'STBY', 1000, NOW(), NOW()),  -- 반이학생마라탕마라반 미션 1
                                                                                      (2, 1, 'STBY',  500, NOW(), NOW()),  -- 반이학생마라탕마라반 미션 2
                                                                                      (3, 2, 'STBY',  800, NOW(), NOW());  -- 홍대파스타집 미션 1

-- ========================================
-- MemberFood 기본 데이터 (BaseEntityX)
-- MemberFood(member_food_id, member_id, food_id)
-- ========================================
INSERT INTO member_food (member_food_id, member_id, food_id) VALUES
                                                                 (1, 1, 1),  -- 김토마토 - 마라탕
                                                                 (2, 1, 2),  -- 김토마토 - 파스타
                                                                 (3, 2, 2),  -- 이파스타 - 파스타
                                                                 (4, 3, 3);  -- 박피자   - 피자

-- ========================================
-- MemberMission 기본 데이터 (BaseEntityX)
-- MemberMission(member_mission_id, member_id, mission_id)
-- ========================================
INSERT INTO member_mission (member_mission_id, member_id, mission_id) VALUES
                                                                          (1, 1, 1),
                                                                          (2, 1, 2),
                                                                          (3, 2, 3);

-- ========================================
-- Review 기본 데이터 (BaseEntityO)
-- Review(review_id, store_id, member_id, title, body, rating, created_at, updated_at)
-- ========================================
INSERT INTO review (review_id, store_id, member_id, title, body, rating, created_at, updated_at) VALUES
                                                                                                     (1, 1, 1, '마라탕 국물 미쳤다', '국물이 진하고 재료도 신선해요.', 'NONE', NOW(), NOW()),
                                                                                                     (2, 2, 1, '파스타 맛있음',     '치즈가 많고 면이 알단테에요.', 'NONE', NOW(), NOW()),
                                                                                                     (3, 3, 2, '피자 배달 좋음',    '도우가 쫄깃하고 토핑도 많아요.', 'NONE', NOW(), NOW());

-- ========================================
-- Review_Photo 기본 데이터 (BaseEntityO)
-- Review_Photo(review_photo_id, review_id, created_at, updated_at)
-- ========================================
INSERT INTO review_photo (review_photo_id, review_id, created_at, updated_at) VALUES
                                                                                  (1, 1, NOW(), NOW()),
                                                                                  (2, 1, NOW(), NOW()),
                                                                                  (3, 2, NOW(), NOW());

-- ========================================
-- (선택) 댓글 데이터: Reivew_Comments
-- 엔티티/테이블 이름이 정확히 어떻게 생성됐는지 모르니까
-- 실제 DB에 생성된 테이블 이름 확인 후 열고 싶으면 아래 주석 풀어서
-- 테이블명만 맞춰서 쓰면 됨.
-- ========================================
-- INSERT INTO reivew_comments (review_comments_id, review_id, title, body, created_at, updated_at) VALUES
--     (1, 1, '첫 댓글', '저도 여기 자주 가요!', NOW(), NOW()),
--     (2, 1, '정보 감사', '미션 깨러 가봐야겠네요.', NOW(), NOW()),
--     (3, 2, '파스타 러버', '여기 크림 파스타도 맛있어요.', NOW(), NOW());
