package sc.activemq.service;

import javax.jms.Destination;

public interface ProductService {
	
    void sendMessage(Destination destination,String message);
}
