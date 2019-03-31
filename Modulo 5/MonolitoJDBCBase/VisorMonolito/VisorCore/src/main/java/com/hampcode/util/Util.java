package com.hampcode.util;

import java.util.ResourceBundle;


public final class Util {

    private Util(){
    }
    
    public static String getProperty(String clave){
        ResourceBundle rb = ResourceBundle.getBundle("db");
        return rb.getString(clave);
    }
}
