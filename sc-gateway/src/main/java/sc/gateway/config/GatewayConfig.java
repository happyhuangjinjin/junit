package sc.gateway.config;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route.AsyncBuilder;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.BooleanSpec;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {

//		Function<PredicateSpec, AsyncBuilder> fn = new Function<PredicateSpec, AsyncBuilder>() {
//
//			@Override
//			public AsyncBuilder apply(PredicateSpec t) {
//				BooleanSpec builder = t.path("/sina");
//				return builder.uri("http://www.sina.com.cn/");
//			}
//		};
//		
//		return builder.routes().route("sina", fn).build();
		
		return builder.routes()
	            //basic proxy
	            .route("sina", r -> r.path("/sina")
	            .uri("http://www.sina.com.cn/")
	            ).build();

	}

}
