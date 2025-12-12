package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

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
        if(gamepad1.right_trigger>0&&!rightPressed){
            power++;
            rightPressed = true;
        }
        if(gamepad1.right_trigger==0){
            rightPressed = false;
        }

        if(gamepad1.left_trigger>0&&!leftPressed){
            power--;
            leftPressed = true;
        }
        if(gamepad1.left_trigger==0){
            leftPressed = false;
        }
        if(gamepad1.a){
            robot.shooters.fireShooter(4,power/10);
        }
        telemetry.addData("Shooter Power: %",power*10);
        telemetry.addData("Tx: ",robot.limeLight.LookTx());


    }
}
