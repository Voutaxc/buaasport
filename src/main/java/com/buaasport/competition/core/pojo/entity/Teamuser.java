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
@ApiModel(value="Team对象", description="")
public class Teamuser implements Serializable {


    @Column(name = "team_id", nullable = false, length = 12)
    private Long teamId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teamuser_id", nullable = true, length = 20)
    private Long teauserId;


    @Column(name = "user_id", nullable = false, length = 20)
    private Long userId;


}
