package com.anv.intv.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anv.intv.dao.IUserDAO;

@Service("userDetailsSVC")
public class UserDetailsSVCImpl implements IUserDetailsSVC {

	@Autowired
	private IUserDAO userDao;
	
	@Override
	@Transactional
	public boolean validateLoginUser(String userName, String password) {
		// TODO Auto-generated method stub
		
		return userDao.validateLoginUser(userName, password) != null;
	}

}
