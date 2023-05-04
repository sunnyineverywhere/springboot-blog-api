package blog.service;

import blog.controller.dto.MemberRemoveRequestDTO;
import blog.controller.dto.PasswordRequestDTO;
import blog.controller.dto.SignUpRequestDTO;
import blog.entity.Member;
import blog.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member registerAccount(SignUpRequestDTO requestDTO) {
        if (memberRepository.findByEmail(requestDTO.getEmail()).isPresent()){
            throw new IllegalArgumentException("이미 존재하는 계정입니다.");
        }
        return memberRepository.save(
                requestDTO.toEntity()
        );
    }

    public Member findAccount(Long accountId) {
        return memberRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 계정입니다."));
    }

    public Member modifyPassword(PasswordRequestDTO requestDTO) {
        Member member = memberRepository.findById(requestDTO.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 계정입니다."));
        member.setPassword(requestDTO.getPassword());
        member = memberRepository.save(member);
        return member;
    }

    public void removeAccount(MemberRemoveRequestDTO requestDTO) {
        Member member = memberRepository.findById(requestDTO.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 계정입니다."));
        memberRepository.delete(member);
    }
}
