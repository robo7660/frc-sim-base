package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveTime extends CommandBase {
    private final DriveSubsystem m_drive;
    private Double m_driveTime = 0.0;
    private Double m_speed = 0.6;
    private final Timer m_timer = new Timer();

  
    public DriveTime(DriveSubsystem drive, Double time, Double speed) {
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(drive);
  
      m_drive = drive;
      m_driveTime = time;
      m_speed = speed;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
      m_timer.reset();
      m_timer.start();
      m_drive.setDrive(m_speed, 0);
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      if (m_timer.get() > m_driveTime) {
        m_drive.setDrive(0, 0);
      } else {
        // I'm 98% sure this is not necessary here, but not able to verify.
        m_drive.setDrive(m_speed, 0);
      }
  }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
      m_drive.setDrive(0, 0);
    }
  
    // Returns true when the command should end.

  }
