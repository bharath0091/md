package com.time.util;


import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.time.beans.TimeBean;

/**
 * This utility class provide supporting function for calculating 2 digit time combinations 
 * @author 510963
 *
 */
public class TimeUtil {
	
	private TimeUtil() {}
	
	/**
	 * Check whether user provided date is valid or not
	 * @param strDate user input
	 * @return true or false
	 */
	public static boolean isDateValid(String strDate) {
		boolean isValid = false;
		if(strDate!=null && !strDate.isEmpty()) {
			String expression ="(([0-1]?[0-9])|(2[0-3])):[0-5][0-9]:[0-5][0-9]";
			Pattern pattern = Pattern.compile(expression);
			Matcher matcher = pattern.matcher(strDate);
			if(matcher.matches()){
				isValid = true;
			}
		}
		return isValid;
	}
	
	/** 
	 * This method parse the time details
	 * @param startTime start of time range
	 * @param endTime end of time range
	 * @return TimeBean object containing parsed time details
	 */
	public static TimeBean parseTime(String startTime, String endTime) {
		TimeBean objTimeBean = null;
		if((startTime!=null && !startTime.isEmpty()) && (endTime!=null && !endTime.isEmpty())) {
			List<Integer> listStartTIme = Arrays.stream(startTime.trim().split(":"))
	                .map(Integer::valueOf)
	                .collect(Collectors.toList());
			List<Integer> listEndTIme = Arrays.stream(endTime.trim().split(":"))
	                .map(Integer::valueOf)
	                .collect(Collectors.toList());
			objTimeBean = new TimeBean(listStartTIme, listEndTIme);
		}
		return objTimeBean;
	}

	
	/**
	 * Increment hr time by 1 hr
	 * @param objTimeBean time details
	 */
	public static void incrementHr(TimeBean objTimeBean) {
		if(objTimeBean!=null) {
			objTimeBean.setStartHr(objTimeBean.getStartHr()+1);	
			objTimeBean.setStartMin(00);
			objTimeBean.setStartSec(00);
		}
	}
	
	
	/**
	 * Increment min time by 1 min
	 * @param objTimeBean time details
	 */
	public static void incrementMin(TimeBean objTimeBean) {
		if(objTimeBean!=null) {
			if(objTimeBean.getStartMin()==59) {
				objTimeBean.setStartHr(objTimeBean.getStartHr()+1);	
				objTimeBean.setStartMin(00);
				objTimeBean.setStartSec(00);
			}else {
				objTimeBean.setStartMin(objTimeBean.getStartMin()+1);
				objTimeBean.setStartSec(00);
			}
		}	
	}
}
