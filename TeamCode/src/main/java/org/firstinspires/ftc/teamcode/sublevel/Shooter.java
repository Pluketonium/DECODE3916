package org.firstinspires.ftc.teamcode.sublevel;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


// this class handles everything for the shooter motor, the intake motor, and the feeder servo
public class Shooter {
    private DcMotor shooterMotor;

    public Shooter(DcMotor motor) {
        this.shooterMotor = motor;
    }

    public void handleInput(boolean yPressed) {
        if (yPressed) {
            shooterMotor.setPower(1.0);
        } else {
            stop();
        }
    }

    public void stop() {
        shooterMotor.setPower(0.0);
    }
}
