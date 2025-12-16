package org.firstinspires.ftc.teamcode;

//import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

//import org.firstinspires.ftc.teamcode.Mechinisms.LimeLight;
import org.firstinspires.ftc.teamcode.Mechinisms.Shooter;
import org.firstinspires.ftc.teamcode.Mechinisms.Stilts;
import org.firstinspires.ftc.teamcode.Mechinisms.TankDrive;

public class Robot {
    //public LimeLight limeLight = new LimeLight();
    public Shooter shooters = new Shooter();
    public TankDrive tankDrive = new TankDrive();
    public Stilts stilts = new Stilts();


    public void init(HardwareMap hardwareMap){
       // limeLight.init(hardwareMap);
        stilts.init(hardwareMap);
        shooters.init(hardwareMap);
        tankDrive.init(hardwareMap);
    }
}
