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

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String birthday;

    private String address;

    private String nickname;

    private String phoneNum;

    private String email;

    private Integer point;

    @Enumerated(EnumType.STRING)
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
