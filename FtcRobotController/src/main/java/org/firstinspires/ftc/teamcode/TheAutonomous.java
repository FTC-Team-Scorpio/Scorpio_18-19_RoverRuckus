package org.firstinspires.ftc.teamcode;
import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.Range;

@Autonomous
public class TheAutonomous extends LinearOpMode{
    ColorSensor colorSensor;
    public void runOpMode () {
        colorSensor = hardwareMap.get(ColorSensor.class, "color");
        waitForStart();
        while (opModeIsActive()) {
            DcMotor awesome = hardwareMap.get(DcMotor.class,"atach");
            awesome.setPower(1);
            telemetry.addData("Color Sensor",colorSensor.alpha());
            telemetry.update();
        }
    }
}
