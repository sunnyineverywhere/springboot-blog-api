package blog.controller.dto;


import lombok.Getter;

@Getter
public class PasswordRequestDTO {
    private Long memberId;
    private String password;
}
