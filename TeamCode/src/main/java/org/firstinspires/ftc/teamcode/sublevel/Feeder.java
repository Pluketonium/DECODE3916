package org.firstinspires.ftc.teamcode.sublevel;

import com.qualcomm.robotcore.hardware.CRServo;

public class Feeder {
    private CRServo servo;

    public Feeder(CRServo servo) {
        this.servo = servo;
    }

    public void update(double rightTrigger) {
        if (rightTrigger > 0.1) {
            servo.setPower(1.0);
        } else {
            servo.setPower(0.0);
        }
    }
}
