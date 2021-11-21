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
    /*SystemOutRule，该规则能够基于控制台的输出编写断言。*/
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
	    
	    assertEquals("请输入命令："+ lineSeperator + "请输入命令：" + lineSeperator + "程序退出..." + lineSeperator, systemOutRule.getLog());
	    
	    verify(lhMock);
	  }


}
