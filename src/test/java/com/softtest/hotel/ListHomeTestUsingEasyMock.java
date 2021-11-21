package com.softtest.hotel;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class ListHomeTestUsingEasyMock {
	
	@Rule
    /*SystemOutRule，该规则能够基于控制台的输出编写断言。*/
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	private IData iData = null;
	
	@Test
	public void testSearchWhenAllRoomIsEmpty() {
		iData = createMock("iData", IData.class);
		for (int i = 0; i < HotelConstant.HOTEL_TOTAL_FLOOR; i++) {			
			//打印房间号
			for (int j = 0; j < HotelConstant.HOTEL_ROOMS_EVERYFLOOR; j++)
			{
				expect(iData.getStation((i+1)*100+j+1)).andReturn(HotelConstant.EMPTY);
			
			}
		}
		
		
		
		replay(iData);
		
		ListHome lh = new ListHome(iData);
		lh.search();
		
		String lineSeperator = System.getProperty("line.separator");
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < HotelConstant.HOTEL_TOTAL_FLOOR; i++) {			
			//打印房间号
			for (int j = 0; j < HotelConstant.HOTEL_ROOMS_EVERYFLOOR; j++)
			{
				if (j + 1 < 10){
					sb.append(i + 1 + "0" + (j + 1) + "\t"); 
				}
				else {
					sb.append(i + 1 + "" + (j + 1) + "\t");
				}

			}
			

			//打印房间状态
			sb.append(lineSeperator);
			for (int j = 0; j < HotelConstant.HOTEL_ROOMS_EVERYFLOOR; j++) {
				sb.append(HotelConstant.EMPTY + "\t");
			}

			sb.append(lineSeperator);

		}
		
		assertEquals(sb.toString(), systemOutRule.getLog());
		
		verify(iData);
		
		
	}
	
	@Test
	public void testSearchWhenRoom101IsNotEmpty() {
		iData = createMock("iData", IData.class);
		for (int i = 0; i < HotelConstant.HOTEL_TOTAL_FLOOR; i++) {			
			//打印房间号
			for (int j = 0; j < HotelConstant.HOTEL_ROOMS_EVERYFLOOR; j++)
			{
				if ((i==0) && (j==0)){
					expect(iData.getStation(101)).andReturn("张三");					
				}
				else{
					expect(iData.getStation((i+1)*100+j+1)).andReturn(HotelConstant.EMPTY);
				}
				
			
			}
		}
		
		
		
		replay(iData);
		
		ListHome lh = new ListHome(iData);
		lh.search();
		
		String lineSeperator = System.getProperty("line.separator");
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < HotelConstant.HOTEL_TOTAL_FLOOR; i++) {			
			//打印房间号
			for (int j = 0; j < HotelConstant.HOTEL_ROOMS_EVERYFLOOR; j++)
			{
				if (j + 1 < 10){
					sb.append(i + 1 + "0" + (j + 1) + "\t"); 
				}
				else {
					sb.append(i + 1 + "" + (j + 1) + "\t");
				}

			}
			

			//打印房间状态
			sb.append(lineSeperator);
			for (int j = 0; j < HotelConstant.HOTEL_ROOMS_EVERYFLOOR; j++) {
				if ((i==0) && (j==0)){
					sb.append("张三"+"\t");
				}
				else
				{
				    sb.append(HotelConstant.EMPTY + "\t");
				}
			}

			sb.append(lineSeperator);

		}
		
		assertEquals(sb.toString(), systemOutRule.getLog());
		
		verify(iData);
		
		
	}

}
