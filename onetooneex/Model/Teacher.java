package com.example.onetooneex.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should not be empty")
    @Column(columnDefinition = "varchar(20) not null ")
    private String name;
    @NotNull(message = "age should not be null")
    @Column(columnDefinition = "int not null")
    private Integer age;
    @Email
    @NotEmpty(message = "email should not be empty")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;
    @NotNull(message = "salary should not be null")
    @Column(columnDefinition = "int not null")
    private Integer salary;


    @OneToOne(cascade =CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> courses;
}
