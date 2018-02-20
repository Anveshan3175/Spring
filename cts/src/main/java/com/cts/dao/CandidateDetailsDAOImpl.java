package com.cts.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.model.CandidatePojo;
import com.cts.model.SkillsPojo;

@Repository("candidateDetailsDAOImpl")
public class CandidateDetailsDAOImpl implements ICandidateDetailsDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public CandidateDetailsDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveCandidate(CandidatePojo pojo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.persist(pojo);
	}

	@Override
	public Integer getNextCandidateId() {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("select candidate_seq.nextval as id from dual")
				.addScalar("id", StandardBasicTypes.INTEGER);
		return ((Integer) query.uniqueResult()).intValue();
	}

	@Override
	public CandidatePojo getCandidateDetails(Integer candidateId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		CandidatePojo pojo = (CandidatePojo) session.get(CandidatePojo.class, candidateId);
		return pojo;
	}

	@Override
	public void updateCandidateDetails(CandidatePojo modifiedPojo) {
		Session session = this.sessionFactory.getCurrentSession();
		//CandidatePojo existingpojo = (CandidatePojo) session.get(CandidatePojo.class, modifiedPojo.getId());
		/*for (CandidateSkillsPojo skill : existingpojo.getSkills()) {
			session.delete(skill);
		}*/
		//Utils.copyDataFromModifiedToExistingPojo(existingpojo,modifiedPojo);
		session.update(modifiedPojo);
	}
	
	@Override
	public List<SkillsPojo> listAllSkills() {
		Session session = sessionFactory.getCurrentSession();
		List<SkillsPojo> allSkillsList = session.createQuery("from SkillsPojo").list();
		return allSkillsList;
	}



}
