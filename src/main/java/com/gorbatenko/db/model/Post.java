package com.gorbatenko.db.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="posts")
public class Post {
    @Id
    private int id;

    @Column(name="title")
    private String title;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
    @OrderBy("id ASC")
    @JsonManagedReference
    private List<PostComment> comments;
}
