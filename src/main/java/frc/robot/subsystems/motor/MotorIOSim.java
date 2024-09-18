package frc.robot.subsystems.motor;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import frc.robot.Constants.MotorConstants;
import frc.robot.Constants.RobotStateConstants;

public class MotorIOSim implements MotorIO {
  // Declare any objects below needed to run your Motor Simunlation...
  private final FlywheelSim motorSim;

  /** Creates a new MotorIOSim. Instansiate all objects in this method */
  public MotorIOSim() {
    System.out.println("[Init] Creating MotorIOSim");
    motorSim =
        new FlywheelSim(DCMotor.getNEO(1), MotorConstants.GEAR_RATIO, MotorConstants.MOI_KG_M2);
  }

  @Override
  public void updateInputs(MotorIOInputs inputs) {
    // Use your objects created above to update the logged values created in your IO file
    // inputs.{logged value} = {object}.{getValue method};
    inputs.motorCurrentAmps = motorSim.getCurrentDrawAmps();
    inputs.motorPositionRad +=
        motorSim.getAngularVelocityRadPerSec() * RobotStateConstants.LOOP_PERIODIC_SEC;
    inputs.motorPositionDeg +=
        Units.radiansToDegrees(
            inputs.motorPositionRad);
    inputs.motorRPM = motorSim.getAngularVelocityRPM();
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
