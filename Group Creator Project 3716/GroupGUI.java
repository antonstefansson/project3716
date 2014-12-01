import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GroupGUI {
	/**
	 * GUI implementation that interacts with the SystemManager class
	 */
	public static void main( String args[] ) {
		final JFrame frame = new JFrame("Group Creator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize( 400, 650 );
		frame.setLocationRelativeTo(null);
		
		final JPanel loginpane = new JPanel( new BorderLayout() );
		JPanel login = new JPanel();
		JLabel userl = new JLabel("Username:");
		JLabel passl = new JLabel("Password:");
		final JTextField user = new JTextField( 10 );
		final JTextField pass = new JTextField( 10 );
		final JButton logButton = new JButton( "Login" );
		login.add( userl );
		login.add( user );
		login.add( passl );
		login.add( pass );
		loginpane.add( login, BorderLayout.CENTER );
		loginpane.add( logButton, BorderLayout.SOUTH );
		
		String[] courseString = {"CS3716","CS3715"};
		
		final JPanel profPanel = new JPanel( new BorderLayout() );
		JPanel upper = new JPanel( new GridLayout( 3, 2 ) );
		JLabel jl1 = new JLabel("Course Number");
		JLabel jl2 = new JLabel("Group Size");
		JLabel jl3 = new JLabel("Use Student GPAs?");
		final JComboBox jcob = new JComboBox(courseString);
		//final JTextField jtf1 = new JTextField( 10 );
		final JTextField jtf2 = new JTextField( 10 );
		final JCheckBox jcb = new JCheckBox();
		final JTextArea jta = new JTextArea();
		JScrollPane scroll = new JScrollPane( jta );
		final JButton createButton = new JButton( "Create Groups" );
		final JButton editButton = new JButton( "Edit Groups" );
		final JButton submitButton = new JButton( "Submit Groups" );
		upper.add( jl1 );
		upper.add( jcob );
		//upper.add( jtf1 );
		upper.add( jl2 );
		upper.add( jtf2 );
		upper.add( jl3 );
		upper.add( jcb );
		profPanel.add( upper, BorderLayout.NORTH );
		profPanel.add( scroll, BorderLayout.CENTER );
		profPanel.add( createButton, BorderLayout.SOUTH );
		
		logButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent evt ) {
				if( user.getText().equals("Professor") ) {
					frame.remove( loginpane );
					frame.add( profPanel );
					frame.revalidate();
					frame.repaint();
				}
				else {
					SystemManager sm = new SystemManager();
					sm.readClassList( "CourseNo" );
					ArrayList<Student> students = sm.getStudentList();
					String username = user.getText();
					boolean valid = false;
					Student s_user = new Student( "", "", "" );
					for( Student s : students ) {
						if( username.equals( s.getStudentNo() ) ) {
							s_user = s;
							valid = true;
						}
					}
					if( valid ) {
						final JPanel studentPanel = new JPanel();
						JLabel sl1 = new JLabel("Student Email Address:");
						final Student stu = s_user;
						final JTextField sjtf1 = new JTextField( stu.getStudentEmail(), 20 );
						JButton sb1 = new JButton( "Update" );
						JButton sb2 = new JButton( "Print" );
						studentPanel.add( sl1 );
						studentPanel.add( sjtf1 );
						studentPanel.add( sb1 );
						studentPanel.add( sb2 );
						sb1.addActionListener( new ActionListener() {
							public void actionPerformed( ActionEvent evt ) {
								stu.setEmail( sjtf1.getText() );
							}
						});
						sb2.addActionListener( new ActionListener() {
							public void actionPerformed( ActionEvent evt ) {
								System.out.println( stu.getStudentEmail() );
							}
						});
						frame.remove( loginpane );
						frame.add( studentPanel );
						frame.revalidate();
						frame.repaint();
					}
				}
			}
		});

		user.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent evt ) {
				logButton.doClick();
			}
		});
		
		pass.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent evt ) {
				logButton.doClick();
			}
		});
		
		//jcob.addActionListener( new ActionListener() {
		//	public void actionPerformed( ActionEvent evt ) {
		//		createButton.doClick();
		//	}
		//});
		
		jtf2.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent evt ) {
				createButton.doClick();
			}
		});
		
		createButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent evt ) {
				String courseNo = (String) jcob.getSelectedItem();
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
					final SystemManager sm = new SystemManager();
					sm.readClassList( courseNo );
					if( jcb.isSelected() ) {
						sm.readGPAs();
					}
					int numStudents = sm.getNumStudents();
					if( numStudents >= size ) {
						sm.createProject();
						if( jcb.isSelected() ) {
							sm.createGroupsGPA( size );
						}
						else {
							sm.createGroups( size );
						}
						profPanel.remove( createButton );
						JPanel subPanel = new JPanel( new GridLayout( 1, 2 ) );
						subPanel.add( editButton );
						subPanel.add( submitButton );
						editButton.addActionListener( new ActionListener() {
							public void actionPerformed( ActionEvent evt ) {
								ArrayList<ArrayList<Student>> templist = sm.getGroups();
								int numStu = sm.getNumStudents();
								ArrayList<Student> tempstu = new ArrayList<Student>();
								final JPanel updatePanel = new JPanel( new BorderLayout() );
								JPanel namePanel = new JPanel( new GridLayout( numStu, 1 ) );
								JPanel editPanel = new JPanel( new GridLayout( numStu, templist.size() ) );
								//JPanel editPanel = new JPanel( new GridLayout( numStu, templist.size() + 1 ) );
								ArrayList<ButtonGroup> arbg = new ArrayList<ButtonGroup>();
								for( int i = 0; i < templist.size(); i++ ) {
									for( Student stu : templist.get( i ) ) {
										tempstu.add( stu );
										namePanel.add( new JLabel( stu.getStudentName() ) );
										//editPanel.add( new JLabel( stu.getStudentName() ) );
										ButtonGroup bg = new ButtonGroup();
										for( int j = 1; j <= templist.size(); j++ ) {
											JRadioButton jrb = new JRadioButton( "" + j + "" );
											jrb.setActionCommand( "" + j + "" );
											if( i + 1 == j ) {
												jrb.setSelected( true );
											}
											bg.add( jrb );
											editPanel.add( jrb );
										}
										arbg.add( bg );
									}
								}
								final ArrayList<Student> stuList = tempstu;
								final ArrayList<ButtonGroup> bglist = arbg;
								final int numGroups = templist.size();
								JButton updateButton = new JButton( "Update Groups" );
								updateButton.addActionListener( new ActionListener() {
									public void actionPerformed( ActionEvent evt ) {
										ArrayList<ArrayList<Student>> newgroups = new ArrayList<ArrayList<Student>>();
										for( int n = 0; n < numGroups; n++ ) {
											newgroups.add( new ArrayList<Student>() );
										}
										for( int k = 0; k < stuList.size(); k++ ) {
											newgroups.get( Integer.parseInt( (bglist.get( k ).getSelection()).getActionCommand() ) - 1 ).add( stuList.get( k ) );
										}
										sm.updateGroups( newgroups );
										jta.setText( "" );
										for( ArrayList<Student> s : newgroups ) {
											for( Student stu : s ) {
												jta.append( stu.getStudentNo() + "\t\t" + stu.getStudentGPA() + "\t" + stu.getStudentName() + "\n" );
											}
											jta.append("\n");
										}
										frame.remove( updatePanel );
										frame.add( profPanel );
										frame.revalidate();
										frame.repaint();
									}
								});
								updatePanel.add( namePanel, BorderLayout.WEST );
								updatePanel.add( editPanel, BorderLayout.CENTER );
								updatePanel.add( updateButton, BorderLayout.SOUTH );
								frame.remove( profPanel );
								frame.add( updatePanel );
								frame.revalidate();
								frame.repaint();
							}
						});
						submitButton.addActionListener( new ActionListener() {
							public void actionPerformed( ActionEvent evt ) {
								jta.append( "\nCompleted Groups are stored in the file \"CompletedGroups.txt\"\n\n" );
								sm.storeGroups();
							}
						});
						profPanel.add( subPanel, BorderLayout.SOUTH );
						frame.revalidate();
						frame.repaint();
						listofgroups = sm.getGroups();
						for( ArrayList<Student> s : listofgroups ) {
							for( Student stu : s ) {
								jta.append( stu.getStudentNo() + "\t\t" + stu.getStudentGPA() + "\t" + stu.getStudentName() + "\n" );
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
		frame.add( loginpane );
		frame.setVisible( true );
		
	}
}
