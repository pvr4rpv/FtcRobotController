package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class DriveTrainFourWheelOpMode extends OpMode {

    private DcMotor leftFront = null;
    private DcMotor rightFront = null;
    private DcMotor leftRear = null;
    private DcMotor rightRear = null;

    @Override
    public void init() {
        leftFront  = hardwareMap.get(DcMotor.class, "left_front_motor");
        rightFront = hardwareMap.get(DcMotor.class, "right_front_motor");
        leftRear   = hardwareMap.get(DcMotor.class, "left_rear_motor");
        rightRear  = hardwareMap.get(DcMotor.class, "right_rear_motor");

        // Reverse motors on one side so they spin the right way
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftRear.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        // Use just the right joystick for driving
        double drive = -gamepad1.right_stick_y; // forward/back
        double turn  = gamepad1.right_stick_x;  // left/right

        double leftPower  = drive + turn;
        double rightPower = drive - turn;

        // Set power to all 4 motors
        leftFront.setPower(leftPower);
        leftRear.setPower(leftPower);
        rightFront.setPower(rightPower);
        rightRear.setPower(rightPower);

        telemetry.addData("Left Power", leftPower);
        telemetry.addData("Right Power", rightPower);
    }
}

