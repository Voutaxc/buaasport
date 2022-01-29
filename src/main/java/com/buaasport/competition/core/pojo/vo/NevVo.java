package com.buaasport.competition.core.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * {
 * 					name: 'SysUser',
 * 					title: '用户管理',
 * 					icon: 'el-icon-s-custom',
 * 					path: '/sys/users',
 * 					component: 'sys/User',
 * 					children: []
 *                                },
 */
@Data
public class NevVo implements Serializable {

	String[] authorityInfoArray;
	List<MenuVo> nev;

}
