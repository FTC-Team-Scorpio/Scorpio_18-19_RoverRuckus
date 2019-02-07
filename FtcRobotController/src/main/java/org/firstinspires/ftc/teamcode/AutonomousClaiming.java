package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.Range;
@Autonomous
@Disabled
public class AutonomousClaiming extends LinearOpMode{
    private DcMotor motorTest;
    private DcMotor motor2;
    private DcMotor leftmotor;
    private DcMotor rightmotor;
    private DcMotor leftmotor2;
    private DcMotor rightmotor2;
    public void runOpMode() {
        waitForStart();
        //Init
        leftmotor = hardwareMap.get(DcMotor.class, "leftmotor");
        leftmotor2 = hardwareMap.get(DcMotor.class, "leftmotor2");
        rightmotor = hardwareMap.get(DcMotor.class, "rightmotor");
        rightmotor2 = hardwareMap.get(DcMotor.class, "rightmotor2");
        //Straight
        leftmotor.setPower(-0.5);
        leftmotor2.setPower(-0.5);
        rightmotor.setPower(0.5);
        rightmotor2.setPower(0.5);
        sleep(4000);
        //CLAIM
        leftmotor.setPower(0);
        leftmotor2.setPower(0);
        rightmotor.setPower(0);
        rightmotor2.setPower(0);
        Servo servo0 = hardwareMap.get(Servo.class, "servo0");
        servo0.setPosition(1);
        sleep(1000);
        leftmotor.setPower(0.5);
        leftmotor2.setPower(0.5);
        rightmotor.setPower(-0.5);
        rightmotor2.setPower(-0.5);
        sleep(1000);
        /*//Turn
        sleep(1000);
        leftmotor.setPower(0.5);
        rightmotor.setPower(0.5);
        sleep(400);
        //Backwards
        leftmotor.setPower(0.5);
        rightmotor.setPower(-0.5);
        sleep(4000);
        //DE END
        leftmotor.setPower(0);
        rightmotor.setPower(0);
        Servo servo1 = hardwareMap.get(Servo.class, "servo1");
        servo1.setPosition(Range.scale(0.7,0,1,0,1));
        sleep(1000);*/
    }
}
