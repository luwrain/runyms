
#include<string>
#include<vector>

#include "aot/LemmatizerLib/MorphologyHolder.h"
#include"aot/LemmatizerLib/Lemmatizers.h"
#include"aot/LemmatizerLib/Morphan.h"

int main()
{
    CMorphologyHolder Holder;
    if (!Holder.LoadLemmatizer(morphRussian))
      {
        std::cerr << "Cannot load morphology\n";
        return 1;
    }
    std::cout << "Morphology loaded" << std::endl;
    std::string s = convert_from_utf8("века", morphRussian);
    std::string result = LemmatizeJson(s.c_str(), &Holder, /*printForms*/true, true, true);
    std::cout << result << std::endl;
    return 0;
}
