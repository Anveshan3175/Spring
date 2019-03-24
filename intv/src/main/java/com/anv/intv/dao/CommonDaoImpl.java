package com.anv.intv.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anv.intv.entities.CandidatePojo;
import com.anv.intv.entities.InterviewPojo;
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

	@Override
	public CandidatePojo getCandidateByEmail(String email) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession(); 
		 CriteriaBuilder builder = session.getCriteriaBuilder();
		 CriteriaQuery<CandidatePojo> criteriaQuery = builder.createQuery(CandidatePojo.class);
		 Root<CandidatePojo> root = criteriaQuery.from(CandidatePojo.class);
		 
		 Predicate[] predicates = new Predicate[1];
		 predicates[0] = builder.equal(root.get("email"), email);
		 
		 criteriaQuery.select(root).where(predicates);
		 
		 Query<CandidatePojo> query = session.createQuery(criteriaQuery);
		 List<CandidatePojo> results = query.getResultList();
		 
		 return (results != null && !results.isEmpty()) ? results.get(0) : null;
	}

	@Override
	public boolean addNewInterview(InterviewPojo pojo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession(); 
		session.save(pojo);
		return true;
	}

}
