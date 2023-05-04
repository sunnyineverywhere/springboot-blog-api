package blog.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(length = 64, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String contents;

    @Enumerated(EnumType.STRING)
    @NonNull
    private PostStatus status;

    @Builder
    public Post(Long postId, String title, String contents, @NonNull PostStatus status) {
        this.postId = postId;
        this.title = title;
        this.contents = contents;
        this.status = status;
    }
}
