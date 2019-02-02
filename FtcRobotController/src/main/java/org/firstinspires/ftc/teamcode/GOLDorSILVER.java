package org.firstinspires.ftc.teamcode;

import android.content.Context;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

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
public class GOLDorSILVER extends LinearOpMode {
    //Create a object that will detect minerals
    private TFObjectDetector tfod;
    //Create Vuforia Object
    private VuforiaLocalizer vuforia;
    //Create variable that stores the Vuforia License Key
    private static final String VUFORIA_KEY = "AWcVaaD/////AAABmZwP74eVtklZnIyqakTO2OgZwlPh8T1HsrgYVIEDnOoyHLj2L/rcsf4swWk/DCfwjbmE1BW6y7PmkyMW4qU52qB6ne+cY0gWZ2N7K1xYZpG78NA3EWxYq8B+j81wdDD7viNoWx62SX04i5BDxzZIHpSNFfMUIBmQfEMnczuHyPOLNCN4akso3GDtigRTi+KedV0B3w7+J3yMkpWcgmMhZOMT32WAlASPl8sP2OfinvRZkX+dk0AzuMLrUyD85dbnOBrmHKllIaYp9Vky1xYvKJ96EsNGAnCGFd8KBNNLAZhwkWrBGtzRYuy1R0zLVWDYIkt85yMLBnyuC+TOd+bn+SCsWgib1mVckAhg0D8XGPkq";
    //Function to Run Op Mode
    public void runOpMode () {
        //Initialize Vuforia (Refer to "initVuforia" function)
        initVuforia();
        //Initalize TensorFlow (Refer to "initTFOD" function)
        initTFOD();
        //Wait until driver presses "Start"
        waitForStart();
        //Run while the OP Mode is running
        while (opModeIsActive()) {

        }
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
}
