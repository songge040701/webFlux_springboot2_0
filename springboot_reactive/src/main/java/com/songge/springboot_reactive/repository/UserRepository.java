package com.songge.springboot_reactive.repository;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.songge.springboot_reactive.domain.User;

/**  
* @ClassName: UserRepository  
* @Description: 用户仓储
* @author songge  
* @date 2018年2月19日 
* {@link User}{@link Repository} 
*    
*/
@Repository
public class UserRepository {
	/**
	 * 用户仓储
	 */
	private final ConcurrentHashMap<Integer, User> userMap = new ConcurrentHashMap<Integer, User>();
	
	private final static AtomicInteger idGenerator = new AtomicInteger();
	
	/**
	 * 
	* @Title: save  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param name
	* @param @return    参数  
	* @return boolean   成功是返回<code>true</code>失败时返回<code>false</code> 
	* @throws
	 */
	public boolean save(User user) {
		//从1开始累加
		Integer id = idGenerator.incrementAndGet();
		user.setId(id);
		return userMap.put(id, user) == null;
	}
	
	public Collection<User> findAll() {
		return userMap.values();
	}
}
