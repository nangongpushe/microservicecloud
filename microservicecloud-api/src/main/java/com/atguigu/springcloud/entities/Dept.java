package com.atguigu.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

//@AllArgsConstructor
@NoArgsConstructor
@Data //set和get方法
@Accessors(chain=true)
public class Dept {
	
	//主键
	private Long deptno;
	//部门名称
	private String dname;
	//来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同的数据库
	private String db_source;
	
	public Dept(String dname) {
		super();
		this.dname = dname;
	}
	
//	public static void main(String[] args) {
//		
//		Dept dept = new Dept();
//		//@Accessors(chain=true)这个注解保证下面的链式写法
//		dept.setDeptno(11L).setDname("RD").setDb_source("DB01");
//		
//	}
	
}
