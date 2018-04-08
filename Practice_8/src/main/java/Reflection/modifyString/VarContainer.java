package Reflection.modifyString;


/**
 * Created by Denis on 08.04.2018.
 */
public class VarContainer {

    private String variable;

    public void setVariable(){
        variable = "Hello";
    }

    public void setVariable(String var){
        variable = var;
    }

    public String getVariable(){
        return variable;
    }
}
