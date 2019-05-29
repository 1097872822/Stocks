package com.neepu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neepu.dao.StockDao;
import com.neepu.dao.StockNameDao;
import com.neepu.dao.UserDao;
import com.neepu.po.Stock;
import com.neepu.po.StockName;
import com.neepu.po.StockVo;
import com.neepu.po.User;
import com.neepu.service.RainService;


@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("RainService")
public class RainServiceImpl implements RainService{

	@Autowired
	private UserDao userdao;
	
	
	@Autowired
	private StockDao stockDao;
	
	@Autowired
	private StockNameDao stockNameDao;
	

	/**
	 * 部门信息的管理
	 */
	
	@Override
	public User login(String loginname, String password) {
		User user = userdao.get_login(loginname,password);
		return user;
	}
	@Override
	public List<User> get_UserList() {
		return userdao.get_List();
	}
	@Override
	public User get_UserInfo(Integer id) {
		return userdao.get_Info(id);
	}
	@Override
	public void update_UserInfo(User user) {
		userdao.update_Info(user);
	}
	@Override
	public void insert_UserInfo(User user) {
		userdao.insert_Info(user);
	}
	@Override
	public void delete_UserInfo(Integer id) {
		userdao.delete_Info(id);
	}
	
	@Override
	public List<Stock> get_StockList1() {
		
		return stockDao.get_List1();
	}
	@Override
	public List<Stock> get_StockList2() {
		
		return stockDao.get_List2();
	}
	@Override
	public List<Stock> get_StockList3() {
		
		return stockDao.get_List3();
	}
	@Override
	public List<Stock> get_StockList4() {
		
		return stockDao.get_List4();
	}
	@Override
	public List<Stock> get_StockList5() {
		
		return stockDao.get_List5();
	}
	@Override
	public List<Stock> get_StockList6() {
		
		return stockDao.get_List6();
	}
	@Override
	public List<Stock> get_StockList7() {
		
		return stockDao.get_List7();
	}
	@Override
	public List<Stock> get_StockList8() {
		
		return stockDao.get_List8();
	}
	@Override
	public List<Stock> get_StockList9() {
		
		return stockDao.get_List9();
	}
	@Override
	public List<Stock> get_StockList10() {
		
		return stockDao.get_List10();
	}
	@Override
	public List<Stock> get_StockList11() {
		
		return stockDao.get_List11();
	}
	@Override
	public List<Stock> get_StockList12() {
		
		return stockDao.get_List12();
	}
	@Override
	public List<Stock> get_StockList13() {
		
		return stockDao.get_List13();
	}
	@Override
	public List<Stock> get_StockList14() {
		
		return stockDao.get_List14();
	}
	@Override
	public List<Stock> get_StockList15() {
		
		return stockDao.get_List15();
	}
	@Override
	public List<Stock> get_StockList16() {
		
		return stockDao.get_List16();
	}
	@Override
	public List<Stock> get_StockList17() {
		
		return stockDao.get_List17();
	}
	@Override
	public List<Stock> get_StockList18() {
		
		return stockDao.get_List18();
	}
	@Override
	public List<Stock> get_StockList19() {
		
		return stockDao.get_List19();
	}
	@Override
	public List<Stock> get_StockList20() {
		
		return stockDao.get_List20();
	}
	@Override
	public List<Stock> get_StockList21() {
		
		return stockDao.get_List21();
	}
	@Override
	public List<Stock> get_StockList22() {
		
		return stockDao.get_List22();
	}
	@Override
	public List<Stock> get_StockList23() {
		
		return stockDao.get_List23();
	}
	@Override
	public List<Stock> get_StockList24() {
		
		return stockDao.get_List24();
	}
	@Override
	public List<Stock> get_StockList25() {
		
		return stockDao.get_List25();
	}
	
	
	
