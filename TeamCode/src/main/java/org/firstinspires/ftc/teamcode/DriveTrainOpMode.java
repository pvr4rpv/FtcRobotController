package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class DriveTrainOpMode extends OpMode {

    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;

    @Override
    public void init() {
        leftDrive  = hardwareMap.get(DcMotor.class, "left_front_motor");
        rightDrive = hardwareMap.get(DcMotor.class, "right_front_motor");

        // Reverse the right motor if needed
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        // Tank drive: one stick for each side
        double leftPower  = -gamepad1.left_stick_y;
        double rightPower = -gamepad1.right_stick_y;

        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);

        telemetry.addData("Left Power", leftPower);
        telemetry.addData("Right Power", rightPower);
    }
}