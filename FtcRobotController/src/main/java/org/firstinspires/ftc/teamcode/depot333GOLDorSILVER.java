package org.firstinspires.ftc.teamcode;

import android.content.Context;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.function.Consumer;
import org.firstinspires.ftc.robotcore.external.function.Continuation;
import org.firstinspires.ftc.robotcore.external.hardware.camera.Camera;
import org.firstinspires.ftc.robotcore.external.hardware.camera.CameraCharacteristics;
import org.firstinspires.ftc.robotcore.external.hardware.camera.CameraName;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.internal.system.Deadline;

import java.util.List;

@Autonomous
public class depot333GOLDorSILVER extends LinearOpMode {
    //Init variables
    int gold = 0;
    int silver = 0;
    float mineralposition = -1;
    DcMotor leftmotor;
    DcMotor rightmotor;
    DcMotor leftmotor2;
    DcMotor rightmotor2;
    //Create a object that will detect minerals
    private TFObjectDetector tfod;
    //Create Vuforia Object
    private VuforiaLocalizer vuforia;
    //Create variable that stores the Vuforia License Key
    private static final String VUFORIA_KEY = "AWcVaaD/////AAABmZwP74eVtklZnIyqakTO2OgZwlPh8T1HsrgYVIEDnOoyHLj2L/rcsf4swWk/DCfwjbmE1BW6y7PmkyMW4qU52qB6ne+cY0gWZ2N7K1xYZpG78NA3EWxYq8B+j81wdDD7viNoWx62SX04i5BDxzZIHpSNFfMUIBmQfEMnczuHyPOLNCN4akso3GDtigRTi+KedV0B3w7+J3yMkpWcgmMhZOMT32WAlASPl8sP2OfinvRZkX+dk0AzuMLrUyD85dbnOBrmHKllIaYp9Vky1xYvKJ96EsNGAnCGFd8KBNNLAZhwkWrBGtzRYuy1R0zLVWDYIkt85yMLBnyuC+TOd+bn+SCsWgib1mVckAhg0D8XGPkq";
    //Function to Run Op Mode
    public void runOpMode () throws InterruptedException {
        //Initialize Vuforia (Refer to "initVuforia" function)
        initVuforia();
        //Initalize TensorFlow (Refer to "initTFOD" function)
        initTFOD();
        //Wait until driver presses "Start"
        waitForStart();
        //Init
        leftmotor = hardwareMap.get(DcMotor.class, "leftmotor");
        rightmotor = hardwareMap.get(DcMotor.class, "rightmotor");
        leftmotor2 = hardwareMap.get(DcMotor.class, "leftmotor2");
        rightmotor2 = hardwareMap.get(DcMotor.class, "rightmotor2");
        DcMotor motor3 = hardwareMap.get(DcMotor.class, "atach");
        Servo claim = hardwareMap.get(Servo.class, "servo0");
        double base = 1;
        //Go Down
        motor3.setPower(1);
        sleep(9750);
        motor3.setPower(0);
        //Go Forwards
        leftmotor.setPower(base);
        leftmotor2.setPower(base);
        rightmotor.setPower(base);
        rightmotor2.setPower(base);
        sleep(450);
        //Turn Right
        leftmotor.setPower(base);
        leftmotor2.setPower(base);
        rightmotor.setPower(base);
        rightmotor2.setPower(base);
        sleep(950);
        //Sideways Right
        leftmotor.setPower(base);
        rightmotor.setPower(base);
        leftmotor2.setPower(base);
        rightmotor2.setPower(base);
        sleep(600);
        //Stop
        leftmotor.setPower(0);
        leftmotor2.setPower(0);
        rightmotor.setPower(0);
        rightmotor2.setPower(0);
        //Move straight a bit
        leftmotor.setPower(base);
        leftmotor2.setPower(base);
        rightmotor.setPower(base);
        rightmotor2.setPower(base);
        sleep(120);
        //Stop IT!
        leftmotor.setPower(0);
        leftmotor2.setPower(0);
        rightmotor.setPower(0);
        rightmotor2.setPower(0);
        //Check
        sleep(750);
        check();
        telemetry.addData("Gold Minerals: ", gold);
        telemetry.addData("Silver Minerals: ", silver);
        telemetry.addData("loc", mineralposition);
        telemetry.update();
        check();
        sleep(500);
        if (gold == 1) {
            //Go Forwards
            leftmotor.setPower(base);
            leftmotor2.setPower(base);
            rightmotor.setPower(base);
            rightmotor2.setPower(base);
            sleep(2800);
            //Turn left
            leftmotor.setPower(base);
            leftmotor2.setPower(base);
            rightmotor.setPower(base);
            rightmotor2.setPower(base);
            sleep(400);
            //Straight
            leftmotor.setPower(base);
            leftmotor2.setPower(base);
            rightmotor.setPower(base);
            rightmotor2.setPower(base);
            sleep(600);
            //Stop
            leftmotor.setPower(0);
            leftmotor2.setPower(0);
            rightmotor.setPower(0);
            rightmotor2.setPower(0);
            //Claim
            claim.setPosition(0.3);
            sleep(500);
            claim.setPosition(1);
            middlegoldpark();
        }
        else {
            //Turn Left
            leftmotor.setPower(base);
            leftmotor2.setPower(base);
            rightmotor.setPower(base);
            rightmotor2.setPower(base);
            sleep(350);
            //Stop
            leftmotor.setPower(0);
            leftmotor2.setPower(0);
            rightmotor.setPower(0);
            rightmotor2.setPower(0);
            //Check
            sleep(750);
            gold = 0;
            silver = 0;
            check();
            telemetry.addData("Gold Minerals2: ", gold);
            telemetry.addData("Silver Minerals2: ", silver);
            telemetry.addData("loc", mineralposition);
            telemetry.update();
            if (gold == 1) {
                //Go Forwards
                leftmotor.setPower(base);
                leftmotor2.setPower(base);
                rightmotor.setPower(base);
                rightmotor2.setPower(base);
                sleep(1500);
                //Turn a little bit left
                /*leftmotor.setPower(base);
                leftmotor2.setPower(base);
                rightmotor.setPower(base);
                rightmotor2.setPower(base);
                sleep(600);*/
                //Turn Right
                leftmotor.setPower(-0.4);
                leftmotor2.setPower(-0.4);
                rightmotor.setPower(-0.4);
                rightmotor2.setPower(-0.4);
                sleep(900);
                //Straight
                leftmotor.setPower(base);
                leftmotor2.setPower(base);
                rightmotor.setPower(base);
                rightmotor2.setPower(base);
                sleep(1500);
                //Turn Right
                leftmotor.setPower(base);
                leftmotor2.setPower(base);
                rightmotor.setPower(base );
                rightmotor2.setPower(base);
                sleep(450);
                //Move sideways left
                leftmotor.setPower(base);
                rightmotor.setPower(base);
                leftmotor2.setPower(base);
                rightmotor2.setPower(base);
                sleep(1000);
                //Stop
                leftmotor.setPower(0);
                leftmotor2.setPower(0);
                rightmotor.setPower(0);
                rightmotor2.setPower(0);
                //Claim
                claim.setPosition(0.3);
                sleep(500);
                claim.setPosition(1);
                //Move sideways right
                leftmotor.setPower(base);
                rightmotor.setPower(base);
                leftmotor2.setPower(base);
                rightmotor2.setPower(base);
                sleep(200);
                //Park
                leftgoldpark();
            }
            else {
                //Turn Right
                leftmotor.setPower(base);
                leftmotor2.setPower(base);
                rightmotor.setPower(base);
                rightmotor2.setPower(base);
                sleep(950);
                //Go Forwards
                leftmotor.setPower(base);
                leftmotor2.setPower(base);
                rightmotor.setPower(base);
                rightmotor2.setPower(base);
                sleep(1300);
                //Turn a little bit left
                /*leftmotor.setPower(base);
                leftmotor2.setPower(base);
                rightmotor.setPower(base);
                rightmotor2.setPower(base);
                sleep(600);*/
                //Turn left
                leftmotor.setPower(0.4);
                leftmotor2.setPower(0.4);
                rightmotor.setPower(0.4);
                rightmotor2.setPower(0.4);
                sleep(876);
                //Straight
                leftmotor.setPower(base);
                leftmotor2.setPower(base);
                rightmotor.setPower(base);
                rightmotor2.setPower(base);
                sleep(1800);
                //Turn left
                leftmotor.setPower(0.4);
                leftmotor2.setPower(0.4);
                rightmotor.setPower(0.4);
                rightmotor2.setPower(0.4);
                sleep(750);
                //Straight
                leftmotor.setPower(base);
                leftmotor2.setPower(base);
                rightmotor.setPower(base);
                rightmotor2.setPower(base);
                sleep(500);
                //Stop
                leftmotor.setPower(0);
                leftmotor2.setPower(0);
                rightmotor.setPower(0);
                rightmotor2.setPower(0);
                //Claim
                claim.setPosition(0.3);
                sleep(500);
                claim.setPosition(1);
                //Sideways
                leftmotor.setPower(base);
                rightmotor.setPower(base);
                leftmotor2.setPower(base);
                rightmotor2.setPower(base);
                sleep(200);
                //Park
                rightgoldpark();
            }
        }
        sleep(10000);
    }
    public void initVuforia () {
        //Create Vuforia Paramters Object
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();
        //Initialize the Vuforia License Key
        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        //Initalize the Camera Direction
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);
    }
    public void initTFOD () {
        //Identify the TensorFlow "Sensor"
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        //Create TensorFlow Parameters Object
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        //Initialize the TensorFlow parameters
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        //Load the models of the gold and silver minerals
        tfod.loadModelFromAsset("RoverRuckus.tflite", "Gold Mineral", "Silver Mineral");
    }
    public int check () {
        gold = 0;
        silver = 0;
        while (opModeIsActive()) {
            tfod.activate();
            //Create a list of all new recognized objects
            List<Recognition> objects = tfod.getUpdatedRecognitions();
            //If there is no new recognized objects
            if (objects == null) {
                //Restart loop
                continue;
            }
            //For every new identified object
            for (Recognition object : objects) {
                //If the object is gold then add one to gold variable
                if (object.getLabel().equals("Gold Mineral")) {
                    gold = 1;
                    mineralposition = object.getLeft();
                }
                //If the object is silver then add one to silver variable
                if (object.getLabel().equals("Silver Mineral")) {
                    silver = 1;
                    mineralposition = object.getLeft();
                }
            }
            if (gold == 1 || silver == 1) {
                break;
            }
        }
        return 0;
    }
    public void middlegoldpark () {
        double base = 1;
        //Turn left a little bit
        leftmotor.setPower(base);
        leftmotor2.setPower(base);
        rightmotor.setPower(base);
        rightmotor2.setPower(base);
        sleep(100);
        //GO BACKWARDS
        leftmotor.setPower(base);
        leftmotor2.setPower(base);
        rightmotor.setPower(base);
        rightmotor2.setPower(base);
        sleep(1000);
        //Go sideways left
        leftmotor.setPower(base);
        rightmotor.setPower(base);
        leftmotor2.setPower(base);
        rightmotor2.setPower(base);
        sleep(1200);
        //GO BACKWARDS
        leftmotor.setPower(base);
        leftmotor2.setPower(base);
        rightmotor.setPower(base);
        rightmotor2.setPower(base);
        sleep(4200);
        //Stop
        leftmotor.setPower(0);
        leftmotor2.setPower(0);
        rightmotor.setPower(0);
        rightmotor2.setPower(0);
        //Move thing down
        DcMotor atach2 = hardwareMap.get(DcMotor.class, "atach2");
        atach2.setPower(0.4);
        sleep(1000);
        atach2.setPower(0);
    }
    public void leftgoldpark () {
        double base = 1;
        //Turn left a little bit
        leftmotor.setPower(base);
        leftmotor2.setPower(base);
        rightmotor.setPower(base);
        rightmotor2.setPower(base);
        sleep(100);
        //GO BACKWARDS
        leftmotor.setPower(base);
        leftmotor2.setPower(base);
        rightmotor.setPower(base);
        rightmotor2.setPower(base);
        sleep(700);
        //Move sideways left
        leftmotor.setPower(base);
        rightmotor.setPower(base);
        leftmotor2.setPower(base);
        rightmotor2.setPower(base);
        sleep(1200);
        //GO BACKWARDS
        leftmotor.setPower(base);
        leftmotor2.setPower(base);
        rightmotor.setPower(base);
        rightmotor2.setPower(base);
        sleep(2300);
        //GO BACKWARDS
        leftmotor.setPower(base);
        leftmotor2.setPower(base);
        rightmotor.setPower(base);
        rightmotor2.setPower(base);
        sleep(1200);
        //Stop
        leftmotor.setPower(0);
        leftmotor2.setPower(0);
        rightmotor.setPower(0);
        rightmotor2.setPower(0);
        //Move thing down
        DcMotor atach2 = hardwareMap.get(DcMotor.class, "atach2");
        atach2.setPower(0.4);
        sleep(1000);
        atach2.setPower(0);
    }
    public void rightgoldpark () {
        double base = 1;
        //GO BACKWARDS
        leftmotor.setPower(base);
        leftmotor2.setPower(base);
        rightmotor.setPower(base);
        rightmotor2.setPower(base);
        sleep(1000);
        //Move sideways left
        leftmotor.setPower(base);
        rightmotor.setPower(base);
        leftmotor2.setPower(base);
        rightmotor2.setPower(base);
        sleep(500);
        //GO BACKWARDS
        leftmotor.setPower(base);
        leftmotor2.setPower(base);
        rightmotor.setPower(base);
        rightmotor2.setPower(base);
        sleep(3200);
        //Stop
        leftmotor.setPower(0);
        leftmotor2.setPower(0);
        rightmotor.setPower(0);
        rightmotor2.setPower(0);
        //Move thing down
        DcMotor atach2 = hardwareMap.get(DcMotor.class, "atach2");
        atach2.setPower(0.4);
        sleep(1000);
        atach2.setPower(0);
    }
}
