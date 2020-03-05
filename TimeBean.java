package com.time.beans;
import java.util.List;

/**
 * This is bean class is used to hold the different value of time range
 *  for example start hr, start min, start sec, end hr, end min, end sec
 * @author 510963
 *
 */
public class TimeBean {

	private int startHr;
	private int startMin;
	private int startSec;
	private int endHr;
	private int endMin;
	private int endSec;
	
	public TimeBean(List<Integer> listStartTIme, List<Integer> listEndTIme) {
		
		startHr = listStartTIme.get(0);
		startMin = listStartTIme.get(1);
		startSec = listStartTIme.get(2);
		
		endHr = listEndTIme.get(0);
		endMin = listEndTIme.get(1);
		endSec = listEndTIme.get(2);
	}

	public int getStartHr() {
		return startHr;
	}

	public void setStartHr(int startHr) {
		this.startHr = startHr;
	}

	public int getStartMin() {
		return startMin;
	}

	public void setStartMin(int startMin) {
		this.startMin = startMin;
	}

	public int getStartSec() {
		return startSec;
	}

	public void setStartSec(int startSec) {
		this.startSec = startSec;
	}

	public int getEndHr() {
		return endHr;
	}

	public void setEndHr(int endHr) {
		this.endHr = endHr;
	}

	public int getEndMin() {
		return endMin;
	}

	public void setEndMin(int endMin) {
		this.endMin = endMin;
	}

	public int getEndSec() {
		return endSec;
	}

	public void setEndSec(int endSec) {
		this.endSec = endSec;
	}

	@Override
	public String toString() {
		return "TimeBean [startHr=" + startHr + ", startMin=" + startMin + ", startSec=" + startSec + ", endHr=" + endHr
				+ ", endMin=" + endMin + ", endSec=" + endSec + "]";
	}
	
}
