import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GroupGUI {
	/**
	 * GUI implementation that interacts with the SystemManager class
	 */
	public static void main( String args[] ) {
		JFrame frame = new JFrame("Group Creator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize( 400, 650 );
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel( new BorderLayout() );
		JPanel upper = new JPanel( new GridLayout( 2, 2 ) );
		
		JLabel jl1 = new JLabel("Course Number");
		JLabel jl2 = new JLabel("Group Size");
		final JTextField jtf1 = new JTextField( 10 );
		final JTextField jtf2 = new JTextField( 10 );
		final JTextArea jta = new JTextArea();
		JScrollPane scroll = new JScrollPane( jta );
		final JButton button = new JButton( "Submit" );
		
		upper.add( jl1 );
		upper.add( jtf1 );
		upper.add( jl2 );
		upper.add( jtf2 );
		panel.add( upper, BorderLayout.NORTH );
		panel.add( scroll, BorderLayout.CENTER );
		panel.add( button, BorderLayout.SOUTH );

		jtf1.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent evt ) {
				button.doClick();
			}
		});
		
		jtf2.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent evt ) {
				button.doClick();
			}
		});
		
		button.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent evt ) {
				String courseNo = jtf1.getText();
				boolean sizeint = true;
				int size = 0;
				try {
					size = Integer.parseInt( jtf2.getText() );
				}
				catch( Exception e ) {
					sizeint = false;
				}
				if( sizeint ) {
					jta.setText( "" );
					ArrayList<ArrayList<Student>> listofgroups;
					SystemManager sm = new SystemManager();
					sm.readClassList( courseNo );
					int numStudents = sm.getNumStudents();
					if( numStudents >= size ) {
						jta.append( "\nCompleted Groups are stored in the file \"CompletedGroups.txt\"\n\n" );
						sm.createProject();
						sm.createGroups( size );
						sm.storeGroups();
						listofgroups = sm.getGroups();
						for( ArrayList<Student> s : listofgroups ) {
							for( Student stu : s ) {
								jta.append( stu.getStudentNo() + "\t\t" + stu.getStudentName() + "\n" );
							}
							jta.append("\n");
						}
					}
					else {
						jta.setText( "\n\nThe Group Size must be less than the number of students.");
						jtf2.setText( "" );
					}
				}
				else {
					jta.setText( "" );
					jta.setText( "\n\nThe Group Size field must be an integer.");
					jtf2.setText( "" );
				}
			}
		});
		frame.add( panel );
		frame.setResizable( false );
		frame.setVisible( true );
	}
}
