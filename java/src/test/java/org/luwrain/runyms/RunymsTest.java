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

import java.io.*;
import org.junit.*;

import org.luwrain.runyms.json.*;

public final class RunymsTest extends Assert
{
    @Test public void plain() throws Exception
    {
	final Runyms r = new Runyms();
	r.init();
	final String res = r.lemmatize("Томск");
	assertNotNull(res);
	assertFalse(res.isEmpty());
	System.out.println("Proba: " + res);
    }

    @Test public void tomsk() throws Exception
    {
	final Runyms r = new Runyms();
	r.init();
	final String res = r.lemmatize("Томск");
	assertNotNull(res);
	assertFalse(res.isEmpty());
	final LemmResult[] l = LemmResult.fromJsonAsArray(res);
	assertNotNull(l);
	assertEquals(1, l.length);
	final LemmResult k = l[0];
	assertNotNull(k.commonGrammems);
	assertFalse(k.commonGrammems.trim().isEmpty());
	assertTrue(k.found);
	assertNotNull(k.paradigm);
	assertEquals(1, k.paradigm.size());
	final Paradigm p = k.paradigm.get(0);
	assertNotNull(p);
	assertNotNull(p.formsGroups);
	assertEquals(2, p.formsGroups.size());
	for(FormsGroup g: p.formsGroups)
	{
	    assertNotNull(g);
	    assertNotNull(g.forms);
	    assertEquals(6, g.forms.size());
	    assertNotNull(g.grm);
	    assertFalse(g.grm.trim().isEmpty());
	    for(Form f: g.forms)
	    {
		assertNotNull(f);
		assertNotNull(f.f);
		assertFalse(f.f.trim().isEmpty());
		assertNotNull(f.grm);
		assertFalse(f.grm.trim().isEmpty());
	    }
	}
	assertNotNull(p.pos);
	assertEquals("СУЩЕСТВИТЕЛЬНОЕ мр", p.pos);
	assertNotNull(k.wordForm);
	assertEquals("ТОМСК", k.wordForm);
    }

        @Test public void tomske() throws Exception
    {
	final Runyms r = new Runyms();
	r.init();
	final String res = r.lemmatize("Томске");
	assertNotNull(res);
	assertFalse(res.isEmpty());
	final LemmResult[] l = LemmResult.fromJsonAsArray(res);
	assertNotNull(l);
	assertEquals(1, l.length);
	final LemmResult k = l[0];
	assertNotNull(k.commonGrammems);
	assertFalse(k.commonGrammems.trim().isEmpty());
	assertTrue(k.found);
	assertNotNull(k.paradigm);
	assertEquals(1, k.paradigm.size());
	final Paradigm p = k.paradigm.get(0);
	assertNotNull(p);
	assertNotNull(p.formsGroups);
	assertEquals(2, p.formsGroups.size());
	for(FormsGroup g: p.formsGroups)
	{
	    assertNotNull(g);
	    assertNotNull(g.forms);
	    assertEquals(6, g.forms.size());
	    assertNotNull(g.grm);
	    assertFalse(g.grm.trim().isEmpty());
	    for(Form f: g.forms)
	    {
		assertNotNull(f);
		assertNotNull(f.f);
		assertFalse(f.f.trim().isEmpty());
		assertNotNull(f.grm);
		assertFalse(f.grm.trim().isEmpty());
	    }
	}
	assertNotNull(p.pos);
	assertEquals("СУЩЕСТВИТЕЛЬНОЕ мр", p.pos);
	assertNotNull(k.wordForm);
	assertEquals("ТОМСК", k.wordForm);
    }
}
