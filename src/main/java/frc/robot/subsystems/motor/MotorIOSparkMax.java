package frc.robot.subsystems.motor;
import frc.robot.subsystems.motor.*;
import frc.robot.Constants;
import frc.robot.Constants.motorConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.units.Units;
import com.revrobotics.CANSparkBase.IdleMode;

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
  }

  // Define any other mehods needed to for your Motor below...
}
