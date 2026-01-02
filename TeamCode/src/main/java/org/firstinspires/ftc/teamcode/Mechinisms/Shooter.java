package org.firstinspires.ftc.teamcode.Mechinisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter {

    DcMotorEx shooterMotor;
    DcMotor intakeMotor;
    DcMotor actuatorMotor;

    public void init(HardwareMap hardwareMap){
        shooterMotor = hardwareMap.get(DcMotorEx.class,"0");
        intakeMotor = hardwareMap.get(DcMotor.class,"1");
        actuatorMotor = hardwareMap.get(DcMotor.class,"2");
        shooterMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void spinUpShooter(double power){
        shooterMotor.setVelocity(1400);

    }

    public void spinDown(){
        shooterMotor.setVelocity(0);
    }

    public void intake(){
        intakeMotor.setPower(1);
    }

    public void outake(){intakeMotor.setPower(-1);}
    public void fire(){
        actuatorMotor.setPower(-1);
    }

    public void stopIntaking(){
        intakeMotor.setPower(0);
    }
    public void stopFiring(){
        actuatorMotor.setPower(0);
    }

}
