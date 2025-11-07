package com.example.umc9th.domain.Food.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFood is a Querydsl query type for Food
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFood extends EntityPathBase<Food> {

    private static final long serialVersionUID = -1765196280L;

    public static final QFood food = new QFood("food");

    public final EnumPath<com.example.umc9th.domain.Food.enums.FoodName> foodName = createEnum("foodName", com.example.umc9th.domain.Food.enums.FoodName.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.example.umc9th.domain.member.entity.mapping.UserFoodPreference, com.example.umc9th.domain.member.entity.mapping.QUserFoodPreference> userFoodPreferences = this.<com.example.umc9th.domain.member.entity.mapping.UserFoodPreference, com.example.umc9th.domain.member.entity.mapping.QUserFoodPreference>createList("userFoodPreferences", com.example.umc9th.domain.member.entity.mapping.UserFoodPreference.class, com.example.umc9th.domain.member.entity.mapping.QUserFoodPreference.class, PathInits.DIRECT2);

    public QFood(String variable) {
        super(Food.class, forVariable(variable));
    }

    public QFood(Path<? extends Food> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFood(PathMetadata metadata) {
        super(Food.class, metadata);
    }

}

