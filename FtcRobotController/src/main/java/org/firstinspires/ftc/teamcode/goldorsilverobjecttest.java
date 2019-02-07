package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;

@Autonomous
@Disabled
public class goldorsilverobjecttest extends LinearOpMode {
    WebcamName webcamName;
    public void runOpMode () {
        GOLDorSILVERObject object = new GOLDorSILVERObject();
        while (opModeIsActive()) {
            object.updateVariables();
            telemetry.addData("Gold",object.gold);
            telemetry.addData("Silver",object.silver);
            telemetry.update();
        }
    }
}
