package com.softtest.hotel;

import static org.easymock.EasyMock.*;


import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;



public class MainRunTestUsingEasyMock {

	@Rule
    /*SystemOutRule���ù����ܹ����ڿ���̨�������д���ԡ�*/
    public final SystemOutRule systemOutRule 
        = new SystemOutRule().enableLog();
	
	@Rule
	public final TextFromStandardInputStream systemInMock
	    = emptyStandardInputStream();
	
	private ListHome lhMock = null;
	
	@Test
	  public void testCommand() {
		lhMock = createMock("listHome", ListHome.class);
		
		lhMock.search();
		
		replay(lhMock);
		
		MainRun.setLh(lhMock);
		
		
	    systemInMock.provideLines("search", "exit");
	    MainRun.main(null);
	    
	    String lineSeperator = System.getProperty("line.separator");
	    
	    assertEquals("���������"+ lineSeperator + "���������" + lineSeperator + "�����˳�..." + lineSeperator, systemOutRule.getLog());
	    
	    verify(lhMock);
	  }


}
