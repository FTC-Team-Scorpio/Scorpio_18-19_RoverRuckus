package org.firstinspires.ftc.teamcode;

//Import stuff
import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class myFIRSTJavaOpMode extends LinearOpMode{
    //Create Variables
    //private Gyroscope imu;
    private DcMotor motorTest;
    private DcMotor motor2;
    private DcMotor leftmotor;
    private DcMotor rightmotor;
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
        motorTest = hardwareMap.get(DcMotor.class, "motorTest");
        leftmotor = motorTest;
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        rightmotor = motor2;
        motor3 = hardwareMap.get(DcMotor.class, "atach");
        /*digitalTouch = hardwareMap.get(DigitalChannel.class, "digitalTouch");
        sensorColorRange = hardwareMap.get(DistanceSensor.class, "sensorColorRange");
        servoTest = hardwareMap.get(Servo.class, "servoTest");*/

        //Wait for Start
        waitForStart();
        while (opModeIsActive()) {
            newmotor(); //Control the basic drivetrain using the controller (Refer to newmotor function)
            //servoMotor(); //Do the servos
            landing();
        }
    }

    public void oldmotor () {
        tgtPower = this.gamepad1.left_stick_y;
        tgtpower2 = -this.gamepad1.right_stick_y;
        //Set the motor according to the gamepad
        motorTest.setPower(tgtPower);
        motor2.setPower(tgtpower2);
        //Display the target motor power
        telemetry.addData("Target Power", tgtPower);
        telemetry.addData("X Axis", this.gamepad1.left_stick_x);
        //Display the actual motor power
        telemetry.addData("Motor Power", motorTest.getPower());
        //Display that the status is running
        telemetry.addData("Status", "Running");
        //Update the screen
        telemetry.update();
    }

    public void newmotor () {
        //Set the base to the y of the speed joystick (add 1.5 because range is -1 to 0) which is speed
        //not accounting for the turn
        double base = (gamepad1.right_stick_y*-1) + 1.3;
        //If left joystick forward
        if (gamepad1.left_stick_y > 0) {
            double leftspeed =  Range.scale(base /*+ gamepad1.left_stick_x*/,-2.3,2.3,-1,1);
            double rightspeed = Range.scale(base * -1,-2.3,2.3,-1,1);
            if (gamepad1.left_stick_x >= -0.1 && gamepad1.left_stick_x <= 0.1) {
                rightspeed *= -1;
                leftspeed *= -1;
            }
            else if (gamepad1.left_stick_x > 0) {
                rightspeed *= -1;
            }
            else if (gamepad1.left_stick_x < 0) {
                leftspeed *= -1;
            }
            rightmotor.setPower(rightspeed * -1);
            leftmotor.setPower(leftspeed * -1);

        }
        //If left joystick back
        else if (gamepad1.left_stick_y < 0) {
            //Set left motor to base speed plus the turn and multiply by -1 because moving backward
            double leftspeed = Range.scale((base /*+ gamepad1.left_stick_x*/) * -1,-2.3,2.3,-1,1);
            double rightspeed = Range.scale(base * -1 * -1, -2.3,2.3,-1,1);
            if (gamepad1.left_stick_x >= -0.1 && gamepad1.left_stick_x <= 0.1) {
                rightspeed *= -1;
                leftspeed *= -1;
            }
            else if (gamepad1.left_stick_x > 0) {
                rightspeed *= -1;
            }
            else if (gamepad1.left_stick_x < 0) {
                leftspeed *= -1;
            }
            leftmotor.setPower(leftspeed * -1);
            //Set right motor to base speed times -1 because backward (Extra -1 based on clockwise/counter-clockwise)
            rightmotor.setPower(rightspeed * -1);
        }
        //If left joystick in center
        else if (gamepad1.a){
            //Set left motor to base speed (going straight)
            leftmotor.setPower(base);
            //Set right motor to base speed (going straight) (Extra -1 based on clockwise/counter-clockwise)
            rightmotor.setPower(base * -1);
        }
        else if (gamepad1.y) {
            leftmotor.setPower(base * -1);
            rightmotor.setPower(base);
        }
        else {
            //Set left motor to base speed plus the turn
            leftmotor.setPower(0);
            //Set right motor to base speed (Extra -1 based on clockwise/counter-clockwise)
            rightmotor.setPower(0);
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
    }
    public void landing () {
        if (gamepad2.a) {
            motor3.setPower(1);
        }
        else if (gamepad2.y) {
            motor3.setPower(1);
        }
        else {
            motor3.setPower(0);
        }
    }
}
