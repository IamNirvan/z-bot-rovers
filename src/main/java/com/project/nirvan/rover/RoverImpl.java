package com.project.nirvan.rover;

import com.project.nirvan.exceptions.IllegalRoverTransformationException;

import java.util.Arrays;

public class RoverImpl implements Rover {
    private static int numOfRovers = 0;
    private final int ID;
    private String orientation;
    private final int[] COORDINATES;
    private final int[][] BOUNDARY;

    public RoverImpl(String orientation, int[] coordinates, int[][] boundary) {
        this.orientation = orientation;
        this.COORDINATES = coordinates;
        BOUNDARY = boundary;
        this.ID = ++ numOfRovers;
    }

    /**
     * Changes the rover's orientation (heading) to one of the 4 cardinal compass points by considering
     * the rover's current orientation.
     * @param rotationByDegrees a rotation by -90 (indicating a left rotation), or 90 (indicating a right rotation)
     * */
    @Override
    public void changeOrientation(int rotationByDegrees) {
        if(this.orientation.equalsIgnoreCase("north")) {
            if(rotationByDegrees == 90) {
                this.orientation = "East";
            }
            else if(rotationByDegrees == -90) {
                this.orientation = "West";
            }
        }
        else if(this.orientation.equalsIgnoreCase("east")) {
            if(rotationByDegrees == 90) {
                this.orientation = "South";
            }
            else if(rotationByDegrees == -90) {
                this.orientation = "North";
            }
        }
        else if(this.orientation.equalsIgnoreCase("south")) {
            if(rotationByDegrees == 90) {
                this.orientation = "West";
            }
            else if(rotationByDegrees == -90) {
                this.orientation = "East";
            }
        }
        else if(this.orientation.equalsIgnoreCase("west")) {
            if(rotationByDegrees == 90) {
                this.orientation = "North";
            }
            else if(rotationByDegrees == -90) {
                this.orientation = "South";
            }
        }
    }

    /**
     * Controls the movement of the rover. Performs validations prior to moving to ensure the rover does not
     * exceed the boundaries of the minefield.
     * @throws IllegalRoverTransformationException when the rover's movement causes it to exceed the minefield's boundaries
     * */
    @Override
    public void move() throws IllegalRoverTransformationException {
        if(this.orientation.equalsIgnoreCase("north")) {
            // Check if the rover's y-axis coordinate will exceed the upper boundary
            if(this.COORDINATES[1] != this.BOUNDARY[1][1]) {
                // Increment y-axis by 1
                this.COORDINATES[1] += 1;
                return;
            }
            throw new IllegalRoverTransformationException(
                String.valueOf(this.ID),
                String.format("Exceeding the upper boundary of the minefield. Cannot move to coordinate (%s, %s)...",
                    this.COORDINATES[0],
                    this.COORDINATES[1] + 1
                )
            );
        }
        else if(this.orientation.equalsIgnoreCase("south")) {
            // Check if the rover's y-axis coordinate will go below the lower boundary
            if(this.COORDINATES[1] != 0) {
                // Decrement y-axis by 1
                this.COORDINATES[1] -= 1;
                return;
            }
            throw new IllegalRoverTransformationException(
                    String.valueOf(this.ID),
                    String.format("Exceeding the lower boundary of the minefield. Cannot move to coordinate (%s, %s)...",
                            this.COORDINATES[0],
                            this.COORDINATES[1] - 1
                    )
            );
        }
        else if(this.orientation.equalsIgnoreCase("west")) {
            // Check if the rover's X-axis coordinate will exceed the left boundary
            if(this.COORDINATES[0] != 0) {
                // Decrement x-axis by 1
                this.COORDINATES[0] -= 1;
                return;
            }
            throw new IllegalRoverTransformationException(
                    String.valueOf(this.ID),
                    String.format("Exceeding the left boundary of the minefield. Cannot move to coordinate (%s, %s)...",
                            this.COORDINATES[0] -1,
                            this.COORDINATES[1]
                    )
            );
        }
        else if(this.orientation.equalsIgnoreCase("east")) {
            // Check if the rover's X-axis coordinate will exceed the right boundary
            if(this.COORDINATES[0] != this.BOUNDARY[1][0]) {
                // Increment x-axis by 1
                this.COORDINATES[0] += 1;
                return;
            }
            throw new IllegalRoverTransformationException(
                    String.valueOf(this.ID),
                    String.format("Exceeding the right boundary of the minefield. Cannot move to coordinate (%s, %s)...",
                            this.COORDINATES[0] + 1,
                            this.COORDINATES[1]
                    )
            );
        }
    }

    @Override
    public String toString() {
        return "Rover " + this.ID + " {"  +
                "\n\t Orientation: " + this.orientation +
                "\n\t Current coordinates: " + Arrays.toString(this.COORDINATES) +
                "\n}\n";
    }
}
