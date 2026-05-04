package SquadFinder;

/** GUI for use with the SESF
 * @author Keegan Walpole 
 * @version 1.0
 * @since 1.0
*/
/*  
* OS: Windows 11 24H2 Build: 26100.7462
* IDE: [Eclipse 25]
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified, nor used generative AI as a final draft. 
* I have not given other fellow student(s) access to my program.
*/

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HellGUI implements ActionListener {

	private JFrame frame;
	private JButton button;
	private JTextField uNameField;
	private JLabel uNameLabel;
	private JTextField lvlField;
	private JLabel lvlLabel;
	private JComboBox diffBox;
	private JComboBox tudeBox;
	private JPanel panel;
	private JPanel searchPanel;
	private JLabel diffLabel;
	private JLabel tudeLabel;
	private JLabel searchMsg;
	private JLabel squadLabel;
	private JTextArea squadMsg;

	HellProgram hp = new HellProgram();

	public HellGUI() {
		// GUI asks for username, level, preferred difficulty, and attitude

		// JComboBox Options
		String diff[] = { "1: Trivial", "2: Easy", "3: Medium", "4: Challenging", "5: Hard", "6: Extreme",
				"7: Suicide Mission", "8: Impossible", "9: Helldive", "10: Super Helldive" };
		String tude[] = { "Calm", "Serious", "Goofy", "Team Oriented" };

		frame = new JFrame();

		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 10));
		panel.setLayout(null);

		uNameLabel = new JLabel("ENTER YOUR USERNAME:"); // Label uNameField
		uNameLabel.setBounds(10, 20, 150, 25);
		panel.add(uNameLabel);

		uNameField = new JTextField(); // Text Field for UserName
		uNameField.setBounds(160, 20, 165, 25);
		panel.add(uNameField);

		lvlLabel = new JLabel("ENTER YOUR LEVEL:"); // Label lvlField
		lvlLabel.setBounds(10, 50, 150, 25);
		panel.add(lvlLabel);

		lvlField = new JTextField(); // Text Field for Level
		lvlField.setBounds(160, 50, 165, 25);
		panel.add(lvlField);

		diffLabel = new JLabel("PREFERRED DIFFICULTY:"); // Label for Difficulty
		diffLabel.setBounds(10, 80, 150, 25);
		panel.add(diffLabel);

		diffBox = new JComboBox(diff); // Drop Down Box for difficulty
		diffBox.setBounds(160, 80, 165, 25);
		panel.add(diffBox);

		tudeLabel = new JLabel("YOUR ATTITUDE:"); // Label for attitude
		tudeLabel.setBounds(10, 110, 150, 25);
		panel.add(tudeLabel);

		tudeBox = new JComboBox(tude); // Drop down box for attitude
		tudeBox.setBounds(160, 110, 165, 25);
		panel.add(tudeBox);

		button = new JButton("FIND YOUR SQUAD"); // bottom of GUI
		button.setBounds(35, 140, 265, 25);
		panel.add(button);
		button.addActionListener(this); // run search program when button is pressed

		searchMsg = new JLabel("SEARCHING FOR SQUAD..."); // Message displayed after clicking button
		searchMsg.setBounds(35, 80, 265, 25);
		panel.add(searchMsg);
		searchMsg.setVisible(false);

		squadLabel = new JLabel("SQUAD REPORT:");
		squadLabel.setBounds(10, 20, 165, 25);
		panel.add(squadLabel);
		squadLabel.setVisible(false);

		squadMsg = new JTextArea();
		squadMsg.setBounds(10, 50, 500, 400);
		panel.add(squadMsg);
		squadMsg.setVisible(false);

		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("SUPER EARTH SQUAD FINDER");
		frame.pack();
		frame.setVisible(true);
		frame.setSize(400, 300);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		uNameLabel.setVisible(false);
		uNameField.setVisible(false);
		lvlLabel.setVisible(false);
		lvlField.setVisible(false);
		diffLabel.setVisible(false);
		diffBox.setVisible(false);
		tudeLabel.setVisible(false);
		tudeBox.setVisible(false);
		button.setVisible(false);

		searchMsg.setVisible(true);

		String user = uNameField.getText();
		int lvl = Integer.parseInt(lvlField.getText());
		int diff = Integer.parseInt(String.valueOf(diffBox.getSelectedItem().toString().charAt(0)));
		String tude = tudeBox.getSelectedItem().toString();

		try {
			String squad = hp.hellProgram(user, lvl, diff, tude);
			searchMsg.setVisible(false);

			squadLabel.setVisible(true);
			squadMsg.setText(squad);
			squadMsg.setVisible(true);
		} catch (OutOfRangeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
