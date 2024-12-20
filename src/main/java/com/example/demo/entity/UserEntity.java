package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    /**
     * Eager
     * @OneToOne
     * @ManyToOne
     *
     * Lazy
     * @OneToMany
     * @ManyToMany Курсы - студенты
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private CityEntity city;

    @Column(name = "city_id", insertable=false, updatable=false)
    private Integer cityId;

    //@OneToMany
    //private List<CommentEntity> comments;
}
