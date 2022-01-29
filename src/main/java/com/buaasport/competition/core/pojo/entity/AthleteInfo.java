package com.buaasport.competition.core.pojo.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2021-12-24
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="运动员信息对象", description="")
public class AthleteInfo implements Serializable {
    @Column(name = "gender", nullable = false, length = 20)
    private String gender;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "email", nullable = false, length = 20)
    private String email;

    @Column(name = "student_number", nullable = false, length = 20)
    private String studentNumber;


    @Column(name = "academy", nullable = false, length = 20)
    private String academy;

    @Column(name = "remark", nullable = false, length = 20)
    private String remark;

    
    @Id
    @Column(name = "user_id", nullable = false, length = 20)
    private Long userId;

    @ManyToMany(mappedBy = "athletes")
    private List<Team> teams;





}
