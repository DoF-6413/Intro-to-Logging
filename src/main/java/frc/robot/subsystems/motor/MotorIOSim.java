package frc.robot.subsystems.motor;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import frc.robot.Constants;
import frc.robot.Constants.RobotStateConstants;

public class MotorIOSim implements MotorIO {
  // Declare any objects below needed to run your Motor Simunlation...
  private final FlywheelSim motorSim;

  /** Creates a new MotorIOSim. Instansiate all objects in this method */
  public MotorIOSim() {
    System.out.println("[Init] Created Motor IO Sim");
    motorSim =
        new FlywheelSim(
            DCMotor.getNEO(1),
            Constants.motorConstants.gearRatio,
            Constants.motorConstants.momentOfInertia);
  }

  @Override
  public void updateInputs(MotorIOInputs inputs) {
    // Use your objects created above to update the logged values created in your IO file
    // inputs.{logged value} = {object}.{getValue method};
    inputs.motorCurrentAmps = motorSim.getCurrentDrawAmps();
    inputs.motorRPM = motorSim.getAngularVelocityRPM();
    inputs.positionDegrees +=
        Units.radiansToDegrees(
            motorSim.getAngularVelocityRadPerSec() * RobotStateConstants.LOOP_PERIODIC_SEC);
    inputs.positionRadians +=
        motorSim.getAngularVelocityRadPerSec() * RobotStateConstants.LOOP_PERIODIC_SEC;
  }

  // Define any other mehods needed to for your Motor below...
  @Override
  public void setSpeed(double percent) {
    motorSim.setInputVoltage(percent * RobotStateConstants.BATTERY_VOLTAGE);
  }

  @Override
  public void setVoltage(double volts) {
    motorSim.setInputVoltage(volts);
  }
}
