package com.example.umc9th.domain.reviewPhoto.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewPhoto is a Querydsl query type for ReviewPhoto
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewPhoto extends EntityPathBase<ReviewPhoto> {

    private static final long serialVersionUID = 1140550226L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewPhoto reviewPhoto = new QReviewPhoto("reviewPhoto");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.example.umc9th.domain.review.entity.QReview review;

    public final StringPath reviewPhotoUrl = createString("reviewPhotoUrl");

    public QReviewPhoto(String variable) {
        this(ReviewPhoto.class, forVariable(variable), INITS);
    }

    public QReviewPhoto(Path<? extends ReviewPhoto> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewPhoto(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewPhoto(PathMetadata metadata, PathInits inits) {
        this(ReviewPhoto.class, metadata, inits);
    }

    public QReviewPhoto(Class<? extends ReviewPhoto> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.review = inits.isInitialized("review") ? new com.example.umc9th.domain.review.entity.QReview(forProperty("review"), inits.get("review")) : null;
    }

}

