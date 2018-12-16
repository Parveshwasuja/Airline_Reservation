import javax.swing.*;
import javax.swing.DefaultCellEditor;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class pdetails extends JInternalFrame implements ActionListener{
	Container c = getContentPane();
	Connection con;
    Statement stmt;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JLabel t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    String []cols = {"Ticket No.","First name","Last name","Type","Age","Gender","Phone","E-mail","Aadhar no"}; 
    Object obj[][];   
    java.util.Date d1 = new java.util.Date();
    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    int nooftickets=0;
    String v1,v2,v3,v4,v5,v6,v7,v8,v9,v10;
    JComboBox cb1,cb2;
    JTable jt;
    JButton b1,b2;
    int j;
    int b_no=0;
    int flag=0;
    ArrayList list1;
    String insertkaro[];
    pdetails(int bno){
    	
    	super("Passenger details",true,false,false,false);
    	list1 = new ArrayList();
    	b_no=bno;
    	    sdf1.setLenient(false);
    	    sdf2.setLenient(false);
	    	//setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setSize(1366,712);
	        setTitle("Flights booking");
	        setLayout(null);
	        c.setBackground(Color.white);

	        l1 = new JLabel("Booking no");
	        l2 = new JLabel("Aircraft code");
	        l3 = new JLabel("Source");
	        l4 = new JLabel("Class");
	        l5 = new JLabel("Booking Date");
	        l6 = new JLabel("Departure Date");
	        l7 = new JLabel("Destination");
	        l8 = new JLabel("No of Tickets");
	        l9 = new JLabel("Passenger Details");
	        l10 = new JLabel("Charge per Ticket");
	        l11 = new JLabel("Total amount");

	        l1.setFont(new Font("Arial",Font.BOLD,16));
	        l2.setFont(new Font("Arial",Font.BOLD,16));
	        l3.setFont(new Font("Arial",Font.BOLD,16));
	        l4.setFont(new Font("Arial",Font.BOLD,16));
	        l5.setFont(new Font("Arial",Font.BOLD,16));
	        l6.setFont(new Font("Arial",Font.BOLD,16));
	        l7.setFont(new Font("Arial",Font.BOLD,16));
	        l8.setFont(new Font("Arial",Font.BOLD,16));
	        l9.setFont(new Font("Arial",Font.BOLD,20));
	        l10.setFont(new Font("Arial",Font.BOLD,16));
	        l11.setFont(new Font("Arial",Font.BOLD,16));

	        l9.setForeground(Color.blue);

	        add(l1);
	        add(l2);
	        add(l3);
	        add(l4);
	        add(l5);
	        add(l6);
	        add(l7);
	        add(l8);
	        add(l9);
	        add(l10);
	        add(l11);

	       l1.setBounds(100,50,200,30);
	       l2.setBounds(100,110,200,30);
	       l3.setBounds(100,170,200,30);
	       l4.setBounds(100,230,200,30);
	       l5.setBounds(750,50,200,30);
	       l6.setBounds(750,110,200,30);
	       l7.setBounds(750,170,200,30);
	       l8.setBounds(750,230,200,30);
	       l9.setBounds(550,360,300,30);
	       l10.setBounds(100,290,200,30);
	       l11.setBounds(750,290,200,30);

	       try{
              
              Class.forName("com.mysql.cj.jdbc.Driver");
              con =DriverManager.getConnection("jdbc:mysql://localhost/FlightReservation","root","");
              stmt = con.createStatement();
              String class1="";
              String findkro = "select * from bookingmaster where booking_no="+bno+"";
              ResultSet rs = stmt.executeQuery(findkro);
              if(rs.next()){
              	v1 = String.valueOf(bno);

              	String sqldate1 = rs.getString(2);
              	   d1 = sdf2.parse(sqldate1);
              	String showdate1 = sdf1.format(d1);

              	String sqldate2 = rs.getString(3);
              	   d1 = sdf2.parse(sqldate2);
              	String showdate2 = sdf1.format(d1);

              	v2 = rs.getString(4);
              	v3 = rs.getString(5);
              	v7 = rs.getString(6);
              	int a = rs.getInt(7);
              	int b = rs.getInt(8);
              	v9 = String.valueOf(rs.getDouble(9))+"/-";
              	v10 = String.valueOf(rs.getDouble(10))+"/-";
              	if(a>b){
                  class1="Economy";
                  nooftickets = a;
                  v8 = String.valueOf(nooftickets);
              	}else{
              		if(b>a){
              			class1="Buisness";
              			nooftickets = b;
              			v8 = String.valueOf(nooftickets);
              		}
              	}
              	v4 = class1;

              	

                v5 = showdate1;
              	v6 = showdate2;
              	
              }

	       }
	       catch(Exception e){
	       	JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
	       }

	       t1 = new JLabel(v1);
	       t2 = new JLabel(v2);
	       t3 = new JLabel(v3);
	       t4 = new JLabel(v4);
	       t5 = new JLabel(v5);
	       t6 = new JLabel(v6);
	       t7 = new JLabel(v7);
	       t8 = new JLabel(v8);
	       t9 = new JLabel(v9);
	       t10 = new JLabel(v10);

	        t1.setFont(new Font("Arial",Font.PLAIN,17));
	        t2.setFont(new Font("Arial",Font.PLAIN,17));
	        t3.setFont(new Font("Arial",Font.PLAIN,17));
	        t4.setFont(new Font("Arial",Font.PLAIN,17));
	        t5.setFont(new Font("Arial",Font.PLAIN,17));
	        t6.setFont(new Font("Arial",Font.PLAIN,17));
	        t7.setFont(new Font("Arial",Font.PLAIN,17));
	        t8.setFont(new Font("Arial",Font.PLAIN,17));
	        t9.setFont(new Font("Arial",Font.PLAIN,17));
	        t10.setFont(new Font("Arial",Font.PLAIN,17));

	       add(t1);
	       add(t2);
	       add(t3);
	       add(t4);
	       add(t5);
	       add(t6);
	       add(t7);
	       add(t8);
	       add(t9);
	       add(t10);

	       t1.setBounds(310,50,150,30);
	       t2.setBounds(310,110,150,30);
	       t3.setBounds(310,170,150,30);
	       t4.setBounds(310,230,150,30);
	       t5.setBounds(960,50,150,30);
	       t6.setBounds(960,110,150,30);
	       t7.setBounds(960,170,150,30);
	       t8.setBounds(960,230,150,30);
	       t9.setBounds(310,290,150,30);
	       t10.setBounds(960,290,150,30);

	       obj = new Object[nooftickets][9];
	      
           try{

		       String s1 = "select t_no from bookingtransaction order by t_no desc limit 1";
	           ResultSet rs2 = stmt.executeQuery(s1);
	           int ticket_no=0;
	           if(rs2.next()){
	           	    ticket_no = rs2.getInt(1);
	            }
	            ticket_no++;
	            for(int i=0;i<nooftickets;i++){
	            	for(int j=0;j<9;j++){
	            		obj[i][0]=ticket_no;
	            	}
	            	ticket_no++;
	            }
           }
           catch(Exception e){
           	  JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
           }
            
           jt = new JTable(obj,cols);
	       JScrollPane jsp = new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	       add(jsp);
	       jt.setRowHeight(32);
	       jt.setBackground(Color.white);
	       jt.setFont(new Font("Arial",Font.PLAIN,16));
	       jt.getTableHeader().setFont(new Font("Arial",Font.BOLD,14));
	       jsp.setBounds(30,420,1290,200);


	       	TableModel tm = new mytablemodel();
	       	jt.setModel(tm);

	       	/*DefaultTableModel dtmm = new DefaultTableModel(obj,cols);
	       	jt = new JTable(dtmm)
	       	{
	       		public Component prepareRenderer(TableCellRenderer rendererr,int roww,int columnn)
	       		{
	       			Component componentt = super.pre
	       		}
	       	}*/

	       TableColumn gendercolumn = jt.getColumnModel().getColumn(5);
	       cb1 = new JComboBox();
	       add(cb1);
	       cb1.addItem("Male");
	       cb1.addItem("Female");
	       gendercolumn.setCellEditor(new DefaultCellEditor(cb1));


	       TableColumn typecolumn = jt.getColumnModel().getColumn(3);
	       cb2 = new JComboBox();
	       add(cb2);
	       cb2.addItem("Adult");
	       cb2.addItem("Child");
	       typecolumn.setCellEditor(new DefaultCellEditor(cb2));

	       //jt.setResizable(false);

	       //jt.getColumnModel().getColumn(0).setBackground(Color.red);
	       b1 = new JButton("Check in");
	       b2 = new JButton("Cancel");
	       b1.setBackground(Color.green);
	       b1.setForeground(Color.black);
	       b2.setBackground(Color.red);
	       b2.setForeground(Color.white);
	       add(b1);
	       add(b2);
	       b1.setBounds(530,640,120,30);
	       b2.setBounds(670,640,120,30);
	       b1.addActionListener(this);
	       b2.addActionListener(this);
	       insertkaro = new String[nooftickets];

	      //setVisible(true);

    }
    public class mytablemodel extends DefaultTableModel{
    	mytablemodel(){
    		super(obj,cols);
    		
    	}
    	public boolean isCellEditable(int row,int cols){
    		if(cols==0){
    			return false;
    		}
    		return true;
    	}
    	/*public Component prepareRenderer(TableCellRenderer rendererr,int roww,int columnn)
	       	{
	       			Component componentt = super.prepareRenderer(rendererr,roww,columnn);
	       			if(columnn==0){
	       				componentt.setBackground(Color.red);
	       		    }
	       		return componentt;
	       	}*/
        }
        public void actionPerformed(ActionEvent e){
        	try{
        		if(e.getSource()==b1)
        		{
        			

        			for(j=0;j<nooftickets;j++)
        			{

                        String a1 = String.valueOf(b_no);
	                    String b1 = String.valueOf(jt.getValueAt(j,0));
	                    String c1 = (String)(jt.getValueAt(j,1));
	                    
	                    String d1 = (String)(jt.getValueAt(j,2));
	                    
	                    String e1 = (String)(jt.getValueAt(j,6));
	                    
	                    String f1 = (String)(jt.getValueAt(j,7));

	                    String g1="";
	                    
	                    g1 = (String)(jt.getValueAt(j,4));
	                               
	                    String h1 = (String)(jt.getValueAt(j,3));
	                    String i1 = (String)(jt.getValueAt(j,5));
	                    String j1 = (String)(jt.getValueAt(j,8));
	                    try{

	                    if( ( c1!=null || !c1.isEmpty() ) && (d1!=null || !d1.isEmpty()) && ( h1!=null || !h1.isEmpty()) && (g1!=null || !g1.isEmpty()) && (i1!=null || !i1.isEmpty()) && (e1!=null || !e1.isEmpty()) && (j1!=null || !j1.isEmpty()))
                    {
                        
                        if( !validation.checkname(c1) || !validation.checkname(d1))
                        {
                            JOptionPane.showMessageDialog(this,"Name should contain only alphabets");
                        }
                        else if(!validation.checkcontact(e1))
                                {
                                  JOptionPane.showMessageDialog(this,"Contact should contain only wholenumbers and must be 10 digits");
                                }
                        else if(f1.length()>0 && !validation.checkemail(f1))
                                {
                                  JOptionPane.showMessageDialog(this,"Enter a valid e-mail");
                                }
                        else if(!validation.checkage(String.valueOf(g1)))
                                {
                                  JOptionPane.showMessageDialog(this,"Age should be a whole number and must be less than 100");
                                }
                        else if(!validation.checkadhaar(j1))
                                {
                                  JOptionPane.showMessageDialog(this,"Aadhaar number should contain only whole numbers and should be 12 digits");
                                }
                        else{
                               
                                   insertkaro[j] = "insert into bookingtransaction values("+a1+","+b1+",'"+c1+"','"+d1+"','"+e1+"','"+f1+"',"+g1+",'"+h1+"','"+i1+"','"+j1+"')";
                                   
                                   if(list1.size()>1){
                                   	if(list1.contains(j)){
                                   		list1.remove(j);
                                   	}

                                   }
                                   else{
                                   	list1.clear();
                                   }  
                            }
                    
                    }
                }
                    catch(NullPointerException ef){
                    	if(list1.contains(j)){

                        }
                        else{
                        	list1.add(j);
                        }
                    }
                }
                    
                        
        			
        		
        			if(list1.size()==0){
        				for(int k=0;k<nooftickets;k++){
        					stmt.executeUpdate(insertkaro[k]);
        				}
        				JOptionPane.showMessageDialog(this,"Flight is booked successfully");
        				this.dispose();
        			}
        			else{
        				
        				JOptionPane.showMessageDialog(this,"Please fill all the rows");
        			}
        		
        	    }
        	  if(e.getSource()==b2){
        	  	int ecoseats=0;
        	  	int buisseats=0;
        	  	String findkrobookingno = "select * from bookingmaster where booking_no="+b_no+"";
        	  	ResultSet dumbo = stmt.executeQuery(findkrobookingno);
        	  	if(dumbo.next()){
                   ecoseats = dumbo.getInt(7);
                   buisseats=dumbo.getInt(8);
        	  	}
        	  	int ecoseatsphlewali = 0;
        	  	int buisseatsphlewali=0;
        	  	String dd = sdf2.format(sdf1.parse(v6));
        	  	String uthaodata = "select * from flightbookinginfo where a_code='"+v2+"' and departuredate='"+dd+"'";
        	  	ResultSet combo = stmt.executeQuery(uthaodata);
        	  	if(combo.next()){
                    ecoseatsphlewali = combo.getInt(4);
                    buisseatsphlewali = combo.getInt(5);
        	  	}
        	  	String updatekroflightbookinginfo = "update flightbookinginfo set a_eco_seats ="+(ecoseatsphlewali+ecoseats)+" ,a_buis_seats="+(buisseatsphlewali+buisseats)+" where a_code='"+v2+"' and departuredate='"+dd+"'";
        	  	stmt.executeUpdate(updatekroflightbookinginfo);
        	  	String deletekrobookingmasterko = "delete from bookingmaster where booking_no="+b_no+"";
        	  	stmt.executeUpdate(deletekrobookingmasterko);
        	  	this.dispose();

        	  }
        	}
        	catch(Exception ex){
        		if(j<nooftickets-1){
        			JOptionPane.showMessageDialog(this,"Please fill all the rows");
        		}
        		ex.printStackTrace();
        		//JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
        	}
        }
    /*public static void main(String[] args) {
    	new pdetails();
    }*/
}
