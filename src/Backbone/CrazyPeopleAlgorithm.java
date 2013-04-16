package Backbone;

import java.util.Random;

public class CrazyPeopleAlgorithm implements Algorithm {

	Simulator s;
	Map m;
	
	public CrazyPeopleAlgorithm(Simulator s)
	{
		this.s = s;
		m = s.getMap();
	}
	
	
	@Override
	public boolean move(Subject subject) {
		
		Random rand = new Random();
		int offsetX = rand.nextInt(3) -1;
		int offsetY = rand.nextInt(3) -1;
		int oldPosX = subject.getPositionX();
		int oldPosY = subject.getPositionY();
		subject.setPositionX(oldPosX + offsetX*4);
		subject.setPositionY(oldPosY + offsetY*4);
		if (m.changePosition(oldPosX, oldPosY, subject.getPositionX(), subject.getPositionY()))
			return true;
		else
		{
			subject.setPositionX(oldPosX);
			subject.setPositionY(oldPosY);
			return false;
		}
	}
	
}
