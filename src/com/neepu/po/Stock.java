package com.neepu.po;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
    private Date date;
    
    private String creatTimeStr;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private String stockcode;

    private String name;

    private double income;

    private float dnepershare;

    private float depershare;

    private float netassets;

    private float providentfund;

    private float undistributedprofit;

    private float operatingcashflow;

    private float toperatingincome;

    private float grossprofit;

    private float aaprofit;

    private float nonnetprofit;

    private float toiincreasedyoy;
    
    private float npatyoygrowth;
    
    private float nonnetprofitrrgrowth;
    
    private float toiincreasedyoyrrgrowth;
    
    private float npatyoygrowthrrgrowth;
    
    private float npgrowth;
    
    private float dronassets;
    
    private float gpmargin;
    
    private float nirate;
    
    private float equitymultiplier;
    
    private float tatrate;
    
    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
    	 this.date = date;
         String time = sdf.format(date);
         setCreatTimeStr(time);
    }

    

	public String getCreatTimeStr() {
		return creatTimeStr;
	}

	public void setCreatTimeStr(String creatTimeStr) {
		this.creatTimeStr = creatTimeStr;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public float getDnepershare() {
		return dnepershare;
	}

	public void setDnepershare(float dnepershare) {
		this.dnepershare = dnepershare;
	}

	public float getDepershare() {
		return depershare;
	}

	public void setDepershare(float depershare) {
		this.depershare = depershare;
	}

	public float getNetassets() {
		return netassets;
	}

	public void setNetassets(float netassets) {
		this.netassets = netassets;
	}

	public float getProvidentfund() {
		return providentfund;
	}

	public void setProvidentfund(float providentfund) {
		this.providentfund = providentfund;
	}

	public float getUndistributedprofit() {
		return undistributedprofit;
	}

	public void setUndistributedprofit(float undistributedprofit) {
		this.undistributedprofit = undistributedprofit;
	}

	public float getOperatingcashflow() {
		return operatingcashflow;
	}

	public void setOperatingcashflow(float operatingcashflow) {
		this.operatingcashflow = operatingcashflow;
	}

	public float getToperatingincome() {
		return toperatingincome;
	}

	public void setToperatingincome(float toperatingincome) {
		this.toperatingincome = toperatingincome;
	}

	public float getGrossprofit() {
		return grossprofit;
	}

	public void setGrossprofit(float grossprofit) {
		this.grossprofit = grossprofit;
	}

	public float getAaprofit() {
		return aaprofit;
	}

	public void setAaprofit(float aaprofit) {
		this.aaprofit = aaprofit;
	}

	public float getNonnetprofit() {
		return nonnetprofit;
	}

	public void setNonnetprofit(float nonnetprofit) {
		this.nonnetprofit = nonnetprofit;
	}

	public float getToiincreasedyoy() {
		return toiincreasedyoy;
	}

	public void setToiincreasedyoy(float toiincreasedyoy) {
		this.toiincreasedyoy = toiincreasedyoy;
	}

	public float getNpatyoygrowth() {
		return npatyoygrowth;
	}

	public void setNpatyoygrowth(float npatyoygrowth) {
		this.npatyoygrowth = npatyoygrowth;
	}

	public float getNonnetprofitrrgrowth() {
		return nonnetprofitrrgrowth;
	}

	public void setNonnetprofitrrgrowth(float nonnetprofitrrgrowth) {
		this.nonnetprofitrrgrowth = nonnetprofitrrgrowth;
	}

	public float getToiincreasedyoyrrgrowth() {
		return toiincreasedyoyrrgrowth;
	}

	public void setToiincreasedyoyrrgrowth(float toiincreasedyoyrrgrowth) {
		this.toiincreasedyoyrrgrowth = toiincreasedyoyrrgrowth;
	}

	public float getNpatyoygrowthrrgrowth() {
		return npatyoygrowthrrgrowth;
	}

	public void setNpatyoygrowthrrgrowth(float npatyoygrowthrrgrowth) {
		this.npatyoygrowthrrgrowth = npatyoygrowthrrgrowth;
	}

	public float getNpgrowth() {
		return npgrowth;
	}

	public void setNpgrowth(float npgrowth) {
		this.npgrowth = npgrowth;
	}

	public float getDronassets() {
		return dronassets;
	}

	public void setDronassets(float dronassets) {
		this.dronassets = dronassets;
	}

	public float getGpmargin() {
		return gpmargin;
	}

	public void setGpmargin(float gpmargin) {
		this.gpmargin = gpmargin;
	}

	public float getNirate() {
		return nirate;
	}

	public void setNirate(float nirate) {
		this.nirate = nirate;
	}

	public float getEquitymultiplier() {
		return equitymultiplier;
	}

	public void setEquitymultiplier(float equitymultiplier) {
		this.equitymultiplier = equitymultiplier;
	}

	public float getTatrate() {
		return tatrate;
	}

	public void setTatrate(float tatrate) {
		this.tatrate = tatrate;
	}

	


}