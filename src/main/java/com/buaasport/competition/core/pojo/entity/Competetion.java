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
@ApiModel(value="赛事对象", description="")
public class Competetion implements Serializable {
    @Column(name = "game_type", nullable = false, length = 20)
    private String gameType;

    @Column(name = "game_pattern", nullable = false, length = 20)
    private String gamePattern;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "competition_id", nullable = false, length = 20)
    private Long competitionId;

    @Column(name = "manager_id", nullable = false, length = 1)
    private Long managerId;



}
