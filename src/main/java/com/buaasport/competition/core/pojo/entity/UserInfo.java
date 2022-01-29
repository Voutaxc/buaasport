package com.buaasport.competition.core.pojo.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Id;

import javax.persistence.*;

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
@ApiModel(value="UserInfo对象", description="")
public class UserInfo implements Serializable {
    @Column(name = "username", nullable = false, length = 20)
    private String userName;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false, length = 20)
    private Long userId;

    @Column(name = "auth", nullable = false, length = 1)
    private Integer auth;

    @Column(name = "phone", nullable = false, length = 15)
    private String phone;




}
