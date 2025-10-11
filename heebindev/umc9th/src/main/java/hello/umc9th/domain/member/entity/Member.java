package hello.umc9th.domain.member.entity;


import hello.umc9th.domain.member.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@Table(name = "member")
@EntityListeners(AuditingEntityListener.class)
@EnableJpaAuditing
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 5, nullable = false)
    private String name;

    @Column(name = "gender",nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Gender gender = Gender.NONE;

    @Column(name="birth", nullable = false)
    private LocalDate birth;

    @CreatedDate
    @Column(name = "create_at",nullable = false)
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(name = "update_at",nullable = false)
    private LocalDateTime updatedAt;
}
