package org.firstinspires.ftc.teamcode.Mechinisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Stilts {

    DcMotor StiltRight;
    DcMotor StiltLeft;

    public void init(HardwareMap hardwareMap){
        StiltLeft = hardwareMap.get(DcMotor.class,"ex1");
        StiltRight = hardwareMap.get(DcMotor.class,"ex2");
    }

    public void ascend(double power){
        StiltLeft.setPower(power);
        StiltRight.setPower(-power);
    }

    public void stop(){
        StiltRight.setPower(0);
        StiltLeft.setPower(0);
    }


}
