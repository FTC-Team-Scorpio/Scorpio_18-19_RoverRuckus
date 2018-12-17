package org.firstinspires.ftc.teamcode;

//Import stuff
import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class myFIRSTJavaOpMode extends LinearOpMode{
    //Create Variables
    //private Gyroscope imu;
    private DcMotor leftmotor;
    private DcMotor rightmotor;
    private DcMotor leftmotor2;
    private DcMotor rightmotor2;
    private DcMotor motor3;
    double tgtPower = 0;
    double tgtpower2 = 0;
    /*private DigitalChannel digitalTouch;
    private DistanceSensor sensorColorRange;
    private Servo servoTest;*/

    @Override

    public void runOpMode () {
        //Map the sensors
        //imu = hardwareMap.get(Gyroscope.class, "imu");

        //Initalize Motors
        leftmotor = hardwareMap.get(DcMotor.class, "motorTest");
        rightmotor = hardwareMap.get(DcMotor.class, "motor2");
        leftmotor2 = hardwareMap.get(DcMotor.class, "leftmotor2"); //MECANUM
        rightmotor2 = hardwareMap.get(DcMotor.class, "rightmotor2"); //MECANUM
        motor3 = hardwareMap.get(DcMotor.class, "atach");
        /*digitalTouch = hardwareMap.get(DigitalChannel.class, "digitalTouch");
        sensorColorRange = hardwareMap.get(DistanceSensor.class, "sensorColorRange");
        servoTest = hardwareMap.get(Servo.class, "servoTest");*/

        //Wait for Start
        waitForStart();
        while (opModeIsActive()) {
            newmotor(); //Control the basic drivetrain using the controller (Refer to newmotor function)
            servoMotor(); //Do the servos
            landing();
            arm();
            mecanum();
        }
    }

    public void oldmotor () {
        tgtPower = this.gamepad1.left_stick_y;
        tgtpower2 = -this.gamepad1.right_stick_y;
        //Set the motor according to the gamepad
        leftmotor.setPower(tgtPower);
        rightmotor.setPower(tgtpower2);
        //Display the target motor power
        telemetry.addData("Target Power", tgtPower);
        telemetry.addData("X Axis", this.gamepad1.left_stick_x);
        //Display the actual motor power
        telemetry.addData("Motor Power", leftmotor.getPower());
        //Display that the status is running
        telemetry.addData("Status", "Running");
        //Update the screen
        telemetry.update();
    }

    public void newmotor () {
        //Set the base to the y of the speed joystick (add 1.5 because range is -1 to 0) which is speed
        //not accounting for the turn
        double base = Range.scale((gamepad1.right_stick_y*-1) + 1.3,0.3,1.3, 0,0.4);
        //If left joystick forward
        if (gamepad1.left_stick_y > 0) {
            double leftspeed =  Range.scale(base /*+ gamepad1.left_stick_x*/,-2.3,2.3,-1,1);
            double rightspeed = Range.scale(base * -1,-2.3,2.3,-1,1);
            if (gamepad1.left_stick_x > 0) {
                rightspeed *= -1;
            }
            else if (gamepad1.left_stick_x < 0) {
                leftspeed *= -1;
            }
            rightmotor.setPower(rightspeed * -1 * 2);
            rightmotor2.setPower(rightspeed * -1 * 2); //MECANUM
            leftmotor.setPower(leftspeed * -1 * 2);
            leftmotor2.setPower(leftspeed * -1 * 2); //MECANUM

        }
        //If left joystick back
        else if (gamepad1.left_stick_y < 0) {
            //Set left motor to base speed plus the turn and multiply by -1 because moving backward
            double leftspeed = Range.scale((base /*+ gamepad1.left_stick_x*/) * -1,-2.3,2.3,-1,1);
            double rightspeed = Range.scale(base * -1 * -1, -2.3,2.3,-1,1);
            if (gamepad1.left_stick_x > 0) {
                rightspeed *= -1;
            }
            else if (gamepad1.left_stick_x < 0) {
                leftspeed *= -1;
            }
            leftmotor.setPower(leftspeed * -1 * 2);
            leftmotor2.setPower(leftspeed * -1 * 2); //MECANUM
            //Set right motor to base speed times -1 because backward (Extra -1 based on clockwise/counter-clockwise)
            rightmotor.setPower(rightspeed * -1 * 2);
            rightmotor2.setPower(rightspeed * -1 * 2); //MECANUM
        }
        //If left joystick in center
        else if (gamepad1.a){
            //Set left motor to base speed (going straight)
            leftmotor.setPower(base);
            leftmotor2.setPower(base); //MECANUM
            //Set right motor to base speed (going straight) (Extra -1 based on clockwise/counter-clockwise)
            rightmotor.setPower(base * -1);
            rightmotor2.setPower(base * -1); //MECANUM
        }
        else if (gamepad1.y) {
            leftmotor.setPower(base * -1);
            rightmotor.setPower(base); //MECANUM
            leftmotor2.setPower(base * -1);
            rightmotor2.setPower(base); //MECANUM
        }
        else {
            //Set left motor to base speed plus the turn
            leftmotor.setPower(0);
            leftmotor2.setPower(0); //MECANUM
            //Set right motor to base speed (Extra -1 based on clockwise/counter-clockwise)
            rightmotor.setPower(0);
            rightmotor2.setPower(0); //MECANUM
        }
        //Print everything
        telemetry.addData("Left Joystick X", gamepad1.left_stick_x);
        telemetry.addData("Left Joystick Y", gamepad1.left_stick_y);
        telemetry.addData("Right Joystick X", gamepad1.right_stick_x);
        telemetry.addData("Right Joystick Y", base);
        telemetry.addData("Left Motor Speed", leftmotor.getPower());
        telemetry.addData("Right Motor Speed", rightmotor.getPower());
        telemetry.update();
    }
    public void servoMotor () {
        Servo servo1 = hardwareMap.get(Servo.class, "servo1");
        servo1.setPosition(Range.scale(gamepad2.left_stick_x,-1,1,0,1));
        telemetry.addData("DA ONE (SERVO POS)", Range.scale(gamepad2.left_stick_x,-1,1,0,1));
        telemetry.update();
    }
    public void landing () {
        if (gamepad2.a) {
            motor3.setPower(1);
        }
        else if (gamepad2.y) {
            motor3.setPower(-1);
        }
        else {
            motor3.setPower(0);
        }
    }
    public void arm () {
        DcMotor arm = hardwareMap.get(DcMotor.class, "arm");
        if (gamepad2.x) {
            arm.setPower(0.2);
        }
        else if (gamepad2.b) {
            arm.setPower(-0.2);
        }
        else {
            arm.setPower(0);
        }
    }
    public void mecanum () {
        double base = Range.scale((gamepad1.right_stick_y*-1) + 1.3,0.3,1.3, 0,0.4);
        if (gamepad1.left_trigger != 0) {
            leftmotor.setPower(base * -1);
            rightmotor.setPower(base);
            leftmotor2.setPower(base);
            rightmotor2.setPower(base * -1);
        }
        else if (gamepad1.right_trigger != 0) {
            leftmotor.setPower(base);
            rightmotor.setPower(base * -1);
            leftmotor2.setPower(base * -1);
            rightmotor2.setPower(base);
        }
    }
}
