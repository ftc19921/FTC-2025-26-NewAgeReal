package org.firstinspires.ftc.teamcode.Autos;

import static java.lang.System.nanoTime;

import android.telephony.SmsManager;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Mechinisms.Shooter;
import org.firstinspires.ftc.teamcode.Mechinisms.TankDrive;
import org.firstinspires.ftc.teamcode.Robot;

public class AutoScore extends OpMode {
    boolean end;
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
        telemetry.addData("Distance to target: ",distanceToTarget);
        fireThisMany(1,0.5);
        fireThisMany(2,1);
    }

    public void MoveDistanceAwayFromTarget(double Power,double Distance /*in Inches*/){
        while(Distance>distanceToTarget) {
            if (robot.limeLight.detectID() == -1) {
                end = true;
                break;
            } else {
                robot.tankDrive.setDrivePowers(Power,Power);
            }
        }
        while(Distance<distanceToTarget){
            if (robot.limeLight.detectID() == -1) {
                end = true;
                break;
            } else {
                robot.tankDrive.setDrivePowers(-Power,-Power);
            }
        }
    }
    public void fireThisMany(double ArtifactsToFire, double power){
        while(ArtifactsToFire>0){
            robot.shooters.spinUpShooter(power);
            waitToSpin(2);
            robot.shooters.fire();
            waitToSpin(2);
            robot.shooters.spinUpShooter(0);
            ArtifactsToFire--;
        }
    }
    public double getDistanceFromPercent(double Percent){
        //screenArea = distanceToTarget*(distanceToTarget*0.75);
            //targetArea = 36;//Inches squared
                //percentScreenOfTarget = (targetArea/screenArea)*100;
                    //percentScreenOfTarget/100 = (targetArea/screenArea)
                        //(100*targetArea)/percentScreenOfTarget = screenArea
                            //(3600)/percentScreenOfTarget = distanceToTarget*(distanceToTarget*0.75);
                                //3600/percentScreenOfTarget = distanceToTarget^2
        return(Math.sqrt(3600/(percentScreenOfTarget*0.75)));
    }

    public void waitToSpin(double Time){
        Time=Time*System.nanoTime()*1000000000;
        while(Time>0){
            Time--;
        }
    }
}



