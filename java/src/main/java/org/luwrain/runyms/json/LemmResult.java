
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

    static public LemmResult[] fromJsonAsArray(String str)
    {
	final List<LemmResult> res = new Gson().fromJson(str, LIST_TYPE);
	if (res == null)
	    return null;
	return res.toArray(new LemmResult[res.size()]);
    }
}
