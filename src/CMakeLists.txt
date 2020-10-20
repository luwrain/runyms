
add_subdirectory (aot)
add_subdirectory (jni)

add_executable (runyms runyms.cpp)

target_link_libraries(runyms LemmatizerLib)

