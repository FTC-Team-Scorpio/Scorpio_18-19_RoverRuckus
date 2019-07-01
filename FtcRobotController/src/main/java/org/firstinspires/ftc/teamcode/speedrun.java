package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class speedrun extends LinearOpMode {
    private DcMotor leftmotor;
    private DcMotor rightmotor;
    private DcMotor leftmotor2;
    private DcMotor rightmotor2;
    public void runOpMode () {
        waitForStart();
        while (opModeIsActive()) {
            cool();
        }
    }
    public void cool () {
        leftmotor = hardwareMap.get(DcMotor.class, "leftmotor");
        rightmotor = hardwareMap.get(DcMotor.class, "rightmotor");
        leftmotor2 = hardwareMap.get(DcMotor.class, "leftmotor2"); //MECANUM
        rightmotor2 = hardwareMap.get(DcMotor.class, "rightmotor2"); //MECANUM
        if (gamepad1.y) {
            leftmotor.setPower(1);
            leftmotor2.setPower(1);
            rightmotor.setPower(-1);
            rightmotor2.setPower(-1);
        }
        else if (gamepad1.a) {
            leftmotor.setPower(-1);
            leftmotor2.setPower(-1);
            rightmotor.setPower(1);
            rightmotor2.setPower(1);
        }
        else if (gamepad1.left_stick_x < 0) {
            leftmotor.setPower(0.25);
            leftmotor2.setPower(0.25);
            rightmotor.setPower(-0.5);
            rightmotor2.setPower(-0.5);
        }
        else if (gamepad1.left_stick_x > 0) {
            //turn right
            leftmotor.setPower(1);
            leftmotor2.setPower(1);
            rightmotor.setPower(-0.3);
            rightmotor2.setPower(-0.3);
        }
        else if (gamepad1.left_trigger != 0) {
            //Move sideways left
            leftmotor.setPower(1 * -1);
            rightmotor.setPower(1 * -1);
            leftmotor2.setPower(1);
            rightmotor2.setPower(1);
        }
        //If right trigger pressed
        else if (gamepad1.right_trigger != 0) {
            //Move sideways right
            leftmotor.setPower(1);
            rightmotor.setPower(1);
            leftmotor2.setPower(1 * -1);
            rightmotor2.setPower(1 * -1);
        }
        else {
            //stop
            leftmotor.setPower(0);
            leftmotor2.setPower(0);
            rightmotor.setPower(0);
            rightmotor2.setPower(0);
        }
    }
}
