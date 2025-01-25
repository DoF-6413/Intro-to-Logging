package frc.robot.subsystems.motor;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.math.util.Units;

public class MotorIOSparkMax implements MotorIO {
  /** Creates a new MotorIOSparkMax. Instansiate all objects in this method */
  private final CANSparkMax leftMotor;

  private final CANSparkMax rightMotor;
  private final RelativeEncoder leftRelativeEncoder;
  private final RelativeEncoder rightRelativeEncoder;

  public MotorIOSparkMax() {
    System.out.println("[Init] Creating ALGAE end effector");

    leftMotor = new CANSparkMax(MotorConstants.LEFT_CAN_ID, MotorType.kBrushless);
    rightMotor = new CANSparkMax(MotorConstants.RIGHT_CAN_ID, MotorType.kBrushless);

    leftRelativeEncoder = leftMotor.getEncoder();
    rightRelativeEncoder = rightMotor.getEncoder();

    /** Defaults to brake mode on initialization */
    leftMotor.setIdleMode(IdleMode.kBrake);
    rightMotor.setIdleMode(IdleMode.kBrake);

    /** Sets the current limit of the motors */
    leftMotor.setSmartCurrentLimit(MotorConstants.CURRENT_LIMIT_A);
    rightMotor.setSmartCurrentLimit(MotorConstants.CURRENT_LIMIT_A);

    /** Saves the configuration to the SPARKMAX */
    leftMotor.burnFlash();
    rightMotor.burnFlash();
  }

  @Override
  public void updateInputs(MotorIOInputs inputs) {
    inputs.leftAppliedVolts = leftMotor.getAppliedOutput() * leftMotor.getBusVoltage();
    inputs.leftCurrentAmps = leftMotor.getOutputCurrent();
    inputs.leftTempCelsius = leftMotor.getMotorTemperature();
    inputs.leftRPM = leftRelativeEncoder.getVelocity() / MotorConstants.LEFT_GEAR_RATIO;
    inputs.leftPositionRad = leftRelativeEncoder.getPosition() * MotorConstants.LEFT_GEAR_RATIO;
    inputs.leftPositionDeg =
        Units.radiansToDegrees(leftRelativeEncoder.getPosition() * MotorConstants.LEFT_GEAR_RATIO);

    inputs.rightAppliedVolts = rightMotor.getAppliedOutput() * leftMotor.getBusVoltage();
    inputs.rightCurrentAmps = rightMotor.getOutputCurrent();
    inputs.rightTempCelsius = rightMotor.getMotorTemperature();
    inputs.rightRPM = rightRelativeEncoder.getVelocity() / MotorConstants.RIGHT_GEAR_RATIO;
    inputs.rightPositionRad = rightRelativeEncoder.getPosition() * MotorConstants.RIGHT_GEAR_RATIO;
    inputs.rightPositionDeg =
        Units.radiansToDegrees(
            rightRelativeEncoder.getPosition() * MotorConstants.RIGHT_GEAR_RATIO);
  }

  @Override
  public void setVoltage(double volts) {
    leftMotor.setVoltage(volts);
    rightMotor.setVoltage(volts);
  }

  @Override
  public void setSpeed(double percent) {
    leftMotor.set(percent);
    rightMotor.set(percent);
  }
}
