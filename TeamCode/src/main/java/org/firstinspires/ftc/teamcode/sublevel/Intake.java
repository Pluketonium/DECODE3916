package org.firstinspires.ftc.teamcode.sublevel;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Intake {
    private DcMotor intakeMotor;
    public static final double INTAKE_POWER = 0.1;

    public Intake(DcMotor motor) {
        this.intakeMotor = motor;
    }

    public void update(double rightTrigger, double leftTrigger) {
        if (rightTrigger > 0.1) {
            intakeMotor.setPower(rightTrigger);
        } else {
            intakeMotor.setPower(0.0);
        }
    }

    public void stop() {
        intakeMotor.setPower(0.0);
    }
}
