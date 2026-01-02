package org.firstinspires.ftc.teamcode.Autos;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Robot;

public class AutoScore extends OpMode {

    double percentScreenOfTarget;
    //(In inches)
    double distanceToTarget;
    //(In inches)
    double screenArea;
    //(In inches squared)
    double targetArea;
    //(In inches squared)

    public Robot robot = new Robot();

    @Override
    public void init(){
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        percentScreenOfTarget = robot.limeLight.LookTa();
        distanceToTarget = getDistanceFromPercent(percentScreenOfTarget);
    }
    public double getDistanceFromPercent(double Percent){
        //screenArea = distanceToTarget*(distanceToTarget*0.75);
        //targetArea = 36;//Inches squared
        //percentScreenOfTarget = (targetArea/screenArea)*100;

        //percentScreenOfTarget/100 = (targetArea/screenArea)
        //(100*targetArea)/percentScreenOfTarget = screenArea
        //(3600)/percentScreenOfTarget = distanceToTarget*(distanceToTarget*0.75);
        //3600/percentScreenOfTarget =


        return(Percent);
    }
}



