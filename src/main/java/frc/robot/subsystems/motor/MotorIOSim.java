package frc.robot.subsystems.motor;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import frc.robot.Constants.MotorConstants;
import frc.robot.Constants.RobotStateConstants;

public class MotorIOSim implements MotorIO {
  // Declare any objects below needed to run your Motor Simunlation...
  private final FlywheelSim MotorSim;
  /** Creates a new MotorIOSim. Instansiate all objects in this method */
  public MotorIOSim() {
    MotorSim =
        new FlywheelSim(
            DCMotor.getNEO(1), MotorConstants.GEAR_RATIO, MotorConstants.MOMENT_OF_INERTIA);
    System.out.println("[innit] creating motor io sim");
  }

  @Override
  public void updateInputs(MotorIOInputs inputs) {
    // Use your objects created above to update the logged values created in your IO file
    // inputs.{logged value} = {object}.{getValue method};
    inputs.MotorCurrentAmps = MotorSim.getCurrentDrawAmps();
    inputs.MotorRPM = MotorSim.getAngularVelocityRPM();
    inputs.PositionDegrees =
        Units.radiansToDegrees(
            MotorSim.getAngularVelocityRadPerSec() * RobotStateConstants.LOOP_PERIODIC_SEC);
    inputs.PositionRadians =
        MotorSim.getAngularVelocityRadPerSec() * RobotStateConstants.LOOP_PERIODIC_SEC;
    MotorSim.update(RobotStateConstants.LOOP_PERIODIC_SEC);
  }

  // Define any other mehods needed to for your Motor below...
  @Override
  public void SetVolts(double volts) {
    MotorSim.setInputVoltage(volts);
  }

  @Override
  public void SetSpeed(double percent) {
    MotorSim.setInputVoltage(percent * RobotStateConstants.BATTERY_VOLTAGE);
  }
}
