package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class TestServo extends LinearOpMode {

    public void runOpMode () {
        waitForStart();
        Servo motor2 = hardwareMap.get(Servo.class, "servo0");
        while (opModeIsActive()) {
            motor2.setPosition(180);
        }
    }
}
