package com.softtest.hotel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ InHotelTestUsingEasyMock.class, InHotelTestUsingJMock.class })
public class InHotelTests {

}
