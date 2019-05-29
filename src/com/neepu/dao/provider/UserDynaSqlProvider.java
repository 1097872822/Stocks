package com.neepu.dao.provider;

import static com.neepu.util.common.Constants.USERTABLE;

import org.apache.ibatis.jdbc.SQL;

import com.neepu.po.User;

public class UserDynaSqlProvider {
			// 动态插入
			public String insert_Notice(User job){
				
				return new SQL(){
					{
						INSERT_INTO(USERTABLE);
						if(job.getLoginname() != null ){
							VALUES("loginname", "#{loginname}");
						}
						if(job.getPassword()!=null){
							VALUES("password","#{password}");
						}
						if(job.getUsername()!=null){
							VALUES("username","#{username}");
						}
						
					
						
					}
				}.toString();
			}	
			// 动态更新
			public String update_Notice(User job){
				
				return new SQL(){
					{
						UPDATE(USERTABLE);
						if(job.getLoginname() != null ){
							SET("loginname = #{loginname}");
						}
						if(job.getPassword()!=null){
							SET("password = #{password}");
						}
						if(job.getUsername()!=null){
							SET("username = #{username}");
						}
						
						WHERE(" id = #{id} ");
					}
				}.toString();
			}
			
			
			// 动态更新
						public String update_User_Stock(User job){
							
							return new SQL(){
								{
									UPDATE(USERTABLE);
									if(job.getFirst()!= null ){
										SET("first = #{first}");
									}
									if(job.getSecond()!=null){
										SET("second = #{second}");
									}
									if(job.getThird()!=null){
										SET("third = #{third}");
									}
									if(job.getFourth()!=null){
										SET("fourth = #{fourth}");
									}
									if(job.getFifth()!=null){
										SET("fifth = #{fifth}");
									}
									WHERE(" id = #{id} ");
								}
							}.toString();
						}
}
