package hello.umc9th.global.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity { //공통적인 칼럼을 만드는 엔터티
    //생성일자
    @CreatedDate
    @Column(name="created_at",nullable = false)
    private LocalDateTime createdAt;

    //수정일자
    @LastModifiedDate
    @Column(name="updated_at",nullable = false)
    private LocalDateTime updatedAt;

    //삭제일자
    @Column(name="deleted_at",nullable = true)
    private LocalDateTime deletedAt;
    //삭제일자는 먼가 메서드를 따로 넣어야할 거같아서 일단 필드만 놔둠.
}
