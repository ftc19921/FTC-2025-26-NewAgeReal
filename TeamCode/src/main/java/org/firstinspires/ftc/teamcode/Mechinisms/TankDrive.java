package org.firstinspires.ftc.teamcode.Mechinisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.R;

public class TankDrive {
    DcMotor RightMotor;
    DcMotor LeftMotor;
    public void init(HardwareMap hardwareMap) {
        RightMotor = hardwareMap.get(DcMotor.class,"3");
        LeftMotor = hardwareMap.get(DcMotor.class, "ex0");
        LeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        LeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    public void setDrivePowers(double rightPower, double leftPower){
        RightMotor.setPower(rightPower);
        LeftMotor.setPower(leftPower);
    }

    public void driveUsingEncoders(double DistanceRight,double DistanceLeft,double Speed){
        while(DistanceLeft>Math.abs(LeftMotor.getCurrentPosition())||DistanceRight>Math.abs(RightMotor.getCurrentPosition())){
            if(DistanceLeft>Math.abs(LeftMotor.getCurrentPosition())){
                LeftMotor.setPower(Speed);
            }
            if(DistanceRight>Math.abs(RightMotor.getCurrentPosition())){
                RightMotor.setPower(Speed);
            }
        }
        RightMotor.setPower(0);
        LeftMotor.setPower(0);
        RightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
}
