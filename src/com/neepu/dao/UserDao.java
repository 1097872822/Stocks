package com.neepu.dao;

import static com.neepu.util.common.Constants.USERTABLE;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.neepu.dao.provider.UserDynaSqlProvider;
import com.neepu.po.User;

public interface UserDao {

	@Select("select * from "+USERTABLE+" ")
	List<User> get_List();
	
	@Select("select * from "+USERTABLE+"  where loginname = #{loginname} AND password = #{password}")
	User get_login(@Param("loginname") String loginname,
			@Param("password") String password);
	
	
	@Select("select * from "+USERTABLE+" where loginname = #{loginname} and username = #{username}")
	User selectByLoginAndName(
		@Param("loginname") String loginname,
		@Param("username") String username);
	
	
	@Select("select * from "+USERTABLE+" where loginname = #{loginname} ")
	User selectByLogin(
		@Param("loginname") String loginname);
	
	@Select("select * from "+USERTABLE+" where username = #{username}")
	User selectByName(
		@Param("username") String username);
	
	
	
	@SelectProvider(type=UserDynaSqlProvider.class,method="insert_Notice")
	void insert_Info(User employee);
	
	@Select("select * from "+USERTABLE+" where id = #{id}")
	User get_Info(Integer id);

	@SelectProvider(type=UserDynaSqlProvider.class,method="update_Notice")
	void update_Info(User employee);
	
	
	@SelectProvider(type=UserDynaSqlProvider.class,method="update_User_Stock")
	void update_Stock(User employee);
	
	@Delete(" delete from "+USERTABLE+" where id = #{id} ")
	void delete_Info(Integer id);

}
