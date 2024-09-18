package frc.robot.subsystems.motor;

import org.littletonrobotics.junction.AutoLog;

public interface MotorIO {
  /** This serves as the base for all logged values */
  @AutoLog
  public static class MotorIOInputs {
    // Create your values to log from the Motor
    // They should all follow the following format:
    // public {type} {name} = {default value};

    /** The number of volts being sent to the Motor */
    public double motorAppliedVolts = 0.0;
    /** The current position of the Motor in radians */
    public double motorPositionRad = 0.0;
    /** The current position of the Motor in degrees */
    public double motorPositionDeg = 0.0;
    /** The velocity of the Motor in rotations per minute */
    public double motorRPM = 0.0;
    /** The Current drawn from the Motor in Amps */
    public double motorCurrentAmps = 0.0;
    /** The tempature of the Motor in Celsius */
    public double motorTempCelsius = 0.0;
  }

  /** Updates the set of loggable inputs. */
  public default void updateInputs(MotorIOInputs inputs) {}

  // Define your other methods below.
  // These will serve as a template so no need to worry about adding any logic inside of them, that
  // will be done elsewhere
  // Note: All javadoc comments made to methods here will make them visable to all within other
  // files using them.

  /**
   * Sets the speed of the Motor based on a percentage
   *
   * @param percent -1 to 1
   */
  public default void setSpeed(double percent) {}

  /**
   * Set the voltage sent to the Motor by the speed controller
   *
   * @param volts -12 to 12
   */
  public default void setVoltage(double volts) {}
}
