package com.neepu.service;

import java.util.List;
import java.util.Map;

import com.neepu.po.Stock;
import com.neepu.po.StockName;
import com.neepu.po.StockVo;
import com.neepu.po.User;

public interface RainService {
	
	User login(String loginname, String password);
	User findUserByLoginAndName(String loginname,String username);
	User findUserByLogin(String loginname);
	User findUserByName(String username);
	List<User> get_UserList();
	User get_UserInfo(Integer id);
	void update_UserInfo(User user);
	void insert_UserInfo(User user);
	void delete_UserInfo(Integer id);
	
	void update_UserStock(User user);
	StockName get_StockNameInfo(Integer id);
	List<StockName> get_StockNameList();
	
	
	
	List<Stock> get_StockList1();
	List<Stock> get_StockList2();
	List<Stock> get_StockList3();
	List<Stock> get_StockList4();
	List<Stock> get_StockList5();
	
	List<Stock> get_StockList6();
	List<Stock> get_StockList7();
	List<Stock> get_StockList8();
	List<Stock> get_StockList9();
	List<Stock> get_StockList10();
	
	
	List<Stock> get_StockList11();
	List<Stock> get_StockList12();
	List<Stock> get_StockList13();
	List<Stock> get_StockList14();
	List<Stock> get_StockList15();
	
	List<Stock> get_StockList16();
	List<Stock> get_StockList17();
	List<Stock> get_StockList18();
	List<Stock> get_StockList19();
	List<Stock> get_StockList20();
	List<Stock> get_StockList21();
	List<Stock> get_StockList22();
	List<Stock> get_StockList23();
	List<Stock> get_StockList24();
	List<Stock> get_StockList25();
	
	//今日推荐折线统计图数据获取方法
	List<Map<String, Object>> pieData(Integer id);
	
	
	List<StockVo> get_StockVo();
}
