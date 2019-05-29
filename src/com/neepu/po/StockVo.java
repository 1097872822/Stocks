package com.neepu.po;

public class StockVo {
	
	private String stockcode;
	
	private String name;
	
	private double stockbas;
	
	private double stocknormal;
	
	private double stockhigh;

	public String getStockcode() {
		return stockcode;
	}

	public void setStockcode(String stockcode) {
		this.stockcode = stockcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getStockbas() {
		return stockbas;
	}

	public void setStockbas(double stockbas) {
		this.stockbas = stockbas;
	}

	public double getStocknormal() {
		return stocknormal;
	}

	public void setStocknormal(double stocknormal) {
		this.stocknormal = stocknormal;
	}

	public double getStockhigh() {
		return stockhigh;
	}

	public void setStockhigh(double stockhigh) {
		this.stockhigh = stockhigh;
	}

	@Override
	public String toString() {
		return "StockVo [stockcode=" + stockcode + ", name=" + name + ", stockbas=" + stockbas + ", stocknormal="
				+ stocknormal + ", stockhigh=" + stockhigh + "]";
	}
	
	
	

}
