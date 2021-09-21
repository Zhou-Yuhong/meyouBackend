package com.meyou.backend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

//描述组内成员Tag
@Data
@Entity
@Table(name="match_tag")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"}) /* 防止循环引用 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@DynamicUpdate
@DynamicInsert
public class MatchTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="match_tag_id")
    private Integer id;

    @Column(name="type") //tag种类
    private Integer type;

    @Column(name="value") //tag值
    private String value;

    @ManyToOne
    @JoinColumn(name="matched", referencedColumnName = "match_id")
    private Matched matched;
}
