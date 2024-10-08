// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.motor;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Motor extends SubsystemBase {
  // Declare any objects here...
  private final MotorIO io;
  private final MotorIOInputsAutoLogged inputs = new MotorIOInputsAutoLogged();
  /** Creates a new Motor. Instansiate all objects in this method */
  public Motor(MotorIO io) {
    System.out.print("[Init] Creating Motor");
    this.io = io;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    io.updateInputs(inputs);
    Logger.processInputs("motor", inputs);
  }

  // Define all methods needed for your Motor below...
  public void setSpeed(double percent) {
    io.setSpeed(percent);
  }

  public void setVoltage(double volts) {
    io.setVoltage(volts);
  }
}
