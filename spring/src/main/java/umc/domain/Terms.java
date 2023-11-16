package umc.domain;

import lombok.*;
import umc.domain.common.BaseEntity;
import umc.domain.mapping.MemberAgree;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Terms extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false, length = 100)
    private String content;

    @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();
}
