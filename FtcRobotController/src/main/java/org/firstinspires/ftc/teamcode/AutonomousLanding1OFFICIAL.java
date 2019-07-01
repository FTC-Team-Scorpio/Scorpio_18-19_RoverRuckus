package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class AutonomousLanding1OFFICIAL extends LinearOpMode {
    private DcMotor leftmotor;
    private DcMotor rightmotor;
    private DcMotor leftmotor2;
    private DcMotor rightmotor2;
    public void runOpMode() {
        waitForStart();
        //Init
        leftmotor = hardwareMap.get(DcMotor.class, "leftmotor");
        rightmotor = hardwareMap.get(DcMotor.class, "rightmotor");
        leftmotor2 = hardwareMap.get(DcMotor.class, "leftmotor2");
        rightmotor2 = hardwareMap.get(DcMotor.class, "rightmotor2");
        DcMotor motor3 = hardwareMap.get(DcMotor.class, "atach");
        double base = 0.6;
        //Go Down
        motor3.setPower(1);
        sleep(9750);
        motor3.setPower(0);
        //Go Forwards
        leftmotor.setPower(base);
        leftmotor2.setPower(base);
        rightmotor.setPower(base);
        rightmotor2.setPower(base);
        sleep(500);
        //Turn Left
        leftmotor.setPower(base);
        leftmotor2.setPower(base);
        rightmotor.setPower(base);
        rightmotor2.setPower(base);
        sleep(1450);
        //Go Forwards
        leftmotor.setPower(base);
        leftmotor2.setPower(base);
        rightmotor.setPower(base);
        rightmotor2.setPower(base);
        sleep(4000);
        //Stop
        leftmotor.setPower(0);
        leftmotor2.setPower(0);
        rightmotor.setPower(0);
        rightmotor2.setPower(0);
        //Claim
        Servo servo0 = hardwareMap.get(Servo.class, "servo0");
        servo0.setPosition(1);
        sleep(1000);
        leftmotor.setPower(0.5);
        rightmotor.setPower(-0.5);
        sleep(1500);
        //Go Back
        leftmotor.setPower(-0.5);
        rightmotor.setPower(0.5);
        sleep(2250);
    }
}
