package com.project.nirvan;

import com.project.nirvan.exceptions.IllegalRoverTransformationException;
import com.project.nirvan.exceptions.MinefieldDimensionException;
import com.project.nirvan.rover.RoverHandler;
import com.project.nirvan.rover.RoverImpl;
import com.project.nirvan.utility.Utility;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int roverCount = 1;
        ArrayList<RoverHandler> rovers = new ArrayList<>();
        Utility.showLogo();

        try(Scanner scanner = new Scanner(System.in)) {
            int[][] boundary = initializeMinefield(scanner);
            if (boundary == null) {
                return;
            }

            while(true) {
                if(roverCount > 1) {
                    System.out.print("\nEnter (x) to exit (p) to proceed: ");
                    if(scanner.nextLine().equalsIgnoreCase("x")) {
                        break;
                    }
                }
                System.out.println("");
                //
                // Get rover's starting coordinates and heading
                //
                System.out.print("[Rover #" + roverCount + "] starting coordinates and heading (separated by whitespace): ");
                String[] position = scanner.nextLine().split(" ");

                if(position.length != 3) {
                    throw new IllegalRoverTransformationException("Invalid starting position arguments");
                }

                int xCoordinate = Integer.parseInt(position[0]);
                int yCoordinate = Integer.parseInt(position[1]);
                int[] roverCoordinates = {xCoordinate, yCoordinate};
                String orientation = Utility.translateOrientation(position[2]);
                //
                // Validate starting position and heading
                //
                if (Utility.validateCoordinate(xCoordinate, boundary[0][0], boundary[1][0])) {
                    throw new IllegalRoverTransformationException("Invalid starting x-axis coordinate.");
                }
                if (Utility.validateCoordinate(yCoordinate, boundary[0][1], boundary[1][1])) {
                    throw new IllegalRoverTransformationException("Invalid starting y-axis coordinate.");
                }
                else if (orientation == null) {
                    throw new IllegalRoverTransformationException("Invalid heading");
                }
                //
                // Get movements
                //
                System.out.print("[Rover #" + roverCount + "] movements: ");
                String[] transformations = scanner.nextLine().split("");
                //
                // Validate movements
                //
                if(!Utility.validateTransformations(transformations)) {
                    throw new IllegalRoverTransformationException("Invalid movement detected. Can only include L,R,M");
                }
                //
                // Create Rover Handler
                //
                RoverHandler handler = new RoverHandler(
                        new RoverImpl(orientation, roverCoordinates, boundary),
                        transformations
                );
                rovers.add(handler);
                roverCount ++;
            }
            //
            // Make the rovers move and/or rotate
            //
            rovers.forEach(RoverHandler::applyTransformations);
            System.out.println("\n\nFinal position of each rover\n");
            rovers.forEach(roverHandler -> System.out.println(roverHandler.getRover()) );
        }
        catch(Exception ex) {
            if(ex.getMessage() == null) {
                System.err.println((ex));
            }
            else {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static int[][] initializeMinefield(Scanner scanner) throws MinefieldDimensionException {
        System.out.print("\nEnter the minefield's left and top boundary coordinates (separated by whitespace): ");
        String[] position = scanner.nextLine().split(" ");

        if(position.length != 2) {
            throw new MinefieldDimensionException("Invalid boundary coordinates");
        }

        int xAxisCoordinate = Integer.parseInt(position[0]);
        int yAxisCoordinate = Integer.parseInt(position[1]);

        if(Utility.validateCoordinate(xAxisCoordinate, 1)) {
            throw new MinefieldDimensionException("x-axis coordinate must be greater than 1");
        }
        if(Utility.validateCoordinate(yAxisCoordinate, 1)) {
            throw new MinefieldDimensionException("y-axis coordinate must be greater than 1");
        }

        System.out.println("\nInitializing minefield dimensions...");
        System.out.println("Setting lower boundary coordinates to [0, 0]");
        System.out.println(String.format("Setting upper boundary coordinates to [%s, %s]",
                xAxisCoordinate, yAxisCoordinate)
        );

        return new int[][] { {0, 0}, {xAxisCoordinate, yAxisCoordinate} };
    }
}