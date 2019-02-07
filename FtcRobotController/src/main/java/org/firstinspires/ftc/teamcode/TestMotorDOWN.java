package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
@Disabled
public class TestMotorDOWN extends LinearOpMode {

    public void runOpMode () {
        waitForStart();
        DcMotor motor2 = hardwareMap.get(DcMotor.class, "atach2");
        while (opModeIsActive()) {
            motor2.setPower(-1);
        }
    }
}
