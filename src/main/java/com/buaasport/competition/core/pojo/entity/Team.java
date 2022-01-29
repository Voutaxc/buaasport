package com.buaasport.competition.core.pojo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.naming.Name;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

public class Team implements Serializable {
    @Column(name = "team_name", nullable = false, length = 20)
    private String teamName;

    @Column(name = "leader_id", nullable = false, length = 12)
    private Long leaderId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id", nullable = true, length = 20)
    private Long teamId;

    @Column(name = "intro", nullable = false, length = 100)
    private String intro;

    @Column(name = "game_type", nullable = false, length = 20)
    private String gameType;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "teams_users", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "team_id"})},
    joinColumns = {@JoinColumn(name = "team_id", referencedColumnName = "team_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")}
    )
    @JsonIgnore
    private List<AthleteInfo> athletes;


}
