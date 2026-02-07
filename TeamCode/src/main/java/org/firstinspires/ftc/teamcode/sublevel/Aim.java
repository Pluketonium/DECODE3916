package org.firstinspires.ftc.teamcode.sublevel;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Aim {
    private CRServo aim1;
    private CRServo aim2;

    public Aim(CRServo _aim1, CRServo _aim2) {aim1 = _aim1; aim2 = _aim2;}

    public void update(boolean bumperL, boolean bumperR) {
        if (bumperL && !bumperR) {
            aim1.setPower(-0.1);
            aim2.setPower(-0.1);
        } else if (bumperR && !bumperL) {
            aim1.setPower(0.1);
            aim2.setPower(0.1);
        } else {
            aim1.setPower(0.0);
            aim2.setPower(0.0);
        }
    }
}
