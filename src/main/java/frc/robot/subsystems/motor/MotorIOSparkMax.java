package frc.robot.subsystems.motor;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.math.util.Units;
import frc.robot.Constants.motorConstants;

public class MotorIOSparkMax implements MotorIO {
  // Declare any objects below necessary to run your Motor connected to a SPARKMAX speed
  // controller...
  private CANSparkMax motor;
  private RelativeEncoder encoder;

  /** Creates a new MotorIOSparkMax. Instansiate all objects in this method */
  public MotorIOSparkMax() {
    System.out.println("[init] Creating MotorIO SparkMax");
    motor = new CANSparkMax(motorConstants.CanSparkMax_Id, MotorType.kBrushless);
    encoder = motor.getEncoder();
    motor.setIdleMode(IdleMode.kBrake);
    motor.setInverted(motorConstants.motorInvertido);
  }

  @Override
  public void updateInputs(MotorIOInputs inputs) {
    // Use your objects created above to update the logged values created in your IO file
    // inputs.{logged value} = {object}.{getValue method};
    inputs.motorAppliedVolts = motor.getAppliedOutput() * motor.getBusVoltage();
    inputs.motorCurrentAmps = motor.getOutputCurrent();
    inputs.motorRPM = encoder.getVelocity();
    inputs.positionDegrees = Units.rotationsToDegrees(encoder.getPosition());
    inputs.positionRadians = Units.rotationsToRadians(encoder.getPosition());
  }

  // Define any other mehods needed to for your Motor below...
  @Override
  public void setSpeed(double percent) {
    motor.set(percent);
  }

  @Override
  public void setVoltage(double volts) {
    motor.setVoltage(volts);
  }
}
