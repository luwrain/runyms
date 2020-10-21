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

package org.luwrain.runyms;

public class Runyms
{
    private byte[] core = null;

    private native void initImpl();
    private native byte[] lemmatizeImpl(byte[] word);

    static private boolean jniLoaded = false;

    public void init()
    {
	if (!jniLoaded)
	    System.loadLibrary("runyms_jni");
	jniLoaded = true;
	initImpl();
    }

    public String lemmatize(String word)
    {
	try {
	    return new String (lemmatizeImpl(word.getBytes("UTF-8")), "UTF-8");
	}
	catch(java.io.IOException e)
	{
	    throw new RuntimeException(e);
	}
    }

    static public void main(String[] args)
    {
	final Runyms r = new Runyms();
	r.init();
	System.out.println(r.lemmatize("Томск"));
    }
}
