package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp
@Disabled
public class TestServo extends LinearOpMode {

    public void runOpMode () {
        waitForStart();
        Servo servo0 = hardwareMap.get(Servo.class, "claim");
        while (opModeIsActive()) {
           servo0.setPosition(Range.scale(gamepad1.left_stick_y*-1,-1,1,0,1));
        }
    }
}
