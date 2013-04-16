package Backbone;

import javax.swing.*; 
import java.awt.*; 

public class PaintImage extends JPanel 
{ 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
Map map; 
  
  public PaintImage (Map map) 
  { 
	  super(); 
      this.map = map;

  } 

  public void paintComponent(Graphics g) 
  { 
	  
		for(int x = 0; x < map.getWidth(); x++)
		{
			for (int y = 0; y < map.getHeight(); y++)
			{
				Color color;
				byte data = map.getDataXY(x,y);
				if (data == 0)
					color = new Color(255,255,255);
				else if (data == 1)
					color = new Color(0,0,0);
				else if (data == 2)
					color = new Color(0,0,150);	
				else if (data == 3)
					color = new Color(150,0,0);		
				else
					color = new Color(0,150,0);
				g.setColor(color);
				g.drawRect(x, y, 0, 0);
			}
		}
       
      repaint(); 
  } 

}