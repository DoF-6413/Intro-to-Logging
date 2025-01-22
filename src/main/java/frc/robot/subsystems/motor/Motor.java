// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.motor;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Motor extends SubsystemBase {
  private final MotorIO io;
  private final MotorIOInputsAutoLogged inputs = new MotorIOInputsAutoLogged();
  
  // private double setpointRPM = 0.0;
  /** Creates a new Motor. Instansiate all objects in this method */
  public Motor(MotorIO io) {
    this.io = io;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    this.updateInputs();
    Logger.processInputs("ALGAE", inputs);
  }

  /** Updates the set of loggable inputs for both motors */
  public void updateInputs() {
    io.updateInputs(inputs);
  }

  public void setSpeed(double percent) {
    io.setSpeed(percent);
  }

  public void setVoltage(double volts) {
    io.setVoltage(volts);
  }
}
