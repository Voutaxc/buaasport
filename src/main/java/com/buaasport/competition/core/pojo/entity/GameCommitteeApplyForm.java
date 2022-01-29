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
public class GameCommitteeApplyForm implements Serializable {

    @Column(name = "game_name", nullable = false, length = 20)
    private String gameName;

    @Column(name = "game_des", nullable = false, length = 20)
    private String gameDes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apply_form_id", nullable = false, length = 12)
    private Long applyFormId;

    @Column(name = "user_id", nullable = false, length = 12)
    private Long userId;

    @Column(name = "state", nullable = false, length = 12)
    private Integer state;




}
