package com.Carros.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UsersService {
	
	@Autowired
	private UserRepository userRep;
	
	public List<UserDTO> getUsers(){
		List<User> user = userRep.findAll();
		List<UserDTO> userList = new ArrayList<>();
		
		for (User userDto : user ) {
			userList.add(UserDTO.create(userDto));
		}
		return userList;
	}
}
