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
        double fLeft;
        double fRight;
        double bLeft;
        double bRight;
        double max;
        int cooldown = 0;

        robot.innit(hardwareMap);

        telemetry.addData("Say", "Not Broken Yet");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            drive = gamepad1.left_stick_y;
            turn = gamepad1.left_stick_x;
            strafe = gamepad1.right_stick_x;

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

            robot.frontLeft.setPower(fLeft);
            robot.frontRight.setPower(fRight);
            robot.backLeft.setPower(bLeft);
            robot.backRight.setPower(bRight);

            telemetry.update();

            // Pause for 20 mS each cycle = update 50 times a second.
            sleep(20);

        }
    }
}
