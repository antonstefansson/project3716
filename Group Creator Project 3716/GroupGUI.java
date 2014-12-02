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
		frame.setSize( 400, 700 );
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
		
		final JTextField q1 = new JTextField();
		final JTextField q2 = new JTextField();
		final JTextField q3 = new JTextField();
		final JTextField q4 = new JTextField();
		final JTextField q5 = new JTextField();
		final JTextField q6 = new JTextField();
		final JTextField q7 = new JTextField();
		final JTextField q8 = new JTextField();
		final JTextField q9 = new JTextField();
		final JTextField q10 = new JTextField();
		final JButton selfEvalTest = new JButton();
		selfEvalTest.setEnabled( false );
		
		final JPanel profPanel = new JPanel( new BorderLayout() );
		JPanel upper = new JPanel( new GridLayout( 5, 2 ) );
		JLabel jl1 = new JLabel("Course Number");
		JLabel jl2 = new JLabel("Group Size");
		JLabel jl3 = new JLabel("Use Student GPAs?");
		JLabel jl4 = new JLabel("Use Self Evaluation?");
		final JComboBox jcob = new JComboBox(courseString);
		//final JTextField jtf1 = new JTextField( 10 );
		final JTextField jtf2 = new JTextField( 10 );
		final JCheckBox jcb = new JCheckBox();
		final JCheckBox jcb2 = new JCheckBox();
		final JTextArea jta = new JTextArea();
		JScrollPane scroll = new JScrollPane( jta );
		final JButton backButton = new JButton( "<= Back to Login" );
		final JButton selfEvalButton = new JButton( "Setup Self Eval");
		final JButton createButton = new JButton( "Create Groups" );
		final JButton editButton = new JButton( "Edit Groups" );
		final JButton submitButton = new JButton( "Submit Groups" );
		upper.add( backButton );
		upper.add( selfEvalButton );
		upper.add( jl1 );
		upper.add( jcob );
		//upper.add( jtf1 );
		upper.add( jl2 );
		upper.add( jtf2 );
		upper.add( jl3 );
		upper.add( jcb );
		upper.add( jl4 );
		upper.add( jcb2 );
		profPanel.add( upper, BorderLayout.NORTH );
		profPanel.add( scroll, BorderLayout.CENTER );
		profPanel.add( createButton, BorderLayout.SOUTH );
		
		final SystemManager sm = new SystemManager();
		sm.readClassList( (String) jcob.getSelectedItem() );
		
		logButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent evt ) {
				if( user.getText().equals("Professor") ) {
					frame.remove( loginpane );
					frame.add( profPanel );
					frame.revalidate();
					frame.repaint();
				}
				else {
					String courseNo = (String) jcob.getSelectedItem();
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
						final JPanel studentPanel = new JPanel( new BorderLayout() );
						JPanel center = new JPanel( new GridLayout( 3, 1 ) );
						JPanel holder = new JPanel();
						JPanel email = new JPanel();
						JPanel self = new JPanel();
						JLabel sl1 = new JLabel("Student Email Address:");
						final Student stu = s_user;
						JLabel stuName = new JLabel( stu.getStudentName() );
						holder.add( stuName );
						final JTextField sjtf1 = new JTextField( stu.getStudentEmail(), 20 );
						JButton backButton2 = new JButton( "<= Back to Login" );
						JButton sb1 = new JButton( "Update" );
						final JButton stuEvalButton = new JButton( "Answer questions for Self Evaluation" );
						email.add( sl1 );
						email.add( sjtf1 );
						email.add( sb1 );
						self.add( stuEvalButton );
						studentPanel.add( backButton2, BorderLayout.NORTH );
						center.add( holder );
						center.add( email );
						center.add( self );
						studentPanel.add( center, BorderLayout.CENTER );
						backButton2.addActionListener( new ActionListener() {
							public void actionPerformed( ActionEvent evt ) {
								frame.remove( studentPanel );
								frame.add( loginpane );
								frame.revalidate();
								frame.repaint();
							}
						});
						sb1.addActionListener( new ActionListener() {
							public void actionPerformed( ActionEvent evt ) {
								stu.setEmail( sjtf1.getText() );
							}
						});
						stuEvalButton.addActionListener( new ActionListener() {
							public void actionPerformed( ActionEvent evt ) {
								if( selfEvalTest.isEnabled() ) {
									frame.remove( studentPanel );
									final JPanel stuSelfEval = new JPanel( new GridLayout( 11, 2 ) );
									final JTextField[] jtfas = new JTextField[10];
									for( int i = 0; i < 10; i++ ) {
										jtfas[i] = new JTextField();
									}
									final JPanel blank = new JPanel();
									final JButton submitEval = new JButton( "Submit" );
									stuSelfEval.add( new JLabel( q1.getText() ) );
									stuSelfEval.add( jtfas[0] );
									stuSelfEval.add( new JLabel( q2.getText() ) );
									stuSelfEval.add( jtfas[1] );
									stuSelfEval.add( new JLabel( q3.getText() ) );
									stuSelfEval.add( jtfas[2] );
									stuSelfEval.add( new JLabel( q4.getText() ) );
									stuSelfEval.add( jtfas[3] );
									stuSelfEval.add( new JLabel( q5.getText() ) );
									stuSelfEval.add( jtfas[4] );
									stuSelfEval.add( new JLabel( q6.getText() ) );
									stuSelfEval.add( jtfas[5] );
									stuSelfEval.add( new JLabel( q7.getText() ) );
									stuSelfEval.add( jtfas[6] );
									stuSelfEval.add( new JLabel( q8.getText() ) );
									stuSelfEval.add( jtfas[7] );
									stuSelfEval.add( new JLabel( q9.getText() ) );
									stuSelfEval.add( jtfas[8] );
									stuSelfEval.add( new JLabel( q10.getText() ) );
									stuSelfEval.add( jtfas[9] );
									stuSelfEval.add( blank );
									stuSelfEval.add( submitEval );
									submitEval.addActionListener( new ActionListener() {
										public void actionPerformed( ActionEvent evt ) {
											int[] ans = new int[10];
											boolean cont = true;
											for( int i = 0; i < 10; i++ ) {
												try {
													ans[i] = Integer.parseInt( jtfas[i].getText() );
													if( ans[i] > 10 || ans[i] < 1 ) {
														throw new Exception();
													}
												}
												catch( Exception e ) {
													cont = false; 
												}
											}
											if( cont ) {
												stu.setSelfEvalValues( ans );
												frame.remove( stuSelfEval );
												frame.add( studentPanel );
												frame.revalidate();
												frame.repaint();
											}
											else {
												blank.removeAll();
												blank.add( new JLabel( "All answers must be integers" ) );
												blank.add( new JLabel( "between 1 and 10" ) );
												frame.revalidate();
												frame.repaint();
											}
										}
									});
									frame.add( stuSelfEval );
									frame.revalidate();
									frame.repaint();
								}
								else {
									stuEvalButton.setText( "Self Evaluation Not Set Up" );
								}
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
					boolean isSelfEval = true;
					if( jcb.isSelected() ) {
						sm.readGPAs();
					}
					if( jcb2.isSelected() ) {
						if( selfEvalTest.isEnabled() ) {
							isSelfEval = true;
						}
						else {
							isSelfEval = false;
						}
					}
					int numStudents = sm.getNumStudents();
					if( numStudents >= size && isSelfEval ) {
						sm.createProject();
						if( jcb.isSelected() && jcb2.isSelected() ) {
							sm.createGroupsSelfEvalGPA( size );
						}
						else if( jcb.isSelected() && !jcb2.isSelected() ) {
							sm.createGroupsGPA( size );
						}
						else if( !jcb.isSelected() && jcb2.isSelected() ) {
							sm.createGroupsSelfEval( size );
						}
						else {
							sm.createGroups( size );
						}
						createButton.setEnabled( false );
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
											if( jcb.isSelected() && jcb2.isSelected() ) {
												for( Student stu : s ) {
													jta.append( stu.getStudentNo() + "\t\t" + stu.getStudentGPA() + "\t" + stu.getSelfEvalScore() + "\t" + stu.getStudentName() + "\n" );
												}
											}
											else if( jcb.isSelected() && !jcb2.isSelected() ) {
												for( Student stu : s ) {
													jta.append( stu.getStudentNo() + "\t\t" + stu.getStudentGPA() + "\t" + stu.getStudentName() + "\n" );
												}
											}
											else if( !jcb.isSelected() && jcb2.isSelected() ) {
												for( Student stu : s ) {
													jta.append( stu.getStudentNo() + "\t\t" + stu.getSelfEvalScore() + "\t" + stu.getStudentName() + "\n" );
												}
											}
											else {
												for( Student stu : s ) {
													jta.append( stu.getStudentNo() + "\t\t" + stu.getStudentName() + "\n" );
												}
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
							if( jcb.isSelected() && jcb2.isSelected() ) {
								for( Student stu : s ) {
									jta.append( stu.getStudentNo() + "\t\t" + stu.getStudentGPA() + "\t" + stu.getSelfEvalScore() + "\t" + stu.getStudentName() + "\n" );
								}
							}
							else if( jcb.isSelected() && !jcb2.isSelected() ) {
								for( Student stu : s ) {
									jta.append( stu.getStudentNo() + "\t\t" + stu.getStudentGPA() + "\t" + stu.getStudentName() + "\n" );
								}
							}
							else if( !jcb.isSelected() && jcb2.isSelected() ) {
								for( Student stu : s ) {
									jta.append( stu.getStudentNo() + "\t\t" + stu.getSelfEvalScore() + "\t" + stu.getStudentName() + "\n" );
								}
							}
							else {
								for( Student stu : s ) {
									jta.append( stu.getStudentNo() + "\t\t" + stu.getStudentName() + "\n" );
								}
							}
							jta.append("\n");
						}
					}
					else {
						jta.setText( "" );
						if( !( numStudents >= size ) ) {
							jta.append( "\n\nThe Group Size must be less than the number of students.");
							jtf2.setText( "" );
						}
						if( !isSelfEval ) {
							jta.append( "\n\nSelf Evaluation must be set up before it can be used.");
							jcb2.setSelected( false );
						}
					}
				}
				else {
					jta.setText( "" );
					jta.setText( "\n\nThe Group Size field must be an integer.");
					jtf2.setText( "" );
				}
			}
		});
		
		backButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent evt ) {
				frame.remove( profPanel );
				frame.add( loginpane );
				frame.revalidate();
				frame.repaint();
			}
		});
		
		selfEvalButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent evt ) {
				frame.remove( profPanel );
				final JPanel evalPanel = new JPanel( new GridLayout( 11, 2 ) );
				JPanel blank = new JPanel();
				JButton setupButton = new JButton( "Finish Setup" );
				evalPanel.add( new JLabel( "Question 1:" ) );
				evalPanel.add( q1 );
				evalPanel.add( new JLabel( "Question 2:" ) );
				evalPanel.add( q2 );
				evalPanel.add( new JLabel( "Question 3:" ) );
				evalPanel.add( q3 );
				evalPanel.add( new JLabel( "Question 4:" ) );
				evalPanel.add( q4 );
				evalPanel.add( new JLabel( "Question 5:" ) );
				evalPanel.add( q5 );
				evalPanel.add( new JLabel( "Question 6:" ) );
				evalPanel.add( q6 );
				evalPanel.add( new JLabel( "Question 7:" ) );
				evalPanel.add( q7 );
				evalPanel.add( new JLabel( "Question 8:" ) );
				evalPanel.add( q8 );
				evalPanel.add( new JLabel( "Question 9:" ) );
				evalPanel.add( q9 );
				evalPanel.add( new JLabel( "Question 10:" ) );
				evalPanel.add( q10 );
				evalPanel.add( blank );
				evalPanel.add( setupButton );
				
				setupButton.addActionListener( new ActionListener() {
					public void actionPerformed( ActionEvent evt ) {
						selfEvalTest.setEnabled( true );
						frame.remove( evalPanel );
						frame.add( profPanel );
						frame.revalidate();
						frame.repaint();
					}
				});
				
				frame.add( evalPanel );
				frame.revalidate();
				frame.repaint();
			}
		});
		frame.add( loginpane );
		frame.setVisible( true );
		
	}
}
