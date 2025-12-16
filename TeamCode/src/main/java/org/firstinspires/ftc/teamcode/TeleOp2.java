package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Mechinisms.Shooter;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp2 extends OpMode {
    Robot robot = new Robot();
    double power;
    boolean leftPressed;
    boolean rightPressed;
    @Override
    public void init() {
        robot.init(hardwareMap);
        leftPressed = false;
        rightPressed = false;
    }

    @Override
    public void loop() {

        robot.tankDrive.setDrivePowers(gamepad1.right_stick_y-gamepad2.right_stick_y,gamepad1.left_stick_y-gamepad2.left_stick_y);

        if(gamepad2.right_bumper&&!rightPressed){
            power++;
            rightPressed = true;
        }
        if(!gamepad2.right_bumper){
            rightPressed = false;
        }

        if(gamepad2.left_bumper&&!leftPressed){
            power--;
            leftPressed = true;
        }
        if(!gamepad2.left_bumper){
            leftPressed = false;
        }
        if(gamepad2.a){
            robot.shooters.spinUpShooter(-1);
        }else{
            robot.shooters.spinDown();
        }
        if(gamepad2.right_trigger>0){
            robot.shooters.fire();
        }else{
            robot.shooters.stopFiring();
        }
        if(gamepad1.right_trigger>0){
            robot.shooters.intake();
        }else{
            robot.shooters.stopIntaking();
        }



        if(gamepad2.dpad_up&&gamepad2.y){
            if(gamepad2.b){
            robot.stilts.ascend(1);
            }
            else{
                robot.stilts.ascend(-1);
            }
        }
        if(gamepad2.x){
            robot.stilts.stop();
        }

        telemetry.addData("Shooter Power: %",power*10);



    }
}
