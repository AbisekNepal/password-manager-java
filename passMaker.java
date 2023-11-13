
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.image.*;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;

public class passMaker extends JFrame implements ActionListener{
	
	private JLabel headerText,label1,label2,label3,label11,label22,label33; //Declaring the label
	private JTextField yourText, passwordText,websiteText,userNameText;
	private JPanel northPanel,npOne,npTwo,npThree,npFour,npFive, nppOne,nppTwo,nppThree;
	private JCheckBox alphabetOption,symbolsOption,numberOption;
	private JButton copyPassButton,generatePassButton,quitButton,saveButton,exportButton;
	private JPasswordField userPassField;
	private JSlider slider;
	private JComboBox accountOption;

	
	
	public passMaker() {
		
		super("Password Generator");
				
		
		northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(8,1));
		
		
			
		npOne = new JPanel();
		npOne.setLayout(new GridLayout(2,1));
		headerText = new JLabel("myPassManager");
		label1 = new JLabel("Let's get that perfect pas****d for you!");
			npOne.add(headerText);
			npOne.add(label1);
			
			northPanel.add(npOne);
			Font labelFont = new Font("Serif", Font.BOLD, 24);
			headerText.setFont(labelFont);
			headerText.setForeground(Color.BLUE);
			headerText.setHorizontalAlignment(JLabel.CENTER); // Center the text
			headerText.setVerticalAlignment(JLabel.CENTER);
			label1.setHorizontalAlignment(JLabel.CENTER);
			
		nppThree = new JPanel();
		label33 = new JLabel("Account:");
		String accountOpt[] = {"{select}","Personal","Office"};
		accountOption = new JComboBox(accountOpt);
			nppThree.add(label33);
			nppThree.add(accountOption);
				
			northPanel.add(nppThree);
			
		nppOne = new JPanel();
		label11 = new JLabel("Website:");
		websiteText = new JTextField(15);
			nppOne.add(label11);
			nppOne.add(websiteText);
			
			northPanel.add(nppOne);
			websiteText.addFocusListener(new FocusListener() {
                public void focusGained(FocusEvent e) {
                    if (websiteText.getText().equals("www.internet.com")) {
                    	websiteText.setText("");
                    	websiteText.setForeground(Color.BLACK);
                    }
                }

                public void focusLost(FocusEvent e) {
                    if (websiteText.getText().isEmpty()) {
                    	websiteText.setText("www.internet.com");
                    	websiteText.setForeground(Color.GRAY);
                    }
                }
			});
			
		nppTwo = new JPanel();
		label22 = new JLabel("Username:");
		userNameText = new JTextField(10);
			nppTwo.add(label22);
			nppTwo.add(userNameText);
			
			northPanel.add(nppTwo);
			userNameText.addFocusListener(new FocusListener() {
                public void focusGained(FocusEvent e) {
                    if (userNameText.getText().equals("user123")) {
                    	userNameText.setText("");
                    	userNameText.setForeground(Color.BLACK);
                    }
                }

                public void focusLost(FocusEvent e) {
                    if (userNameText.getText().isEmpty()) {
                    	userNameText.setText("user123");
                    	userNameText.setForeground(Color.GRAY);
                    }
                }
			});
		
		npTwo = new JPanel();
		label2 = new JLabel("Length:");
		slider = new JSlider(JSlider.HORIZONTAL, 10, 20, 15);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        	npTwo.add(label2);
        	npTwo.add(slider);
        	
        	northPanel.add(npTwo);
        	
        
        npThree = new JPanel();
		alphabetOption = new JCheckBox("alphabets(x,y,z)");
		symbolsOption = new JCheckBox("symbols(@,#,!)");
		numberOption = new JCheckBox("numbers(1,2,3)");
			npThree.add(alphabetOption);
			npThree.add(symbolsOption);
			npThree.add(numberOption);
			
			northPanel.add(npThree);
			
		npFour = new JPanel();
		passwordText = new JTextField(20);
			npFour.add(passwordText);
			
			northPanel.add(npFour);
			
		npFive = new JPanel();
		copyPassButton = new JButton("Copy");
		generatePassButton = new JButton("Generate");
		quitButton = new JButton("Quit");
		saveButton = new JButton("Save");
		exportButton = new JButton("Export All");

			npFive.add(copyPassButton);
			npFive.add(generatePassButton);
			npFive.add(saveButton);
			npFive.add(exportButton);
			npFive.add(quitButton);
			
			northPanel.add(npFive);
		
		
		copyPassButton.addActionListener(this);
		generatePassButton.addActionListener(this);
		quitButton.addActionListener(this);
		alphabetOption.addActionListener(this);
	    symbolsOption.addActionListener(this);
	    numberOption.addActionListener(this);
	    saveButton.addActionListener(this);
	    exportButton.addActionListener(this);

		add(northPanel,BorderLayout.NORTH);
		
