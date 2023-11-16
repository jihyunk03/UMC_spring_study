package umc.domain;

import lombok.*;
import umc.domain.common.BaseEntity;
import umc.domain.enums.Gender;
import umc.domain.enums.MemberStatus;
import umc.domain.mapping.MemberAgree;
import umc.domain.mapping.MemberMission;
import umc.domain.mapping.MemberPrefer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Column(nullable = false, length = 10)
    private String birthday;

    @Column(nullable = false, length = 50)
    private String address;

    @Column(nullable = false, length = 20)
    private String nickname;

    @Column(nullable = false, length = 15)
    private String phoneNum;

    @Column(nullable = false, length = 30)
    private String email;

    private Integer point;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    private LocalDate inactiveDate;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
