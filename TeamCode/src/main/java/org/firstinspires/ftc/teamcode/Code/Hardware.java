package org.firstinspires.ftc.teamcode.Code;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hardware {
    DcMotor backLeft, backRight, frontLeft, frontRight, intakeMotor, crabMotor;
    HardwareMap hwMap = null;
    CRServo slideFLeft, slideFRight, slideBLeft, slideBRight;
    public Servo crab;

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
        crabMotor = hwMap.get(DcMotor.class, "crabMotor");

        //Define and initialize servos


        //Set all motors to zero power.
        backLeft.setPower(0);
        backRight.setPower(0);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        crabMotor.setPower(0);

        //Allows for motors to run without encoders, except for the front left motor.
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        crabMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }

}
