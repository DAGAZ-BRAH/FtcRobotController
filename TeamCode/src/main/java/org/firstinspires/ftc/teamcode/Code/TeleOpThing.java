package org.firstinspires.ftc.teamcode.Code;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

public class TeleOpThing extends LinearOpMode {
    Hardware robot = new Hardware();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        double drive;
        double turn;
        double strafe;
        double crabRotate;
        boolean pinch = false; //false = crab claw is opened, true is equal to closed.
        boolean open; //boolean for checking if claw open button was pushed.
        boolean close; //boolean for checking if claw closed button was pushed.
        double fLeft;
        double fRight;
        double bLeft;
        double bRight;
        double max;
        boolean spinny; //spin factor for the motor on the shoot thing
        boolean noSpinny;
        boolean pinBall;
        int cooldown = 0;

        robot.innit(hardwareMap);

        telemetry.addData("Say", "Not Broken Yet");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            drive = gamepad1.left_stick_y;
            turn = gamepad1.left_stick_x;
            strafe = gamepad1.right_stick_x;
            crabRotate = (-1 * gamepad1.left_trigger) + gamepad1.right_trigger;
            open = gamepad1.x;
            close = gamepad1.b;
            spinny = gamepad1.right_bumper;
            noSpinny = gamepad1.left_bumper;
            pinBall = gamepad1.dpad_up;

            //Different combinations of motor powers make the robot move in different ways
            //To go forwards, the two left wheels spin counterclockwise while the right wheels spin clockwise
            //To strafe, the front left and back right spin counter clockwise
            //To turn, all spin clockwise (values are inverted)
            fLeft = -drive - turn - strafe;
            fRight = drive - turn + strafe;
            bLeft = -drive - turn + strafe;
            bRight = drive - turn - strafe;

            max = Math.max(Math.max(Math.abs(fLeft), Math.abs(fRight)), Math.max(Math.abs(bLeft), Math.abs(bRight)));
            if (max > 1.0) {
                fLeft /= max;
                fRight /= max;
                bLeft /= max;
                bRight /= max;
                //brah moment

            }

            if(spinny)
            {
                robot.shootyThingy.setPower(1);
                noSpinny = false;
            }
            else if(noSpinny)
            {
                robot.shootyThingy.setPower(0);
                spinny = false;
            }
            if(open)
            {
                robot.lockServo.setPosition(90);
                robot.crabServo.setPosition(90);
                close = false;
            }
            if(close)
            {
                robot.crabServo.setPosition(0);
                robot.lockServo.setPosition(0);
                open = false;
            }
            if(pinBall)
            {
                robot.pinBall.setPosition(90);
                pinBall = false;
            }
            robot.pinBall.setPosition(0);
            robot.frontLeft.setPower(fLeft);
            robot.frontRight.setPower(fRight);
            robot.backLeft.setPower(bLeft);
            robot.backRight.setPower(bRight);
            robot.crabMotor.setPower(crabRotate);


            telemetry.update();

            // Pause for 20 mS each cycle = update 50 times a second.
            sleep(20);

        }
    }
}
