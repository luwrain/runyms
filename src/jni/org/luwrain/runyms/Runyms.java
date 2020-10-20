
package org.luwrain.runyms;

public class Runyms
{
    private native void initImpl();
    private native byte[] lemmatizeImpl(byte[] word);

    static public void main(String[] args) throws Exception
    {
	System.loadLibrary("runyms_jni");
	final Runyms r = new Runyms();
	final String text = "Это пробный текст";
	r.lemmatizeImpl(text.getBytes("UTF-8"));
    }
}
