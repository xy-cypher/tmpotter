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

import bitext2tmx.core.TranslationAligner;
import java.io.BufferedWriter;
import java.io.OutputStream;
import junit.framework.TestCase;

/**
 *
 * @author miurahr
 */
public class UtilitiesTest extends TestCase {
  
  public UtilitiesTest(String testName) {
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
   * Test of getFontNames method, of class Utilities.
   */
  public void testGetFontNames() {
    System.out.println("getFontNames");
    String[] result = Utilities.getFontNames();
    assertNotNull(result);
  }

  /**
   * Test of joinString method, of class Utilities.
   */
  public void testJoinString() {
    System.out.println("joinString");
    String separator = ",";
    String[] items = {"first","second","third"};
    String expResult = "first,second,third";
    String result = StringUtil.joinString(separator, items);
    assertEquals(expResult, result);
  }

  /**
   * Test of printUTF8 method, of class Utilities.
   */
  public void testPrintUTF8() {
    System.out.println("printUTF8");
    String output = "test output";
    Utilities.printUTF8(output);
  }

  /**
   * Test of saveUTF8 method, of class Utilities.
   */
  public void testSaveUTF8() {
    System.out.println("saveUTF8");
    String dir = "";
    String filename = "";
    String output = "";
    Utilities.saveUTF8(dir, filename, output);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
  
  /**
   * Test of getConfigDir method, of class Utilities.
   */
  public void testGetConfigDir() {
    System.out.println("getConfigDir");
    String expResult = "/.bitext2tmx/";
    String result = Utilities.getConfigDir();
    assertTrue(result.endsWith(expResult));
  }

  /**
   * Test of installDir method, of class Utilities.
   */
  public void testInstallDir() {
    System.out.println("installDir");
    String expResult = "bitext2tmx/build";
    String result = Utilities.installDir();
    assertTrue(result.endsWith(expResult));
  }

  /**
   * Test of largerSize method, of class Utilities.
   */
  public void testLargerSize() {
    System.out.println("largerSize");
    int a = 1;
    int b = 2;
    int expResult = 2;
    int result = Utilities.largerSize(a, b);
    assertEquals(expResult, result);
  }
  
}