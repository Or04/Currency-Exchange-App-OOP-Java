package currency;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTable;
import org.apache.log4j.Logger;

public class GUIamit  extends JFrame implements ActionListener, Runnable{
	    private static final Logger log = Logger.getLogger(GUIamit.class);
		ViewDemo VIEW;
		FlowLayout myLayout = new FlowLayout();
		JButton convert = new JButton("go");
		JLabel res = new JLabel("---");
		JLabel d = new JLabel();
		
		private static String curr[]={"NIS","USD","GBP","JPY","EUR","AUD","CAD","DKK","NOK","ZAR","SEK","CHF","JOD","LBP","EGP"};
		
		public GUIamit(String name) throws IOException{
			super(name);
			log.info("test message");
			VIEW = new ViewDemo();
			VIEW.update();
			VIEW.setBox1(new JComboBox(curr));
			VIEW.setBox2( new JComboBox(curr));

			setLayout(myLayout);
			
			d.setText(VIEW.getDate());
			JLabel Currency = new JLabel("Currency: ");
			JLabel A = new JLabel("Amount: ");
			JLabel B = new JLabel("->");
		        
			convert.addActionListener(this);
		        
			JPanel mainPan = new JPanel();
		    
			mainPan.add(d);
			mainPan.add(A);
			mainPan.add(VIEW.getAmount());
			mainPan.add(Currency);
			mainPan.add(VIEW.getBox1());
			mainPan.add(B);
			mainPan.add(VIEW.getBox2());
			mainPan.add(convert);
			add(mainPan,BorderLayout.NORTH);
		        

			/* Result components */
		        
			res.setForeground(Color.black);
			res.setBorder(BorderFactory.createCompoundBorder(
		             BorderFactory.createLineBorder(Color.black),
		             BorderFactory.createEmptyBorder(5,5,5,5)
		        ));
		        
		        JPanel result = new JPanel();

		        
		        result.add(res);
		        
		        add(result, BorderLayout.SOUTH);
		        
		        /* Update components */
		        
		        JButton update = new JButton("Update");
		        
		        update.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						/**add code that update the table according to the URL file in the Parser class*/
						
						VIEW.update();
					}
				}

			);
		        
		        add(update, BorderLayout.BEFORE_FIRST_LINE);
		}
		
	    public void actionPerformed(ActionEvent e) {
				res.setText(VIEW.ExchangeRate());
	    }



		

	 	public JTable Table()
		{
			Object rowData[][] = {
					{ VIEW.getCurrencies().get(0).getCountry(), VIEW.getCurrencies().get(0).getRate() },
					{ VIEW.getCurrencies().get(1).getCountry(), VIEW.getCurrencies().get(1).getRate() },
					{ VIEW.getCurrencies().get(2).getCountry(), VIEW.getCurrencies().get(2).getRate() },
					{ VIEW.getCurrencies().get(3).getCountry(), VIEW.getCurrencies().get(3).getRate() },
					{ VIEW.getCurrencies().get(4).getCountry(), VIEW.getCurrencies().get(4).getRate() },
					{ VIEW.getCurrencies().get(5).getCountry(), VIEW.getCurrencies().get(5).getRate() },
					{ VIEW.getCurrencies().get(6).getCountry(), VIEW.getCurrencies().get(6).getRate() },
					{ VIEW.getCurrencies().get(7).getCountry(), VIEW.getCurrencies().get(7).getRate() },
					{ VIEW.getCurrencies().get(8).getCountry(), VIEW.getCurrencies().get(8).getRate() },
					{ VIEW.getCurrencies().get(9).getCountry(), VIEW.getCurrencies().get(9).getRate() },
					{ VIEW.getCurrencies().get(10).getCountry(), VIEW.getCurrencies().get(10).getRate() },
					{ VIEW.getCurrencies().get(11).getCountry(), VIEW.getCurrencies().get(11).getRate() },
					{ VIEW.getCurrencies().get(12).getCountry(), VIEW.getCurrencies().get(12).getRate() },
					{ VIEW.getCurrencies().get(13).getCountry(), VIEW.getCurrencies().get(13).getRate() } };

			Object columnNames[] = { "Country", "Exchange Rate" };
			return new JTable(rowData, columnNames);
		}

		@Override
		public void run() {

		}
	}