		setVisible(true);
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}



	
	public static void main(String[] args) {
		passMaker app = new passMaker();
	}

	public void actionPerformed(ActionEvent event) {
		String newPass = " ";
        int passLength = 0;
        passLength = slider.getValue();
        boolean includeAlpha = false;
        boolean includeSymb = false;
        boolean includeNum = false;
        if(alphabetOption.isSelected())
        	includeAlpha = true;
        if(symbolsOption.isSelected())
        	includeSymb = true;
        if(numberOption.isSelected())
        	includeNum = true;
        
        newPass=getThatPass(passLength,includeAlpha,includeSymb,includeNum);
        
	    if (event.getSource() == copyPassButton) {
	    	StringSelection stringSelection = new StringSelection(passwordText.getText());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
	    } else if (event.getSource() == generatePassButton) {
	        
	    	newPass = getThatPass(passLength,includeAlpha,includeSymb,includeNum);
	        passwordText.setText(newPass);	        
	        
	    } else if (event.getSource() == quitButton) {
	        dispose();
	        
	    } else if (event.getSource() == saveButton) {
	        if (websiteText.getText().isEmpty() || userNameText.getText().isEmpty() || passwordText.getText().isEmpty() || accountOption.getSelectedItem().equals("{select}")) {
	            JOptionPane.showMessageDialog(this, "Please fill in all the required fields.", "Missing Information", JOptionPane.WARNING_MESSAGE);
	        } else {
	            saveToDatabase();
	        }
	    }else if(event.getSource()==exportButton) {
	    	exportPasswordToFile();
	    }

	}
	
	  private void exportPasswordToFile() {
		  try {
	            Class.forName("com.mysql.jdbc.Driver");

	            String URL = "jdbc:mysql://localhost/myPassGenerate?user=root&password=";
	            Connection conn = DriverManager.getConnection(URL);
	            System.out.println("Login Successfully");
	            String query = "SELECT website, username, password, account_type FROM passwords;";

	            Statement stmt = conn.createStatement();
	            ResultSet result = stmt.executeQuery(query);

	            // Create a BufferedWriter to write to the text file
	            try (BufferedWriter writer = new BufferedWriter(new FileWriter("passwords.txt"))) {
	                while (result.next()) {
	                    String website = result.getString("website");
	                    String username = result.getString("username");
	                    String password = result.getString("password");
	                    String accountType = result.getString("account_type");

	                    writer.write("Website: " + website);
	                    writer.newLine();
	                    writer.write("Username: " + username);
	                    writer.newLine();
	                    writer.write("Password: " + password);
	                    writer.newLine();
	                    writer.write("Account Type: " + accountType);
	                    writer.newLine();
	                    writer.newLine(); 
	                }
	            }

	            System.out.println("Passwords exported to 'passwords.txt'");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}




	private void saveToDatabase() {
		  String website = websiteText.getText();
	        String username = userNameText.getText();
	        String generatedPassword = passwordText.getText();
	        String accountType = accountOption.getSelectedItem().toString();
		try {
				Class.forName("com.mysql.jdbc.Driver");
				
				String URL = "jdbc:mysql://localhost/myPassGenerate?user=root&password=";
				Connection conn = DriverManager.getConnection(URL);
				System.out.println("Login Successfully");
				String insert = "INSERT INTO passwords (website, username, password, account_type) " +
	                    "VALUES ('" + website + "', '" + username + "', '" + generatedPassword + "', '" + accountType + "');";
				
				
				Statement stmt = conn.createStatement();
				boolean didItWork = stmt.execute(insert);
				if (!didItWork) {
				System.out.println("command ran successfully");
				}else {
					System.out.println("command run failed!");

				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}




	public void itemStateChanged(ItemEvent e) {
		  String newPass = " ";
	        int passLength = 0;
	        passLength = slider.getValue();
	        boolean includeAlpha = false;
	        boolean includeSymb = false;
	        boolean includeNum = false;
	        if(alphabetOption.isSelected())
	        	includeAlpha = true;
	        if(symbolsOption.isSelected())
	        	includeSymb = true;
	        if(numberOption.isSelected())
	        	includeNum = true;
	        
	        newPass=getThatPass(passLength,includeAlpha,includeSymb,includeNum);
	        if (alphabetOption.isSelected() || symbolsOption.isSelected() || numberOption.isSelected()) {
	            passwordText.setText(newPass);
	        } else {
	            passwordText.setText("");
	        }
	    }



	private String getThatPass(int passLength, boolean includeAlpha, boolean includeSymb, boolean includeNum) {
		StringBuilder myPassWord = new StringBuilder();
		String alphabets = "abcdefghijklmnopqrstuvwxyz";
		String symbols = "!@#$%^&*()_+";
		String numbers = "0123456789";
		String characters = "";
		
		if(includeAlpha) 
			characters += alphabets;
		if(includeSymb)
			characters += symbols;
		if(includeNum)
			characters += numbers;
		if (characters.isEmpty())
	        return "--------"; 

		
		for(int i = 0; i < passLength;i++) {
			int randomIndex = (int) (Math.random() * characters.length());
			char randomChar = characters.charAt(randomIndex);
			myPassWord.append(randomChar);
		}
		return myPassWord.toString();
		
	}



}

