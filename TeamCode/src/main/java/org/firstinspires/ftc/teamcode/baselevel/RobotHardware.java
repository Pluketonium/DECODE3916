package org.firstinspires.ftc.teamcode.baselevel;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

public class RobotHardware {
    // declare da hardware
    public DcMotor frontLeft = null;

    public DcMotor backLeft = null;

    public DcMotor frontRight = null;

    public DcMotor backRight = null;

    public DcMotor shooterMotor = null;

    public DcMotor intakeMotor = null;

    public CRServo feedServo = null;
    public Servo shootservo = null;
    public CRServo contshoot = null;
    public Servo angleshot = null;

    public void init(HardwareMap myHardwareMap) {

        frontLeft = myHardwareMap.get(DcMotor.class, "front_left");
        backLeft = myHardwareMap.get(DcMotor.class, "back_left");
        frontRight = myHardwareMap.get(DcMotor.class, "front_right");
        backRight = myHardwareMap.get(DcMotor.class, "back_right");
        shooterMotor = myHardwareMap.get(DcMotor.class, "smd");
        intakeMotor = myHardwareMap.get(DcMotor.class, "intake");
        feedServo = myHardwareMap.get(CRServo.class, "feeder");

        shootservo = myHardwareMap.get(Servo.class, "shoots");
        contshoot = myHardwareMap.get(CRServo.class, "contshoot");
        angleshot = myHardwareMap.get(Servo.class,"ashot");



        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.REVERSE);
        shooterMotor.setDirection(DcMotor.Direction.REVERSE);
        intakeMotor.setDirection(DcMotor.Direction.FORWARD);

        // stop motors for safety
        frontLeft.setPower(0.0);
        backLeft.setPower(0.0);
        frontRight.setPower(0.0);
        backRight.setPower(0.0);
        shooterMotor.setPower(0.0);
        intakeMotor.setPower(0.0);
        feedServo.setPower(0.0);
        shootservo.setPosition(0.5);
        angleshot.setPosition(0.5);

        contshoot.setPower(0.0);

    }
}
