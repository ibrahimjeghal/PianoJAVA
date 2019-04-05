package pianoV;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import t2s.son.LecteurTexte;


public class PianoV  {
	
	public static JFrame frame;
	public static int selInst;
	public static int oct1;
	public static int oct2;
	public static String nom;
	public static LecteurTexte lecteur = new LecteurTexte();


	@SuppressWarnings("deprecation")
	PianoV() {

		frame=new JFrame();
		frame.setTitle("Piano");
		frame.setBounds(170, 150, 1012, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		//TTS
		
		new Thread() {
			public void run() {
				
				nom=JOptionPane.showInputDialog(null, "Veuillez entrez votre nom : ", "Identification", JOptionPane.QUESTION_MESSAGE);
				
				if(nom!=null)
				{
					lecteur.setTexte("Bonjour " + nom + " !");
		            lecteur.playAll();
				}
				else 
				{
					frame.dispose();
				}
			}
		}.start();
		ImageIcon img = new ImageIcon(getClass().getResource("/Icon.png")); //getClass().getResource("/Icon.png") retourne un string
		frame.setIconImage(img.getImage());
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmTest = new JMenuItem("Quitter");
		mntmTest.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mntmTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lecteur.setTexte("Au revoir " + nom + " !");
	            lecteur.playAll();
				frame.dispose();
			}
		});
		
		mntmTest.setIcon(new ImageIcon(getClass().getResource("/Quitter.png")));
		mnFichier.add(mntmTest);
		
		JMenu mnHelp = new JMenu("?");
		menuBar.add(mnHelp);
		
		JMenuItem mntmTest_2 = new JMenuItem("Qui sommes Nous ?");
		mntmTest_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame AboutUs = new JFrame();
				AboutUs.setTitle("Qui sommes Nous ?");
				AboutUs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				AboutUs.setBounds(500, 200, 350, 100);
				AboutUs.setResizable(false);
				AboutUs.setIconImage(new ImageIcon(getClass().getResource("/About us.png")).getImage());
				
				JPanel panel = new JPanel();
				AboutUs.getContentPane().add(panel, BorderLayout.CENTER);
				panel.setLayout(null);
				panel.setBackground(Color.CYAN); 
				
				JLabel lblDev = new JLabel("Developped by JEGHAL Ibrahim & NEHAS Imane");
				lblDev.setBounds(25, 20, 300, 14);
				panel.add(lblDev);
				
				new Thread() {
					public void run() {
						
						lecteur.setTexte("Cette application est développée. par JRAL Ibrahim, et NHAS Imane !");
			            lecteur.playAll();

					}
				}.start();
				
				AboutUs.setVisible(true);
			}
		});
		mntmTest_2.setIcon(new ImageIcon(getClass().getResource("/About us.png")));
		mnHelp.add(mntmTest_2);
		
		JMenuItem mntmTest_1 = new JMenuItem("Besoin d'aide ?");
		mntmTest_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame Help = new JFrame();
				Help.setTitle("Besoin d'aide ?");
				Help.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Help.setBounds(500, 200, 350, 100);
				Help.setResizable(false);
				
				Help.setIconImage(new ImageIcon(getClass().getResource("/Help Contents.png")).getImage());
				
				JPanel panel = new JPanel();
				Help.getContentPane().add(panel, BorderLayout.CENTER);
				panel.setLayout(null);
				panel.setBackground(Color.CYAN); 
				
				JLabel lblDev = new JLabel("Comming Soon");
				lblDev.setBounds(130, 20, 300, 14);
				panel.add(lblDev);
				
				new Thread() {
					public void run() {
						lecteur.setTexte("Le service d'aide sera disponible prochainement .");
			            lecteur.playAll();
					}
				}.start();
				
				Help.setVisible(true);
				
			}
		});
		
		mntmTest_1.setIcon(new ImageIcon(getClass().getResource("/Help Contents.png")));
		mnHelp.add(mntmTest_1);
		
		
		JTabbedPane tabbedPane = new JTabbedPane();
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		JLayeredPane layeredPane = new JLayeredPane();
		JPanel onglet2=new JPanel();
		onglet2.setBackground(Color.CYAN);
		layeredPane.setLayout(null);
		onglet2.setLayout(null);
		
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/icon2.png"));
	    tabbedPane.addTab("Piano",icon1,layeredPane,"C'est un piano !");
	 
	    ImageIcon icon2 = new ImageIcon(getClass().getResource("/tts.png"));
	    tabbedPane.addTab("Text to Speech",icon2,onglet2,"Transforme votre texte en voix !");
	    
	   
        
	    
	    JScrollPane sp = new JScrollPane();   // JTextArea is placed in a JScrollPane.
	    sp.setBounds(64, 77, 596, 200);
	    onglet2.add(sp);
	    
	    JTextArea ta = new JTextArea();
	    sp.setViewportView(ta);
	    
	    JButton btnParle = new JButton("Parle");
	    btnParle.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		new Thread() {
	    			public void run()
	    			{
	    				btnParle.setEnabled(false);
	    				lecteur.setTexte(ta.getText());
	    				lecteur.playAll();
	    				btnParle.setEnabled(true);
	    			}
	    		}.start();
	            
	    	}
	    });
	    btnParle.setBounds(670, 155, 89, 23);
	    onglet2.add(btnParle);
	    
	    JLabel lblEcrivezVotreTexte = new JLabel("Ecrivez votre texte en fran\u00E7ais ici :");
	    lblEcrivezVotreTexte.setBounds(75, 52, 215, 14);
	    onglet2.add(lblEcrivezVotreTexte);
	    

		
		JLabel lblNewLabel2 = new JLabel();
		layeredPane.add(lblNewLabel2,-1);
		lblNewLabel2.setBounds(0, 0, 996, 361);
		ImageIcon img3 = new ImageIcon(getClass().getResource("/bg.jpg"));
		lblNewLabel2.setIcon(img3);
		
		
		JLabel lblOutput = new JLabel("OutPut");
		lblOutput.setForeground(Color.GRAY);
		lblOutput.setBounds(215, 119, 46, 14);
		layeredPane.add(lblOutput);
		layeredPane.setPosition(lblOutput, 0);
		

		JTextField textField = new JTextField(); // out
		textField.setBounds(267, 116, 625, 20);
		layeredPane.add(textField);
		textField.setColumns(10);
		layeredPane.setPosition(textField, 1);
		// par defaut au debut
		textField.setText("I[PIANO] ");

		JLabel lblInput = new JLabel("InPut");
		lblInput.setForeground(Color.GRAY);
		lblInput.setBounds(215, 88, 46, 14);
		layeredPane.add(lblInput);
		layeredPane.setPosition(lblInput, 0);

		JTextField textField_1 = new JTextField(); // in
		textField_1.setBounds(267, 85, 625, 20);
		textField_1.setColumns(10);
		layeredPane.add(textField_1);
		layeredPane.setPosition(textField_1, 1);
		// par defaut au debut
		textField_1.setText(
				"I[PIANO] C5q D5q E5q C5q C5q D5q E5q C5q E5q F5q G5h E5q F5q G5h G5i A5i G5i F5i E5q C5q G5i A5i G5i F5i E5q C5q C5q G4q C5h C5q G4q C5w ");
		
		JLabel lblOct = new JLabel("Octaves");
		lblOct.setForeground(Color.WHITE);
		lblOct.setBounds(38, 19, 53, 14);
		layeredPane.add(lblOct);
		layeredPane.setPosition(lblOct, 0);
		
		String[] oct= {"0","1","2","3","4","5","6","7","8","9"};
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox comboBox_1 = new JComboBox(oct);
		comboBox_1.setBounds(93, 11, 67, 22);
		layeredPane.add(comboBox_1);
		layeredPane.setPosition(comboBox_1, 0);
		oct1=4;
		comboBox_1.setSelectedIndex(4);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oct1=comboBox_1.getSelectedIndex();
			}
		});
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox comboBox_2 = new JComboBox(oct);
		comboBox_2.setBounds(93, 30, 67, 22);
		layeredPane.add(comboBox_2);
		layeredPane.setPosition(comboBox_2, 0);
		oct2=5;
		comboBox_2.setSelectedIndex(5);
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oct2=comboBox_2.getSelectedIndex();
			}
		});
		
		JLabel lblInstrument = new JLabel("Instrument");
		lblInstrument.setForeground(Color.GRAY);
		lblInstrument.setBounds(21, 88, 62, 14);
		layeredPane.add(lblInstrument);
		layeredPane.setPosition(lblInstrument, 0);

		String[] ins = { "PIANO", "CELESTA", "DRAWBAR_ORGAN", "GUITAR", "ACOUSTIC_BASS", "VIOLIN", "STRING_ENSEMBLE_1",
				"TRUMPET", "SOPRANO_SAX", "PICCOLO", "SITAR", "TINKLE_BELL", "GUITAR_FRET_NOISE" };
		selInst = 0;
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox comboBox = new JComboBox(ins);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 8));
		comboBox.setBounds(93, 84, 112, 22);
		layeredPane.add(comboBox);
		layeredPane.setPosition(comboBox, 0);
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				selInst = comboBox.getSelectedIndex();
				textField_1.setText("I[" + ins[selInst]
						+ "] C5q D5q E5q C5q C5q D5q E5q C5q E5q F5q G5h E5q F5q G5h G5i A5i G5i F5i E5q C5q G5i A5i G5i F5i E5q C5q C5q G4q C5h C5q G4q C"+oct[oct2]+"w ");
				textField.setText("I[" + ins[selInst] + "] ");
			}

		});

		Player player = new Player();

		JButton btn2 = new JButton("Do");
		btn2.setBounds(21, 150, 70, 200);
		btn2.setForeground(Color.BLACK);
		btn2.setVerticalAlignment(SwingConstants.BOTTOM);
		btn2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn2.setBackground(Color.WHITE);
		layeredPane.add(btn2);
		layeredPane.setPosition(btn2, 1);
		btn2.setMargin(new Insets(0, 0, 0, 0));
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "C"+oct[oct1]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] C"+oct[oct1]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] C"+oct[oct1]+"w "));
						}
					}
				}.start();
			}
		});

		JButton btn1 = new JButton("Do#");
		btn1.setBounds(64, 150, 50, 120);
		btn1.setForeground(Color.WHITE);
		btn1.setVerticalAlignment(SwingConstants.BOTTOM);
		btn1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn1.setBackground(Color.BLACK);
		layeredPane.add(btn1);
		layeredPane.setPosition(btn1, 0);
		btn1.setMargin(new Insets(0, 0, 0, 0));
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "C"+oct[oct1]+"#w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] C"+oct[oct1]+"#w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] C"+oct[oct1]+"#w "));
						}
					}
				}.start();
			}
		});

		JButton btnD = new JButton("Ré");
		btnD.setBounds(90, 150, 70, 200);
		btnD.setVerticalAlignment(SwingConstants.BOTTOM);
		btnD.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnD.setBackground(Color.WHITE);
		layeredPane.add(btnD);
		layeredPane.setPosition(btnD, 1);
		btnD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "D"+oct[oct1]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] D"+oct[oct1]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] D"+oct[oct1]+"w "));
						}
					}
				}.start();
			}
		});

		JButton button = new JButton("Ré#");
		button.setBounds(134, 150, 50, 120);
		button.setVerticalAlignment(SwingConstants.BOTTOM);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBackground(Color.BLACK);
		layeredPane.add(button);
		layeredPane.setPosition(button, 0);
		button.setMargin(new Insets(0, 0, 0, 0));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "D#"+oct[oct1]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] D#"+oct[oct1]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] D#"+oct[oct1]+"w "));
						}
					}
				}.start();
			}
		});

		JButton btnE = new JButton("Mi");
		btnE.setBounds(159, 150, 70, 200);
		btnE.setVerticalAlignment(SwingConstants.BOTTOM);
		btnE.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnE.setBackground(Color.WHITE);
		layeredPane.add(btnE);
		layeredPane.setPosition(btnE, 1);
		btnE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "E"+oct[oct1]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] E"+oct[oct1]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] E"+oct[oct1]+"w "));
						}
					}
				}.start();
			}

		});

		JButton btnF_2 = new JButton("Fa");
		btnF_2.setBounds(227, 150, 70, 200);
		btnF_2.setVerticalAlignment(SwingConstants.BOTTOM);
		btnF_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnF_2.setBackground(Color.WHITE);
		layeredPane.add(btnF_2);
		layeredPane.setPosition(btnF_2, 1);
		btnF_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "F"+oct[oct1]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] F"+oct[oct1]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] F"+oct[oct1]+"w "));
						}
					}
				}.start();
			}

		});

		JButton button_1 = new JButton("Fa#");
		button_1.setBounds(267, 150, 50, 120);
		button_1.setVerticalAlignment(SwingConstants.BOTTOM);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBackground(Color.BLACK);
		layeredPane.add(button_1);
		layeredPane.setPosition(button_1, 0);
		button_1.setMargin(new Insets(0, 0, 0, 0));
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "F#"+oct[oct1]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] F#"+oct[oct1]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] F#"+oct[oct1]+"w "));
						}
					}
				}.start();
			}

		});

		JButton btnSol = new JButton("Sol");
		btnSol.setBounds(295, 150, 70, 200);
		btnSol.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSol.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSol.setBackground(Color.WHITE);
		layeredPane.add(btnSol);
		layeredPane.setPosition(btnSol, 1);
		btnSol.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "G"+oct[oct1]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] G"+oct[oct1]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] G"+oct[oct1]+"w "));
						}
					}
				}.start();
			}
		});

		JButton button_2 = new JButton("Sol#");
		button_2.setBounds(339, 150, 50, 120);
		button_2.setVerticalAlignment(SwingConstants.BOTTOM);
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_2.setBackground(Color.BLACK);
		layeredPane.add(button_2);
		layeredPane.setPosition(button_2, 0);
		button_2.setMargin(new Insets(0, 0, 0, 0));
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "G#"+oct[oct1]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] G#"+oct[oct1]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] G#"+oct[oct1]+"w "));
						}
					}
				}.start();
			}
		});

		JButton btnLa = new JButton("La");
		btnLa.setBounds(364, 150, 70, 200);
		btnLa.setVerticalAlignment(SwingConstants.BOTTOM);
		btnLa.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLa.setBackground(Color.WHITE);
		layeredPane.add(btnLa);
		layeredPane.setPosition(btnLa, 1);
		btnLa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "A"+oct[oct1]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] A"+oct[oct1]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] A"+oct[oct1]+"w "));
						}
					}
				}.start();
			}
		});

		JButton button_3 = new JButton("La#");
		button_3.setBounds(410, 150, 50, 120);
		button_3.setVerticalAlignment(SwingConstants.BOTTOM);
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_3.setBackground(Color.BLACK);
		layeredPane.add(button_3);
		layeredPane.setPosition(button_3, 0);
		button_3.setMargin(new Insets(0, 0, 0, 0));
		button_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "A#"+oct[oct1]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] A#"+oct[oct1]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] A#"+oct[oct1]+"w "));
						}
					}
				}.start();
			}
		});

		JButton btnSi = new JButton("Si");
		btnSi.setBounds(432, 150, 70, 200);
		btnSi.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSi.setBackground(Color.WHITE);
		layeredPane.add(btnSi);
		layeredPane.setPosition(btnSi, 1);
		btnSi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "B"+oct[oct1]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] B"+oct[oct1]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] B"+oct[oct1]+"w "));
						}
					}
				}.start();
			}
		});

		JButton btn2_2 = new JButton("Do");
		btn2_2.setBounds(500, 150, 70, 200);
		btn2_2.setForeground(Color.BLACK);
		btn2_2.setVerticalAlignment(SwingConstants.BOTTOM);
		btn2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn2_2.setBackground(Color.WHITE);
		layeredPane.add(btn2_2);
		layeredPane.setPosition(btn2_2, 1);
		btn2_2.setMargin(new Insets(0, 0, 0, 0));
		btn2_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "C"+oct[oct2]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] C"+oct[oct2]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] C"+oct[oct2]+"w "));
						}
					}
				}.start();
			}
		});

		JButton btn1_2 = new JButton("Do#");
		btn1_2.setBounds(543, 150, 50, 120);
		btn1_2.setForeground(Color.WHITE);
		btn1_2.setVerticalAlignment(SwingConstants.BOTTOM);
		btn1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn1_2.setBackground(Color.BLACK);
		layeredPane.add(btn1_2);
		layeredPane.setPosition(btn1_2, 0);
		btn1_2.setMargin(new Insets(0, 0, 0, 0));
		btn1_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "C#"+oct[oct2]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] C#"+oct[oct2]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] C#"+oct[oct2]+"w "));
						}
					}
				}.start();
			}
		});

		JButton btnD_2 = new JButton("Ré");
		btnD_2.setBounds(568, 150, 70, 200);
		btnD_2.setVerticalAlignment(SwingConstants.BOTTOM);
		btnD_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnD_2.setBackground(Color.WHITE);
		layeredPane.add(btnD_2);
		layeredPane.setPosition(btnD_2, 1);
		btnD_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "D"+oct[oct2]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] D"+oct[oct2]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] D"+oct[oct2]+"w "));
						}
					}
				}.start();
			}
		});

		JButton button_2_2 = new JButton("Ré#");
		button_2_2.setBounds(611, 150, 50, 120);
		button_2_2.setVerticalAlignment(SwingConstants.BOTTOM);
		button_2_2.setForeground(Color.WHITE);
		button_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_2_2.setBackground(Color.BLACK);
		layeredPane.add(button_2_2);
		layeredPane.setPosition(button_2_2, 0);
		button_2_2.setMargin(new Insets(0, 0, 0, 0));
		button_2_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "D#"+oct[oct2]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] D#"+oct[oct2]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] D#"+oct[oct2]+"w "));
						}
					}
				}.start();
			}
		});

		JButton btnE_2 = new JButton("Mi");
		btnE_2.setBounds(636, 150, 70, 200);
		btnE_2.setVerticalAlignment(SwingConstants.BOTTOM);
		btnE_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnE_2.setBackground(Color.WHITE);
		layeredPane.add(btnE_2);
		layeredPane.setPosition(btnE_2, 1);
		btnE_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "E"+oct[oct2]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] E"+oct[oct2]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] E"+oct[oct2]+"w "));
						}
					}
				}.start();
			}

		});

		JButton btnF_2_2 = new JButton("Fa");
		btnF_2_2.setBounds(704, 150, 70, 200);
		btnF_2_2.setVerticalAlignment(SwingConstants.BOTTOM);
		btnF_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnF_2_2.setBackground(Color.WHITE);
		layeredPane.add(btnF_2_2);
		layeredPane.setPosition(btnF_2_2, 1);
		btnF_2_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "F"+oct[oct2]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] F"+oct[oct2]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] F"+oct[oct2]+"w "));
						}
					}
				}.start();
			}

		});

		JButton button_1_2 = new JButton("Fa#");
		button_1_2.setBounds(747, 150, 50, 120);
		button_1_2.setVerticalAlignment(SwingConstants.BOTTOM);
		button_1_2.setForeground(Color.WHITE);
		button_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1_2.setBackground(Color.BLACK);
		layeredPane.add(button_1_2);
		layeredPane.setPosition(button_1_2, 0);
		button_1_2.setMargin(new Insets(0, 0, 0, 0));
		button_1_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "F#"+oct[oct2]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] F#"+oct[oct2]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] F#"+oct[oct2]+"w "));
						}
					}
				}.start();
			}

		});

		JButton btnSol_2 = new JButton("Sol");
		btnSol_2.setBounds(772, 150, 70, 200);
		btnSol_2.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSol_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSol_2.setBackground(Color.WHITE);
		layeredPane.add(btnSol_2);
		layeredPane.setPosition(btnSol_2, 1);
		btnSol_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "G"+oct[oct2]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] G"+oct[oct2]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] G"+oct[oct2]+"w "));
						}
					}
				}.start();
			}
		});

		JButton BtnSolc_2 = new JButton("Sol#");
		BtnSolc_2.setBounds(815, 150, 50, 120);
		BtnSolc_2.setVerticalAlignment(SwingConstants.BOTTOM);
		BtnSolc_2.setForeground(Color.WHITE);
		BtnSolc_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		BtnSolc_2.setBackground(Color.BLACK);
		layeredPane.add(BtnSolc_2);
		layeredPane.setPosition(BtnSolc_2, 0);
		BtnSolc_2.setMargin(new Insets(0, 0, 0, 0));
		BtnSolc_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "G#"+oct[oct2]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] G#"+oct[oct2]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] G#"+oct[oct2]+"w "));
						}
					}
				}.start();
			}
		});

		JButton btnLa_2 = new JButton("La");
		btnLa_2.setBounds(840, 150, 70, 200);
		btnLa_2.setVerticalAlignment(SwingConstants.BOTTOM);
		btnLa_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLa_2.setBackground(Color.WHITE);
		layeredPane.add(btnLa_2);
		layeredPane.setPosition(btnLa_2, 1);
		btnLa_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "A"+oct[oct2]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] A"+oct[oct2]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] A"+oct[oct2]+"w "));
						}
					}
				}.start();
			}
		});

		JButton button_3_2 = new JButton("La#");
		button_3_2.setBounds(883, 150, 50, 120);
		button_3_2.setVerticalAlignment(SwingConstants.BOTTOM);
		button_3_2.setForeground(Color.WHITE);
		button_3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_3_2.setBackground(Color.BLACK);
		layeredPane.add(button_3_2);
		layeredPane.setPosition(button_3_2, 0);
		button_3_2.setMargin(new Insets(0, 0, 0, 0));
		button_3_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "A#"+oct[oct2]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] A#"+oct[oct2]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] A#"+oct[oct2]+"w "));
						}
					}
				}.start();
			}
		});

		JButton btnSi_2 = new JButton("Si");
		btnSi_2.setBounds(908, 150, 70, 200);
		btnSi_2.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSi_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSi_2.setBackground(Color.WHITE);
		layeredPane.add(btnSi_2);
		layeredPane.setPosition(btnSi_2, 1);
		btnSi_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				textField.setText(textField.getText() + "B"+oct[oct2]+"w ");
				new Thread() {
					public void run() {
						try {
							player.play(new Pattern("I[" + ins[selInst] + "] B"+oct[oct2]+"w "));
						} catch (IllegalStateException e) {
							player.play(new Pattern("I[" + ins[selInst] + "] B"+oct[oct2]+"w "));

						}
					}
				}.start();
			}
		});

		JLabel lblInput_cla = new JLabel("Console");
		lblInput_cla.setForeground(Color.GRAY);
		lblInput_cla.setBounds(21, 119, 46, 14);
		layeredPane.add(lblInput_cla);
		layeredPane.setPosition(lblInput_cla, 1);

		JTextField textField_cla = new JTextField(); // clavier
		textField_cla.setBounds(94, 116, 99, 20);
		textField_cla.setColumns(10);
		layeredPane.add(textField_cla);
		layeredPane.setPosition(textField_cla, 1);
		textField_cla.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				switch (e.getKeyChar()) {

				case 'Q':
					btn2.doClick(150);
					break;
				case 'Z':
					btn1.doClick(150);
					break;
				case 'S':
					btnD.doClick(150);
					break;
				case 'E':
					button.doClick(150);
					break;
				case 'D':
					btnE.doClick(150);
					break;
				case 'F':
					btnF_2.doClick(150);
					break;
				case 'T':
					button_1.doClick(150);
					break;
				case 'G':
					btnSol.doClick(150);
					break;
				case 'Y':
					button_2.doClick(150);
					break;
				case 'H':
					btnLa.doClick(150);
					break;
				case 'U':
					button_3.doClick(150);
					break;
				case 'J':
					btnSi.doClick(150);
					break;

				case 'q':
					btn2_2.doClick(150);
					break;
				case 'z':
					btn1_2.doClick(150);
					break;
				case 's':
					btnD_2.doClick(150);
					break;
				case 'e':
					button_2_2.doClick(150);
					break;
				case 'd':
					btnE_2.doClick(150);
					break;
				case 'f':
					btnF_2_2.doClick(150);
					break;
				case 't':
					button_1_2.doClick(150);
					break;
				case 'g':
					btnSol_2.doClick(150);
					break;
				case 'y':
					BtnSolc_2.doClick(150);
					break;
				case 'h':
					btnLa_2.doClick(150);
					break;
				case 'u':
					button_3_2.doClick(150);
					break;
				case 'j':
					btnSi_2.doClick(150);
					break;
				default:

				}
			}

			public void keyReleased(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
			}
		});

		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(902, 84, 76, 23);
		layeredPane.add(btnPlay);
		layeredPane.setPosition(btnPlay, 1);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				new Thread() {
					public void run() {
						player.play(textField_1.getText());
					}
				}.start();
			}
		});

		JButton btnRaz = new JButton("RAZ");
		btnRaz.setBounds(902, 116, 76, 23);
		layeredPane.add(btnRaz);
		layeredPane.setPosition(btnRaz, 1);
		btnRaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox.setSelectedIndex(0);
				textField.setText("I[" + ins[0] + "] ");
				textField_1.setText("I[" + ins[0] + "] ");
				textField_cla.setText("");
				comboBox_1.setSelectedIndex(4);
				comboBox_2.setSelectedIndex(5);
				lecteur.muet();
				player.play("");
			}
		});
		

	}
	

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		PianoV P = new PianoV();
	}
}
