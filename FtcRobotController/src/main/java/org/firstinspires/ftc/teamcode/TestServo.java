package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
@Disabled
public class TestServo extends LinearOpMode {

    public void runOpMode () {
        waitForStart();
        Servo servo0 = hardwareMap.get(Servo.class, "servo0");
        Servo servo1 = hardwareMap.get(Servo.class, "servo1");
        while (opModeIsActive()) {
            servo0.setPosition(1);
            servo1.setPosition(1);
            telemetry.addData("thing",1);
            telemetry.update();
            sleep(2000);
            servo0.setPosition(0);
            servo1.setPosition(0);
            telemetry.addData("thing",0);
            telemetry.update();
            sleep(2000);
        }
    }
}
