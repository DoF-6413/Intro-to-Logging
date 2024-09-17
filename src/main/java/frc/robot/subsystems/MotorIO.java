package frc.robot.subsystems;

import org.littletonrobotics.junction.AutoLog;

public interface MotorIO {
    
    @AutoLog
    public static class MotorIOInputs {

    }

  /** Updates the set of loggable inputs. */
  public default void updateInputs(MotorIOInputs inputs) {}
}
