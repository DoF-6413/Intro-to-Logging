package frc.robot.subsystems.motor;

import org.littletonrobotics.junction.AutoLog;

public interface MotorIO {
  @AutoLog
  /** This serves as the base for all logged values */
  public static class MotorIOInputs {
    public double leftAppliedVolts = 0.0;
    public double leftPositionRad = 0.0;
    public double leftPositionDeg = 0.0;
    public double leftRPM = 0.0;
    public double leftCurrentAmps = 0.0;
    public double leftTempCelsius = 0.0;

    public double rightAppliedVolts = 0.0;
    public double rightPositionRad = 0.0;
    public double rightPositionDeg = 0.0;
    public double rightRPM = 0.0;
    public double rightCurrentAmps = 0.0;
    public double rightTempCelsius = 0.0;
  }

  /** Updates the set of loggable inputs. */
  public default void updateInputs(MotorIOInputs inputs) {}

  public default void setSpeed(double percent) {}

  public default void setVoltage(double volts) {}
}
