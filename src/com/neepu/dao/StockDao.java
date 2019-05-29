package com.neepu.dao;

import static com.neepu.util.common.Constants.STOCKTEMPORARYTABLE;
import static com.neepu.util.common.Constants.STOCKTABLE1;
import static com.neepu.util.common.Constants.STOCKTABLE10;
import static com.neepu.util.common.Constants.STOCKTABLE11;
import static com.neepu.util.common.Constants.STOCKTABLE12;
import static com.neepu.util.common.Constants.STOCKTABLE13;
import static com.neepu.util.common.Constants.STOCKTABLE14;
import static com.neepu.util.common.Constants.STOCKTABLE15;
import static com.neepu.util.common.Constants.STOCKTABLE16;
import static com.neepu.util.common.Constants.STOCKTABLE17;
import static com.neepu.util.common.Constants.STOCKTABLE18;
import static com.neepu.util.common.Constants.STOCKTABLE19;
import static com.neepu.util.common.Constants.STOCKTABLE2;
import static com.neepu.util.common.Constants.STOCKTABLE20;
import static com.neepu.util.common.Constants.STOCKTABLE21;
import static com.neepu.util.common.Constants.STOCKTABLE22;
import static com.neepu.util.common.Constants.STOCKTABLE23;
import static com.neepu.util.common.Constants.STOCKTABLE24;
import static com.neepu.util.common.Constants.STOCKTABLE25;
import static com.neepu.util.common.Constants.STOCKTABLE3;
import static com.neepu.util.common.Constants.STOCKTABLE4;
import static com.neepu.util.common.Constants.STOCKTABLE5;
import static com.neepu.util.common.Constants.STOCKTABLE6;
import static com.neepu.util.common.Constants.STOCKTABLE7;
import static com.neepu.util.common.Constants.STOCKTABLE8;
import static com.neepu.util.common.Constants.STOCKTABLE9;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.neepu.dao.provider.StockDynaSqlProvider;
import com.neepu.po.Stock;
import com.neepu.po.StockVo;

public interface StockDao {
	
	@Select("select * from "+STOCKTABLE1+" ")
	List<Stock> get_List1();
	
	@Select("select * from "+STOCKTABLE2+" ")
	List<Stock> get_List2();
	
	@Select("select * from "+STOCKTABLE3+" ")
	List<Stock> get_List3();
	
	@Select("select * from "+STOCKTABLE4+" ")
	List<Stock> get_List4();
	
	@Select("select * from "+STOCKTABLE5+" ")
	List<Stock> get_List5();
	
	@Select("select * from "+STOCKTABLE6+" ")
	List<Stock> get_List6();
	
	@Select("select * from "+STOCKTABLE7+" ")
	List<Stock> get_List7();
	
	
	@Select("select * from "+STOCKTABLE8+" ")
	List<Stock> get_List8();
	
	@Select("select * from "+STOCKTABLE9+" ")
	List<Stock> get_List9();
	
	@Select("select * from "+STOCKTABLE10+" ")
	List<Stock> get_List10();
	
	@Select("select * from "+STOCKTABLE11+" ")
	List<Stock> get_List11();
	
	@Select("select * from "+STOCKTABLE12+" ")
	List<Stock> get_List12();
	
	@Select("select * from "+STOCKTABLE13+" ")
	List<Stock> get_List13();
	
	@Select("select * from "+STOCKTABLE14+" ")
	List<Stock> get_List14();
	
	@Select("select * from "+STOCKTABLE15+" ")
	List<Stock> get_List15();
	
	@Select("select * from "+STOCKTABLE16+" ")
	List<Stock> get_List16();
	
	@Select("select * from "+STOCKTABLE17+" ")
	List<Stock> get_List17();
	
	@Select("select * from "+STOCKTABLE18+" ")
	List<Stock> get_List18();
	
	@Select("select * from "+STOCKTABLE19+" ")
	List<Stock> get_List19();
	
	@Select("select * from "+STOCKTABLE20+" ")
	List<Stock> get_List20();
	
	@Select("select * from "+STOCKTABLE21+" ")
	List<Stock> get_List21();
	
	@Select("select * from "+STOCKTABLE22+" ")
	List<Stock> get_List22();
	
	@Select("select * from "+STOCKTABLE23+" ")
	List<Stock> get_List23();
	
	@Select("select * from "+STOCKTABLE24+" ")
	List<Stock> get_List24();
	
	@Select("select * from "+STOCKTABLE25+" ")
	List<Stock> get_List25();
	
	@Select("select SUM(depershare)/2  AS depershare from "+STOCKTEMPORARYTABLE+" ")
	List<Stock> get_stock();
	
	//应该写一个方法，这个方法可以通过股票名称直接获取股票对象
	@Select("select name, nirate*equitymultiplier*tatrate  AS depershare from "+ STOCKTEMPORARYTABLE+" where id < 14;")
	List<Stock> get_stock01();
	//应该写一个方法，这个方法可以通过股票名称直接获取股票对象
	@Select("select name, nirate*equitymultiplier*tatrate  AS depershare from "+ STOCKTEMPORARYTABLE+" where id BETWEEN 14 and 26; ")
	List<Stock> get_stock02();
	//应该写一个方法，这个方法可以通过股票名称直接获取股票对象
	@Select("select name, nirate*equitymultiplier*tatrate  AS depershare from "+ STOCKTEMPORARYTABLE+" where id BETWEEN 27 and 39;")
	List<Stock> get_stock03();
	//应该写一个方法，这个方法可以通过股票名称直接获取股票对象
	@Select("select name, nirate*equitymultiplier*tatrate  AS depershare from "+ STOCKTEMPORARYTABLE+" where id BETWEEN 40 and 52;")
	List<Stock> get_stock04();
	//应该写一个方法，这个方法可以通过股票名称直接获取股票对象
	@Select("select name, nirate*equitymultiplier*tatrate  AS depershare from "+ STOCKTEMPORARYTABLE+" where id BETWEEN 53 and 65;")
	List<Stock> get_stock05();
	
	
	//临时表插入
	@SelectProvider(type=StockDynaSqlProvider.class,method="insert_Stock")
	void insert_Info(Stock stock);
	
	
	@Delete("truncate "+STOCKTEMPORARYTABLE+" ")
	void deleteAll();
	
	
	@Select("SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE1 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE2 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE3 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100*(-1) as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100*(-1)  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100*(-1)  as stockhigh from " + STOCKTABLE4 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE5 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE6 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE7 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100 as stockhigh from " + STOCKTABLE8 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE9 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE10 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE11 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE12 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE13 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE14 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE15 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE16 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE17 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE18 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE19 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE20 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE21 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE22 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE23 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100 as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100  as stockhigh from " + STOCKTABLE24 + " where id=2"
			+"	UNION SELECT stockcode,name,netassets*nirate*equitymultiplier*tatrate*10/100*(-1) as stockbas,netassets*nirate*equitymultiplier*tatrate*20/100*(-1)  as stocknormal,netassets*nirate*equitymultiplier*tatrate*30/100*(-1)  as stockhigh from " + STOCKTABLE25 + " where id=2")
			List<StockVo> getStockVo();
	
}
