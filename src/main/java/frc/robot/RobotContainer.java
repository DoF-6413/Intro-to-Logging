// Copyright 2021-2024 FRC 6328
// http://github.com/Mechanical-Advantage
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// version 3 as published by the Free Software Foundation or
// available in the root directory of this project.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.motor.Motor;
import frc.robot.subsystems.motor.MotorIO;
import frc.robot.subsystems.motor.MotorIOSim;
import frc.robot.subsystems.motor.MotorIOSparkMax;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Declare subsystems below...
private final Motor m_MotorSubsystem;
private final CommandXboxController m_Controller;
  /** The container for the robot. Contains subsystems, IO devices, and commands. */
  public RobotContainer() {
    m_Controller = new CommandXboxController(0);
    switch (Constants.RobotStateConstants.getMode()) {
      case REAL:
        // Instansiate Motor using the "real" IO file
        m_MotorSubsystem = new Motor(new MotorIOSparkMax());

        break;

      case SIM:
        // Instansiate Motor using the sim IO file
        m_MotorSubsystem = new Motor(new MotorIOSim());

        break;

      default:
        // Instansiate Motor using the default IO file
        m_MotorSubsystem = new Motor (new MotorIO(){});

        break;
    }
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    m_MotorSubsystem.setDefaultCommand(new InstantCommand(m_MotorSubsystem.SetSpeed(doub)));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
  }
}
