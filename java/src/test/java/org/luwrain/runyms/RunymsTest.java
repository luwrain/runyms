
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
	//		System.out.println("Proba: " + res);
    }

        @Test public void json() throws Exception
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
	}
}
