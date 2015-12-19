/*
 * Copyright (C) 2015 miurahr
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package bitext2tmx.util;

import junit.framework.TestCase;

/**
 *
 * @author miurahr
 */
public class RuntimePreferencesTest extends TestCase {
  
  public RuntimePreferencesTest(String testName) {
    super(testName);
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
  }
  
  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
  }

  /**
   * Test of isSegmentByLineBreak method, of class RuntimePreferences.
   */
  public void testIsSegmentByLineBreak() {
    System.out.println("isSegmentByLineBreak");
    boolean expResult = false;
    boolean result = RuntimePreferences.isSegmentByLineBreak();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setSegmentByLineBreak method, of class RuntimePreferences.
   */
  public void testSetSegmentByLineBreak() {
    System.out.println("setSegmentByLineBreak");
    boolean segmentRule = false;
    RuntimePreferences.setSegmentByLineBreak(segmentRule);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setUserHome method, of class RuntimePreferences.
   */
  public void testSetUserHome() {
    System.out.println("setUserHome");
    String home = "";
    RuntimePreferences.setUserHome(home);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getUserHome method, of class RuntimePreferences.
   */
  public void testGetUserHome() {
    System.out.println("getUserHome");
    String expResult = "";
    String result = RuntimePreferences.getUserHome();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
  
}