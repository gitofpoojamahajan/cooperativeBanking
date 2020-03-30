package com.dhavisoft.CB.DAO;

import java.util.List;

import com.dhavisoft.CB.dto.Employee_Add_Trans;

public interface TransactionDAO {

	public Employee_Add_Trans add(Employee_Add_Trans contact);
	public Employee_Add_Trans delete(Long id);
	public List<Employee_Add_Trans> list();

}
