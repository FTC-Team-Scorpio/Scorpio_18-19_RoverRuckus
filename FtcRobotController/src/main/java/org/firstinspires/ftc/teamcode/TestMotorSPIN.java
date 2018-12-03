package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class TestMotorSPIN extends LinearOpMode {

    public void runOpMode () {
        waitForStart();
        DcMotor motor2 = hardwareMap.get(DcMotor.class, "spin");
        while (opModeIsActive()) {
            motor2.setPower(1);
        }
    }
}
