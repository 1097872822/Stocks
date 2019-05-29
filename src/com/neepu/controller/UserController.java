package com.neepu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neepu.po.Stock;
import com.neepu.po.StockName;
import com.neepu.po.User;
import com.neepu.service.RainService;
import com.neepu.util.common.Constants;

@Controller
public class UserController {
	@Autowired
	@Qualifier("RainService")
	private RainService rainservice;
	private User user1;
		@RequestMapping(value="/user/")
		 public ModelAndView index2(ModelAndView mv){
			mv.setViewName("/user/list");
			return mv;
		}
		@RequestMapping(value="/login")
		 public ModelAndView login(@RequestParam("loginname") String loginname,
				 @RequestParam("password") String password,Model model,
				 HttpSession session,
				 ModelAndView mv){
			user1 = rainservice.login(loginname, password);
			if(user1 != null){
				session.setAttribute(Constants.USER_SESSION, user1);
				//这里应该通过传入的id去查询
				StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
				
				StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
				StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
				StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
				StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
				
				model.addAttribute("stockName_first", stockName_first);
				model.addAttribute("stockName_second", stockName_second);
				model.addAttribute("stockName_third", stockName_third);
				model.addAttribute("stockName_fourth", stockName_fourth);
				model.addAttribute("stockName_fifth", stockName_fifth);
				
				
				mv.setViewName("redirect:/index");
			}else{
				mv.addObject("message", "登录名或密码错误!请重新输入");
				// 服务器内部跳转到登录页面
				mv.setViewName("forward:/loginForm");
			}
			return mv;
		}
		// 如果在目录下输入任何不存在的参数，则跳转到list
		@RequestMapping(value="/user/{formName}")
		 public String index2(@PathVariable String formName){
			String blank = "/user/list";
			return blank;
		}
		@RequestMapping(value="/user/list",method=RequestMethod.GET)
		 public String list(Model model){
			List<User> job_list = rainservice.get_UserList();
			model.addAttribute("list",job_list);
			return "user/list";
		}
		
		
		@RequestMapping(value="/user/add",method=RequestMethod.GET)
		 public String add(Model model,Integer id){
			if(id!=null){
				User job = rainservice.get_UserInfo(id);
				model.addAttribute("job",job);
			}
			return "/user/add";
		}
		
		@RequestMapping(value="/user/add",method=RequestMethod.POST)
		 public ModelAndView add(ModelAndView mv,@ModelAttribute User notice ,Integer id,Integer userid){
			
			if(id!=null){
				
				rainservice.update_UserInfo(notice);
				if(userid==1) {
					mv.setViewName("redirect:/user/list");
				}else {
					mv.setViewName("redirect:/index");
				}
				
			}else{
				
				//1.需要判断，如果此用户已经存在，将不能继续添加注册
				User user = rainservice.findUserByLoginAndName(notice.getLoginname(), notice.getUsername());
				User user1 = rainservice.findUserByLogin(notice.getLoginname());
				User user2 = rainservice.findUserByName(notice.getUsername());
				if(user==null&&user1==null&&user2==null) {
					rainservice.insert_UserInfo(notice);
					mv.setViewName("redirect:/loginForm");
				}else {
					mv.addObject("message1", "此登录名或者用户名已经被注册，请更换！！！");
					mv.setViewName("redirect:/toRegister");
				}
			}
			return mv;
		}
		
		
		@RequestMapping(value="/user/delete",method=RequestMethod.GET)
		 public ModelAndView delete(ModelAndView mv,Integer id){
			if(id!=null){
				rainservice.delete_UserInfo(id);
			}
			mv.setViewName("redirect:/user/list");
			return mv;
		}
		
		
		@RequestMapping(value="/toRegister",method=RequestMethod.GET)
		 public String toregister(Model model){
			return "/register";
		}
		
		
		@RequestMapping(value="/visit",method=RequestMethod.GET)
		public String tovisit(Model model,ModelAndView mv){
			    List<Stock> job_list = rainservice.get_StockList1();
			    mv.addObject("job_list", job_list);
				return "/index";
		}
		
	
		
				
		
				@RequestMapping(value="/user/admin_add",method=RequestMethod.GET)
				public String admintoadd(Model model){
						return "/user/admin_add";
		}
				
				//20个可供选择的股票
				//当点击系统首页的时候传入用户的id.应为这里可能就进行修改股票信息
				@RequestMapping(value="/index",method=RequestMethod.GET)
				 public String index(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList1();
					model.addAttribute("job_list", job_list);
				    
					
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
					
				}
				
