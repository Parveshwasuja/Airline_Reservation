import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class aircodedatewiseflights extends JInternalFrame implements ActionListener,ItemListener{
    Container c = getContentPane();
    Connection con;
    Statement stmt;
    JLabel l1,l2,l3,l4;
    JTextField t1,t2;
    JComboBox cb1,cb2;
    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date d1 = new java.util.Date();
    JButton b1;
    JTable jt;
    ArrayList list1;
    JScrollPane jsp;
    String cols[] = {"S no","Booking no","Ticket no","Full name","Contact","E-mail","Age","Gender"};
    Object obj [][];
    int num=0;
    
    aircodedatewiseflights(){
    	super("Aircode and date wise flights",true,true,true,true);
    	//super("Create new employee",true,true,true,true);
        list1 = new ArrayList();
    	setSize(1366,712);
	    setTitle("Flights booking");
	    setLayout(null);
	    c.setBackground(Color.white);

       l1 = new JLabel("Aircraft code");
       l2 = new JLabel("Source");
       l3 = new JLabel("Destination");
       l4 = new JLabel("Date");

       t1 = new JTextField(30);
       t2 = new JTextField(30);

       b1 = new JButton("Show");

       t1.setEditable(false);
       t2.setEditable(false);

       l1.setFont(new Font("Arial",Font.BOLD,20));
       l2.setFont(new Font("Arial",Font.BOLD,20));
       l3.setFont(new Font("Arial",Font.BOLD,20));
       l4.setFont(new Font("Arial",Font.BOLD,20));

       t1.setFont(new Font("Arial",Font.BOLD,17));
       t2.setFont(new Font("Arial",Font.BOLD,17));
       b1.setFont(new Font("Arial",Font.BOLD,13));

       add(l1);
       add(l2);
       add(l3);
       add(l4);

       add(t1);
       add(t2);

       add(b1);
       b1.addActionListener(this);

       b1.setBackground(Color.red);
       b1.setForeground(Color.white);

       cb1 = new JComboBox();
       cb2 = new JComboBox();
       cb1.setFont(new Font("Arial",Font.BOLD,13));
       add(cb1);
       cb1.addItemListener(this);
       add(cb2);
       cb2.addItemListener(this);
       cb1.addItem("Select");
       cb2.addItem("Select date");

       l1.setBounds(400,50,200,30);
       cb1.setBounds(630,50,200,30);
       l2.setBounds(230,130,200,30);
       t1.setBounds(420,130,160,30);
       l3.setBounds(720,130,200,30);
       t2.setBounds(930,130,160,30);
       l4.setBounds(500,210,130,30);
       cb2.setBounds(610,210,130,30);
       b1.setBounds(625,290,100,30);

       try{
       	    Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost/FlightReservation","root","");
            stmt = con.createStatement();
            String find_a_code = "select distinct a_code from bookingmaster";
            ResultSet rs = stmt.executeQuery(find_a_code);
            while(rs.next()){
            	cb1.addItem(rs.getString(1));
            }
       }
       catch(Exception e){
       	JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
       }
       //setVisible(true);
    }
    public void itemStateChanged(ItemEvent e){
    	try{
	    	if(e.getSource()==cb1 && e.getStateChange()==ItemEvent.SELECTED){
	    		if(cb1.getSelectedIndex()==0){
	                t1.setText("");
	                t2.setText("");
	                cb2.removeAllItems();
	                cb2.addItem("Select date");
	    		}
	    		else{
	    			String find_s_and_d = "select source,destination from route where a_code='"+cb1.getSelectedItem()+"'";
	                ResultSet rs1 = stmt.executeQuery(find_s_and_d);
	                if(rs1.next()){
	                	t1.setText(rs1.getString(1));
	                	t2.setText(rs1.getString(2));
	                }
	                cb2.removeAllItems();
	                cb2.addItem("Select date");
	                String find_date = "select distinct dep_date from bookingmaster where a_code='"+cb1.getSelectedItem()+"' order by dep_date";
	    			ResultSet rs2 = stmt.executeQuery(find_date);
	    			while(rs2.next()){
	    				d1 = sdf2.parse(rs2.getString(1));
	    				String dateshow = sdf1.format(d1);
	    				cb2.addItem(dateshow);
	    				//list1.add(rs2.getInt(2));
	    			}


	    		}

	    	}
	    }
	    catch(Exception ex){
	    	JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
	    }
    }
    public void createtable(String x){
    try{
      String query1 =" SELECT count(*) AS SIZE  FROM ("+x+")AS t";
      ResultSet rs = stmt.executeQuery(query1);
      
      while(rs.next()){
        num = rs.getInt(1);
      }
    }catch(Exception z){
      JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
    }
    if(jsp!=null){
    	remove(jsp);
    	jt = null;
    	jsp = null;
    	repaint();
    }

     if(num!=0){
       int i=0;
       int s_no =1;
       obj= new Object[num][8];
       try{
         ResultSet rs1 = stmt.executeQuery(x);
         while(rs1.next())
         {
                    obj[i][0]=String.valueOf(s_no);
                	s_no++;
                	obj[i][1]=rs1.getString(1);
                	obj[i][2]=rs1.getString(2);
                	obj[i][3]=rs1.getString(3)+" " +rs1.getString(4);
                	obj[i][4]=rs1.getString(5);
                	obj[i][5]=rs1.getString(8);
                	obj[i][6]=rs1.getInt(6);
                	obj[i][7]=rs1.getString(7);
           i++;
         }
       }catch(Exception ex){
         JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
       }

       jt =new JTable(obj ,cols);
       jsp =new JScrollPane(jt ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       add(jsp);
       jt.setRowHeight(32);
       jt.setBackground(Color.white);
       jt.setFont(new Font("Arial" ,Font.PLAIN ,15));
       jt.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
       jt.getTableHeader().setReorderingAllowed(false);   // dragging  false
       jt.setFont(new Font("Arial", Font.PLAIN, 15));
       int y=num*33+32;
       if(y>500){
       	y=500;
       }
       jsp.setBounds(30,400,1300,y);
       TableModel tm =new mytablemodel();
       jt.setModel(tm);
       jt.getColumnModel().getColumn(0).setPreferredWidth(10);
     }
     else{
     	
     	jsp=null;
     	jt = null;
     	
     	JOptionPane.showMessageDialog(this,"Selected data not found");
     }
    }
    public void actionPerformed(ActionEvent e){
    	try{
	    	if(e.getSource()==b1){
	    		if(cb2.getSelectedIndex()!=0){
               

	    		d1 = sdf1.parse(String.valueOf(cb2.getSelectedItem()));
	    		String d2 = sdf2.format(d1);
	    		String query = "select t.b_no,t.t_no,t.fname,t.lname,t.contact,t.age,t.gender,t.email from bookingtransaction as t join bookingmaster as b on t.b_no=b.booking_no where b.dep_date='"+d2+"' and a_code='"+cb1.getSelectedItem()+"'";
                createtable(query);
	               }
	               else{
	               	      JOptionPane.showMessageDialog(this,"Please Select a date");
	               }
	            
	 
	    	}
	    }
	    catch(Exception ex){
	    	JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
	    }
    }
    public class mytablemodel extends DefaultTableModel{
    	mytablemodel(){
    		super(obj,cols);
    	}
    	public boolean isCellEditable(int row,int cols){
    		return false;
    	}
    }
    public static void main(String[] args) {
    	new aircodedatewiseflights();
    }

}