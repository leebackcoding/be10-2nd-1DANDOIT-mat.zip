package com.matzip.matzipback.matzipList.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "list_comment")
@NoArgsConstructor
@SQLDelete(sql = "UPDATE list_comment SET list_comment_status = 'delete', list_comment_deleted_time = NOW() WHERE list_comment_seq = ?")
public class MyListComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long listCommentSeq;
    private long listSeq;
    private long listCommentUserSeq;
    private String listCommentContent;
    private String listCommentStatus;
    @CreatedDate
    private LocalDateTime listCommentCreatedTime;
    @LastModifiedDate
    private LocalDateTime listCommentUpdatedTime;
    private LocalDateTime listCommentDeletedTime;
}
