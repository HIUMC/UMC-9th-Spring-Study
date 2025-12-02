-- ===========================
-- MEMBER (리뷰 작성자)
-- ===========================
INSERT INTO member (
    id,
    name,
    gender,
    birth,
    address,
    detail_address,
    social_uid,
    social_type,
    point,
    email,
    phone_number,
    deleted_at,
    created_at,
    updated_at
)
VALUES
    (1, '임준서', 'MALE', '2000-05-12', 'MAPO', '서교동 101', 'uid_jun', 'KAKAO', 0, 'jun@example.com', '01012345678', NULL, NOW(), NOW()),
    (2, '한하나', 'FEMALE', '1998-09-20', 'SEODAEMUN', '신촌동 5', 'uid_hana', 'GOOGLE', 0, 'hana@example.com', '01098765432', NULL, NOW(), NOW());

-- ===========================
-- STORE (가게)
-- ===========================
INSERT INTO store (
    id,
    name,
    manager_number,
    detail_address,
    region,
    created_at,
    updated_at
)
VALUES
    (1, '반이학생마라탕마라반', 1, '서울 마포구 서교동 123', 'MAPO', NOW(), NOW()),
    (2, '홍익돈까스', 2, '서울 마포구 와우산로 20', 'MAPO',NOW(), NOW()),
    (3, '커피플레이스', 3, '서울 마포구 연남동 45', 'MAPO',NOW(), NOW());

-- ===========================
-- REVIEW (리뷰 본문)
-- ===========================
INSERT INTO review (
    id,
    content,
    star,
    store_id,
    member_id,
    reply_id,
    created_at,
    updated_at
)
VALUES
    (1, '마라탕 맛이 진하고 재료가 신선했어요!', 5.0, 1, 1, NULL, NOW(), NOW()),
    (2, '양은 많지만 조금 짰어요.', 3.5, 1, 2, NULL, NOW(), NOW()),
    (3, '돈까스 바삭하고 맛있어요!', 4.8, 2, 1, NULL, NOW(), NOW()),
    (4, '커피가 너무 연했어요 ㅠㅠ', 2.5, 3, 2, NULL, NOW(), NOW());

-- ===========================
-- MISSION: 가게별 미션 등록
-- ===========================

INSERT INTO mission (
    id,
    deadline,
    conditional,
    point,
    store_id,
    created_at,
    updated_at
)
VALUES
    -- Store 1: 반이학생마라탕마라반
    (1, '2025-03-10', '마라탕 10000원 이상 주문', 1000, 1, NOW(), NOW()),
    (2, '2025-03-25', '마라샹궈 주문', 1000, 1, NOW(), NOW()),

    -- Store 2: 홍익돈까스
    (3, '2025-04-01', '돈까스 정식 주문', 1000, 2, NOW(), NOW()),
    (4, '2025-04-05', '매장에서 10000원 이상 주문', 1000, 2, NOW(), NOW()),

    -- Store 3: 커피플레이스
    (5, '2025-03-15', '아메리카노 주문', 1000, 3, NOW(), NOW()),
    (6, '2025-03-28', '디저트 세트 구매', 1000, 3, NOW(), NOW());

-- ===========================
-- MEMBER_MISSION
-- ===========================

INSERT INTO member_mission (
    id,
    is_complete,
    member_id,
    mission_id,
    created_at,
    updated_at
)
VALUES
    (1, FALSE, 1, 1, NOW(), NOW()),   -- 준서: 마라탕 미션 진행 중
    (2, FALSE, 1, 3, NOW(), NOW()),   -- 준서: 돈까스 미션 진행 중
    (3, TRUE, 2, 2, NOW(), NOW()),    -- 하나: 미션 2 완료
    (4, FALSE, 1, 5, NOW(), NOW()),   -- 준서: 커피 미션 진행 중
    (5, FALSE, 2, 4, NOW(), NOW());   -- 하나: 미션 진행 중
