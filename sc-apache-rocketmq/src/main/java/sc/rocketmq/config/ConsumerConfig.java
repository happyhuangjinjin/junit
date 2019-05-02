package sc.rocketmq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "rocketmq.consumer")
@Configuration
public class ConsumerConfig {
	
    private String groupName;
    
    private String namesrvAddr;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getNamesrvAddr() {
		return namesrvAddr;
	}

	public void setNamesrvAddr(String namesrvAddr) {
		this.namesrvAddr = namesrvAddr;
	}

	@Override
	public String toString() {
		return "ConsumerConfig [groupName=" + groupName + ", namesrvAddr=" + namesrvAddr + "]";
	}
    
}