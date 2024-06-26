package com.demo.blogweb.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "Blog")
class Blog {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id

    @Column(name = "title")
    String title

    @Column(name = "section")
    String section

    @Column(name = "author")
    String author

    @Column(name = "content")
    String content

    @Column(name = "likes")
    int likes

    @Column(name = "dislikes")
    int dislikes

    @Column(name = "date")
    Date creationDate;

    Blog() {
    }

    Blog(int id, String title, String section, String author, String content, int likes, int dislikes, Date creationDate) {
        this.id = id
        this.title = title
        this.section = section
        this.author = author
        this.content = content
        this.likes = likes
        this.dislikes = dislikes
        this.creationDate = creationDate
    }

    @Override
    String toString() {
        "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", section='" + section + '\'' +
                ", owner='" + author + '\'' +
                ", description='" + content + '\'' +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", creationDate=" + creationDate +
        '}'
    }
}
