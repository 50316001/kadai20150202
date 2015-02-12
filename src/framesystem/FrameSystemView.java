package framesystem;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import dbconsole.MySQL;

public class FrameSystemView extends Frame implements ActionListener, WindowListener {
	private Button button1 = new Button("東アジアの平均寿命");
	CardLayout cardlayout;
	Panel panel;
	Panel btnpanel;
	
	
	public FrameSystemView(FrameSystemController controller) {
		// TODO Auto-generated constructor stub
		addWindowListener(this);
		setTitle("東アジアの平均寿命");
		panel = new Panel();
		btnpanel = new Panel();
		addWindowListener(this);
		cardlayout = new CardLayout();
		setLayout(cardlayout);
		btnpanel.add(button1,BorderLayout.CENTER);
		add(btnpanel);
		add(panel);
		button1.addActionListener(this);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==button1){
			double overall,male,female;
			String Country;
			ResultSet rs;
			MySQL mysql = new MySQL();
			rs = mysql.selectAll();
			DefaultCategoryDataset data = new DefaultCategoryDataset();
			try{
					panel.add(new Label("DataBase"));
					while(rs.next()){
						Country = rs.getString("country");
						overall = rs.getDouble("Overall life expectancy");
						male = rs.getDouble("Male life expectancy");
						female = rs.getDouble("Female life expectancy");
						data.addValue(overall,"overall",Country);
						data.addValue(male,"male",Country);
						data.addValue(female,"female",Country);
						panel.add(new Label("Country:" + Country + " Overall:" + overall + " male:" + male + " female:" + female));
					}
			}catch(SQLException et){
			}
			
			JFreeChart chart = ChartFactory.createBarChart("average life span", "Country", "average",data,PlotOrientation.VERTICAL,true,false,false);
			ChartPanel cpanel = new ChartPanel(chart);
			panel.add(cpanel);
			cardlayout.next(this);		}
	}

}
