package org.firstinspires.ftc.teamcode.Autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous
public class MoveForwardAuto extends OpMode {
    public int frameCounter;
    Robot robot = new Robot();
   public void init(){
        robot.init(hardwareMap);
        frameCounter=0;
    }

    @Override
    public void loop() {
        frameCounter++;
        if(frameCounter<100){
            robot.tankDrive.setDrivePowers(1,1);
        }else{
            robot.tankDrive.setDrivePowers(0,0);
        }
    }
}
