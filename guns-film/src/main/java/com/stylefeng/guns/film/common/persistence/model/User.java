<<<<<<< HEAD:guns-cinema/src/main/java/com/stylefeng/guns/cinema/common/persistence/model/User.java
package com.stylefeng.guns.cinema.common.persistence.model;
=======
package com.stylefeng.guns.film.common.persistence.model;
>>>>>>> 57fccb6f6b4082b624fd15ef1f3c66b881cc1e03:guns-film/src/main/java/com/stylefeng/guns/film/common/persistence/model/User.java

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author stylefeng
 * @since 2017-08-23
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

	private Long id;
	private String userName;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", userName=" + userName +
			"}";
	}
}
