package hongikUMC.workbook.domain.member.entity;

import hongikUMC.workbook.domain.member.entity.mapped.Member_Food;
import hongikUMC.workbook.domain.member.enums.Gender;
import hongikUMC.workbook.domain.mission.entity.mapped.Member_Mission;
import hongikUMC.workbook.global.enums.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
@Table(name = "member")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    @Column(name = "name", length = 3, nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Gender gender = Gender.NONE;

    @Column(name = "social_id", nullable = false)
    private String social_id;

    @Column(name = "social_pw", nullable = false)
    private String social_pw;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    //==양방향 고려==//
    /** Member_Food */
    @OneToMany(mappedBy = "member")
    private List<Member_Food> memberFoodList = new ArrayList<>();

    /** Member_Mission */
    @OneToMany(mappedBy = "member")
    private List<Member_Mission> memberMissionList = new ArrayList<>();

}
