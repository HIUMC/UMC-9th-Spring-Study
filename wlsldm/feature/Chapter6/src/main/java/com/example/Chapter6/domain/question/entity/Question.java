package com.example.Chapter6.domain.question.entity;

import com.example.Chapter6.domain.question.enums.QuestionType;
import com.example.Chapter6.domain.user.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "questions")
@EntityListeners(AuditingEntityListener.class)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memeber_id")
    private Member memeber;

    @Column(name = "title", length = 30, nullable = false)
    private String title;

    @Column(name = "context", nullable = false)
    private String context;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private QuestionType type = QuestionType.ETC;
}
