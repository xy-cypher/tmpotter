/**************************************************************************
 *
 *  bitext2tmx - Bitext Aligner/TMX Editor
 *
 *  Copyright (C) 2000-2006 Keith Godfrey and Maxym Mykhalchuk
 *  Copyright (C) 2015 Hiroshi Miura
 *
 *  This file is part of bitext2tmx.
 *
 *  bitext2tmx is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  bitext2tmx is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with bitext2tmx.  If not, see http://www.gnu.org/licenses/.
 *
 **************************************************************************/

package bitext2tmx.segmentation.datamodels;

import bitext2tmx.segmentation.SRX;

import javax.swing.ButtonModel;
import javax.swing.JToggleButton;


/**
 * 
 * @author Maxym Mykhalchuk
 */
@SuppressWarnings("serial")
public class SRXOptionsModel extends JToggleButton.ToggleButtonModel {

  protected SRX srx;

  /**
   * Creates a new instance of SRXOptionsModel
   */
  protected SRXOptionsModel(SRX srx) {
    this.srx = srx;
  }

  /**
   * a model for segment subflows checkbox
   */
  private static class SegmentSubflowsModel extends SRXOptionsModel {

    SegmentSubflowsModel(SRX srx) {
      super(srx);
    }

    public void setSelected(boolean b) {
      srx.setSegmentSubflows(b);
      super.setSelected(b);
    }

    public boolean isSelected() {
      return srx.isSegmentSubflows();
    }

  }

  /**
   * a model for segment subflows checkbox
   */
  public static ButtonModel getSegmentSubflowsModel(SRX srx) {
    return new SegmentSubflowsModel(srx);
  }

  /**
   * a model for including starting formatting tags at the end boundary of the
   * segment checkbox
   */
  private static class IncludeStartingTagsModel extends SRXOptionsModel {

    IncludeStartingTagsModel(SRX srx) {
      super(srx);
    }

    public void setSelected(boolean b) {
      srx.setIncludeStartingTags(b);
      super.setSelected(b);
    }

    public boolean isSelected() {
      return srx.isIncludeStartingTags();
    }

  }

  /**
   * a model for including starting formatting tags at the end boundary of the
   * segment checkbox
   */
  public static ButtonModel getIncludeStartingTagsModel(SRX srx) {
    return new IncludeStartingTagsModel(srx);
  }

  /**
   * a model for including ending formatting tags at the end boundary of the
   * segment checkbox
   */
  private static class IncludeEndingTagsModel extends SRXOptionsModel {

    IncludeEndingTagsModel(SRX srx) {
      super(srx);
    }

    public void setSelected(boolean b) {
      srx.setIncludeEndingTags(b);
      super.setSelected(b);
    }

    public boolean isSelected() {
      return srx.isIncludeEndingTags();
    }

  }

  /**
   * a model for including ending formatting tags at the end boundary of the
   * segment checkbox
   */
  public static ButtonModel getIncludeEndingTagsModel(SRX srx) {
    return new IncludeEndingTagsModel(srx);
  }

  /**
   * a model for including isolated formatting tags at the end boundary of the
   * segment checkbox
   */
  private static class IncludeIsolatedTagsModel extends SRXOptionsModel {

    IncludeIsolatedTagsModel(SRX srx) {
      super(srx);
    }

    public void setSelected(boolean b) {
      srx.setIncludeIsolatedTags(b);
      super.setSelected(b);
    }

    public boolean isSelected() {
      return srx.isIncludeIsolatedTags();
    }

  }

  /**
   * a model for including isolated formatting tags at the end boundary of the
   * segment checkbox
   */
  public static ButtonModel getIncludeIsolatedTagsModel(SRX srx) {
    return new IncludeIsolatedTagsModel(srx);
  }

}
