package blog.controller.dto;

import blog.entity.Member;
import lombok.Getter;

@Getter
public class SignUpRequestDTO {
    private String email;
    private String name;
    private String password;

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .name(name)
                .password(password)
                .build();
    }
}
