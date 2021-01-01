/*
   Copyright 2020 Michael Pozhidaev <msp@luwrain.org>

   This file is part of LUWRAIN.

   LUWRAIN is free software; you can redistribute it and/or
   modify it under the terms of the GNU General Public
   License as published by the Free Software Foundation; either
   version 3 of the License, or (at your option) any later version.

   LUWRAIN is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
   General Public License for more details.
*/

package org.luwrain.runyms.json;

import java.util.*;
import com.google.gson.annotations.*; 

public class Paradigm
{
    @SerializedName("formsGroups")
    public List<FormsGroup> formsGroups = null;

    @SerializedName("pos")
    public String pos = null;

    public String getPosNotNull()
    {
	return pos != null?pos.toUpperCase():"";
    }
}
