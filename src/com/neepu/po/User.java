package com.neepu.po;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer first;
	private Integer second;
	private Integer third;
	private Integer fourth;
	private Integer fifth;
	private String username;
	private String loginname;
	private String password;
	//关于时间的格式转换
	private Date createdate;
    private String creatTimeStr;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public User(){
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
        this.createdate = createdate;
        String time = sdf.format(createdate);
        setCreatTimeStr(time);
	}
	
	public String getCreatTimeStr() {
		return creatTimeStr;
	}
 
	public void setCreatTimeStr(String creatTimeStr) {
		this.creatTimeStr = creatTimeStr;
	}

	public Integer getFirst() {
		return first;
	}

	public void setFirst(Integer first) {
		this.first = first;
	}

	public Integer getSecond() {
		return second;
	}

	public void setSecond(Integer second) {
		this.second = second;
	}

	public Integer getThird() {
		return third;
	}

	public void setThird(Integer third) {
		this.third = third;
	}

	public Integer getFourth() {
		return fourth;
	}

	public void setFourth(Integer fourth) {
		this.fourth = fourth;
	}

	public Integer getFifth() {
		return fifth;
	}

	public void setFifth(Integer fifth) {
		this.fifth = fifth;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}
}
