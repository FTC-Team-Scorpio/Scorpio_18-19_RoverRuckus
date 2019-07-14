package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class CALGAMESlongauto extends LinearOpMode {
    public void runOpMode () {
        waitForStart();
        //Init
        DcMotor leftmotor = hardwareMap.get(DcMotor.class, "leftmotor");
        DcMotor rightmotor = hardwareMap.get(DcMotor.class, "rightmotor");
        DcMotor leftmotor2 = hardwareMap.get(DcMotor.class, "leftmotor2");
        DcMotor rightmotor2 = hardwareMap.get(DcMotor.class, "rightmotor2");
        DcMotor motor3 = hardwareMap.get(DcMotor.class, "atach");
        double base = 0.6;
        //Go Down
        motor3.setPower(-1);
        sleep(2000);
        motor3.setPower(0);
        //Go backwards buddy
        leftmotor.setPower(-base);
        leftmotor2.setPower(-base);
        rightmotor.setPower(base);
        rightmotor2.setPower(base);
        sleep(200);
        //go forwarsd buddy
        leftmotor.setPower(base);
        leftmotor2.setPower(base);
        rightmotor.setPower(-base);
        rightmotor2.setPower(-base);
        sleep(400);
        //left buddy
        leftmotor.setPower(-base);
        leftmotor2.setPower(-base);
        rightmotor.setPower(-base);
        rightmotor2.setPower(-base);
        sleep(50);
        leftmotor.setPower(0);
        leftmotor2.setPower(0);
        rightmotor.setPower(0);
        rightmotor2.setPower(0);
        //go upwards and onwards
        motor3.setPower(1);
        sleep(3000);
        motor3.setPower(0);
        //Go Down
        motor3.setPower(-1);
        sleep(3000);
        motor3.setPower(0);
        //Go backwards buddy
        leftmotor.setPower(-base);
        leftmotor2.setPower(-base);
        rightmotor.setPower(base);
        rightmotor2.setPower(base);
        sleep(200);
        //sideways
        leftmotor.setPower(1 * -1);
        rightmotor.setPower(1 * -1);
        leftmotor2.setPower(1);
        rightmotor2.setPower(1);
        sleep(1000);
        //Go backwards buddy
        leftmotor.setPower(-base);
        leftmotor2.setPower(-base);
        rightmotor.setPower(base);
        rightmotor2.setPower(base);
        sleep(1000);
        //left buddy
        leftmotor.setPower(-base);
        leftmotor2.setPower(-base);
        rightmotor.setPower(-base);
        rightmotor2.setPower(-base);
        sleep(1000);
        //Go backwards buddy
        leftmotor.setPower(-base);
        leftmotor2.setPower(-base);
        rightmotor.setPower(base);
        rightmotor2.setPower(base);
        sleep(1000);
        //sideways
        leftmotor.setPower(1);
        rightmotor.setPower(1);
        leftmotor2.setPower(-1);
        rightmotor2.setPower(-1);
        sleep(1000);
    }

}
