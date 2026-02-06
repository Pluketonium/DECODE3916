package org.firstinspires.ftc.teamcode.sublevel;

import org.firstinspires.ftc.teamcode.baselevel.RobotHardware;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Rotate {
    private RobotHardware robot;

    public Rotate(RobotHardware _robot) {
        robot = _robot;
    }

    public void rotateToAngle(double target, double power) {
        robot.imu.resetYaw();

        double currentAngle = 0;

        while (Math.abs(target - currentAngle) > 3.14159) {
            currentAngle = robot.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);

            if (target > currentAngle) {
                setTurnPower(power);
            } else {
                setTurnPower(-power);
            }

            setTurnPower(0);
        }
    }

    private void setTurnPower(double p) {
        robot.frontLeft.setPower(p);
        robot.backLeft.setPower(p);
        robot.frontRight.setPower(-p);
        robot.backRight.setPower(-p);
    }
}
