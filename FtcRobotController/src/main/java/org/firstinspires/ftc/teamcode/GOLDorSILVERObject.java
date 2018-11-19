package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

public class GOLDorSILVERObject {
    //Create a object that will detect minerals
    private TFObjectDetector tfod;
    //Create Vuforia Object
    private VuforiaLocalizer vuforia;
    //Var for TensorFlow
    int tfodMonitorViewId;
    //Create variable that stores the Vuforia License Key
    private static final String VUFORIA_KEY = "AWcVaaD/////AAABmZwP74eVtklZnIyqakTO2OgZwlPh8T1HsrgYVIEDnOoyHLj2L/rcsf4swWk/DCfwjbmE1BW6y7PmkyMW4qU52qB6ne+cY0gWZ2N7K1xYZpG78NA3EWxYq8B+j81wdDD7viNoWx62SX04i5BDxzZIHpSNFfMUIBmQfEMnczuHyPOLNCN4akso3GDtigRTi+KedV0B3w7+J3yMkpWcgmMhZOMT32WAlASPl8sP2OfinvRZkX+dk0AzuMLrUyD85dbnOBrmHKllIaYp9Vky1xYvKJ96EsNGAnCGFd8KBNNLAZhwkWrBGtzRYuy1R0zLVWDYIkt85yMLBnyuC+TOd+bn+SCsWgib1mVckAhg0D8XGPkq";
    //Constructor
    GOLDorSILVERObject (int tfod) {
        //Initialize Vuforia (Refer to "initVuforia" function)
        initVuforia();
        //Initalize TensorFlow (Refer to "initTFOD" function)
        initTFOD();
        //Initalize Variable for TensorFlow
        tfodMonitorViewId = tfod;
    }
    public int updateVariables () {
            //Activate TensorFlow
            tfod.activate();
            //Create a list of all new recognized objects
            List<Recognition> objects = tfod.getUpdatedRecognitions();
            //If there is no new recognized objects
            if (objects == null) {
                //Restart loop
                return 0;
            }
            //Initalize Amount of Gold and Silver Variables
            int gold = 0;
            int silver = 0;
            //For every new identified object
            for (Recognition object : objects) {
                //If the object is gold then add one to gold variable
                if (object.getLabel().equals("Gold Mineral")) {
                    gold++;
                }
                //If the object is silver then add one to silver variable
                if (object.getLabel().equals("Silver Mineral")) {
                    silver++;
                }
            }
            return 0;

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
        //Create TensorFlow Parameters Object
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        //Initialize the TensorFlow parameters
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        //Load the models of the gold and silver minerals
        tfod.loadModelFromAsset("RoverRuckus.tflite", "Gold Mineral", "Silver Mineral");
    }
}
