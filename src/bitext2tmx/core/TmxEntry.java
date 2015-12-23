/**
 * ************************************************************************
 * bitext2tmx - Bitext Aligner/TMX Editor.
 *
 * Copyright (C) 2015 Hiroshi Miura
 *
 * This file is imported from OmegaT.
 * 
 * Copyright (C) 2000-2006 Keith Godfrey and Maxym Mykhalchuk
 *               2012 Guido Leenders, Didier Briel
 *               2013 Aaron Madlon-Kay, Yu Tang
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

package bitext2tmx.core;

import bitext2tmx.util.KvProp;

import java.util.List;


/**
 * Class for prepare TMXEntry content before save unchangeable copy in the
 * ProjectTMX. We can't use just parameters in the setTranslation() method since
 * count of parameters is too much. Structure of this class is almost the save
 * like TMXEntry.
 *
 * Instead, we will set all parameters into this class, then ProjectTMX will
 * convert in into TMXEntry than save internally.
 *
 * @author Alex Buloichik (alex73mail@gmail.com)
 * @author Guido Leenders
 * @author Aaron Madlon-Kay
 */
public class TmxEntry {

  public String source;
  public String translation;
  public String changer;
  public long changeDate;
  public String creator;
  public long creationDate;
  public String note;
  public List<KvProp> otherProperties;

  public TmxEntry() {
  }

  /**
   * TMX entry class.
   * 
   * @param ent Entry for base
   */
  public TmxEntry(TmxEntry ent) {
    source = ent.source;
    translation = ent.translation;
    changer = ent.changer;
    changeDate = ent.changeDate;
    creator = ent.creator;
    creationDate = ent.creationDate;
    note = ent.note;
    otherProperties = ent.otherProperties;
  }

  public String getPropValue(String propType) {
    if (otherProperties == null) {
      return null;
    }
    for (int i = 0; i < otherProperties.size(); i++) {
      KvProp kv = otherProperties.get(i);
      if (propType.equals(kv.getType())) {
        return kv.getValue();
      }
    }
    return null;
  }

  public boolean hasPropValue(String propType, String propValue) {
    if (otherProperties == null) {
      return false;
    }
    for (int i = 0; i < otherProperties.size(); i++) {
      KvProp kv = otherProperties.get(i);
      if (propType.equals(kv.getType())) {
        if (propValue == null) {
          return true;
        }
        if (propValue.equals(kv.getValue())) {
          return true;
        }
      }
    }
    return false;
  }
}
