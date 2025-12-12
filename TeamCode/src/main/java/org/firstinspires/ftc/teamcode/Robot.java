package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Mechinisms.LimeLight;
import org.firstinspires.ftc.teamcode.Mechinisms.Shooters;
import org.firstinspires.ftc.teamcode.Mechinisms.TankDrive;

public class Robot {
    public LimeLight limeLight = new LimeLight();
    public Shooters shooters = new Shooters();
    public TankDrive tankDrive = new TankDrive();
    public void init(HardwareMap hardwareMap){
        limeLight.init(hardwareMap);
        shooters.init(hardwareMap);
        tankDrive.init(hardwareMap);
    }
}
