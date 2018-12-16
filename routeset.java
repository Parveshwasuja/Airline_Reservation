import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class routeset extends JInternalFrame implements ActionListener,ItemListener{
	Container c = getContentPane();
	Connection con;
    Statement stmt;
    JLabel l1,l2,l3,l4,lb;
    JTextField t1,t2,t3;
    JButton b1,b2;
    JComboBox cb1;
    routeset(){
        super("Create new route",true,true,true,true);
    	//setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366,712);
        //setTitle("Route Set");
        setLayout(null);
        c.setBackground(Color.white);

        l1 = new JLabel("Route code");
        l2 = new JLabel("Source");
        l3 = new JLabel("Destination");
        l4 = new JLabel("Search"); 

        add(l1);
        add(l2);
        add(l3);
        add(l4);

        l1.setFont(new Font("Arial",Font.BOLD,18));
        l2.setFont(new Font("Arial",Font.BOLD,18));
        l3.setFont(new Font("Arial",Font.BOLD,18));
        l4.setFont(new Font("Arial",Font.BOLD,18));

        t1 = new JTextField(30);
        t2 = new JTextField(30);
        t3 = new JTextField(30);

        t1.setFont(new Font("Arial" ,Font.BOLD ,15));
        t2.setFont(new Font("Arial" ,Font.BOLD ,15));
        t3.setFont(new Font("Arial" ,Font.BOLD ,15));

        add(t1);
        add(t2);
        add(t3);

        b1 = new JButton("New");
        b2 = new JButton("Create");

        add(b1);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        b1.setForeground(Color.white);
        b1.setBackground(Color.blue);

        b2.setForeground(Color.white);
        b2.setBackground(Color.red);

        l1.setBounds(440,100,250,30);
        l2.setBounds(440,150,250,30);
        l3.setBounds(440,200,250,30);
        l4.setBounds(500,370,150,30);

        t1.setBounds(680,100,150,30);
        t2.setBounds(680,150,150,30);
        t3.setBounds(680,200,150,30);

        b1.setBounds(530,280,80,30);
        b2.setBounds(630,280,90,30);

        cb1 = new JComboBox();
        cb1.addItemListener(this);
        add(cb1);
        cb1.addItem("Select");
        cb1.setBounds(660,370,150,30);

        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);

        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost/FlightReservation","root","");
            stmt = con.createStatement();
            String s1 = "select * from routemaster";
            ResultSet rs3 = stmt.executeQuery(s1);
            while(rs3.next()){
            	cb1.addItem(rs3.getString(1));
            }
        }
        catch(Exception e){
        	JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
        }
        b2.setEnabled(false);
        ImageIcon ii = new ImageIcon("airplan2.jpeg");
          lb = new JLabel(ii);
          add(lb);
          lb.setBounds(0,0,1366,750);

        //setVisible(true);
    }
    public void clear(){
		t1.setText("");
		t2.setText("");
		t3.setText("");
	}
    public void actionPerformed(ActionEvent e){
    	try{
    		if(e.getSource()==b1){
    			t1.setEditable(true);
    			t2.setEditable(true);
    			t3.setEditable(true);
    			cb1.setSelectedIndex(0);
    			clear();
    			b2.setEnabled(true);
    			t1.requestFocus();
    	    }
    	    if(e.getSource()==b2){
    	    	if(t1.getText().trim().length()==0 || t2.getText().trim().length()==0 || t3.getText().trim().length()==0){
    	    		JOptionPane.showMessageDialog(this,"Fields can not be empty");
    	    	}else{
    	    		 String check = "Select * from routemaster where r_code='"+t1.getText()+"' or (source='"+t2.getText()+"' and destination='"+t3.getText()+"')";
                     ResultSet rs2 = stmt.executeQuery(check);
                     if(rs2.next()){
                         JOptionPane.showMessageDialog(this,"Route code already exists");
                     }
                     else{
                        boolean pw1 = validation.checkname(t2.getText());
                        boolean pw2 = validation.checkname(t3.getText());
                        if(pw1==false || pw2==false){
                            if(pw1==false){
                                JOptionPane.showMessageDialog(this,"Enter a valid Source");

                            }
                            else{
                                if(pw2==false){
                                    JOptionPane.showMessageDialog(this,"Enter a valid Destination");

                                }
                            }
                        }
                        else{


                     	String insert = "insert into routemaster values('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"')";
                     	stmt.executeUpdate(insert);
                     	JOptionPane.showMessageDialog(this,"Created successfully");
                        cb1.addItem(t1.getText());
                        clear();
                        b2.setEnabled(false);
                       }
                     }
    	    	}

    	    }
    	}
    	
    	catch(Exception ex){
    		JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
    	}
    }
     
    public void itemStateChanged(ItemEvent e){
    	if(e.getSource()==cb1 && e.getStateChange()==ItemEvent.SELECTED){
    		if(cb1.getSelectedIndex()==0){
    			clear();
				cb1.setSelectedIndex(0);
    		}else{
    			try{
    				b2.setEnabled(false);
					t1.setEditable(false);
                    t2.setEditable(false);
                    t3.setEditable(false);
                    String s = "select * from routemaster where r_code='"+cb1.getSelectedItem()+"'";
                    ResultSet rs = stmt.executeQuery(s);
                    if(rs.next()){
                    	t1.setText(rs.getString(1));
                    	t2.setText(rs.getString(2));
                    	t3.setText(rs.getString(3));
                    }

    			}
    			catch(Exception ex){
    				JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
    			}
    		}
    	}

    }

}