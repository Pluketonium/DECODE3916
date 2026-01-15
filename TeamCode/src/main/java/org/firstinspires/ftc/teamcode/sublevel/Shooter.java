package org.firstinspires.ftc.teamcode.sublevel;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


// this class handles everything for the shooter motor, the intake motor, and the feeder servo
public class Shooter {
    private DcMotor shooterMotor;
    private ElapsedTime timer = new ElapsedTime();

    private boolean inSpinningSequence = false;
    private double currentPower = 0;

    public Shooter(DcMotor motor) {
        this.shooterMotor = motor;
    }

    public void handleInput(boolean yPressed, double rightTrigger) {
        if (yPressed) {
            inSpinningSequence = !inSpinningSequence;
            if (inSpinningSequence) {
                timer.reset();
            }
        }

        if (inSpinningSequence) {
            double seconds = timer.seconds();

            if (seconds <= 8.0) {
                currentPower = 1.0;
            } else if (seconds > 8.0 && seconds <= 12.0) {
                double fade = (seconds - 8.0) / 4.0;
                currentPower = 1.0 - (fade * 0.5);
            } else {
                currentPower = 0.5;
            }
        }

        if (rightTrigger > 0.1) {
            shooterMotor.setPower(1.0);
        } else {
            shooterMotor.setPower(currentPower);
        }
    }

    public void stop() {
        shooterMotor.setPower(0.0);
    }
}
