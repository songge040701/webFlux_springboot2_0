package com.songge.springboot_reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.songge.springboot_reactive.domain.User;
import com.songge.springboot_reactive.repository.UserRepository;

/**  
* @ClassName: UserController  
* @Description: usercontroller
* @author songge  
* @date 2018年2月19日  
*    
*/
@RestController
public class UserController {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@PostMapping("/saveUser")
	public User saveUser(User inputuser) {
		User user = new User();
		user.setUser_name(inputuser.getUser_name());
		
		if(userRepository.save(user)) {
			System.out.printf("用户对象：%s 保存成功\n",inputuser.getUser_name());
		}
		return user;
	}
}
