package lab5;

import java.util.regex.Pattern;

public class RegEx {

    static boolean arrTimeCheck(String in)
    {

        if(Pattern.matches("^[0-3][0-9].[0-1][0-2].[0-2][0-9][0-9][0-9]$", in))
            return true;
        else return false;
    }
    static boolean depTimeCheck(String in)
    {

        if(Pattern.matches("^[0-3][0-9].[0-1][0-2].[0-2][0-9][0-9][0-9]$", in))
            return true;
        else return false;
    }
    static boolean stationNameCheck(String in){
        if (Pattern.matches("\\D", in))
            return true;
        else return false;
    }
    static boolean numberCheck (String in){
        if (Pattern.matches("\\d", in))
            return true;
        else return false;
    }
}