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
        RightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        LeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    public void setDrivePowers(double rightPower, double leftPower){
        RightMotor.setPower(rightPower);
        LeftMotor.setPower(leftPower);
    }
}
