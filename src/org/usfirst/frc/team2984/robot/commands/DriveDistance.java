package org.usfirst.frc.team2984.robot.commands;

import org.usfirst.frc.team2984.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveDistance extends Command {

	private double distanceForward;
	private double distanceRight;
	private DriveTrain driveTrain;
	
	private boolean reset;
	
	/**
	 * drives the given distance in inches
	 * @param distance
	 */
    public DriveDistance(double distanceRight, double distanceForward) {
    	this.distanceForward = distanceForward;
    	this.distanceRight = distanceRight;
    	this.driveTrain = DriveTrain.getInstance();
    	this.reset = true;
        requires(this.driveTrain);
    }

    protected void initialize() {

    }

    protected void execute() {
    	if(this.reset){
        	this.driveTrain.resetOrigin();
        	this.reset = false;
    	}
    	SmartDashboard.putString("Test", System.currentTimeMillis() + "");
    	this.driveTrain.moveToDistance(this.distanceRight, this.distanceForward);
    }

    protected boolean isFinished() {
        return this.driveTrain.isThere(2000, this.distanceRight, this.distanceForward);
    }

    protected void end() {
    	this.reset = true;
    }

}
