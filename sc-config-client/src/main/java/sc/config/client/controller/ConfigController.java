package sc.config.client.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

	// git配置文件里的key
	@Value("${jdbc.driverClassName}") 
    private String driverClassName;
	
	@Value("${jdbc.url}") 
    private String url;
	
	@Value("${jdbc.username}") 
    private String username;
	
	@Value("${jdbc.password}") 
    private String password;
	
	@RequestMapping(value="/config/getValue")
	public Map<String, Object> getConfigFromGit() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "000000");
		result.put("msg", "ok");
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("driverClassName", driverClassName);
		body.put("url", url);
		body.put("username", username);
		body.put("password", password);
		result.put("body", body);
		return result;
	}

}
