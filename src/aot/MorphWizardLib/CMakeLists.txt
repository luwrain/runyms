
project(MorphWizardLib)

add_library(MorphWizardLib
  wizard.cpp
  FormInfo.cpp)

target_link_libraries(MorphWizardLib
    PCRE
    AgramtabLib
)
