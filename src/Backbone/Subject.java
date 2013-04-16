package Backbone;

public class Subject {

	private int positionX;
	private int positionY;
	private int directionX;
	private int directionY;
	private State state;
	
	public Subject()
	{
		state = State.Escaping;
	}
	
	public Subject(int x, int y)
	{
		state = State.Escaping;
		positionX = x;
		positionY = y;
	}
	
	
	public enum State
	{
		Escaping, Escaped
	}
	
	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getDirectionX() {
		return directionX;
	}

	public void setDirectionX(int directionX) {
		this.directionX = directionX;
	}

	public int getDirectionY() {
		return directionY;
	}

	public void setDirectionY(int directionY) {
		this.directionY = directionY;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
