package com.neepu.dao.provider;

import static com.neepu.util.common.Constants.STOCKTEMPORARYTABLE;

import org.apache.ibatis.jdbc.SQL;

import com.neepu.po.Stock;

public class StockDynaSqlProvider {
	
	
	// 动态插入
				public String insert_Stock(Stock job){
					
					return new SQL(){
						{
							INSERT_INTO(STOCKTEMPORARYTABLE);
						
							        VALUES("stockcode", "#{stockcode}"); 
							        VALUES("name", "#{name}"); 
							    	VALUES("depershare", "#{depershare}");
									VALUES("netassets", "#{netassets}");
									VALUES("nirate", "#{nirate}");
									VALUES("equitymultiplier", "#{equitymultiplier}");
									VALUES("tatrate", "#{tatrate}");
							
						}
					}.toString();
				}	
}
