
package org.firstinspires.ftc.teamcode.toplevel;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Temp.Devhelp;
import org.firstinspires.ftc.teamcode.baselevel.RobotHardware;
import org.firstinspires.ftc.teamcode.baselevel.Maxspeed;
import org.firstinspires.ftc.teamcode.sublevel.Shooter;
import org.firstinspires.ftc.teamcode.sublevel.Intake;
import org.firstinspires.ftc.teamcode.sublevel.Feeder;
import org.firstinspires.ftc.teamcode.input.MecanumDrive;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.sublevel.Shooter;
@TeleOp(name="Maindrive")
public class Maindrive extends LinearOpMode {

    // Declare OpMode members for each of the 4 motors.
    ElapsedTime runtime = new ElapsedTime();
    RobotHardware robot = new RobotHardware();
    Maxspeed driveMaxSpeed = new Maxspeed();
    MecanumDrive driveLogic = new MecanumDrive();
    Scorer scorer;
    Boolean toshot = false;
    Devhelp help = null;

    @Override
    public void runOpMode() {
        help = new Devhelp();
        robot.init(hardwareMap);
        Shooter shooter = new Shooter(robot.shooterMotor);
        Intake intake = new Intake(robot.intakeMotor);
        Feeder feeder = new Feeder(robot.feedServo);
        scorer = new Scorer(shooter, intake, feeder);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            //temp code start!
            robot.angleshot.setPosition(robot.angleshot.getPosition()+(gamepad1.dpad_up?0.001:0.0)-(gamepad1.dpad_down?0.001:0.0));
            robot.shootservo.setPosition(robot.shootservo.getPosition()+(gamepad1.dpad_right?0.001:0.0)-(gamepad1.dpad_left?0.001:0.0));
            robot.contshoot.setPower((gamepad1.dpad_right?0.5:0.0)-(gamepad1.dpad_left?0.5:0.0));

            robot.shootservo.


            //temp code end :<

            driveLogic.calculate(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

            driveMaxSpeed.setMax(driveLogic.frontLeftPower, driveLogic.frontRightPower, driveLogic.backLeftPower, driveLogic.backRightPower);
            double max = driveMaxSpeed.getMax();


            if (max > 1.0) {
                driveLogic.frontLeftPower /= max;
                driveLogic.frontRightPower /= max;
                driveLogic.backLeftPower /= max;
                driveLogic.backRightPower /= max;
            }

            // Send calculated power to wheels
            robot.frontLeft.setPower(driveLogic.frontLeftPower);
            robot.frontRight.setPower(driveLogic.frontRightPower);
            robot.backLeft.setPower(driveLogic.backLeftPower);
            robot.backRight.setPower(driveLogic.backRightPower);

            if (gamepad1.yWasPressed()){toshot=!toshot;}
            //update everything
            scorer.update(toshot, gamepad1.right_trigger, gamepad1.left_trigger);
            // Show the elapsed game time and wheel power.
            telemetry.addData("shoot",toshot);
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Front left/Right", "%4.2f, %4.2f", driveLogic.frontLeftPower, driveLogic.frontRightPower);
            telemetry.addData("Back left/Right", "%4.2f, %4.2f", driveLogic.backLeftPower, driveLogic.backRightPower);
            telemetry.update();
        }
    }
}
