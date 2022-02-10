package com.example.association.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "course")
    private Student student;

    @Column(name = "name")
    private String name;
}
