package com.stang.game.util;

import java.util.HashMap;  
import java.util.Map;  
  
/** 
 * User: pdc738 Date: 06.22, 2010 Time: 3:36:20 PM  
 * To Encoder special character. 
 * If you want to insert binary data into a string column (such as a BLOB column), the following characters must be represented by escape sequences.  
       NUL NUL byte (0x00). Represent this character by “\0” (a backslash followed by an ASCII “0” character).  
       \ Backslash (ASCII 92). Represent this character by “\\”.  
       ' Single quote (ASCII 39). Represent this character by “\'”.  
       " Double quote (ASCII 34). Represent this character by “\"”.   
 * Within a string, certain sequences have special meaning unless the NO_BACKSLASH_ESCAPES SQL mode is enabled. Each of these sequences begins with 
   a backslash (“\”), known as the escape character. MySQL recognizes the following escape sequences in referencesMap 
 */  
  
public class MYSQLEncoder {  
      
    private static Map<String,String> referencesMap = new HashMap<String,String>();  
  
    static{  
        referencesMap.put("'","\\'");  
        referencesMap.put("\"","\\\"");  
        referencesMap.put("\\","\\\\");  
          
        referencesMap.put("\n","\\\n");  
        referencesMap.put("\0","\\\0");  
        referencesMap.put("\b","\\\b");  
        referencesMap.put("\r","\\\r");  
        referencesMap.put("\t","\\\t");  
        referencesMap.put("\f","\\\f");  
    }  
      
    //escape sql tag with the source code.  
    public static String encode(String source) {  
        if (source == null)  
            return "";  
          
        StringBuffer sbuffer = new StringBuffer(source.length());  
          
        for (int i = 0; i < source.length(); i++) {  
            String c = source.substring(i,i+1);  
              
            //System.out.println("c=" + c);  
            //System.out.println(referencesMap.get(c));  
              
            if (referencesMap.get(c) != null) {  
                sbuffer.append(referencesMap.get(c));  
            } else {  
                sbuffer.append(c);  
            }  
        }  
        return sbuffer.toString();  
    }  
      
    public static void main(String[] args){  
        String tt = encode("They'are \"ok\". \\a");  
        String test = "[{\"one\":0,\"two\":0,\"three\":0,\"four\":0}]";
        test = encode(test);
        System.out.print(test);  
    }  
} 
