package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOpMk4 extends OpMode {
    Robot robot = new Robot();
    double power;
    boolean leftPressed;
    boolean rightPressed;
    @Override
    public void init() {
        robot.init(hardwareMap);
        leftPressed = false;
        rightPressed = false;
        power = 5;
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
            robot.shooters.spinUpShooter((power/10));
        }else if(gamepad2.left_trigger>0)
        {
            robot.shooters.spinUpShooter(-power/10);
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
        }else if (gamepad1.left_trigger>0){
           robot.shooters.outtake();
        }else{
            robot.shooters.stopIntaking();
        }



        if(gamepad2.dpad_up&&gamepad2.y){
            if(gamepad2.b){
            robot.stilts.ascend(0.5);
            }
            else{
                robot.stilts.ascend(-0.5);
            }
        }else{
            robot.stilts.stop();
        }


        telemetry.addData("Shooter Power: %",power*10);



    }
}
