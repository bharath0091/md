package com.time.service;


import java.util.ArrayList;
import java.util.List;

import com.time.beans.TimeBean;
import com.time.util.TimeUtil;

/**
  * Given input has a time format of HH:MM:SS where HH is for hours (24 format), MM is for minutes and SS is for seconds.
  * Write a method where it calculates the amount of times where only 2 digits appear in every possible combination in a specific time range. 
  *
  * For example: if start time is 16:15:00 and end time is 17:00:00 then all expected combinations having only 2 similar digits are
  * 16:16:00 and 16:16:16. Please provide also unit tests after finishing with the code implementation.
  * @author 510963
 **/

public class TimeService {
	
	/**
	 *  This method return count of combination
	 * @param startTime start of time range
	 * @param endTime end of time range
	 * @return count of 2 digit combination
	 */
	public int count(String startTime, String endTime){
		System.out.println("\n\n****** Start of count method *******");
		System.out.println("Start time: "+startTime);
		System.out.println("End time: "+endTime);
		
		if(!TimeUtil.isDateValid(startTime)) {
			System.out.println("Start time '"+startTime+"' is not valid");
			return 0;
		}
		if(!TimeUtil.isDateValid(endTime)) {
			System.out.println("End time '"+startTime+"' is not valid" );
			return 0;
		}
		
		TimeBean obj = TimeUtil.parseTime(startTime, endTime);
		if(obj == null || obj.getStartHr() > obj.getEndHr()){
			System.out.println("No 2 digit combination(s) found");
			return 0;
		}
		
		List<String> listTimeComb = calculateCombinations(obj);
		System.out.println("Count of 2 digit combination(s): "+ listTimeComb.size());
		System.out.println("List of 2 digit combination(s): "+ listTimeComb);
		
		return listTimeComb.size();
	}

	/** 
	 * This method calculate 2 digit combination in given time range
	 * @param obj time details
	 * @return this method return the list of 2 digit combinations 
	 */
	private List<String> calculateCombinations(TimeBean obj) {
		List<String> listTimeComb = new ArrayList<String>();

		while(obj.getStartHr() <= obj.getEndHr()) {
			//If Hr is not 2 digit then pass to next cycle till end time
			if(obj.getStartHr() < 10 && obj.getStartHr()!=0) {
				TimeUtil.incrementHr(obj);
				continue;
			}
			
			// If both end time and start time is 00
			if(obj.getStartHr() == 0 && obj.getEndHr() == 0){
				
				if(obj.getStartMin()<10) {
					TimeUtil.incrementMin(obj);
					continue;
				}
				
				if(obj.getStartMin() < obj.getEndMin() ) {
					listTimeComb.add("00:"+obj.getStartMin()+":"+obj.getStartMin());
					TimeUtil.incrementMin(obj);
				}else if(obj.getStartMin() == obj.getEndMin() && obj.getEndMin() <= obj.getEndSec()) {
					listTimeComb.add("00:"+obj.getStartMin()+":"+obj.getStartMin());
					break;
				}else {
					break;
				}
			
		    //If start time is zero but end time is not zero	
			}else if(obj.getStartHr() == 0 && obj.getEndHr()!= 0){
				
				if(obj.getStartMin()<10) {
					TimeUtil.incrementMin(obj);
					continue;
				}
				
				if(obj.getStartMin() >= obj.getStartSec()) {
					listTimeComb.add("00:"+obj.getStartMin()+":"+obj.getStartMin());
					TimeUtil.incrementMin(obj);
				}
				
			//Both start Hr and end Hr is same. (Last condition check)
			}else if(obj.getStartHr()==obj.getEndHr()) {
				checkCombinationWhenHrAreEqual(obj, listTimeComb);
				break;
				
			//Check rest of the combination	
			}else{
				checkCombinationWhenHrNotEqual(obj, listTimeComb);
			}
		}
		return listTimeComb;
	}
	
	/**
	 *  Below method check the combination of 2 digit when start end end hr equal
	 * @param obj time details
	 * @param listTimeComb return the list of combination
	 */
	private void checkCombinationWhenHrAreEqual(TimeBean obj, List<String> listTimeComb ) {
		if(( obj.getStartMin()==0 ) && (obj.getStartHr() <= obj.getEndSec() ) ) {
			listTimeComb.add(obj.getEndHr()+":00:"+obj.getEndHr());
		}
		
		if((obj.getEndHr() < obj.getEndMin()) ||( obj.getEndHr() == obj.getEndMin() && obj.getStartSec() == 0)) {
			listTimeComb.add(obj.getEndHr()+":"+obj.getEndHr()+":00");
		}

		if((obj.getEndHr() < obj.getEndMin()) || (obj.getEndHr() == obj.getEndMin() && obj.getStartSec() <= obj.getEndMin() && obj.getStartSec() <= obj.getEndSec())) {
			listTimeComb.add(obj.getEndHr()+":"+obj.getEndHr()+":"+obj.getEndHr());
		}
	}
	
	
	/**
	 * Below method check the combination of 2 digit when start end end hr not equal
	 * @param obj time details
	 * @param listTimeComb return the list of combination
	 */
	private void checkCombinationWhenHrNotEqual(TimeBean obj, List<String> listTimeComb ) {
		if(obj.getStartHr() !=0 && obj.getStartMin()==0 && obj.getStartSec()==0) {
			listTimeComb.add(obj.getStartHr()+":00:"+obj.getStartHr());
		}
		
		if(obj.getStartHr() >= obj.getStartMin() && obj.getStartSec()>=0) {
			listTimeComb.add(obj.getStartHr()+":"+obj.getStartHr()+":00");
		}
		
		if(obj.getStartHr() >= obj.getStartMin() && obj.getStartHr() >= obj.getStartSec()) {
			listTimeComb.add(obj.getStartHr()+":"+obj.getStartHr()+":"+obj.getStartHr());
		}
		TimeUtil.incrementHr(obj);
	}
}
