package blog.controller;

import blog.controller.dto.MemberRemoveRequestDTO;
import blog.controller.dto.PasswordRequestDTO;
import blog.controller.dto.SignUpRequestDTO;
import blog.entity.Member;
import blog.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<?> accountRegister(@RequestBody SignUpRequestDTO requestDTO){
        Member member = memberService.registerAccount(requestDTO);
        return new ResponseEntity<>(member.fromEntity("계정이 생성되었습니다."), HttpStatus.OK);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<?> accountFind(@PathVariable Long accountId){
        Member member = memberService.findAccount(accountId);
        return new ResponseEntity<>(member.fromEntity("계정 조회 성공"), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> passwordModify(@RequestBody PasswordRequestDTO requestDTO){
        Member member = memberService.modifyPassword(requestDTO);
        return new ResponseEntity<>(member.fromEntity("패스워드 변경 성공"), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> accountRemove(@RequestBody MemberRemoveRequestDTO requestDTO){
        memberService.removeAccount(requestDTO);
        return new ResponseEntity<>("계정이 삭제되었습니다.", HttpStatus.OK);
    }
}
