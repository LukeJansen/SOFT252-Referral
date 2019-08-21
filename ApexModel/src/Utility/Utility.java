/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

/**
 * Utility Class
 * @author lpjan
 */
public class Utility {
    
    /**
     * Returns the category of a resource from its Dewey Decimal Number
     * @param ddNum Dewey Decimal Number
     * @return Category of Resource
     */
    public static String GetTypeFromDD(float ddNum){
        if (ddNum < 100){
            return "Computer Science, Information & General Works";
        }
        else if (ddNum < 200){
            return "Philosophy and Psychology";
        }
        else if (ddNum < 300){
            return "Religion";
        }
        else if (ddNum < 400){
            return "Social Sciences";
        }
        else if (ddNum < 500){
            return "Language";
        }
        else if (ddNum < 600){
            return "Pure Science";
        }
        else if (ddNum < 700){
            return "Technology";
        }
        else if (ddNum < 800){
            return "Arts & Recreation";
        }
        else if (ddNum < 900){
            return "Literature";
        }
        else if (ddNum < 1000){
            return "History & Geography";
        }
        return "Invalid Dewey Decimal";
    }
    
}
