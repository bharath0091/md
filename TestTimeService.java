package com.time.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.time.service.TimeService;


/**
 * This class test count method of TimeService class
 * @author 510963
 *
 */
public class TestTimeService {
	TimeService obj = new TimeService();
		
	@Test
	public void testCount1() {
		assertEquals(2, obj.count("16:15:00", "17:00:00"));
	 }
	
	@Test
	public void testCount2() {
		assertEquals(92, obj.count("00:00:00", "23:59:59"));
	 }
	
	@Test
	public void testCount3() {
		assertEquals(0, obj.count("15:15:16", "15:15:30"));
	 }
	
	@Test
	public void testCount4() {
		assertEquals(1, obj.count("15:15:14", "15:15:30"));
	 }	

	@Test
	public void testCount5() {
		assertEquals(6, obj.count("00:30:00", "00:35:36"));
	 }	
	
	@Test
	public void testCoun6t() {
		assertEquals(15, obj.count("09:00:00", "15:00:00"));
	 }
	
	@Test
	public void testCount7() {
		assertEquals(3, obj.count("16:15:01", "17:00:18"));
	 }
	
	@Test
	public void testCount8() {
		assertEquals(0, obj.count("16:15:00", null));
	 }
	
	@Test
	public void testCount9() {
		assertEquals(0, obj.count(null, null));
	 }
	
	@Test
	public void testCount10() {
		assertEquals(0, obj.count("56:25:88", null));
	 }
	
}
