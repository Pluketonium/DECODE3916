package org.firstinspires.ftc.teamcode.sublevel;

import org.firstinspires.ftc.teamcode.input.MecanumDrive;

public class Rotate {
    MecanumDrive driveTrain = new MecanumDrive();
    public void rotateRobot(double degrees) {
        double axial = 0;
        axial = degrees * ((double) 1 / 360);
        driveTrain.calculate(axial, 0, 0);
    }
}
