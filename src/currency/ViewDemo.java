package currency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Amit Shwartz on 12/08/2017.
 */
public class ViewDemo implements View {

    private Vector<CoinCurrency> currencies;
    private CurrencyParser parse;
    private JComboBox box1;
    private JComboBox box2;
    private JTextField amount;
    private String date;



    public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ViewDemo(){
        parse = new CurrencyParser();
        amount = new JTextField(12);}

    public JComboBox getBox1() {
        return box1;
    }
    public JComboBox getBox2() {
        return box2;
    }

    public Vector<CoinCurrency> getCurrencies() {
        return currencies;
    }
    public JTextField getAmount() {
        return amount;
    }
    public void setBox1(JComboBox box1) {
        this.box1 = box1;
    }

    public void setBox2(JComboBox box2) {
        this.box2 = box2;
    }


    private JLabel res = new JLabel("---");





    @Override
    public String ExchangeRate()
    {
        double ans, sub;
        /* sub = amount * box1.rate / box1.unit */
        sub = (Double.parseDouble(amount.getText())*(currencies.get(box1.getSelectedIndex()).getRate())/currencies.get(box1.getSelectedIndex()).getUnit());

        /* ans = sub * box2.unit / box2.rate */
        ans = (sub*(currencies.get(box2.getSelectedIndex()).getUnit()))/currencies.get(box2.getSelectedIndex()).getRate();

       return (Double.toString(ans));
    }

    @Override
    public void update() {
    		date = parse.get_date();
            parse.UpdateFile();
            currencies = parse.ToParse();
    }
}
