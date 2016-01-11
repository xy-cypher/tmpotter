/* *************************************************************************
 *
 *  TMPotter - Bi-text Aligner/TMX Editor
 *
 *  Copyright (C) 2015 Hiroshi Miura
 *
 *  Part of this come from OmegaT.
 *
 *  Copyright (C) 2000-2006 Keith Godfrey and Maxym Mykhalchuk
 *
 *  This file is part of TMPotter.
 *
 *  TMPotter is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  TMPotter is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with TMPotter.  If not, see http://www.gnu.org/licenses/.
 *
 * *************************************************************************/

package org.tmpotter.segmentation;

import java.io.Serializable;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * The class representing a single segmentation rule.
 * 
 * @author Maxym Mykhalchuk
 */
@SuppressWarnings("serial")
public class Rule implements Serializable, Cloneable {

  /**
   * Creates a new empty instance of segmentation rule
   */
  public Rule() {
  }

  /**
   * Creates an initialized instance of segmentation rule
   */
  public Rule(boolean breakRule, String beforebreak, String afterbreak) {
    setBreakRule(breakRule);
    setBeforebreak(beforebreak);
    setAfterbreak(afterbreak);
  }

  public Rule clone() {
    Rule result = new Rule();
    result.breakRule = breakRule;
    result.beforebreak = beforebreak;
    result.afterbreak = afterbreak;
    return result;
  }

  /**
   * Holds value of property breakRule.
   * <p>
   * This property corresponds to 'break' attribute of SRX 'rule', meaning
   * whether this is a rule that determines a break or an exception.
   */
  private boolean breakRule;

  /**
   * Returns whether this is a rule that determines a break or an exception.
   *
   * @return true is this is a break rule.
   */
  public boolean isBreakRule() {
    return this.breakRule;
  }

  /**
   * Sets whether this is a rule that determines a break or an exception.
   *
   * @param breakRule New value -- true for a break rule, false for an
   * exception.
   */
  public void setBreakRule(boolean breakRule) {
    this.breakRule = breakRule;
  }

  /**
   * A regular expression which represents the text that appears before a
   * segment break.
   */
  private Pattern beforebreak;

  /**
   * Returns a regular expression which represents the text that appears before
   * a segment break.
   *
   * @return regular expression of a text before break.
   */
  public String getBeforebreak() {
    if (beforebreak != null) {
      return beforebreak.pattern();
    } else {
      return null;
    }
  }

  /**
   * Returns a regular expression which represents the text that appears before
   * a segment break.
   *
   * @return regular expression of a text before break.
   */
  public Pattern getCompiledBeforebreak() {
    return beforebreak;
  }

  /**
   * Sets a regular expression which represents the text that appears before a
   * segment break.
   *
   * @param beforebreak Regular expression string of a text before break.
   */
  public void setBeforebreak(String beforebreak) throws PatternSyntaxException {
    this.beforebreak = compilePattern(beforebreak);
  }

  /**
   * A regular expression which represents the text that appears after a segment
   * break.
   */
  private Pattern afterbreak;

  /**
   * Returns a regular expression which represents the text that appears after a
   * segment break.
   *
   * @return regular expression of a text after break.
   */
  public String getAfterbreak() {
    if (afterbreak != null) {
      return afterbreak.pattern();
    } else {
      return null;
    }
  }

  /**
   * Returns a regular expression which represents the text that appears after a
   * segment break.
   *
   * @return regular expression of a text after break.
   */
  public Pattern getCompiledAfterbreak() {
    return afterbreak;
  }

  /**
   * Sets a regular expression which represents the text that appears after a
   * segment break.
   *
   * @param afterbreak Regular expression string of a text after break.
   */
  public void setAfterbreak(String afterbreak) throws PatternSyntaxException {
    this.afterbreak = compilePattern(afterbreak);
  }

  /**
   * Compiles the pattern and avoids two bugs:
   * <ul>
   * <li>#1385202 - "." does not match newline chars, and hence, OmegaT does not
   * segment on "<br>
   * \n". Fixed by adding Pattern.DOTALL flag.
   * <li>#1393484 - Case sensitivity for segmentation rules, e.g. exception
   * "M\." glues "them. All". Fixed by testing for case sensitivity, and turning
   * UNICODE_CASE flag on iff the case insensitivity is turned on too.
   * </ul>
   */
  private Pattern compilePattern(String pattern) {
    Pattern testFlags = Pattern.compile(pattern);
    if ((testFlags.flags()
            & Pattern.CASE_INSENSITIVE) == Pattern.CASE_INSENSITIVE) {
      return Pattern.compile(pattern, Pattern.UNICODE_CASE
              | Pattern.DOTALL);
    } else {
      return Pattern.compile(pattern, Pattern.DOTALL);
    }
  }

  /**
   * Indicates whether some other Rule is "equal to" this one.
   */
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof Rule)) {
      return false;
    }
    Rule that = (Rule) obj;
    return this.breakRule == that.breakRule
            && this.getBeforebreak().equals(that.getBeforebreak())
            && this.getAfterbreak().equals(that.getAfterbreak());
  }

  /**
   * Returns a hash code value for the object.
   */
  public int hashCode() {
    return (this.isBreakRule() ? 1 : -1) + this.getBeforebreak().hashCode()
            - this.getAfterbreak().hashCode();
  }

  /**
   * Returns a string representation of the Rule for debugging purposes.
   */
  public String toString() {
    return (isBreakRule() ? "Break " : "Exception ") + "Before: " 
            + getBeforebreak() + "After: " + getAfterbreak();
  }
}