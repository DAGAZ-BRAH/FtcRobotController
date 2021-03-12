package org.firstinspires.ftc.teamcode.Code;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hardware {
    DcMotor backLeft, backRight, frontLeft, frontRight;
    DcMotor crabMotor;
    Servo crabServo, lockServo;
    DcMotor shootyThingy;
    Servo pinBall;
    DcMotor pushthing;
    Servo something;
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
        crabMotor = hwMap.get(DcMotor.class, "crabMotor");
        crabServo = hwMap.get(Servo.class, "crabServo");
        lockServo = hwMap.get(Servo.class, "lockServo");
        shootyThingy = hwMap.get(DcMotor.class, "shoot");
        pinBall = hwMap.get(Servo.class, "pinBall");



        backLeft.setPower(0);
        backRight.setPower(0);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        shootyThingy.setPower(0);

    }

}
