
#include<string>
#include<iostream>

#include"jni.h"
#include"org_luwrain_runyms_Runyms.h"

#include "../aot/LemmatizerLib/MorphologyHolder.h"
#include"../aot/LemmatizerLib/Lemmatizers.h"
#include"../aot/LemmatizerLib/Morphan.h"

JNIEXPORT void JNICALL Java_org_luwrain_runyms_Runyms_init
  (JNIEnv* env, jobject obj)
{
    CMorphologyHolder Holder;
    if (!Holder.LoadLemmatizer(morphRussian))
      {
        std::cerr << "Cannot load morphology\n";
    }
}

JNIEXPORT jbyteArray JNICALL Java_org_luwrain_runyms_Runyms_lemmatizeImpl
  (JNIEnv* env, jobject obj, jbyteArray word)
{
          const jsize len = env->GetArrayLength(word);
	          const jbyte* bytes = env->GetByteArrayElements(word, NULL); 
	  std::string w;
	  w.reserve(len);
	  for(jsize i = 0;i < len;i++)
	    w += bytes[i];
	  std::cout << w << std::endl;
}

