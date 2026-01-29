package org.firstinspires.ftc.teamcode.toplevel;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.sublevel.Intake;
import org.firstinspires.ftc.teamcode.sublevel.Shooter;

public class Scorer {
    private Shooter shooter;
    private Intake intake;

    public Scorer(Shooter _shooter, Intake _intake) {
        shooter = _shooter;
        intake = _intake;
    }

    public void update(boolean yTapped, double rightTrigger) {
        shooter.handleInput(yTapped, rightTrigger);

        intake.update(rightTrigger);
    }
}