package com.matzip.matzipback.board.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDateTime;

@Entity
@Table(name = "post_image")
@NoArgsConstructor
@SQLDelete(sql = "UPDATE post_image SET post_image_deleted_yn = 'Y' WHERE post_image_seq = ?")
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postImageSeq;
    private int postSeq;
    private String postImageFilepath;
    private String postImageName;
    private String postImageUrl;
    private LocalDateTime postImageCreatedTime;
    private String postImageDeletedYn;

}