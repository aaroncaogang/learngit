package cn.it.test;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import cn.it.dao.impl.DeptDaoImpl;
import cn.it.entity.Dept;

@DisplayName("Calculator")
public class TestDeptDaoImpl {
	
	private static DeptDaoImpl deptDaoImpl;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		deptDaoImpl = new DeptDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		deptDaoImpl = null;
	}

	@Test
	@DisplayName("insert")
	public void insert() {
		Dept dept = new Dept();
		dept.setDeptName("综合部");
		dept.setDeptAddress("广州天河");
		System.out.println("受影响 的行数："+deptDaoImpl.save(dept));
	}

}