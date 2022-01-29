package com.buaasport.competition.core.pojo.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

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
@ApiModel(value="参赛报名表对象", description="")
public class AthleteApplyForm implements Serializable {

    @Column(name = "team_id", nullable = false, length = 20)
    private Long teamId;//根据运动员学院信息自动匹配

    @Column(name = "game_id", nullable = false, length = 20)
    private Long gameId;

    @Column(name = "remark", nullable = true, length = 100)
    private String remark;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apply_form_id", nullable = false, length = 12)
    private Long applyFormId;

    @Column(name = "user_id", nullable = false, length = 12)
    private Long userId;

    @Column(name = "user_name", nullable = false, length = 12)
    private String userName;

    @Column(name = "game_name", nullable = false, length = 12)
    private String gameName;




}
