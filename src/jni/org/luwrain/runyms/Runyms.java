
package org.luwrain.runyms;

public class Runyms
{
    private byte[] core = null;

    private native void initImpl();
    private native byte[] lemmatizeImpl(byte[] word);

    static public void main(String[] args) throws Exception
    {
	System.loadLibrary("runyms_jni");
	final Runyms r = new Runyms();
	r.initImpl();
	/*
	for(int i = 0;i < r.core.length;i++)
System.out.println((int)r.core[i]);
	*/
	final String text = "пробному";
	String res = new String (r.lemmatizeImpl(text.getBytes("UTF-8")), "UTF-8");
	System.out.println(res);
    }
}
