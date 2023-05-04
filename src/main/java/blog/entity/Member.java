package blog.entity;

import blog.controller.dto.response.MemberResponseDTO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 45)
    private String email;

    @Column(length = 45)
    private String name;

    @Column(length = 45)
    private String password;

    @Builder
    public Member(Long memberId, String email, String name, String password) {
        this.memberId = memberId;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MemberResponseDTO fromEntity(String message) {
        return MemberResponseDTO.builder()
                .message(message)
                .memberId(memberId)
                .email(email)
                .name(name)
                .build();
    }
}
