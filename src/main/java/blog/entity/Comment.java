package blog.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(optional = false)
    @JoinColumn(name = "post_id")
    private Post post;

    @Column()
    private String contents;

    @Builder
    public Comment(Long commentId, Member member, Post post, String contents) {
        this.commentId = commentId;
        this.member = member;
        this.post = post;
        this.contents = contents;
    }

    public void setContent(String contents) {
        this.contents = contents;
    }
}
