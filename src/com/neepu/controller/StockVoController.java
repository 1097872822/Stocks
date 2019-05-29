package com.neepu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neepu.po.StockName;
import com.neepu.po.StockVo;
import com.neepu.po.User;
import com.neepu.service.RainService;

@Controller
public class StockVoController {

	
	@Autowired
	@Qualifier("RainService")
	private RainService rainservice;
	
	
	@RequestMapping(value="/user/stockvo",method=RequestMethod.GET)
	public String stockvo(Model model,Integer id) {
		//通过用户id查询出关注股票名
		//用一个List集合来存储5个股票的信息，并返回一个5个股票的实体对象
				//1.获取到当前访问的用户对象
		        System.out.println("-------"+id);
				 User user = rainservice.get_UserInfo(id);
				//2.通过用户信息获取到5个不同的股票信息的id，根据id查询五种股票信息
				 
				 int a = user.getFirst();
				 int b = user.getSecond();
				 int c = user.getThird();
				 int d = user.getFourth();
				 int e = user.getFifth();
				 StockName stockName1 = rainservice.get_StockNameInfo(a);
				 StockName stockName2 = rainservice.get_StockNameInfo(b);
				 StockName stockName3 = rainservice.get_StockNameInfo(c);
				 StockName stockName4 = rainservice.get_StockNameInfo(d);
				 StockName stockName5 = rainservice.get_StockNameInfo(e);
				 
				 
				 List<String> name_list = new ArrayList<>();
				 name_list.add(stockName1.getName());
				 name_list.add(stockName2.getName());
				 name_list.add(stockName3.getName());
				 name_list.add(stockName4.getName());
				 name_list.add(stockName5.getName());
				 
				 for (String string : name_list) {
					System.out.println(string.toString());
				}
				 
		List<StockVo> job_list = rainservice.get_StockVo();
		model.addAttribute("job_list", job_list);
		model.addAttribute("name_list", name_list);
		return "/user/stockvo";
	}
}
