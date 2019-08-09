package com.loyofo.spa.test.junit;

import com.loyofo.spa.test.controller.MavControllerTest;
import com.loyofo.spa.test.controller.ParamControllerTest;
import com.loyofo.spa.test.controller.SpittrControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({MavControllerTest.class, ParamControllerTest.class, SpittrControllerTest.class})
public class SpaTestSuit {
}
