package org.firstinspires.ftc.teamcode.Temp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.function.BooleanSupplier;

public class Devhelp {
    public void bindmotor(HardwareMap hardwareMap, String Motor, BooleanSupplier button, Boolean forward, BooleanSupplier running){
        DcMotor temp = hardwareMap.get(DcMotor.class, Motor);
        temp.setDirection(forward? DcMotor.Direction.FORWARD: DcMotor.Direction.REVERSE);
        while (running.getAsBoolean()){
            temp.setPower(button.getAsBoolean()?1.0:0);
        }
    }
}
