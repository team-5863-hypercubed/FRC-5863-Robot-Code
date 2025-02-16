/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.*;
import frc.robot.subsystems.Travel;
/**
 * An example command that uses an example subsystem.
 */
public class Traveller extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  
  double rightStickX;
  double rightStickY;
  boolean leftBumper;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Traveller() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.m_travel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    rightStickX = Robot.m_input.testController.getX(Hand.kRight);
    //rightStickY  = Robot.m_input.testController.getY(Hand.kRight);
    leftBumper = Robot.m_input.testController.getBumper(Hand.kLeft);
    
    if (rightStickX > 0 && leftBumper == true) {
      Robot.m_travel.TravelMove(-rightStickX);
    }
    if (rightStickX < 0 && leftBumper == true) {
      Robot.m_travel.TravelMove(rightStickX);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}