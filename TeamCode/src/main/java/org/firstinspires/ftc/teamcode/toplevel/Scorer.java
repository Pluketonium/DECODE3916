package org.firstinspires.ftc.teamcode.toplevel;

import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.sublevel.Shooter;
import org.firstinspires.ftc.teamcode.sublevel.Intake;

public class Scorer {
    private Shooter shooter;
    private Intake intake;
    private ElapsedTime triggerTimer = new ElapsedTime();
    private boolean isTriggerActive = false;

    public Scorer(Shooter _shooter, Intake _intake) {
        shooter = _shooter;
        intake = _intake;
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
        } else {
            isTriggerActive = false;

            intake.update(leftTrigger, 0);
        }
    }
}