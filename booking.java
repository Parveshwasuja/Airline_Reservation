import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.*;
import javax.swing.table.*;
import java.text.*;
import java.time.format.DateTimeFormatter;

public class booking extends JInternalFrame implements ActionListener{
	Container c = getContentPane();
	Connection con;
  Statement stmt;
	JLabel l1,l2,l3,l4,l5,lb,l6,lb1;
	JComboBox cb1,cb2,cb3,cb4,cb5,cb6;
	JTextField t1;
	JButton b1;
	String []cols = {"S No.","Aircraft Code","Departure time","Arrival time","Journey hours","Available eco Seats","Available buis seats","Price"};
	Object obj[][];
	JTable jt;
  JScrollPane jsp;
  int num=0;
	ArrayList list1;
  ArrayList list2;
	java.util.Date cd = new java.util.Date();
	java.util.Date bd = new java.util.Date();
	java.util.Date d1 = new java.util.Date();
	SimpleDateFormat sdf1 = new SimpleDateFormat("d-M-yyyy");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-M-d");
  JDesktopPane pane1;
  int temp1=0;

	JButton but[];
	booking(JDesktopPane p){

    super("Booking",true,true,true,true);
    pane1 = p;
    
		sdf1.setLenient(false);
		list1 = new ArrayList();
	  //setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(1366,712);
      //setTitle("Flights booking");
      setLayout(null);
      c.setBackground(Color.white);

      l1 = new JLabel("Origin");
      l2 = new JLabel("Destination");
      l3 = new JLabel("Departure Date");
      l4 = new JLabel("Passengers");
      l5 = new JLabel("Class");
      l6 = new JLabel("(dd-mm-yyyy)");

      t1 = new JTextField(30);

      b1 = new JButton("Search");
      add(b1);
      b1.setFont(new Font("Arial",Font.BOLD,15));
      b1.setForeground(Color.white);
      b1.setBackground(Color.red);
      b1.setBounds(600,360,100,32);


      t1.setFont(new Font("Arial",Font.BOLD,16));

      l1.setFont(new Font("Arial",Font.BOLD,20));
      l2.setFont(new Font("Arial",Font.BOLD,20));
      l3.setFont(new Font("Arial",Font.BOLD,20));
      l4.setFont(new Font("Arial",Font.BOLD,20));
      l5.setFont(new Font("Arial",Font.BOLD,20));
      l6.setForeground(Color.red);

      add(l1);
      add(l2);
      add(l3);
      add(l4);
      add(l5);
      add(l6);

      b1.addActionListener(this);

      cb1=new JComboBox();
      add(cb1);
      cb1.setFont(new Font("Arial",Font.BOLD,15));
      cb1.setBackground(Color.white);
      cb1.addItem("Choose city");

      cb2=new JComboBox();
      add(cb2);
      cb2.setFont(new Font("Arial",Font.BOLD,15));
      cb2.setBackground(Color.white);
      cb2.addItem("Choose city");

      add(t1);

      cb3 = new JComboBox();
      add(cb3);
      cb3.setFont(new Font("Arial",Font.BOLD,15));
      cb3.setBackground(Color.white);
      cb3.addItem("Adults");
      for(int i=1;i<=10;i++){
        cb3.addItem(String.valueOf(i));
      }

      cb4 = new JComboBox();
      add(cb4);
      cb4.setFont(new Font("Arial",Font.BOLD,15));
      cb4.setBackground(Color.white);
      cb4.addItem("Children");
      for(int i=1;i<=4;i++){
      	cb4.addItem(String.valueOf(i));
      }

      cb5 = new JComboBox();
      add(cb5);
      cb5.setFont(new Font("Arial",Font.BOLD,15));
      cb5.setBackground(Color.white);
      cb5.addItem("Infants");
      for(int i=1;i<=2;i++){
      	cb5.addItem(String.valueOf(i));
      }

      cb6 = new JComboBox();
      add(cb6);
      cb6.setFont(new Font("Arial",Font.BOLD,15));
      cb6.setBackground(Color.white);
      cb6.addItem("Class");
      cb6.addItem("Economy");
      cb6.addItem("Buisness");

      l1.setBounds(350,100,250,32);
      l2.setBounds(350,150,250,32);
      l3.setBounds(350,200,250,32);
      l4.setBounds(350,250,250,32);
      l5.setBounds(350,300,250,32);
      l6.setBounds(750,200,100,30);

      cb1.setBounds(600,100,150,32);
      cb2.setBounds(600,150,150,32);
      t1.setBounds(600,200,150,32);
      cb3.setBounds(600,250,150,32);
      cb4.setBounds(800,250,150,32);
      cb5.setBounds(1000,250,150,32);
      cb6.setBounds(600,300,150,32);

      try{
      	Class.forName("com.mysql.cj.jdbc.Driver");
        con =DriverManager.getConnection("jdbc:mysql://localhost/FlightReservation","root","");
        stmt = con.createStatement();
        String inserts="select distinct source from route";
        ResultSet rs = stmt.executeQuery(inserts);
        while(rs.next()){
           cb1.addItem(rs.getString(1));
        }
        String insertd = "select distinct destination from route";
        ResultSet rs2 = stmt.executeQuery(insertd);
        while(rs2.next()){
        	cb2.addItem(rs2.getString(1));
        }
      }
      catch(Exception ex){
        
      	JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
      }
      /*ImageIcon ii = new ImageIcon("vistara.jpg");
      lb = new JLabel(ii);
      add(lb);
      lb.setBounds(0,0,1366,750);*/
      
     
      //setVisible(true);
      /*ImageIcon ii = new ImageIcon("airplan2.jpeg");
          lb1 = new JLabel(ii);
          add(lb1);
          lb1.setBounds(0,0,1366,750);*/


	}

