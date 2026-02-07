package org.firstinspires.ftc.teamcode.toplevel;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.sublevel.Feeder;
import org.firstinspires.ftc.teamcode.sublevel.Intake;
import org.firstinspires.ftc.teamcode.sublevel.Shooter;

public class Scorer {
    private Shooter shooter;
    private Intake intake;
    private Feeder feeder;

    public Scorer(Shooter _shooter, Intake _intake) {
        shooter = _shooter;
        intake = _intake;
    }

    public void update(boolean yTapped, double rightTrigger, double leftTrigger) {
        shooter.handleInput(yTapped);

        intake.update(rightTrigger);

        feeder.update(leftTrigger);
    }
}