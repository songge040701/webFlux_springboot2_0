package com.songge.springboot_reactive.config;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.songge.springboot_reactive.domain.User;
import com.songge.springboot_reactive.repository.UserRepository;

import reactor.core.publisher.Flux;

/**  
* @ClassName: RouterFunctionConfiguration  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author songge  
* @date 2018年2月19日  
*    
*/
@Configuration
public class RouterFunctionConfiguration {

	/**
	 * servletRequest->servletResponse
	 * serverRequest->serverResponse
	 */
	@Bean
	@Autowired
	public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository) {
		
		return RouterFunctions.route(RequestPredicates.GET("/findAll"), 
				request -> {
					Collection<User> users = userRepository.findAll();
					Flux<User> userFlux = Flux.fromIterable(users);
					return ServerResponse.ok().body(userFlux, User.class);
				});
	}
}
