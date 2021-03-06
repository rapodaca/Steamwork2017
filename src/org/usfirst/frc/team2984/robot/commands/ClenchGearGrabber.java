package org.usfirst.frc.team2984.robot.commands;

import org.usfirst.frc.team2984.robot.subsystems.GearGrabber;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ClenchGearGrabber extends Command {
	private GearGrabber grabber = GearGrabber.getInstance();
	
	public ClenchGearGrabber(){
		requires(grabber);
	}
	
	@Override
	protected void execute() {
		SmartDashboard.putBoolean("Maybe?", true);
		grabber.clench();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
