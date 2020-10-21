
#include<stdio.h>
#include<string>
#include<memory>
#include<iostream>

#include"jni.h"
#include"org_luwrain_runyms_Runyms.h"

#include "../aot/LemmatizerLib/MorphologyHolder.h"
#include"../aot/LemmatizerLib/Lemmatizers.h"
#include"../aot/LemmatizerLib/Morphan.h"

JNIEXPORT void JNICALL Java_org_luwrain_runyms_Runyms_initImpl
(JNIEnv* env, jobject obj)
{
  std::auto_ptr<CMorphologyHolder> h(new CMorphologyHolder());
  if (!h->LoadLemmatizer(morphRussian))
    std::cerr << "Cannot load morphology\n";
  printf("%x \n", h.get());
  jbyteArray ar = env->NewByteArray(sizeof(CMorphologyHolder*));
  CMorphologyHolder* ptr = h.get();
  env->SetByteArrayRegion (ar, 0, sizeof(CMorphologyHolder*), (jbyte*)&ptr);
     jclass cl = env->GetObjectClass(obj);
    const jfieldID id = env->GetFieldID(cl, "core", "[B");
    env->SetObjectField(obj, id, ar);
}

JNIEXPORT jbyteArray JNICALL Java_org_luwrain_runyms_Runyms_lemmatizeImpl
(JNIEnv* env, jobject obj, jbyteArray word)
{
  std::cout << "func" << std::endl;
       jclass cl = env->GetObjectClass(obj);
    const jfieldID id = env->GetFieldID(cl, "core", "[B");
    jbyteArray ar = (jbyteArray)env->GetObjectField(obj, id);

      CMorphologyHolder* ptr = NULL;
  env->GetByteArrayRegion (ar, 0, sizeof(CMorphologyHolder*), (jbyte*)&ptr);
  printf("%x\n", ptr);


      jbyteArray ret = env->NewByteArray(0);
  return ret;


    /*
    
  const jsize len = env->GetArrayLength(word);
  const jbyte* bytes = env->GetByteArrayElements(word, NULL); 
  std::string w;
  w.reserve(len);
  for(jsize i = 0;i < len;i++)
    w += bytes[i];
  //	  std::cout << w << std::endl;
  CMorphologyHolder Holder;
  if (!Holder.LoadLemmatizer(morphRussian))
    {
      std::cerr << "Cannot load morphology\n";
    }
  std::string s = convert_from_utf8(w.c_str(), morphRussian);
  std::string res = LemmatizeJson(s.c_str(), &Holder, /*printForms*//*true, true, true);
  jbyteArray ret = env->NewByteArray(res.length());
  env->SetByteArrayRegion (ret, 0, res.length(), (jbyte*)res.c_str());
  return ret;
*/
}
