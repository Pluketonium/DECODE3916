package org.firstinspires.ftc.teamcode.baselevel;

public class Maxspeed {
    private double max;

    public void setMax(double max) { // who cares about explosions
        this.max = max;
    }

    public void setMax(double motor1Power, double motor2Power, double motor3Power, double motor4Power) { // i care about explosions!
        max = Math.max(Math.abs(motor1Power), Math.abs(motor2Power));
        max = Math.max(max, Math.abs(motor3Power));
        max = Math.max(max, Math.abs(motor4Power));
    }
    public double getMax() {
        return max;
    }
}