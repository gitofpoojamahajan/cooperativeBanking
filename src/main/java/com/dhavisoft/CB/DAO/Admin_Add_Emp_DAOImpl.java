package com.dhavisoft.CB.DAO;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhavisoft.CB.dto.Admin_AddEmployee;
import com.dhavisoft.CB.dto.Employee_Login;
import com.dhavisoft.CB.util.HibernateUtil;

@Repository
public class Admin_Add_Emp_DAOImpl extends HibernateUtil {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @param addEmp Admin Add Employee
	 * @return
	 */

	public Admin_AddEmployee addEmp(Admin_AddEmployee addEmp) {

//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		try {
			session.save(addEmp);
		} catch (HibernateException e) {

			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return addEmp;
	}

	/**
	 * @param addEmps Admin Add Employee method
	 * @return
	 */
	public Employee_Login addEmps(Employee_Login addEmps) {

//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Employee_Login abcd = new Employee_Login();
		String bank_id = addEmps.getBank_id();
		abcd.setBank_id(bank_id);
		String uname = addEmps.getUserName();
		abcd.setUserName(uname);
		String pw = addEmps.getPassword();
		String mpw = md5(pw);
		abcd.setPassword(mpw);
		try {

			session.save(abcd);
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

		return addEmps;
	}

}
