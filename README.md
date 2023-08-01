# Zenzebz - Z Bot Rovers

A squad of robotic rovers are to be landed by Zenzebz on a minefield.  This minefield, which is rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain.

This project allows a controller to control the movements of the rovers in the minefield.
## Technologies
- Java 11

## Features

- Specify the dimensions of the minefield
- Specify the rover's starting position
- Control the rover's movements
- Control the rover's heading
- Obtain the rover's final orientation and co-ordinates
- Navigation validation (ensures the rover does not navigate outside the boundaries of the minefield)
- Sequential deployment of multiple rovers
- Cross platform


## Execution

The approaches to execute the program include but are not limited to:
- Via your preferred IDE
- Via windows prompt

### Windows command prompt
Use the following steps to execute the program via the Windows shell:
- Step 1: Download the ZIP file or clone the repository
- Step 2: Navigate to ```src/main/java```
- Step 3: Execute the following commands

Execute the below command to compile the required java classes.
```bash
javac com/project/nirvan/exceptions/*.java com/project/nirvan/rover/*.java com/project/nirvan/utility/*.java com/project/nirvan/Main.java
```

Run the application by executing the following command
```bash
java com/project/nirvan/Main
```