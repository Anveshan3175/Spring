package com.tap.dao;

import com.tap.model.User;

public interface UserDAO {

	User findUserByName(String username);

}
