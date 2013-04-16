package Backbone;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Map {

	public enum Object {
	
		Floor, Wall, Subject, Obstacle, Exit;
	}
	
	private byte[][] data;
	private int height;
	private int width;
	List<Subject> subjects;
	
	public Map()
	{
		subjects = new ArrayList<Subject>();
		
	}
	
	public void LoadMap(BufferedImage img)
	{
		height = img.getHeight();
		width = img.getWidth();
		
		data = new byte[width][height];
		
		for(int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++)
			{
				int pix = img.getRGB(x, y);
				int r = (pix >> 16) & 0xFF;
				int g = (pix >> 8) & 0xFF;
				int b = pix & 0xFF;
				if (r > 240 && g > 240 && b > 240)
					data[x][y] = 0;
				else if (r > 100) data[x][y] = 3;
				else if (g > 100) data[x][y] = 4;
				else if (r < 10 && g < 10 && b < 10) data[x][y] = 1;
			}
		}
	}
	
	public byte getDataXY(int x, int y)
	{
		return data[x][y];
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public List<Subject> getSubjects()
	{
		return subjects;
	}
	
	public boolean changePosition(int oldPosX, int oldPosY, int newPosX, int newPosY)
	{
		if (data[newPosX][newPosY] == 0 && data[newPosX+3][newPosY] == 0 &&
				data[newPosX][newPosY] == 0 && data[newPosX+3][newPosY+3] == 0 )
		{
			data[oldPosX][oldPosY] = 0;
			data[newPosX][newPosY] = 2;
			data[oldPosX+3][oldPosY] = 0;
			data[newPosX+3][newPosY] = 2;
			data[oldPosX][oldPosY+3] = 0;
			data[newPosX][newPosY+3] = 2;
			data[oldPosX+3][oldPosY+3] = 0;
			data[newPosX+3][newPosY+3] = 2;
			data[oldPosX+2][oldPosY] = 0;
			data[newPosX+2][newPosY] = 2;
			data[oldPosX][oldPosY+2] = 0;
			data[newPosX][newPosY+2] = 2;
			data[oldPosX+2][oldPosY+2] = 0;
			data[newPosX+2][newPosY+2] = 2;
			data[oldPosX+1][oldPosY] = 0;
			data[newPosX+1][newPosY] = 2;
			data[oldPosX][oldPosY+1] = 0;
			data[newPosX][newPosY+1] = 2;
			data[oldPosX+1][oldPosY+1] = 0;
			data[newPosX+1][newPosY+1] = 2;
			data[oldPosX+1][oldPosY+2] = 0;
			data[newPosX+1][newPosY+2] = 2;
			data[oldPosX+1][oldPosY+3] = 0;
			data[newPosX+1][newPosY+3] = 2;
			data[oldPosX+3][oldPosY+1] = 0;
			data[newPosX+3][newPosY+1] = 2;
			data[oldPosX+3][oldPosY+2] = 0;
			data[newPosX+3][newPosY+2] = 2;
			data[oldPosX+2][oldPosY+3] = 0;
			data[newPosX+2][newPosY+3] = 2;
			data[oldPosX+2][oldPosY+1] = 0;
			data[newPosX+2][newPosY+1] = 2;
			return true;
		}
		return false;
	}
	
}
