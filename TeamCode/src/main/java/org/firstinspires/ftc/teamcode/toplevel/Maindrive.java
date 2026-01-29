/* Copyright (c) 2021 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.baselevel.RobotHardware;
import org.firstinspires.ftc.teamcode.baselevel.Maxspeed;
import org.firstinspires.ftc.teamcode.sublevel.Shooter;
import org.firstinspires.ftc.teamcode.sublevel.Intake;
import org.firstinspires.ftc.teamcode.toplevel.Autonomous;
import org.firstinspires.ftc.teamcode.toplevel.Scorer;
import org.firstinspires.ftc.teamcode.sublevel.Rotate;
import org.firstinspires.ftc.teamcode.input.MecanumDrive;

import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name="Maindrive")
public class Maindrive extends LinearOpMode {

    // Declare OpMode members for each of the 4 motors.
    ElapsedTime runtime = new ElapsedTime();
    RobotHardware robot = new RobotHardware();
    Maxspeed driveMaxSpeed = new Maxspeed();
    MecanumDrive driveLogic = new MecanumDrive();
    Rotate rotateThingy = new Rotate();
    Scorer scorer;
    Autonomous autonomous;
    Devhelp help = null;

    @Override
    public void runOpMode() {
        help = new Devhelp();
        robot.init(hardwareMap);
        Shooter shooter = new Shooter(robot.shooterMotor);
        Intake intake = new Intake(robot.intakeMotor);
        scorer = new Scorer(shooter, intake);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            driveLogic.calculate(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

            driveMaxSpeed.setMax(driveLogic.frontLeftPower, driveLogic.frontRightPower, driveLogic.backLeftPower, driveLogic.backRightPower);
            double max = driveMaxSpeed.getMax();

            if (gamepad1.xWasPressed()) {
                rotateThingy.rotateRobot(90);
            }


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

            scorer.update(gamepad1.y, gamepad1.right_trigger, gamepad1.left_trigger);
            autonomous.update();

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Front left/Right", "%4.2f, %4.2f", driveLogic.frontLeftPower, driveLogic.frontRightPower);
            telemetry.addData("Back left/Right", "%4.2f, %4.2f", driveLogic.backLeftPower, driveLogic.backRightPower);
            telemetry.update();
        }
    }
}
