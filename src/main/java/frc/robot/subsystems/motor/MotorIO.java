package frc.robot.subsystems.motor;

import org.littletonrobotics.junction.AutoLog;

public interface MotorIO {
  @AutoLog
  /** This serves as the base for all logged values */
  public static class MotorIOInputs {
    // Create your values to log from the Motor
    // They should all follow the following format:
    // public {type} {name} = {default value};
    public double motorRPM = 0.0;
    public double motorAppliedVolts = 0.0;
    public double motorCurrentAmps = 0.0;
    public double positionRadians = 0.0;
    public double positionDegrees = 0.0;
  }

  /** Updates the set of loggable inputs. */
  public default void updateInputs(MotorIOInputs inputs) {}

  // Define your other methods below.
  // These will serve as a template so no need to worry about adding any logic inside of them, that
  // will be done elsewhere
  // Note: All javadoc comments made to methods here will make them visable to all within other
  // files using them.
  public default void setVoltage(double volts) {}

  public default void setSpeed(double percent) {} // 0-1 is forward, -1 - 0 is backwards
}
