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

    public Scorer(Shooter _shooter, Intake _intake, Feeder _feeder) {
        shooter = _shooter;
        intake = _intake;
        feeder = _feeder;
    }

    public void update(boolean yTapped, double rightTrigger, double leftTrigger) {
        shooter.handleInput(yTapped, rightTrigger);

        intake.update(leftTrigger, 0);
    }
}