package passwordGeneratorPkg;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class passMaker extends JFrame implements ActionListener {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JLabel headerText,label1,label2,label3,label11,label22,label33; //Declaring the label
	private JTextField yourText, passwordText,websiteText,userNameText;
	private JPanel northPanel,npOne,npTwo,npThree,npFour,npFive, nppOne,nppTwo,nppThree,dummyPanel;
	private JCheckBox alphabetOption,symbolsOption,numberOption;
	private JButton copyPassButton,generatePassButton;
	private JPasswordField userPassField;
	private JSlider slider;
	private JComboBox accountOption;
	
	private JPanel panelNum2,pan1,pan2,pan3,pan4;
	private JLabel securityQn,qLOne,qLTwo,ansLOne,ansLTwo,noteLabel;
	private JTextField qTOne,qTTwo,ansTOne,ansTTwo;
	private JTextArea noteTextArea;
	private JButton quitButton,saveButton,exportButton;


    public passMaker() {
        super("Password Generator");

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        createPageOne();
        createPageTwo();

        add(cardPanel);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createPageOne() {
        JPanel pageOne = new JPanel(new BorderLayout());
        pageOne.setBackground(Color.RED); // Set the background color

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
		label33 = new JLabel("*Account:");
		String accountOpt[] = {"{select}","Office","School","Travel","Transportation","Health","Entertainment","Utility","Personal"};
		accountOption = new JComboBox(accountOpt);
			nppThree.add(label33);
			nppThree.add(accountOption);
				
			northPanel.add(nppThree);
			
		nppOne = new JPanel();
		label11 = new JLabel("*Website:");
		websiteText = new JTextField(15);
			nppOne.add(label11);
			nppOne.add(websiteText);
			
			northPanel.add(nppOne);
			
			
		nppTwo = new JPanel();
		label22 = new JLabel("*Username:");
		userNameText = new JTextField(10);
			nppTwo.add(label22);
			nppTwo.add(userNameText);
			
			northPanel.add(nppTwo);
			
		
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
		

			npFive.add(copyPassButton);
			npFive.add(generatePassButton);
			
			
			northPanel.add(npFive);
		
		
		copyPassButton.addActionListener(this);
		generatePassButton.addActionListener(this);
		
		alphabetOption.addActionListener(this);
	    symbolsOption.addActionListener(this);
	    numberOption.addActionListener(this);
	   

	    pageOne.add(northPanel);

        JButton nextPageButton = new JButton("Next");
        nextPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "PageTwo");
            }
        });
              

        pageOne.add(nextPageButton, BorderLayout.SOUTH);

        cardPanel.add(pageOne, "PageOne");
    }

    private void createPageTwo() {
        JPanel pageTwo = new JPanel(new BorderLayout());
        pageTwo.setBackground(Color.CYAN); // Set the background color

        panelNum2 = new JPanel();
		panelNum2.setLayout(new GridLayout(4,1));
		
		
			
		pan1 = new JPanel();
		securityQn = new JLabel("Security Questions");
			pan1.add(securityQn);
			Font labelFont = new Font("Serif", Font.BOLD, 24);
			securityQn.setFont(labelFont);
			panelNum2.add(pan1);
			securityQn.setHorizontalAlignment(JLabel.CENTER);
			
			pan2 = new JPanel();
			pan2.setLayout(new GridLayout(4, 2));
			qLOne = new JLabel("Question 1:");
			qTOne = new JTextField(10);
			ansLOne = new JLabel("Answer 1:");
			ansTOne = new JTextField(10);

			qLTwo = new JLabel("Question 2:");
			qTTwo = new JTextField(10);
			ansLTwo = new JLabel("Answer 2:");
			ansTTwo = new JTextField(10);

			pan2.add(qLOne);
			pan2.add(qTOne);
			pan2.add(ansLOne);
			pan2.add(ansTOne);

			pan2.add(qLTwo);
			pan2.add(qTTwo);
			pan2.add(ansLTwo);
			pan2.add(ansTTwo);

			// Add padding to pan2
			int padding = 50; // You can adjust the padding value as needed
			pan2.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));

			panelNum2.add(pan2);
		
		pan3 = new JPanel();
		pan3.setLayout(new GridLayout(2,1));
			noteLabel = new JLabel("Notes:");
			noteLabel.setHorizontalAlignment(JLabel.CENTER);
			noteTextArea = new JTextArea();
			
			pan3.add(noteLabel);
			pan3.add(noteTextArea);
			
			pan3.setBorder(BorderFactory.createEmptyBorder(0, padding, 0, padding));
			
			panelNum2.add(pan3);
			
		pan4 = new JPanel();
		quitButton = new JButton("Quit");
		saveButton = new JButton("Save");
		exportButton = new JButton("Export All");
		
		pan4.add(quitButton);
		pan4.add(saveButton);
		pan4.add(exportButton);
		
		pan4.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
		
		panelNum2.add(pan4);
		
		 quitButton.addActionListener(this);
		 saveButton.addActionListener(this);
		 exportButton.addActionListener(this);
		
		pageTwo.add(panelNum2);
        JButton previousPageButton = new JButton("Previous");
        previousPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "PageOne");
            }
        });

        pageTwo.add(previousPageButton, BorderLayout.SOUTH);

        cardPanel.add(pageTwo, "PageTwo");
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new passMaker());
    }

    @Override
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
	            String query = "SELECT website, username, password, account_type, Question1, Answer1, Question2, Answer2, Notes FROM passwords;";

	            Statement stmt = conn.createStatement();
	            ResultSet result = stmt.executeQuery(query);

	            // Create a BufferedWriter to write to the text file
	            try (BufferedWriter writer = new BufferedWriter(new FileWriter("passwords.txt"))) {
	            	while (result.next()) {
	                    String website = result.getString("website");
	                    String username = result.getString("username");
	                    String password = result.getString("password");
	                    String accountType = result.getString("account_type");
	                    String question1 = result.getString("Question1");
	                    String answer1 = result.getString("Answer1");
	                    String question2 = result.getString("Question2");
	                    String answer2 = result.getString("Answer2");
	                    String notes = result.getString("Notes");

	                    writer.write("Website: " + website);
	                    writer.newLine();
	                    writer.write("Username: " + username);
	                    writer.newLine();
	                    writer.write("Password: " + password);
	                    writer.newLine();
	                    writer.write("Account Type: " + accountType);
	                    writer.newLine();
	                    writer.write("Question 1: " + question1);
	                    writer.newLine();
	                    writer.write("Answer 1: " + answer1);
	                    writer.newLine();
	                    writer.write("Question 2: " + question2);
	                    writer.newLine();
	                    writer.write("Answer 2: " + answer2);
	                    writer.newLine();
	                    writer.write("Notes: " + notes);
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
        String question1 = qTOne.getText();
        String answer1 = ansTOne.getText();
        String question2 = qTTwo.getText();
        String answer2 = ansTTwo.getText();
        String notes = noteTextArea.getText();

        // Display information in a new JFrame
        JFrame infoFrame = new JFrame("Saved Information");
        JPanel infoPanel = new JPanel();
        
        JPanel subPanel = new JPanel(new GridLayout(9,1));
        subPanel.add(new JLabel("Website: "+website));
        subPanel.add(new JLabel("Username: "+username));
        subPanel.add(new JLabel("Generated Password: "+generatedPassword));
        subPanel.add(new JLabel("Account Type: "+accountType));
        subPanel.add(new JLabel("Question 1: "+question1));
        subPanel.add(new JLabel("Answer 1: "+answer1));
        subPanel.add(new JLabel("Question 2: "+question2));
        subPanel.add(new JLabel("Answer 2: "+answer2));
        subPanel.add(new JLabel("Notes: "+notes));

        infoPanel.add(subPanel);
        JButton saveButton = new JButton("Save to Database");
        JButton cancelButton = new JButton("Cancel");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform save to database action here
                saveToDatabaseAction(website,username,generatedPassword,accountType,question1,answer1,question2,answer2,notes);
                // Close the information display frame
                infoFrame.dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the information display frame without saving to the database
                infoFrame.dispose();
            }
        });

        infoPanel.add(saveButton);
        infoPanel.add(cancelButton);

        infoFrame.add(infoPanel);
        infoFrame.setSize(300, 220);
        infoFrame.setLocationRelativeTo(null);
        infoFrame.setVisible(true);
    }

    private void saveToDatabaseAction(String website, String username, String generatedPassword, String accountType, String question1, String answer1, String question2, String answer2, String notes) {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String URL = "jdbc:mysql://localhost/myPassGenerate?user=root&password=";
			Connection conn = DriverManager.getConnection(URL);
			System.out.println("Login Successfully");
			String insert = "INSERT INTO passwords (website, username, password, account_type, Question1, Answer1, Question2, Answer2, Notes) " +
                    "VALUES ('" + website + "', '" + username + "', '" + generatedPassword + "', '" + accountType + "', '" + question1 + "', '" + answer1 + "', '" + question2 + "', '" + answer2 + "', '" + notes + "');";
			
			
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
	        return "********************"; 

		
		for(int i = 0; i < passLength;i++) {
			int randomIndex = (int) (Math.random() * characters.length());
			char randomChar = characters.charAt(randomIndex);
			myPassWord.append(randomChar);
		}
		return myPassWord.toString();
		
	}

}
