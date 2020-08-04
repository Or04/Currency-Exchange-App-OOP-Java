package currency;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.BorderLayout;
import javax.swing.*;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by Amit Shwartz on 20/07/2017.
 */
public class RunProg {
	
    public static void main(String[] args)throws IOException
    {	
        GUIamit GUI = new GUIamit("Currency Convertor");
        SwingUtilities.invokeLater(GUI);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane(GUI.Table());
        GUI.add(scrollPane, BorderLayout.CENTER);
        GUI.setSize(550, 500);
        GUI.setVisible(true);
        
    }
}
