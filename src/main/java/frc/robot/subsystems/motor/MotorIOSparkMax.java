package frc.robot.subsystems.motor;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.math.util.Units;
import frc.robot.Constants.MotorConstants;

public class MotorIOSparkMax implements MotorIO {

  // Declare any objects below necessary to run your Motor connected to a SPARKMAX speed
  // controller...
  private CANSparkMax Motor;
  private RelativeEncoder Encoder;

  /** Creates a new MotorIOSparkMax. Instansiate all objects in this method */
  public MotorIOSparkMax() {
    System.out.println("[innit]create motor io");
    Motor = new CANSparkMax(MotorConstants.CAN_ID, MotorType.kBrushless);
    Encoder = Motor.getEncoder();
    Motor.setIdleMode(CANSparkBase.IdleMode.kBrake);
    Motor.setInverted(MotorConstants.SET_INVERTED);
  }

  @Override
  public void updateInputs(MotorIOInputs inputs) {
    // Use your objects created above to update the logged values created in your IO file
    // inputs.{logged value} = {object}.{getValue method};
    inputs.MotorAppliedVolts = Motor.getAppliedOutput() * Motor.getBusVoltage();
    inputs.MotorCurrentAmps = Motor.getOutputCurrent();
    inputs.MotorRPM = Encoder.getVelocity();
    inputs.PositionDegrees = Units.rotationsToDegrees(Encoder.getPosition());
    inputs.PositionRadians = Units.rotationsToRadians(Encoder.getPosition());
  }

  // Define any other methods needed to for your Motor below...
  @Override
  public void SetVolts(double volts) {
    Motor.setVoltage(volts);
  }

  @Override
  public void SetSpeed(double percent) {
    Motor.set(percent);
  }
}
