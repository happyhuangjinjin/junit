package sc.zipkin.service;

import java.util.List;

import sc.zipkin.model.UserDTO;

public interface UserService {

	public UserDTO getUser(Integer id);

	public List<UserDTO> listUser();

}
