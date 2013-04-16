package Backbone;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Simulator {

	Map simulationMap;
	List<Subject> subjects;
	Algorithm algorithm;
	BufferedImage image;
	
	public Simulator()
	{
		simulationMap = new Map();
		subjects = simulationMap.getSubjects();
		algorithm = new CrazyPeopleAlgorithm(this);
	}
	
	public Map getMap()
	{
		return simulationMap;
	}
	
	public void LoadMap(BufferedImage img)
	{
		simulationMap.LoadMap(img);
		image = img;
	}
	
	public List<Subject> getSubjects()
	{
		return subjects;
	}
	
	
	public void Simulate() throws InterruptedException
	{
		for (Subject s : subjects)
			simulationMap.changePosition(0, 0, s.getPositionX(), s.getPositionY());
		JFrame f = new JFrame("Window"); 
		PaintImage paintImg = new PaintImage(simulationMap);
		f.add(paintImg); 
		f.setSize(image.getWidth(), image.getHeight() + 30); 
		f.setVisible(true); 
		
		while(true)
		{
			
			if(Step()) break;
			paintImg.repaint();
			Thread.sleep(70);
			
		}
		
	}
	public boolean Step()
	{
		
		LinkedList<Subject> queue = new LinkedList<Subject>();
		
		
		for (Subject s : subjects)
		{
			if(s.getState() == Subject.State.Escaping)
				queue.add(s);
		}
		
		if (queue.isEmpty()) return true;
		while(!queue.isEmpty())
		{
			Subject subject = queue.poll();
			
			//Keep an eye on needing a count for this one
			if(!algorithm.move(subject))
				queue.offer(subject);
							
		}
		return false;
	}
	

	public static void main(String args[]) throws InterruptedException
	{
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("map.png"));
		} catch (IOException e) {
		}
		
		Simulator s = new Simulator();
		s.LoadMap(img);
		List<Subject> subs = s.getSubjects();
		subs.add(new Subject(100,100));
		subs.add(new Subject(110,170));
		subs.add(new Subject(120,150));
		subs.add(new Subject(160,120));
		subs.add(new Subject(90,290));
		subs.add(new Subject(200,200));
		subs.add(new Subject(210,270));
		subs.add(new Subject(220,250));

		s.Simulate();
		
		
	}
	
}
