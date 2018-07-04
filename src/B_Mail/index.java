package B_Mail;

import java.util.Locale;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseEvent;

import java.awt.event.MouseAdapter;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class index {
	private JFrame frmBMail;
	private static final String SayWhat = "kevin16";
	Voice iTalk;
	VoiceManager vm = VoiceManager.getInstance();
	public void findex() {
		JWindow window = new JWindow();
		window.getContentPane().add(new JLabel("   B-MAIL: VOICE BASED E-MAIL SYSTEM FOR VISUALLY CHALLENGED"));
		window.setBounds(450, 200, 400, 380);
		window.getContentPane().setBackground(Color.CYAN);

		window.setVisible(true);
		
		iTalk = vm.getVoice(SayWhat);
		iTalk.allocate();
		try {

			iTalk.speak("CLICK SCROLL BUTTON TO LISTEN TO INSTRUCTIONS");
		

		} catch (Exception ex) {
			System.out.println(" ");

		}
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		window.dispose();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index window = new index();
					window.frmBMail.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public index() {

		initialize();

	}

	public void initialize() {

		frmBMail = new JFrame();
		frmBMail.setBackground(Color.LIGHT_GRAY);
		frmBMail.setResizable(false);
		frmBMail.setTitle("B MAIL");
		frmBMail.setBounds(0, 0, 1380, 900);
		frmBMail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBMail.getContentPane().setLayout(null);
		JLabel lblLeftClickFor = new JLabel("* LEFT CLICK FOR LOGIN");
		lblLeftClickFor.setBounds(557, 281, 258, 36);
		lblLeftClickFor.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frmBMail.getContentPane().add(lblLeftClickFor);

		JLabel lblRightClickFor = new JLabel("* RIGHT CLICK FOR SIGN UP");
		lblRightClickFor.setBounds(557, 377, 319, 36);
		lblRightClickFor.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frmBMail.getContentPane().add(lblRightClickFor);

		frmBMail.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {

				if (e.getButton() == MouseEvent.BUTTON3) {
					Frame1 f1 = new Frame1();
					f1.NewWindow();
				} else if (e.getButton() == MouseEvent.BUTTON1) {

					login.unique();

				}
				else if (e.getButton() == MouseEvent.BUTTON2)
				{
					
					iTalk = vm.getVoice(SayWhat);
					iTalk.allocate();
					try {

						iTalk.speak("LEFT CLICK FOR LOGIN");
						iTalk.speak("RIGHT CLICK TO SIGN UP");

					} catch (Exception ex) {
						System.out.println(" ");

					}
				}

			}

		});

	}

	private WindowAdapter getWindowAdapter() {
		return new WindowAdapter() {

			public void windowClosing(WindowEvent we) {
				super.windowClosing(we);

			}

			public void windowIconified(WindowEvent we) {
				frmBMail.setState(JFrame.NORMAL);

			}
		};
	}
}
