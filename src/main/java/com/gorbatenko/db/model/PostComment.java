package com.gorbatenko.db.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="post_comments")
public class PostComment {
    @Id
    private int id;

    private String comment;

    @ManyToOne(targetEntity=Post.class, fetch=FetchType.LAZY)
    @JsonBackReference
    private Post post;
}
