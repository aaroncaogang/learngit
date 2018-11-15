package cn.it.dao.impl;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.it.dao.util.MybatisSessionFactory;
import cn.it.entity.Dept;

public class DeptDaoImpl {

	/* 1、读取配置文件
	 * 2、构建session工厂
	 * 3、创建session
	 * 4、开启事务（可选）
	 * 5、处理数据
	 * 6、提交，回滚事物
	 * 7、关闭session
	 * */
	
	public int save(Dept dept){
		int i =0;
		SqlSession session = null;
		Reader reader = null;
		try {	
			session = MybatisSessionFactory.getSession();
			i = session.insert("cn.it.entity.DeptMapper.insertDept", dept);
			session.commit();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.rollback();
		}finally{
			try {
				MybatisSessionFactory.closeSession();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}

}
