// Main
//
// Run this every time there's a content update. Move the files it creates to the js folder.

import java.io.*;

public class Main 
{
	public static void main(String[] args) throws IOException
	{
		 PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("src/Objects"))));
		// PrintWriter pw2 = new PrintWriter(new BufferedWriter(new FileWriter(new File("src/ParsedItems"))));
		PrintWriter pw3 = new PrintWriter(new BufferedWriter(new FileWriter(new File("src/TestFile"))));
		
		Puller p = new Puller();
		EquipmentGetter eg = new EquipmentGetter();
		 String ts = p.oneXmlLine();
		
		
		// this loop creates a local copy of the objects file
		while (!ts.contains("</Objects>"))
		{
			// if slash when they create more proc items for no reason this might break again.

				pw.println(ts);
				//System.out.println(ts);
				//pw2.print(p.interpretOneItem(ts));
			ts = p.oneXmlLine();
		}
		
		
		// this should be run every time i use this to update the builder, but i commented it out because
		// it takes a lot of time and it wasn't what i was testing.
		//p.saveImages();
		
		p.stFile();
		
		pw.close();
		// pw2.close();
		pw3.close();
	}

}
