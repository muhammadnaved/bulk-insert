package com.khan.bulk.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(generator = "abc")
    @GenericGenerator(name = "abc", strategy = "increment")
    private Long id;
    private String name;
    @Column(name = "description")
    private String desc;

}