	public void actionPerformed(ActionEvent e){
		try{
			if(e.getSource()==b1){
        

					Calendar d = Calendar.getInstance();
          String bdate = String.valueOf(d.get(Calendar.DATE))+"-"+String.valueOf(d.get(Calendar.MONTH)+1)+"-"+String.valueOf(d.get(Calendar.YEAR));
				if(cb1.getSelectedIndex()==0 || cb2.getSelectedIndex()==0 || cb3.getSelectedIndex()==0 || cb6.getSelectedIndex()==0 || t1.getText().trim().length()==0){
					JOptionPane.showMessageDialog(this,"Fields can not be empty");
				}
				else{
          
          
        try{
					cd = sdf1.parse(bdate);
					bd = sdf1.parse(t1.getText());
        }
        catch(ParseException f3){
          temp1=1;
           if(jsp!=null){
                remove(jsp);
                jsp=null;
                jt=null;
                if(but.length>0){
                  for(int n=0;n<but.length;n++){
                    remove(but[n]);
                  }
                }
               repaint();
        }
          JOptionPane.showMessageDialog(this,"Enter a valid date");

        }
					
                    
          if(bd.after(cd)){

                    		String get1 = "Select timing.a_code,timing.departure,timing.arrival,timing.j_hours from timing join route on timing.a_code=route.a_code where source='"+cb1.getSelectedItem()+"' and destination='"+cb2.getSelectedItem()+"'";
                     try{
                          String count = "Select count(*) as size from ("+get1+") as t;";
                          ResultSet dum1 = stmt.executeQuery(count);
                          if(dum1.next()){
                            num = dum1.getInt(1);
                          }
                          dum1.close();
                     }
                     catch(Exception ex5){

                     }
					ResultSet rs = stmt.executeQuery(get1);
					int i=0;
					int j=1;
          list1.clear();
					String data="";
          obj = new Object[num][8];
          
          Calendar daa = Calendar.getInstance();
          String bdate1 = String.valueOf(daa.get(Calendar.YEAR))+"-"+format(String.valueOf(daa.get(Calendar.MONTH)+1))+"-"+format(String.valueOf(daa.get(Calendar.DATE)));
          String ddate1 = String.valueOf(t1.getText());
          DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-M-d");
          LocalDate date3 = LocalDate.parse(bdate1,formatter3);
          DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("d-M-yyyy");
          LocalDate date4 = LocalDate.parse(ddate1,formatter4);

          Period diff1 = Period.between(date3,date4);
          int years1 = diff1.getYears();
          int months1 = diff1.getMonths();
          int days1 = diff1.getDays();
					
					while(rs.next()){
						obj[i][0] = String.valueOf(j);
						j++;
               data = rs.getString(1);
              list1.add(data);
						obj[i][1] = data;
						obj[i][2] = rs.getString(2);
						obj[i][3] = rs.getString(3);
						obj[i][4] = rs.getString(4);
						i++;
					}
					i=0;
					int no_of_tickets = cb3.getSelectedIndex() + cb4.getSelectedIndex();
					int available_eco_seats=0;
					int available_buis_seats=0;
					String showdate = t1.getText();
					d1 = sdf1.parse(showdate);
					String matchdate = sdf2.format(d1);

					for(int k=0;k<list1.size();k++){
                        
                        String get3 = "select * from flightbookinginfo where a_code='"+list1.get(k)+"' and departuredate='"+matchdate+"'";
					            ResultSet rs3 = stmt.executeQuery(get3);
					    if(!rs3.next()){

                             String get4 = "select * from fleetinfo where a_code='"+list1.get(k)+"'";
                             ResultSet rs4 = stmt.executeQuery(get4);
                             if(rs4.next()){
                             	available_eco_seats = rs4.getInt(3);
                             	available_buis_seats = rs4.getInt(4);
                             	obj[i][5] = String.valueOf(available_eco_seats);
                             	obj[i][6] = String.valueOf(available_buis_seats);
                             	
                             }
					    }
					    else{
				       
				       	     available_eco_seats = rs3.getInt(4);
				       	     available_buis_seats = rs3.getInt(5);
					         obj[i][5] = String.valueOf(available_eco_seats);
					         obj[i][6] = String.valueOf(available_buis_seats);
					      
					   }
             String get22 = "select * from route where a_code='"+list1.get(k)+"'";
             ResultSet rs22 = stmt.executeQuery(get22);
             int baseprice1=0;
            if(rs22.next()){
                  
                 baseprice1 = rs22.getInt(5);
            }
            double per_ticket_charge1=0.0;
                       if(years1>0)
                       {
                        per_ticket_charge1 = (double)baseprice1;
                       }else
                       {
                         if(months1>=1)
                         {
                          per_ticket_charge1 = (double)baseprice1;
                         }
                         else
                         {
                          if(days1<5)
                          {
                            per_ticket_charge1 = (double)baseprice1 + (double)baseprice1/2.0;
                          }
                          else
                          {
                            if(days1<10)
                            {
                                  per_ticket_charge1 = (double)baseprice1 + (double)baseprice1/3.0;
                            }
                            else
                            {
                              if(days1<20)
                              {
                                per_ticket_charge1 = (double)baseprice1 + (double)baseprice1/4.0;
                              }
                              else
                              {
                                per_ticket_charge1 = (double)baseprice1 + (double)baseprice1/10.0;
                              }
                            }
                          }
                         }
                       }
                       if(cb6.getSelectedIndex()==2){
                          
                          per_ticket_charge1=(2.0)*(per_ticket_charge1);
                        }

                       obj[i][7] = String.valueOf(per_ticket_charge1);
                       i++;
             

					}
          

          

          if(  String.valueOf(cb1.getSelectedItem()).trim().equals(String.valueOf(cb2.getSelectedItem()).trim())  )
          {
             if(jsp!=null){
                remove(jsp);
                jsp=null;
                jt=null;
                if(but.length>0){
                  for(int n=0;n<but.length;n++){
                    remove(but[n]);
                  }
                }
               repaint();
        }
            JOptionPane.showMessageDialog(this,"Source and Destination must be different");

          }
          else
          {

					if(  num>0 && ((cb6.getSelectedIndex()==1 && available_eco_seats>=no_of_tickets) ||  (cb6.getSelectedIndex()==2 && available_buis_seats>=no_of_tickets)))
          {

             if(jsp!=null){
                remove(jsp);
                jsp=null;
                jt=null;
                if(but.length>0){
                  for(int n=0;n<but.length;n++){
                    remove(but[n]);
                  }
                }
               repaint();
        }

						          jt = new JTable(obj,cols);
	                    jsp = new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	                    add(jsp);
	                    jsp.setBounds(50,400,1000,185);
	                    jt.setRowHeight(32);
	                    jt.setBackground(Color.white);
	                    jt.getTableHeader().setFont(new Font("Arial",Font.PLAIN,13));

                      TableModel tm =new mytablemodel();
                      jt.setModel(tm);

	                    but = new JButton[i];
	                    int y=425;
	                
	                   for(int a=0;a<but.length;a++)
                     {
	                	   but[a] = new JButton("Book");
	                	   add(but[a]);
	                	   but[a].addActionListener(this);
	                	   but[a].setBounds(1070,y,100,20);
	                	   y=y+35;
	                    }

					}
          else
          {
             if(jsp!=null){
                remove(jsp);
                jsp=null;
                jt=null;
                if(but.length>0){
                  for(int n=0;n<but.length;n++){
                    remove(but[n]);
                  }
                }
               repaint();
        }
            JOptionPane.showMessageDialog(this,"No flights available with required no. of tickets");

          }

        }     
           
           }
           else
           {
             if(jsp!=null){
                remove(jsp);
                jsp=null;
                jt=null;
                if(but.length>0){
                  for(int n=0;n<but.length;n++){
                    remove(but[n]);
                  }
                }
               repaint();
        }
                  JOptionPane.showMessageDialog(this,"Departure date can not behind the current date");
                } 
				}
        
			}

    

			if(bd.after(cd))
      {

			   for(int m=0;m<but.length;m++)
         {
	                if(e.getSource()==but[m])
                  {
	                	String s1 = "select booking_no from bookingmaster order by booking_no desc limit 1";
                        ResultSet rs = stmt.executeQuery(s1);
                        int booking_no=0;
                       if(rs.next()){
           	              booking_no = rs.getInt(1);
                        }
                       booking_no++;
                       Calendar d = Calendar.getInstance();
                      String bdate = String.valueOf(d.get(Calendar.YEAR))+"-"+format(String.valueOf(d.get(Calendar.MONTH)+1))+"-"+format(String.valueOf(d.get(Calendar.DATE)));
                     String ddate = String.valueOf(t1.getText());
                       
                       String from = String.valueOf(cb1.getSelectedItem());
                       String to = String.valueOf(cb2.getSelectedItem());
                       int no_of_tickets = cb3.getSelectedIndex() + cb4.getSelectedIndex();
                       try{

                       DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-M-d");
                       LocalDate date2 = LocalDate.parse(bdate,formatter2);
                       DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d-M-yyyy");
                       LocalDate date1 = LocalDate.parse(ddate,formatter1);

                       Period diff = Period.between(date2,date1);
                       int years = diff.getYears();
                       int months = diff.getMonths();
                       int days = diff.getDays();
                    
                       String aircode = String.valueOf(obj[m][1]);
                       int baseprice=0;
                       String routecode="";
                       String find = "select * from route where a_code='"+aircode+"' and source = '"+from+"' and destination='"+to+"'";
                       ResultSet rs2 = stmt.executeQuery(find);
                       if(rs2.next()){
                           routecode = rs2.getString(1);
                           baseprice = rs2.getInt(5);
                       }
                      
                       double per_ticket_charge=0.0;
                       if(years>0)
                       {
                       	per_ticket_charge = (double)baseprice;
                       }else
                       {
                       	 if(months>=1)
                         {
                       	 	per_ticket_charge = (double)baseprice;
                       	 }
                       	 else
                         {
                       	 	if(days<5)
                          {
                       	 		per_ticket_charge = (double)baseprice + (double)baseprice/2.0;
                       	 	}
                       	 	else
                          {
                       	 		if(days<10)
                            {
                                  per_ticket_charge = (double)baseprice + (double)baseprice/3.0;
                       	 		}
                       	 		else
                            {
                       	 			if(days<20)
                              {
                       	 				per_ticket_charge = (double)baseprice + (double)baseprice/4.0;
                       	 			}
                       	 			else
                              {
                       	 				per_ticket_charge = (double)baseprice + (double)baseprice/10.0;
                       	 			}
                       	 		}
                       	 	}
                       	 }
                       }
                       int no_of_eco=0;
                       int no_of_buis=0;
                       if(cb6.getSelectedIndex()==1)
                       {
                       	no_of_eco = no_of_tickets;
                       	no_of_buis = 0;

                       }else{
                       	if(cb6.getSelectedIndex()==2){
                       		no_of_buis = no_of_tickets;
                       		no_of_eco = 0;
                       		per_ticket_charge=(2.0)*(per_ticket_charge);
                       	}
                       }
                       
                       double t_amount = per_ticket_charge*no_of_tickets;

                       String dalo = "insert into bookingmaster values("+booking_no+",'"+bdate+"','"+String.valueOf(date1)+"','"+aircode+"','"+from+"','"+to+"',"+no_of_eco+","+no_of_buis+","+per_ticket_charge+","+t_amount+")";
                       stmt.executeUpdate(dalo);

                       int t_eco=0;
                       int t_buis=0;

                       String uthao = "select * from fleetinfo where a_code='"+aircode+"'";
                       ResultSet rs3 = stmt.executeQuery(uthao);
                       if(rs3.next()){
                       	  t_eco = rs3.getInt(3);
                       	  t_buis = rs3.getInt(4);
                       }
                       int a_eco = t_eco - no_of_eco;
                       int a_buis = t_buis - no_of_buis;
                       

                       int ecoseatspdihai=0;
                       int buisseatspdihai=0;
                       String routecodeinflightbookinginfo="";
                       String uthao1 = "select * from flightbookinginfo where a_code='"+aircode+"' and r_code='"+routecode+"' and departuredate='"+date1+"'";
                       ResultSet rs4 = stmt.executeQuery(uthao1);
                       if(rs4.next()){
                       	routecodeinflightbookinginfo = rs4.getString(3);
                       	ecoseatspdihai = rs4.getInt(4);
                       	buisseatspdihai = rs4.getInt(5);
                       	String update = "update flightbookinginfo set a_eco_seats="+(ecoseatspdihai-no_of_eco)+",a_buis_seats="+(buisseatspdihai-no_of_buis)+" where a_code='"+aircode+"' and departuredate='"+date1+"' and r_code='"+routecodeinflightbookinginfo+"'";
                       	 stmt.executeUpdate(update);
                
                       }
                       else{
                       	String dalo2 = "insert into flightbookinginfo values('"+aircode+"','"+String.valueOf(date1)+"','"+routecode+"',"+a_eco+","+a_buis+")";
                       	stmt.executeUpdate(dalo2);

                       }
           
                       
                       pdetails obj1 = new pdetails(booking_no);
                       obj1.show();
                      try{
                          obj1.setMaximum(true);
                      }
                      catch(Exception ex){
                         //ex.printStackTrace();
                      }
                      pane1.add(obj1);
                      this.dispose();
                       
                    }
                       

                      catch(Exception ex2){
                        
                        
                      	JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
                      }
              
                }
              }
            }
            
        
         }
		catch(Exception ex){
      

      if(temp1==0){
        
         
        JOptionPane.showMessageDialog(this,"Unfortunately, app is workingly stopped");
      }
			
		}
    
	}
   public String format(String x){
      if(x.length()>1){
        return x;
      }
      else{
        return "0"+x;
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

}