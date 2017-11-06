package com.anvesh.person.dao;

import com.anvesh.person.model.Login;

public interface UserDAO {

	Login findUserByName(String username);

}
