package com.cts.dao;

import com.cts.model.User;

public interface UserDAO {

	User findUserByName(String username);

}
