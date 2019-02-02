package com.anv.intv.dao;

import com.anv.intv.entities.User;


public interface IUserDAO {
	
	User validateLoginUser(String userName,String password);
}
