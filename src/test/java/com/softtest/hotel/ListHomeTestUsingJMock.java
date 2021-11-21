package com.softtest.hotel;

import static org.junit.Assert.*;
import org.jmock.Expectations;
import org.jmock.Mockery;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class ListHomeTestUsingJMock {
	
	@Rule
    /*SystemOutRule���ù����ܹ����ڿ���̨�������д���ԡ�*/
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	private IData iData = null;
	
	private Mockery context = new Mockery();
	
	@Test
	public void testSearchWhenAllRoomIsEmpty() {
		iData = context.mock(IData.class, "iData");
		for (int i = 0; i < HotelConstant.HOTEL_TOTAL_FLOOR; i++) {			
			//��ӡ�����
			for (int j = 0; j < HotelConstant.HOTEL_ROOMS_EVERYFLOOR; j++)
			{
				final int m=i;
				final int n=j;
				context.checking(new Expectations(){{
					oneOf(iData).getStation((m+1)*100+n+1);
				    will(returnValue(HotelConstant.EMPTY));
					
				}});
					
				
			
			}
		}	
		
		
		
		
		ListHome lh = new ListHome(iData);
		lh.search();
		
		String lineSeperator = System.getProperty("line.separator");
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < HotelConstant.HOTEL_TOTAL_FLOOR; i++) {			
			//��ӡ�����
			for (int j = 0; j < HotelConstant.HOTEL_ROOMS_EVERYFLOOR; j++)
			{
				if (j + 1 < 10){
					sb.append(i + 1 + "0" + (j + 1) + "\t"); 
				}
				else {
					sb.append(i + 1 + "" + (j + 1) + "\t");
				}

			}
			

			//��ӡ����״̬
			sb.append(lineSeperator);
			for (int j = 0; j < HotelConstant.HOTEL_ROOMS_EVERYFLOOR; j++) {
				sb.append(HotelConstant.EMPTY + "\t");
			}

			sb.append(lineSeperator);

		}
		
		assertEquals(sb.toString(), systemOutRule.getLog());
		
		
		
		
	}

}
