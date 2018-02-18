package com.songge.springboot_reactive.domain;

/**  
* @ClassName: User  
* @Description: 用户
* @author songge  
* @date 2018年2月19日  
*    
*/
public class User {
	
	/**
	 * 用户id
	 */
	private int id;
	
	/**
	 * 用户名
	 */
	private String user_name;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name + "]";
	}

}
