package com.dhavisoft.CB.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhavisoft.CB.dto.Bank_Details;
import com.dhavisoft.CB.util.HibernateUtil;

@Repository
public class Bank_Details_DAO extends HibernateUtil implements Bank_DetailsDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Bank_Details> list()  {
         
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
        
        List<Bank_Details> details = null;
        
        try 
        {
             
            details = (List<Bank_Details>)session.createQuery("from Bank_Detail").list();
             
        } 
        catch (HibernateException e) 
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        
        session.getTransaction().commit();
        return details;
    }

	public Bank_Details addBank(Bank_Details add)
	{
		
		return add;
	}

}
