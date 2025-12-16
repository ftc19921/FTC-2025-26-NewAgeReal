package org.firstinspires.ftc.teamcode.Mechinisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TankDrive {
    DcMotor RightMotor;
    DcMotor LeftMotor;
    public void init(HardwareMap hardwareMap) {
        RightMotor = hardwareMap.get(DcMotor.class,"3");
        LeftMotor = hardwareMap.get(DcMotor.class, "ex0");
    }
    public void setDrivePowers(double rightPower, double leftPower){
        RightMotor.setPower(rightPower);
        LeftMotor.setPower(leftPower);
    }
}
