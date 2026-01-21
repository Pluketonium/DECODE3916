package org.firstinspires.ftc.teamcode.sublevel;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


// this class handles everything for the shooter motor, the intake motor, and the feeder servo
public class Shooter {
    private DcMotor shooterMotor;
    private ElapsedTime timer = new ElapsedTime();

    public Shooter(DcMotor motor) {
        shooterMotor = motor;
    }

    public void handleInput(boolean yPressed, double rightTrigger) {
        if (yPressed) {
            shooterMotor.setPower(1.0);

        }else{
            shooterMotor.setPower(0.0);
        }


    }

    public void stop() {
        shooterMotor.setPower(0.0);
    }
}
