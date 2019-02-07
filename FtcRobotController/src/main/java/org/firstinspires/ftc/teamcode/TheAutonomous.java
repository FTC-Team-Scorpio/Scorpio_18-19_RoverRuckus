package org.firstinspires.ftc.teamcode;
import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.Range;

@Autonomous
@Disabled
public class TheAutonomous extends LinearOpMode{
    //Create Color Sensor Variable
    ColorSensor colorSensor;
    public void runOpMode () {
        //Initalize the Color Sensor
        colorSensor = hardwareMap.get(ColorSensor.class, "color");
        //Wait until driver presses "Start"
        waitForStart();
        //While OP Mode is running
        while (opModeIsActive()) {
            //Initalize the motor
            DcMotor awesome = hardwareMap.get(DcMotor.class,"atach");
            //Set power of motor to 1
            awesome.setPower(1);
            //Add color sensor data to display
            telemetry.addData("Color Sensor",colorSensor.alpha());
            telemetry.update();
        }
    }
}
