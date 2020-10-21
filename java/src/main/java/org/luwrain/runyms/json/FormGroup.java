
package org.luwrain.runyms.json;

import java.util.*;
import com.google.gson.annotations.*; 

public class FormGroup
{
    @SerializedName("forms")
    public List<Form> forms = null;
}
