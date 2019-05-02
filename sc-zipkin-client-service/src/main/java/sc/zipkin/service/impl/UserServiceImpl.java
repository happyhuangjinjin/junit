package sc.zipkin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import sc.zipkin.model.UserDTO;
import sc.zipkin.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Override
	public UserDTO getUser(Integer id) {
		UserDTO user = new UserDTO();
		user.setId(1);
		user.setUserName("good boy");
		user.setPosition("cto");
		return user;
	}

	@Override
	public List<UserDTO> listUser() {
		UserDTO user = new UserDTO();
		user.setId(1);
		user.setUserName("good boy");
		user.setPosition("cto");

		List<UserDTO> list = new ArrayList<UserDTO>();
		list.add(user);

		UserDTO user2 = new UserDTO();
		user2.setId(2);
		user2.setUserName("bueaty gril");
		user2.setPosition("coo");
		list.add(user2);
		return list;
	}

}
