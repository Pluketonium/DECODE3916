package org.firstinspires.ftc.teamcode.sublevel;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Feeder {
    private CRServo feeder;
    public Feeder(CRServo feeder) {
        this.feeder = feeder;
    }

    public void update(double rightTrigger) {
        if (rightTrigger > 0.1) {
            feeder.setPower(rightTrigger);
        } else {
            stop();
        }
    }

    public void stop() {
        feeder.setPower(0.0);
    }
}
