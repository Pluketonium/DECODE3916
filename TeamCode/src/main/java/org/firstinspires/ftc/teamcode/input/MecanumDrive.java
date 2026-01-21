package org.firstinspires.ftc.teamcode.input;

public class MecanumDrive {
    public double frontLeftPower, backLeftPower, frontRightPower, backRightPower;
    public double flMulti = 1.0;
    public double blMulti = 1.0;
    public double frMulti = 1.0;
    public double brMulti = 1.0;

    public void calculate(double axial, double lateral, double yaw) {
        frontLeftPower = (axial + lateral + yaw) * flMulti;
        backLeftPower = (axial - lateral - yaw) * blMulti;
        frontRightPower = (axial - lateral + yaw) * frMulti;
        backRightPower = (axial + lateral - yaw) * brMulti;
    }

}
