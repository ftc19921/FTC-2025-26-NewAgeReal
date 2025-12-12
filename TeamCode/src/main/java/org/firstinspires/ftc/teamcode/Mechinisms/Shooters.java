package org.firstinspires.ftc.teamcode.Mechinisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooters {

    DcMotor shooter1FirstMotor;
    DcMotor shooter1SecondMotor;
    DcMotor shooter2;
    DcMotor shooter3;
    public void init(HardwareMap hardwareMap){
        shooter1FirstMotor = hardwareMap.get(DcMotor.class,"0");
        shooter1SecondMotor = hardwareMap.get(DcMotor.class,"1");
        shooter2 = hardwareMap.get(DcMotor.class,"2");
        shooter3 = hardwareMap.get(DcMotor.class,"3");
    }
    public void fireShooter(int ShooterToFire, double power){
        if(ShooterToFire == 1){
        shooter1FirstMotor.setPower(power);
        shooter1SecondMotor.setPower(-power);
        }else if(ShooterToFire == 2){
            shooter2.setPower(power);
        }else if(ShooterToFire == 3){
            shooter3.setPower(power);
        }else{
            shooter1SecondMotor.setPower(power);
            shooter1SecondMotor.setPower(-power);
            shooter2.setPower(power);
            shooter3.setPower(power);
        }
    }

    public void stopFiring(int shooterToStop){
        if(shooterToStop == 1){
            shooter1FirstMotor.setPower(0);
            shooter1SecondMotor.setPower(0);
        } else if (shooterToStop == 2) {
            shooter2.setPower(0);
        }else{
            shooter3.setPower(0);
        }
    }

}
