package sc.zipkin.web.service;

import java.util.Map;

public interface UserService {
	
	public Map<String, Object> getUser(Integer id);

	public Map<String, Object> listUser();
}
