package com.meyou.backend.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Data
@Entity
@Table(name="team")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"}) /* 防止循环引用 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@DynamicUpdate
@DynamicInsert
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="team_id")
    private Integer id;

    @Column(name="introduction")
    private String introduction;

    @Column(name="declaration")
    private String declaration;  //组队宣言

    @Column(name="classification")  //赛事分类
    private Integer classification;

    @Column(name="state")
    private Integer state;

    @Column(name = "upload_time")
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp uploadTime; //组队信息上传时间

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user", referencedColumnName = "user_id")
    private User publisher;//发布者

    @JsonIgnore
    @JSONField(serialize = false)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "team")
    private List<Matched> matchedList =new ArrayList<>();

    @JsonIgnore
    @JSONField(serialize = false)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "team")
    private List<TeamTag> teamTagList=new ArrayList<>();

    @JsonIgnore
    @JSONField(serialize = false)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "team")
    private List<TeamDemandTag> teamDemandTagList=new ArrayList<>();
}
