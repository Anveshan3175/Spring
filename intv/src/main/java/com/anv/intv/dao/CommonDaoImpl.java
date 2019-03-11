package com.anv.intv.dao;

import java.util.List;

import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anv.intv.entities.CandidatePojo;
import com.anv.intv.entities.QuestionsPojo;

@Repository("commonDao")
public class CommonDaoImpl implements ICommonDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public boolean addCandidate(CandidatePojo pojo) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession(); 
		session.save(pojo);
		return true;
	}

	@Override
	public void addQuestion(QuestionsPojo pojo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession(); 
		session.save(pojo);
	}

	@Override
	public List<QuestionsPojo> getAllQuestions() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession(); 
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<QuestionsPojo> cr = cb.createQuery(QuestionsPojo.class);
		Root<QuestionsPojo> root = cr.from(QuestionsPojo.class);
		cr.select(root);
		 
		Query<QuestionsPojo> query = session.createQuery(cr);
		List<QuestionsPojo> results = query.getResultList();
		return results;
	}

}
