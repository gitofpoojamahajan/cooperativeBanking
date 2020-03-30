package com.dhavisoft.CB.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhavisoft.CB.dto.Admin_Client_ch_pw;
import com.dhavisoft.CB.util.HibernateUtil;

@Repository
public class Admin_Client_ch_pw_DAO extends HibernateUtil {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @param chpw Admin Can Change Client Password
	 * @return
	 */

	public Admin_Client_ch_pw changepw(Admin_Client_ch_pw chpw) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		String bank_id = chpw.getBank_id();
		String newpw = chpw.getNewpw();
		try {
			String SQL_QUERY2 = "UPDATE Admin_ClientChPW set password = :password WHERE bank_id = :bank_id";
			// Query query2 = session.createQuery(SQL_QUERY2);
			Query query2 = session.createQuery(SQL_QUERY2);
			query2.setParameter("password", newpw);
			query2.setParameter("bank_id", bank_id);
			int result = query2.executeUpdate();
			System.out.println("Rows affected: " + result);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		System.out.println(bank_id);
		System.out.println(newpw);

		session.getTransaction().commit();
		return chpw;
	}

}
