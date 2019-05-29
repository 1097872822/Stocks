package com.neepu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neepu.po.StockName;
import com.neepu.po.User;
import com.neepu.service.RainService;

@Controller
public class RecommendController {
	
	@Autowired
	@Qualifier("RainService")
	private RainService rainservice;
	
	//今日推荐页面跳转
	@RequestMapping(value="/user/inroad",method=RequestMethod.GET)
	public String inroad(Model model,Integer id){
		    User user = rainservice.get_UserInfo(id);
		    if(user!=null) {
		    //提供今日推荐折现统计图里面用户关注的股票名称
		    StockName  stockName_first =  rainservice.get_StockNameInfo(user.getFirst());
			StockName  stockName_second =  rainservice.get_StockNameInfo(user.getSecond());
			StockName  stockName_third =  rainservice.get_StockNameInfo(user.getThird());
			StockName  stockName_fourth =  rainservice.get_StockNameInfo(user.getFourth());
			StockName  stockName_fifth =  rainservice.get_StockNameInfo(user.getFifth());
			model.addAttribute("stockName_first", stockName_first);
			model.addAttribute("stockName_second", stockName_second);
			model.addAttribute("stockName_third", stockName_third);
			model.addAttribute("stockName_fourth", stockName_fourth);
			model.addAttribute("stockName_fifth", stockName_fifth);
		    }
		
	
			return "/user/inroad";
    }
	
	/**
	 *  股票折线图 
	 */
	@RequestMapping(value="/echartsData")
	@ResponseBody
	public List<Map<String, Object>> initChart(Integer id){
		  //股票信息获取接口   不管是哪个用户，都调用此方法   具体算法实现pieData()方法
	     return rainservice.pieData(id);
	 }
}















