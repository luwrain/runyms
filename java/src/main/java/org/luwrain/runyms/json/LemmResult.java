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
import java.lang.reflect.*;

import com.google.gson.*;
import com.google.gson.reflect.*;
import com.google.gson.annotations.*; 

public class LemmResult
{
    static public final Type LIST_TYPE = new TypeToken<List<LemmResult>>(){}.getType();

    @SerializedName("commonGrammems")
    public String commonGrammems = null;

    @SerializedName("found")
    public boolean found = false;

    @SerializedName("morphInfo")
    public String morphInfo = null;

    @SerializedName("paradigm")
    public List<Paradigm> paradigm = null;

    @SerializedName("srcNorm")
    public String srcNorm = null;

    @SerializedName("wordForm")
    public String wordForm = null;

    public String[] getMorphInfoAsArray()
    {
	return splitArray(morphInfo);
    }

    public String[] getCommonGrammemsAsArray()
    {
	return splitArray(commonGrammems);
    }

    static public LemmResult[] fromJsonAsArray(String str)
    {
	final List<LemmResult> res = new Gson().fromJson(str, LIST_TYPE);
	if (res == null)
	    return null;
	return res.toArray(new LemmResult[res.size()]);
    }

    static public String[] splitArray(String value)
    {
	if (value == null)
	    return new String[0];
	final List<String> res = new ArrayList();
	for(String s: value.split(",", -1))
	{
	    final String ss = s.trim();
	    if (!s.isEmpty())
		res.add(s.toUpperCase());
	}
	return res.toArray(new String[res.size()]);
	 }
}
