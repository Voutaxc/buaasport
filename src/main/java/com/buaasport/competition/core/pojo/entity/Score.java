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
@ApiModel(value="个人成绩对象", description="")
public class Score implements Serializable {
    @Id
    @Column(name = "competition_id", nullable = false, length = 20)
    private Long competitionId;

    @Column(name = "game_type", nullable = false, length = 12)
    private String gameType;

    @Column(name = "score", nullable = false, length = 20)
    private String score;

    @Column(name = "remark", nullable = false, length = 20)
    private String remark;

    @Column(name = "user_id", nullable = false, length = 12)
    private Long userId;

    @Column(name = "time", nullable = false, length = 12)
    private String time;




}
