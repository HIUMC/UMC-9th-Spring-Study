package com.example.umc9th.domain.store.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStore is a Querydsl query type for Store
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStore extends EntityPathBase<Store> {

    private static final long serialVersionUID = 135584498L;

    public static final QStore store = new QStore("store");

    public final StringPath detailAddress = createString("detailAddress");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> managerNumber = createNumber("managerNumber", Long.class);

    public final ListPath<com.example.umc9th.domain.mission.entity.Mission, com.example.umc9th.domain.mission.entity.QMission> missionList = this.<com.example.umc9th.domain.mission.entity.Mission, com.example.umc9th.domain.mission.entity.QMission>createList("missionList", com.example.umc9th.domain.mission.entity.Mission.class, com.example.umc9th.domain.mission.entity.QMission.class, PathInits.DIRECT2);

    public final ListPath<com.example.umc9th.domain.review.entity.Review, com.example.umc9th.domain.review.entity.QReview> reviewList = this.<com.example.umc9th.domain.review.entity.Review, com.example.umc9th.domain.review.entity.QReview>createList("reviewList", com.example.umc9th.domain.review.entity.Review.class, com.example.umc9th.domain.review.entity.QReview.class, PathInits.DIRECT2);

    public final StringPath storeName = createString("storeName");

    public QStore(String variable) {
        super(Store.class, forVariable(variable));
    }

    public QStore(Path<? extends Store> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStore(PathMetadata metadata) {
        super(Store.class, metadata);
    }

}

