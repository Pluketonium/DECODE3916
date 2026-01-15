package org.firstinspires.ftc.teamcode.toplevel;

import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.sublevel.Shooter;
import org.firstinspires.ftc.teamcode.sublevel.Intake;
import org.firstinspires.ftc.teamcode.sublevel.Feeder;

public class Scorer {
    private Shooter shooter;
    private Intake intake;
    private Feeder feeder;
    private ElapsedTime triggerTimer = new ElapsedTime();
    private boolean isTriggerActive = false;

    public Scorer(Shooter shooter, Intake intake, Feeder feeder) {
        this.shooter = shooter;
        this.intake = intake;
        this.feeder = feeder;
    }

    public void update(boolean yTapped, double rightTrigger, double leftTrigger) {
        shooter.handleInput(yTapped, rightTrigger);

        if (rightTrigger > 0.1) {
            if (!isTriggerActive) {
                triggerTimer.reset();
                isTriggerActive = true;
            }

            double elapsed = triggerTimer.seconds();

            intake.update(0, rightTrigger);

            if (elapsed > 0.5) {
                feeder.update(rightTrigger);
            } else {
                feeder.update(0);
            }
        } else {
            isTriggerActive = false;
            feeder.update(0);

            intake.update(leftTrigger, 0);
        }
    }
}