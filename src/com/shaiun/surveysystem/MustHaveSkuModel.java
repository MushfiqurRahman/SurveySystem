package com.shaiun.surveysystem;

public class MustHaveSkuModel {
	public String skuTitle;
	public String skuCode;
	public int skuCount;
	
	MustHaveSkuModel(String title, String code, int count){
		this.skuTitle = title;
		this.skuCode = code;
		this.skuCount = count;
	}
}