	@Override
	public List<StockName> get_StockNameList() {
		
		return stockNameDao.get_List();
	}
	@Override
	public StockName get_StockNameInfo(Integer id) {
		return  stockNameDao.get_Info(id);
				 
	}
	@Override
	public void update_UserStock(User user) {
		userdao.update_Stock(user);
	}
	@Override
	public User findUserByLoginAndName(String loginname, String username) {
		
		return userdao.selectByLoginAndName(loginname, username);
	}
	@Override
	public User findUserByLogin(String loginname) {
		
		return userdao.selectByLogin(loginname);
	}
	@Override
	public User findUserByName(String username) {
		
		return userdao.selectByName(username);
	}
	
	
	
	
	
	
	//股票统计核心算法
	/**
	 * 首先明白自己需要什么数据 ，每个用户有5个关注，首先，需要将这五种股票信息查询出来
	 * 需要传入用户参数
	 */
	@SuppressWarnings({ "unchecked", "null" })
	@Override
	public List<Map<String, Object>> pieData(Integer id) {
		//用一个List集合来存储5个股票的信息，并返回一个5个股票的实体对象
		//1.获取到当前访问的用户对象
		 User user = userdao.get_Info(id);
		 
		//2.通过用户信息获取到5个不同的股票信息的id，根据id查询五种股票信息
		 int a = user.getFirst();
		 int b = user.getSecond();
		 int c = user.getThird();
		 int d = user.getFourth();
		 int e = user.getFifth();
		 
		 List<Stock> businesslist1  = null;
		 List<Stock> businesslist2  = null;
		 List<Stock> businesslist3  = null;
		 List<Stock> businesslist4  = null;
		 List<Stock> businesslist5  = null;
		 List<Stock> businesslist6  = null;
		 List<Stock> businesslist7  = null;
		 List<Stock> businesslist8  = null;
		 List<Stock> businesslist9  = null;
		 List<Stock> businesslist10  = null;
		 List<Stock> businesslist11  = null;
		 List<Stock> businesslist12  = null;
		 List<Stock> businesslist13  = null;
		 List<Stock> businesslist14  = null;
		 List<Stock> businesslist15  = null;
		 List<Stock> businesslist16  = null;
		 List<Stock> businesslist17  = null;
		 List<Stock> businesslist18  = null;
		 List<Stock> businesslist19  = null;
		 List<Stock> businesslist20 = null;
		 List<Stock> businesslist21 = null;
		 List<Stock> businesslist22 = null;
		 List<Stock> businesslist23 = null;
		 List<Stock> businesslist24 = null;
		 List<Stock> businesslist25 = null;
		 
		 
		 if(a==1||b==1||c==1||d==1||e==1) {
			 businesslist1 = stockDao.get_List1();
			 
		 }
		if(a==2||b==2||c==2||d==2||e==2) {
			  businesslist2 = stockDao.get_List2();
		 }
		if(a==3||b==3||c==3||d==3||e==3) {
			  businesslist3 = stockDao.get_List3();
		 }
		  if(a==4||b==4||c==4||d==4||e==4) {
			 businesslist4 = stockDao.get_List4();
		 }
		  if(a==5||b==5||c==5||d==5||e==5) {
			 businesslist5 = stockDao.get_List5();
		 }
		  if(a==6||b==6||c==6||d==6||e==6) {
			 businesslist6 = stockDao.get_List6();
		 }
		  if(a==7||b==7||c==7||d==7||e==7) {
			 businesslist7 = stockDao.get_List7();
		 }
		  if(a==8||b==8||c==8||d==8||e==8) {
			  businesslist8 = stockDao.get_List8();
		 }
		  if(a==9||b==9||c==9||d==9||e==9) {
			  businesslist9 = stockDao.get_List9();
		 }
		  if(a==10||b==10||c==10||d==10||e==10) {
			  businesslist10 = stockDao.get_List10();
		 }
		  if(a==11||b==11||c==11||d==11||e==11) {
			businesslist11 = stockDao.get_List11();
		 }
		  if(a==12||b==12||c==12||d==12||e==12) {
			  businesslist12 = stockDao.get_List12();
		 }
		  if(a==13||b==13||c==13||d==13||e==13) {
			  businesslist13 = stockDao.get_List13();
		 }
		  if(a==14||b==14||c==14||d==14||e==14) {
			 businesslist14 = stockDao.get_List14();
		 }
		  if(a==15||b==15||c==15||d==15||e==15) {
			  businesslist15 = stockDao.get_List15();
		 }
		  if(a==16||b==16||c==16||d==16||e==16) {
			  businesslist16 = stockDao.get_List16();
		 }
		  if(a==17||b==17||c==17||d==17||e==17) {
			 businesslist17 = stockDao.get_List17();
		 }
		  if(a==18||b==18||c==18||d==18||e==18) {
			 businesslist18 = stockDao.get_List18();
		 }
		  if(a==19||b==19||c==19||d==19||e==19) {
			 businesslist19 = stockDao.get_List19();
		 }
		  if(a==20||b==20||c==20||d==20||e==20) {
			 businesslist20 = stockDao.get_List20();
		 }
		  if(a==21||b==21||c==21||d==21||e==21) {
			 businesslist21 = stockDao.get_List21();
		 }
		  if(a==22||b==22||c==22||d==22||e==22) {
				 businesslist22 = stockDao.get_List22();
			 }
		  if(a==23||b==23||c==23||d==23||e==23) {
				 businesslist23 = stockDao.get_List23();
			 }
		  if(a==24||b==24||c==24||d==24||e==24) {
				 businesslist24 = stockDao.get_List24();
			 }
		  if(a==25||b==25||c==25||d==25||e==25) {
				 businesslist25 = stockDao.get_List25();
			 }
		 
		 
		 
		 Map<String, Object> fivemap = new HashMap<>();
		 //查完表之后，这里面肯定只有5个List不为空，找出来，存入map
		 if(businesslist1!=null) {
			fivemap.put("businesslist1", businesslist1);
		 }
		 if(businesslist2!=null) {
			 fivemap.put("businesslist2",businesslist2);
		 }
		  if(businesslist3!=null) {
			 fivemap.put("businesslist3",businesslist3);
		 }
		  if(businesslist4!=null) {
			 fivemap.put("businesslist4",businesslist4);
		 }
		  if(businesslist5!=null) {
			 fivemap.put("businesslist5",businesslist5);
		 }
		   if(businesslist6!=null) {
			 fivemap.put("businesslist6",businesslist6);
		 }
		  if(businesslist7!=null) {
			 fivemap.put("businesslist7",businesslist7);
		 }
		  if(businesslist8!=null) {
			 fivemap.put("businesslist8",businesslist8);
		 }
		  if(businesslist9!=null) {
			 fivemap.put("businesslist9",businesslist9);
		 }
		  if(businesslist10!=null) {
			 fivemap.put("businesslist10",businesslist10);
		 }
		  if(businesslist11!=null) {
			 fivemap.put("businesslist11",businesslist11);
		 }
		  if(businesslist12!=null) {
			 fivemap.put("businesslist12",businesslist12);
		 }
		  if(businesslist13!=null) {
			 fivemap.put("businesslist13",businesslist13);
		 }
		  if(businesslist14!=null) {
			 fivemap.put("businesslist14",businesslist14);
		 }
		  if(businesslist15!=null) {
			 fivemap.put("businesslist15",businesslist15);
		 }
		   if(businesslist16!=null) {
			 fivemap.put("businesslist16",businesslist16);
		 }
		   if(businesslist17!=null) {
			 fivemap.put("businesslist17",businesslist17);
		 }
		   if(businesslist18!=null) {
			 fivemap.put("businesslist18",businesslist18);
		 }
		   if(businesslist19!=null) {
			 fivemap.put("businesslist19",businesslist19);
		 }
		  if(businesslist20!=null) {
			 fivemap.put("businesslist20",businesslist20);
		 }
		  if(businesslist21!=null) {
			 fivemap.put("businesslist21",businesslist21);
		 }
		  if(businesslist22!=null) {
				 fivemap.put("businesslist22",businesslist22);
			 }
		  if(businesslist23!=null) {
				 fivemap.put("businesslist23",businesslist23);
			 }
		  if(businesslist24!=null) {
				 fivemap.put("businesslist24",businesslist24);
			 }
		  if(businesslist25!=null) {
				 fivemap.put("businesslist25",businesslist25);
			 }
			
			
			//将这5个表的信息存入一张临时表中
			//首先清空这张表,再插入
			stockDao.deleteAll();
			for (Map.Entry<String, Object> entry : fivemap.entrySet()) {  
				//拿到5个map后，也就是对应着5个List集合，现在开始获取这5个list集合，获取需要的值，进行运算，存入一个List中
			    //接着进行取list值
				//接着进行取list值
			   List<Stock> lisMap = new ArrayList<Stock>();
			   lisMap = (List<Stock>) fivemap.get(entry.getKey());
			   for (int i = 0 ; i< lisMap.size() ; i++){
                      //System.out.println("map中取出List中的value:["+entry.getKey()+ "]的第" + "[" +(i+1)+"]个值："+ lisMap.get(i).toString());
				      //System.out.println("插入的对象  "+lisMap.get(i));
	            	   stockDao.insert_Info(lisMap.get(i)); 
				 }
			}
			     
			
			 
	    		List<Map<String,Object>> data1 =new ArrayList<>();
	    		
	                for(int i=1;i<6;i++){
	                    Map<String,Object> map=new HashMap<>();
	                    map.put("product1", stockDao.get_stock01());
	                    map.put("product2", stockDao.get_stock02());
	                    map.put("product3", stockDao.get_stock03());
	                    map.put("product4", stockDao.get_stock04());
	                    map.put("product5", stockDao.get_stock05());
	                    data1.add(map);
	                }
	            
	            return data1;	
	}
	@Override
	public List<StockVo> get_StockVo() {
		
		return stockDao.getStockVo();
	}
	
	
}
