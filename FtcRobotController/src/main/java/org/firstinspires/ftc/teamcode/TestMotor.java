package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.Range;
@Autonomous
@Disabled
public class TestMotor extends LinearOpMode {

    public void runOpMode () {
        waitForStart();
        DcMotor motor2 = hardwareMap.get(DcMotor.class, "atach");
        while (opModeIsActive()) {
            motor2.setPower(1);
        }
    }
}
