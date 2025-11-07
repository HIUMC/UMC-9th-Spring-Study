package com.example.umc9th.domain.member.entity.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserFoodPreference is a Querydsl query type for UserFoodPreference
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserFoodPreference extends EntityPathBase<UserFoodPreference> {

    private static final long serialVersionUID = 1973381930L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserFoodPreference userFoodPreference = new QUserFoodPreference("userFoodPreference");

    public final com.example.umc9th.domain.Food.entity.QFood food;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.example.umc9th.domain.member.entity.QMember member;

    public final DateTimePath<java.time.LocalDateTime> selectedAt = createDateTime("selectedAt", java.time.LocalDateTime.class);

    public QUserFoodPreference(String variable) {
        this(UserFoodPreference.class, forVariable(variable), INITS);
    }

    public QUserFoodPreference(Path<? extends UserFoodPreference> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserFoodPreference(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserFoodPreference(PathMetadata metadata, PathInits inits) {
        this(UserFoodPreference.class, metadata, inits);
    }

    public QUserFoodPreference(Class<? extends UserFoodPreference> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.food = inits.isInitialized("food") ? new com.example.umc9th.domain.Food.entity.QFood(forProperty("food")) : null;
        this.member = inits.isInitialized("member") ? new com.example.umc9th.domain.member.entity.QMember(forProperty("member")) : null;
    }

}

