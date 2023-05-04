package blog.controller.dto.response;

import blog.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponseDTO {
    private String message;
    private Long memberId;
    private String email;
    private String name;


    public MemberResponseDTO fromEntity(String message, Member member) {
        return MemberResponseDTO.builder()
                .message(message)
                .memberId(member.getMemberId())
                .email(member.getEmail())
                .name(member.getName())
                .build();
    }
}
