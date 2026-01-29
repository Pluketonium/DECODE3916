package org.firstinspires.ftc.teamcode.toplevel;

import org.firstinspires.ftc.teamcode.sublevel.Intake;
import org.firstinspires.ftc.teamcode.sublevel.Rotate;
import org.firstinspires.ftc.teamcode.sublevel.Shooter;

public class Autonomous {
    private Shooter shooter;
    private Intake intake;
    private Rotate rotate;
    public Autonomous(Intake _intake, Shooter _shooter, Rotate _rotate) {
        shooter = _shooter;
        intake = _intake;
        rotate = _rotate;
    }
    public void update() {

    }
}
