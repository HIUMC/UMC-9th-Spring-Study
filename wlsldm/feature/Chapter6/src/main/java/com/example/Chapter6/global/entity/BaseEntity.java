package com.example.Chapter6.global.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseEntity
{
    @CreatedDate
    @Column(name = "create_at", nullable = false)
    private Date createAt;

    @LastModifiedDate
    @Column(name = "update_at", nullable = false)
    private Date updateAt;
}
