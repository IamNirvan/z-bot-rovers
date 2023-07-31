package com.project.nirvan.rover;

import com.project.nirvan.exceptions.IllegalRoverTransformationException;
import com.project.nirvan.rover.RoverImpl;

import java.util.Arrays;

public class RoverHandler {
    private final RoverImpl ROVER;
    private final String[] TRANSFORMATIONS;

    public RoverHandler(RoverImpl rover, String[] transformations) {
        this.ROVER = rover;
        this.TRANSFORMATIONS = transformations;
    }

    public RoverImpl getRover() {
        return ROVER;
    }

    public void applyTransformations() {
        try {
            for(String transformation: this.TRANSFORMATIONS) {
                if(transformation.equalsIgnoreCase("M")) {
                    // Move rover
                    this.ROVER.move();
                }
                else {
                    // Change rover orientation
                    if(transformation.equalsIgnoreCase("L")) {
                        this.ROVER.changeOrientation(-90);
                    }
                    else {
                        this.ROVER.changeOrientation(90);
                    }
                }
            }
        }
        catch (IllegalRoverTransformationException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return "RoverHandler{" +
                "rover=" + ROVER +
                ", transformations=" + Arrays.toString(TRANSFORMATIONS) +
                '}';
    }
}
