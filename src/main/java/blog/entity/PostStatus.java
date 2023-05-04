package blog.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PostStatus {
    CREATED("STATUS_CREATED", "created"),
    MODIFIED("STATUS_MODIFIED", "modified"),
    DELETED("STATUS_DELETED", "deleted");

    private final String key;
    private final String status;
}
