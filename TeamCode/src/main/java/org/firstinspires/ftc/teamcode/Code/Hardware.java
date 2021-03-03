package org.firstinspires.ftc.teamcode.Code;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Hardware {
    DcMotor backLeft, backRight, frontLeft, frontRight;
    HardwareMap hwMap = null;

    public Hardware()
    {

    }

    public void innit(HardwareMap ahwMap)
    {
        hwMap = ahwMap;
        // Define and Initialize Motors
        backLeft  = hwMap.get(DcMotor.class, "backLeft");
        backRight = hwMap.get(DcMotor.class, "backRight");
        frontLeft  = hwMap.get(DcMotor.class, "frontLeft");
        frontRight = hwMap.get(DcMotor.class, "frontRight");

    }

}
