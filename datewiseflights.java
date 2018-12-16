import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.*;

public class datewiseflights extends JInternalFrame implements ActionListener{
	Container c = getContentPane();
	String query = "select distinct b.dep_date,f.a_code,f.a_name,b.source,b.destination,f.ecoseats,f.buisnessseats,fi.a_eco_seats,fi.a_buis_seats from bookingmaster as b join fleetinfo as f on b.a_code=f.a_code join flightbookinginfo as fi on b.a_code=fi.a_code and b.dep_date=fi.departuredate";
	Connection con;
    Statement stmt;
    JLabel l1,l2,lb;
    JButton b1;
    JTextField t1;
    String cols[] = {"S no.","Departure date","Aircraft code","Aircraft name","Source","Destination","Total ecoseats","Total buisness seats","Available ecoseats","Available Buisness seats"};
    JTable tb ;
    Object  obj[][] ;
    JScrollPane sp;
    int num=0;
     SimpleDateFormat sdf1 = new SimpleDateFormat("d-M-yyyy");
  SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-M-d");
  java.util.Date d1 = new java.util.Date();
    datewiseflights(){
          super("Date wise flights",true,true,true,true);
    	    sdf1.setLenient(false);
    	    sdf2.setLenient(false);
    	    //setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setSize(1366,712);
	        //setTitle("Flights booking");
	        setLayout(null);
	        c.setBackground(Color.white);

	        l1 = new JLabel("Enter Date");
	        l2 = new JLabel("DD-MM-YYYY");
	        lb = new JLabel("Selected data not found");
	        t1 = new JTextField(30);
	        b1 = new JButton("Show");

	        l1.setFont(new Font("Arial",Font.BOLD,20));
	        l2.setFont(new Font("Arial",Font.BOLD,13));
	        lb.setFont(new Font("Arial" ,Font.PLAIN ,22));
	        t1.setFont(new Font("Arial" ,Font.PLAIN ,16));
	        lb.setForeground(Color.red);
	        l2.setForeground(Color.red);

	        add(l1);
	        add(t1);
	        add(b1);
	        b1.addActionListener(this);
	        add(l2);

            l1.setBounds(550,50,200,30);
            t1.setBounds(680,50,200,30);
            b1.setBounds(600,100,100,30);
            l2.setBounds(910,50,200,30);

	        try{
	        	Class.forName("com.mysql.cj.jdbc.Driver");
                con =DriverManager.getConnection("jdbc:mysql://localhost/FlightReservation","root","");
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
            }

	        catch(Exception e){
	        	JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
	        }
	        createtable(query);

	        //setVisible(true);
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
    if(sp!=null){
    	remove(sp);
    }

     if(num!=0){
       int i=0;
       int s_no =1;
       obj= new Object[num][11];
       try{
         ResultSet rs1 = stmt.executeQuery(x);
         while(rs1.next())
         {
                    obj[i][0]=String.valueOf(s_no);
                	s_no++;
                	String date3 = rs1.getString(1);
                	d1 = sdf2.parse(date3);
                	String date4 = sdf1.format(d1);
                	obj[i][1]=date4;
                	obj[i][2]=rs1.getString(2);
                	obj[i][3]=rs1.getString(3);
                	obj[i][4]=rs1.getString(4);
                	obj[i][5]=rs1.getString(5);
                	obj[i][6]=rs1.getInt(6);
                	obj[i][7]=rs1.getInt(7);
                	obj[i][8]=rs1.getInt(8);
                	obj[i][9]=rs1.getInt(9);

           i++;
         }
       }catch(Exception ex){
         JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
       }

       tb =new JTable(obj ,cols);
       sp =new JScrollPane(tb ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       add(sp);
       tb.setRowHeight(32);
       tb.setBackground(Color.white);
       tb.setFont(new Font("Arial" ,Font.PLAIN ,15));
       tb.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
       tb.getTableHeader().setReorderingAllowed(false);   // dragging  false
       tb.setFont(new Font("Arial", Font.PLAIN, 15));
       int y=num*33+32;
       if(y>500){
       	y=500;
       }
       sp.setBounds(30,150,1300,y);
       lb.setVisible(false);
       TableModel tm =new mytablemodel();
       tb.setModel(tm);
       tb.getColumnModel().getColumn(0).setPreferredWidth(10);
     }
     else{

     	JOptionPane.showMessageDialog(this,"Selected data not found");
       /*add(lb);
       lb.setVisible(true);
       sp.setVisible(false);
       remove(sp);
       lb.setBounds(500,200,400,45);*/
     }
    }
    public class mytablemodel extends DefaultTableModel{
     mytablemodel()
     {
       super(obj ,cols);
     }
     public boolean isCellEditable(int row ,int cols){
       return false;
     }
   }
   public void actionPerformed(ActionEvent e){
   	if(e.getSource()==b1){
   		try{
   			if(t1.getText().trim().length()==0){
   				if(sp!=null){
   				remove(sp);
   				sp=null;
   				tb=null;
   				repaint();
   			}
   			createtable(query);
   			//JOptionPane.showMessageDialog(this,"Please enter any date");

   			}
   			else{

        try{
          sdf1.setLenient(false);
          sdf2.setLenient(false);
   			String date = t1.getText();
   			d1 = sdf1.parse(date);
   			String date2  = sdf2.format(d1);
   			String newquery = query+" where b.dep_date='"+date2+"'";
   			
   			if(sp!=null){
   				remove(sp);
   				sp=null;
   				tb=null;
   				repaint();
   			}
   			createtable(newquery);
        }
        catch(ParseException f){
          JOptionPane.showMessageDialog(this,"Enter a valid date");
        }
   		}

   		}
   		catch(Exception ex){
   			JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
   		}
   	}

   }
}