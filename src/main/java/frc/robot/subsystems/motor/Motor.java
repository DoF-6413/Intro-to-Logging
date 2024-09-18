// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.motor;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Motor extends SubsystemBase {
  // Declare any objects here...
  private final MotorIO io;
  private final MotorIOInputsAutoLogged inputs = new MotorIOInputsAutoLogged();

  /** Creates a new Motor. Instansiate all objects in this method */
  public Motor(MotorIO io) {
    System.out.println("[Init] Creating Motor");
    this.io = io;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    /* Updates the Outputs of the Motor based on the current mode of the Robot (Real, Sim, Replay) */
    io.updateInputs(inputs);
    Logger.processInputs("Motor", inputs);
  }

  // Define all methods needed for your Motor below...

  /**
   * Sets the speed of the Motor based on a percentage
   *
   * @param percent -1 to 1
   */
  public void setSpeed(double percent) {
    io.setSpeed(percent);
  }

  /**
   * Set the voltage sent to the Motor by the speed controller
   *
   * @param volts -12 to 12
   */
  public void setVoltage(double volts) {
    io.setVoltage(volts);
  }
}
