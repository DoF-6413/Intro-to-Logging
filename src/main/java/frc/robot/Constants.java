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

import edu.wpi.first.wpilibj.RobotBase;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class RobotStateConstants {
    /** Defines the state of the robot */
    public static enum Mode {
      /** Running on a real robot. */
      REAL,

      /** Running a physics simulator. */
      SIM,

      /** Replaying from a log file. */
      REPLAY
    }

    /** Gets Robot Mode (Real, Sim, or Replay) */
    public static final Mode getMode() {
      if (RobotBase.isReal()) {
        return Mode.REAL;
      } else if (RobotBase.isSimulation()) {
        return Mode.SIM;
      } else {
        return Mode.REPLAY;
      }
    }

    /** Command Loop Second */
    public static final double LOOP_PERIODIC_SEC = 0.02;

    /** Average battery voltage */
    public static final int BATTERY_VOLTAGE = 12;
  }

  /** */
  public static class MotorConstants {
    /** ID of the CAN SPARKMAX connected to the Motor */
    public static final int CAN_ID = 1;

    /**
     * Sets the inversion status of the Motor to false. This means that any positive input will
     * result the Motor moving in the CCW direction and any negative input will move it CW
     */
    public static final boolean NOT_INVERTED = false;

    /** Gear ratio of 1:1 */
    public static final double GEAR_RATIO = 1;

    /** Moment of Intertia in Kg * m^2 */
    public static final double MOI_KG_M2 = 0.0001;
  }
}
