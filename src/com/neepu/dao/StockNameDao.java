package com.neepu.dao;

import static com.neepu.util.common.Constants.STOCKNAMETABLE;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.neepu.po.StockName;

public interface StockNameDao {
	
	@Select("select * from "+STOCKNAMETABLE+" ")
	List<StockName> get_List();
	
	
	@Select("select * from "+STOCKNAMETABLE+" where id = #{id}")
	StockName get_Info(Integer id);

}