				@RequestMapping(value="/index0",method=RequestMethod.GET)
				 public String index0(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList1();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index1",method=RequestMethod.GET)
				 public String index1(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList1();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index2",method=RequestMethod.GET)
				 public String index2(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList2();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index3",method=RequestMethod.GET)
				 public String index3(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList3();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index4",method=RequestMethod.GET)
				 public String index4(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList4();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index5",method=RequestMethod.GET)
				 public String index5(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList5();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index6",method=RequestMethod.GET)
				 public String index6(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList6();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index7",method=RequestMethod.GET)
				 public String index7(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList7();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index8",method=RequestMethod.GET)
				 public String index8(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList8();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index9",method=RequestMethod.GET)
				 public String index9(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList9();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index10",method=RequestMethod.GET)
				 public String index10(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList10();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index11",method=RequestMethod.GET)
				 public String index11(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList11();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index12",method=RequestMethod.GET)
				 public String index12(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList12();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index13",method=RequestMethod.GET)
				 public String index13(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList13();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index14",method=RequestMethod.GET)
				 public String index14(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList14();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index15",method=RequestMethod.GET)
				 public String index15(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList15();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index16",method=RequestMethod.GET)
				 public String index16(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList16();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				
				@RequestMapping(value="/index17",method=RequestMethod.GET)
				 public String index17(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList17();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index18",method=RequestMethod.GET)
				 public String index18(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList18();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index19",method=RequestMethod.GET)
				 public String index19(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList19();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index20",method=RequestMethod.GET)
				 public String index20(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList20();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				
				@RequestMapping(value="/index21",method=RequestMethod.GET)
				 public String index21(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList21();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index22",method=RequestMethod.GET)
				 public String index22(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList22();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index23",method=RequestMethod.GET)
				 public String index23(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList23();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index24",method=RequestMethod.GET)
				 public String index24(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList24();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
				
				@RequestMapping(value="/index25",method=RequestMethod.GET)
				 public String index25(Model model,Integer id){
					List<Stock> job_list = rainservice.get_StockList25();
					model.addAttribute("job_list", job_list);
					//这里应该通过传入的id去查询
					if(id!=null) {
						User user = rainservice.get_UserInfo(id);
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
						return "/index";
					}else {
						StockName  stockName_first =  rainservice.get_StockNameInfo(user1.getFirst());
						
						StockName  stockName_second =  rainservice.get_StockNameInfo(user1.getSecond());
						StockName  stockName_third =  rainservice.get_StockNameInfo(user1.getThird());
						StockName  stockName_fourth =  rainservice.get_StockNameInfo(user1.getFourth());
						StockName  stockName_fifth =  rainservice.get_StockNameInfo(user1.getFifth());
						
						model.addAttribute("stockName_first", stockName_first);
						model.addAttribute("stockName_second", stockName_second);
						model.addAttribute("stockName_third", stockName_third);
						model.addAttribute("stockName_fourth", stockName_fourth);
						model.addAttribute("stockName_fifth", stockName_fifth);
						return "/index";
					}
				}
		
		//用户更新页面跳转
				@RequestMapping(value="/user/edit",method=RequestMethod.GET)
				 public String edit(Model model,Integer id){
					if(id!=null){
						User user = rainservice.get_UserInfo(id);
						model.addAttribute("user",user);
					}
					
					return "/user/edit";
				}
				
				
				
				//管理员添加
				@RequestMapping(value="/admin/add",method=RequestMethod.POST)
				 public ModelAndView add(ModelAndView mv,@ModelAttribute User notice){
					//1.需要判断，如果此用户已经存在，将不能继续添加注册
					User user = rainservice.findUserByLoginAndName(notice.getLoginname(), notice.getUsername());
					User user1 = rainservice.findUserByLogin(notice.getLoginname());
					User user2 = rainservice.findUserByName(notice.getUsername());
					if(user==null&&user1==null&&user2==null) {
						rainservice.insert_UserInfo(notice);
						mv.setViewName("redirect:/user/list");
						return mv;
					}else {
						mv.addObject("message1", "此登录名或者用户名已经被注册，请更换！！！");
						mv.setViewName("redirect:/user/admin_add");
						return mv;
					}
				}
				
				
	            //我的关注页面跳转
				//注册页面跳转
				@RequestMapping(value="/user/attention",method=RequestMethod.GET)
				 public String attention(Model model,Integer id){
					//这里需要查询出所有的股票信息
					List<StockName> job_list = rainservice.get_StockNameList();
					User user = rainservice.get_UserInfo(id);
					model.addAttribute("user",user);
					model.addAttribute("job_list", job_list);
					return "/user/attention";
				}
				
				//提交关注结果
				@RequestMapping(value="/attention",method=RequestMethod.POST)
				 public String addattention(Model model,
						 Integer first, Integer second
						 , Integer third
						 , Integer fourth
						 , Integer fifth,Integer id){
				  
					//这里应该通过传入的id去查询
					StockName  stockName_first =  rainservice.get_StockNameInfo(first);
					StockName  stockName_second =  rainservice.get_StockNameInfo(second);
					StockName  stockName_third =  rainservice.get_StockNameInfo(third);
					StockName  stockName_fourth =  rainservice.get_StockNameInfo(fourth);
					StockName  stockName_fifth =  rainservice.get_StockNameInfo(fifth);
					
					model.addAttribute("stockName_first", stockName_first);
					model.addAttribute("stockName_second", stockName_second);
					model.addAttribute("stockName_third", stockName_third);
					model.addAttribute("stockName_fourth", stockName_fourth);
					model.addAttribute("stockName_fifth", stockName_fifth);
					
					//当用户提交完id之后，这里应该是在相对应的用户里面去做更新操作
					
					User user = new User();
					user.setId(id);
					user.setFirst(first);
					user.setSecond(second);
					user.setThird(third);
					user.setFourth(fourth);
					user.setFifth(fifth);
				    rainservice.update_UserStock(user);
					return "/index";
				}
				
				//这里是添加关注的跳转页面
}
