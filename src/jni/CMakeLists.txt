
include_directories(${JNI_INCLUDE_DIRS})

add_library(runyms_jni SHARED jni.cpp)

target_link_libraries(runyms_jni LemmatizerLib)

