
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