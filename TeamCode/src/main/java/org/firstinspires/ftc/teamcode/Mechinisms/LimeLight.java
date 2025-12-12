package org.firstinspires.ftc.teamcode.Mechinisms;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class LimeLight {
    Limelight3A limelight3A;
    public void init(HardwareMap hardwareMap){
        limelight3A = hardwareMap.get(Limelight3A.class,"LimeLight");
        limelight3A.setPollRateHz(100);
        limelight3A.start();
    }
    public double LookTx(){

        return(limelight3A.getLatestResult().getTx());
    }
    public double LookTy(){

        return(limelight3A.getLatestResult().getTy());
    }
    public double LookTa(){

        return(limelight3A.getLatestResult().getTa());
    }
    public double detectID(){
        if(limelight3A.getLatestResult().getDetectorResults().size()>0) {
            return (limelight3A.getLatestResult().getDetectorResults().get(0).getClassId());
        }else{
            return(-1);
        }
    }
}
