package com.example.umc9th.domain.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1769383136L;

    public static final QMember member = new QMember("member1");

    public final com.example.umc9th.global.entity.QBaseEntity _super = new com.example.umc9th.global.entity.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final DateTimePath<java.util.Date> dateOfBirth = createDateTime("dateOfBirth", java.util.Date.class);

    public final StringPath detailAddress = createString("detailAddress");

    public final StringPath email = createString("email");

    public final EnumPath<com.example.umc9th.domain.member.enums.Gender> gender = createEnum("gender", com.example.umc9th.domain.member.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<com.example.umc9th.domain.member.enums.LoginType> loginType = createEnum("loginType", com.example.umc9th.domain.member.enums.LoginType.class);

    public final ListPath<com.example.umc9th.domain.member.entity.mapping.MemberFood, com.example.umc9th.domain.member.entity.mapping.QMemberFood> memberFoodList = this.<com.example.umc9th.domain.member.entity.mapping.MemberFood, com.example.umc9th.domain.member.entity.mapping.QMemberFood>createList("memberFoodList", com.example.umc9th.domain.member.entity.mapping.MemberFood.class, com.example.umc9th.domain.member.entity.mapping.QMemberFood.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public final NumberPath<Long> point = createNumber("point", Long.class);

    public final ListPath<com.example.umc9th.domain.review.entity.Review, com.example.umc9th.domain.review.entity.QReview> reviewList = this.<com.example.umc9th.domain.review.entity.Review, com.example.umc9th.domain.review.entity.QReview>createList("reviewList", com.example.umc9th.domain.review.entity.Review.class, com.example.umc9th.domain.review.entity.QReview.class, PathInits.DIRECT2);

    public final StringPath socialUid = createString("socialUid");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<com.example.umc9th.domain.mission.entity.mapping.UserMission, com.example.umc9th.domain.mission.entity.mapping.QUserMission> userMissionList = this.<com.example.umc9th.domain.mission.entity.mapping.UserMission, com.example.umc9th.domain.mission.entity.mapping.QUserMission>createList("userMissionList", com.example.umc9th.domain.mission.entity.mapping.UserMission.class, com.example.umc9th.domain.mission.entity.mapping.QUserMission.class, PathInits.DIRECT2);

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

