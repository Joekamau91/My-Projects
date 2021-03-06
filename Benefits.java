package mysql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Benefits extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	private int Plan_ID;
	private String Covered_Flag;
	private String EHB_Flag;
	private String EHB_Variance_Reason;
	private String Quant_Serv_Lmt;
	private String Service;
	private String Bene_Description;
	
	public Benefits(int ID,String EhbFlag,String CoveredFlag,String EhbVarianceReason,String QuantServLmt,String Service,String BeneDescription){
		
		this.Plan_ID=ID;
		this.Covered_Flag=CoveredFlag;
		this.EHB_Flag=EhbFlag;
		this.EHB_Variance_Reason=EhbVarianceReason;
		this.Quant_Serv_Lmt=QuantServLmt;
		this.Service=Service;
		this.Bene_Description=BeneDescription;
	}
	public int getID(){
		
		return Plan_ID;
	}
	public String EhbFlag(){
		return EHB_Flag;
	}

	public String CoveredFlag(){
		return Covered_Flag;
	}
	public String EhbVarianceReason(){
		return EHB_Variance_Reason;
	}
	
	public String QuantServLmt(){
		return Quant_Serv_Lmt;
	}
	public String Service(){
		return Service;
	}
	public String BeneDescription(){
		
		return Bene_Description;
	}
	
	public Connection getConnection()
	   {
	       Connection con;

	       try {
	           con = DriverManager.getConnection("jdbc:mysql://localhost/test_db", "root","");
	           return con;
	       } 
	      catch (Exception e) {
	           e.printStackTrace();
	           return null;
	       }
	   }
	
	 public ArrayList<Benefits> getBenefitsList()
	   {
	       ArrayList<Benefits> BenefitsList = new ArrayList<Benefits>();
	       Connection connection = getConnection();
	       
	       String query = "SELECT * FROM  `Benefits` ";//Table name
	       Statement st;
	       ResultSet rs;
	       
	       try {
	           st = connection.createStatement();
	           rs = st.executeQuery(query);
	           Benefits benefits;
	           while(rs.next())
	           {
	               benefits= new Benefits(rs.getInt("id"),rs.getString("EhbFlag"),rs.getString("CoveredFlag"),rs.getNString("EhbVarianceReason"), rs.getString("QuantServLmt"), rs.getString("Service"), rs.getString("BeneDescription"));
	               BenefitsList.add(benefits);
	           }
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	       return BenefitsList;
	   }
	   

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Benefits frame = new Benefits();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Benefits() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBenefits = new JLabel("Benefits");
		lblBenefits.setFont(new Font("Sylfaen", Font.PLAIN, 27));
		lblBenefits.setBounds(416, 33, 156, 28);
		contentPane.add(lblBenefits);
		
		JLabel lblPlanid = new JLabel("Plan_ID");
		lblPlanid.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblPlanid.setBounds(15, 65, 184, 20);
		contentPane.add(lblPlanid);
		
		textField = new JTextField();
		textField.setBounds(15, 86, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCoveredflag = new JLabel("Covered_flag");
		lblCoveredflag.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblCoveredflag.setBounds(15, 133, 146, 28);
		contentPane.add(lblCoveredflag);
		
		textField_1 = new JTextField();
		textField_1.setBounds(15, 165, 146, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEhbflag = new JLabel("EHB_Flag");
		lblEhbflag.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblEhbflag.setBounds(25, 207, 136, 20);
		contentPane.add(lblEhbflag);
		
		textField_2 = new JTextField();
		textField_2.setBounds(15, 233, 146, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEhbvariancereason = new JLabel("EHB_Variance_Reason");
		lblEhbvariancereason.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblEhbvariancereason.setBounds(15, 291, 270, 20);
		contentPane.add(lblEhbvariancereason);
		
		textField_3 = new JTextField();
		textField_3.setBounds(15, 327, 146, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblQuantservlmt = new JLabel("Quant_Serv_Lmt");
		lblQuantservlmt.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblQuantservlmt.setBounds(563, 77, 230, 20);
		contentPane.add(lblQuantservlmt);
		
		textField_4 = new JTextField();
		textField_4.setBounds(563, 122, 146, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblService = new JLabel("Service");
		lblService.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblService.setBounds(563, 168, 190, 20);
		contentPane.add(lblService);
		
		textField_5 = new JTextField();
		textField_5.setBounds(563, 207, 146, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblBenedescription = new JLabel("Bene_Description");
		lblBenedescription.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblBenedescription.setBounds(563, 278, 190, 20);
		contentPane.add(lblBenedescription);
		
		textField_6 = new JTextField();
		textField_6.setBounds(563, 327, 146, 26);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton INSERT = new JButton("Insert");
		INSERT.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 26));
		INSERT.setForeground(Color.YELLOW);
		INSERT.setBackground(Color.GREEN);
		INSERT.setBounds(31, 464, 130, 35);
		contentPane.add(INSERT);
		
		JButton UPDATE = new JButton("Update");
		UPDATE.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 26));
		UPDATE.setForeground(Color.YELLOW);
		UPDATE.setBackground(Color.GRAY);
		UPDATE.setBounds(258, 464, 146, 35);
		contentPane.add(UPDATE);
		
		JButton DISPLAY = new JButton("Display");
		DISPLAY.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 26));
		DISPLAY.setForeground(Color.YELLOW);
		DISPLAY.setBackground(Color.BLUE);
		DISPLAY.setBounds(475, 464, 146, 35);
		contentPane.add(DISPLAY);
		
	      String query = insert into Benefitsold (Plan_ID, Covered_Flag,EHB_Flag,EHB_Variance_Reason,Quant_Serv_Lmt,Service, Bene_Description)
	    	        + " values (?, ?, ?, ?, ?,?,?)";

	    	      // create the mysql insert preparedstatement
	    	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	    	      preparedStmt.setInt (1, "");
	    	      preparedStmt.setString (2, "");
	    	      preparedStmt.setString   (3, "");
	    	      preparedStmt.setString(4, "");
	    	      preparedStmt.setString(5, "");
	    	      preparedStmt.setString (2, "");
	    	      preparedStmt.setString (2, "");

	    	      // execute the preparedstatement
	    	      preparedStmt.execute();
	    	      
	    	      conn.close();
	    	    }
	    	    catch (Exception e)
	    	    {
	    	      System.err.println("Got an exception!");
	    	      System.err.println(e.getMessage());
	    	    }
	    	  }
	    	}

		
		
		
		JButton DELETE = new JButton("Delete");
		DELETE.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 26));
		DELETE.setForeground(Color.YELLOW);
		DELETE.setBackground(Color.RED);
		DELETE.setBounds(663, 464, 130, 35);
		contentPane.add(DELETE);
	}
}
