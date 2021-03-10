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
        double fLeft;
        double fRight;
        double bLeft;
        double bRight;
        double max;
        boolean crabPos = true;
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

            //Different combinations of motor powers make the robot move in different ways
            //To go forwards, the two left wheels spin counterclockwise while the right wheels spin clockwise
            //To strafe, the front left and back right spin counter clockwise
            //To turn, all spin clockwise (values are inverted)
            fLeft = -drive - turn - strafe;
            fRight = drive - turn + strafe;
            bLeft = -drive - turn + strafe;
            bRight = drive - turn - strafe;

            if (cooldown != 0) cooldown--; //Decrement the cooldown on the crab
            if (gamepad1.x && cooldown == 0) {
                if (crabPos) {
                    //Close claw
                    robot.crab.setPosition(0);
                    cooldown = 25; //Cooldown is half a second (25 x 20 ms)
                    crabPos = false;
                } else {
                    //Open claw
                    robot.crab.setPosition(90);
                    cooldown = 25; //Cooldown is half a second (25 x 20 ms)
                    crabPos = true;
                }
            }

            //Moving claw
            if (gamepad1.dpad_up) {

                robot.slideFLeft.setPower(1);
                robot.slideFRight.setPower(-1);
                robot.slideBLeft.setPower(1);
                robot.slideBRight.setPower(-1);

            } else if (gamepad1.dpad_down) {

                robot.slideFLeft.setPower(-1);
                robot.slideFRight.setPower(1);
                robot.slideBLeft.setPower(-1);
                robot.slideBRight.setPower(1);

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
                robot.crabMotor.setPower(crabRotate);

                telemetry.update();

                // Pause for 20 mS each cycle = update 50 times a second.
                sleep(20);

            }
        }
    }
}
