package com.project.nirvan.utility;

import com.project.nirvan.exceptions.MinefieldDimensionException;

import java.util.Scanner;

public class Utility {
    public static boolean validateCoordinate(int coordinate, int lowerBound) {
        return coordinate <= lowerBound;
    }

    public static boolean validateCoordinate(int coordinate, int lowerBound, int upperBound) {
        return coordinate < lowerBound || coordinate > upperBound;
    }


    public static String translateOrientation(String orientation) {
        if(orientation.equalsIgnoreCase("north") || orientation.equalsIgnoreCase("n")) {
            return "north";
        }
        else if(orientation.equalsIgnoreCase("east") || orientation.equalsIgnoreCase("e")) {
            return "east";
        }
        else if(orientation.equalsIgnoreCase("west") || orientation.equalsIgnoreCase("w")) {
            return "west";
        }
        else if(orientation.equalsIgnoreCase("south") || orientation.equalsIgnoreCase("s")) {
            return "south";
        }
        return null;
    }

    public static boolean validateTransformations(String[] transformations) {
        for(String transformation: transformations) {
            if(!transformation.equalsIgnoreCase("l") && !transformation.equalsIgnoreCase("r") &&
                    !transformation.equalsIgnoreCase("m")) {
                return false;
            }
        }
        return true;
    }

    public static void showLogo() {
        System.out.println("""
               \n
               \t|||||||||||                 ||||||||\\\\\\          ///||||||||\\\\\\  ||||||||||||||| 
               \t       ///                  |||      \\\\\\        ///          \\\\\\       ||| 
               \t      ///                   |||      |||       |||            |||      |||
               \t     ///                    |||      ///       |||            |||      ||| 
               \t    ///      |||||||||      |||||||||||        |||            |||      |||
               \t   ///                      |||      \\\\\\       |||            |||      |||          
               \t  ///                       |||      |||       |||            |||      |||
               \t ///                        |||      ///        \\\\\\          ///       |||
               \t|||||||||||                 ||||||||///          \\\\\\||||||||///        |||
                """);
        System.out.print(" \tProtected by Copyright ");
        System.out.print(Character.toString(169));
        System.out.print(" 2023. All rights reserved.\n");
    }


}
