package com.gui.builder.main;

import java.math.BigDecimal;

public class Helper {
	public static BigDecimal ZERO = new BigDecimal("0.00");
	public static BigDecimal HUNDRED = new BigDecimal("100.00");
	
    public static boolean between(BigDecimal min, BigDecimal max, BigDecimal value){
    	return value.compareTo(min) >= 0 && value.compareTo(max) <=0;
    }
    
    public static boolean greater(BigDecimal min, BigDecimal value){
    	return value.compareTo(min) > 0;
    }
    
    public static boolean greaterOrEqual(BigDecimal min, BigDecimal value){
    	return value.compareTo(min) >= 0;
    }
    
    public static boolean less(BigDecimal min, BigDecimal value){
    	return value.compareTo(min) < 0;
    }
    
    public static boolean lessOrEqual(BigDecimal min, BigDecimal value){
    	return value.compareTo(min) <= 0;
    }
}
