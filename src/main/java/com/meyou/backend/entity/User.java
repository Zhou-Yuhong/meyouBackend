package com.meyou.backend.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Data
@Entity
@Table(name="user")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"}) /* 防止循环引用 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@DynamicUpdate
@DynamicInsert
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name="open_id")
    private Integer openId;

    @Column(name="email")
    private String email;

    @Column(name="name")
    private String name;

    @Column(name="year")    //年级，不能用grade关键字
    private Integer year;

    @Column(name="major")
    private Integer major;

    @Column(name="personality")
    private String personality;

    @Column(name="state")
    private Integer state;

    @JsonIgnore
    @JSONField(serialize = false)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "publisher")
    private List<Team> teamList=new ArrayList<>();

    @JsonIgnore
    @JSONField(serialize = false)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "member")
    private List<Matched> matchedList =new ArrayList<>();

    @JsonIgnore
    @JSONField(serialize = false)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private List<Skill> skillList=new ArrayList<>();
}



