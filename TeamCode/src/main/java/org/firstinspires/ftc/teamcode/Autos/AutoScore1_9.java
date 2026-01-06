package org.firstinspires.ftc.teamcode.Autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Robot;
@Autonomous
public class AutoScore1_9 extends OpMode {
    boolean end;
    double percentScreenOfTarget;
    //(In inches)
    double distanceToTarget;
    //(In inches)


    public Robot robot = new Robot();

    @Override
    public void init(){
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {


        distanceToTarget = getDistanceFromPercent(percentScreenOfTarget);


        fireThisMany(1,0.5);
        moveBackTillTargetIsSeen(0.5);
        moveDistanceAwayFromTarget(0.5,71);
        waitToSpin(30-getRuntime());
    }

    public void moveDistanceAwayFromTarget(double Power, double Distance /*in Inches*/){
        while(Distance>distanceToTarget) {

            if (robot.limeLight.LookTx() == 0) {

                break;
            } else {
                robot.tankDrive.setDrivePowers(-Power,-Power);
            }
        }
        while(Distance<distanceToTarget){

            if (robot.limeLight.LookTx() == 0) {

                break;
            } else {
                robot.tankDrive.setDrivePowers(Power,Power);
            }
        }
        robot.tankDrive.setDrivePowers(0,0);
    }

    public void moveBackTillTargetIsSeen(double Power){
        while(robot.limeLight.LookTx() == 0){

            robot.tankDrive.setDrivePowers(-Power,-Power);
        }
        robot.tankDrive.setDrivePowers(0,0);
    }
    public void faceTowardsTarget(double Power){
        while(robot.limeLight.LookTy() == 0){
            robot.tankDrive.setDrivePowers(Power,-Power);
        }
        while(robot.limeLight.LookTy()>0){

            if (robot.limeLight.LookTx() == 0) {

                break;
            } else {

                robot.tankDrive.setDrivePowers(Power,-Power);
            }
        }
        while(robot.limeLight.LookTy()<0){
            if (robot.limeLight.LookTx() == 0) {

                break;
            } else {

                robot.tankDrive.setDrivePowers(-Power,Power);
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
            double waitStartTime = getRuntime();
        while(getRuntime()<(waitStartTime+Time)){


        }
    }
}