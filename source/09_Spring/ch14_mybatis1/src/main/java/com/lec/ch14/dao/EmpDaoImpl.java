package com.lec.ch14.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lec.ch14.dto.Emp;
@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	@Override
	public List<Emp> empList(Emp schEmp) {
		return sessionTemplate.selectList("empList", schEmp);
	}

}
