package com.shaiun.surveysystem;

public class NewProductModel {
	public String skuTitle;
	public String skuCode;
	public int skuCount;
	
	NewProductModel(String title, String code, int count){
		this.skuTitle = title;
		this.skuCode = code;
		this.skuCount = count;
	}
}
