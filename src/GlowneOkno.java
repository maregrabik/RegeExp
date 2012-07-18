import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GlowneOkno extends JFrame {

	private JPanel contentPane;
	private  List<Firma> bazaFirm;
	private GlPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlowneOkno frame = new GlowneOkno();
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
	public GlowneOkno() {
		bazaFirm = new ArrayList<Firma>();
		panel = new GlPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 471);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOpcje = new JMenu("Opcje");
		menuBar.add(mnOpcje);
		
		JMenuItem mntmZaladuj = new JMenuItem("Zaladuj");
		mntmZaladuj.addActionListener(new AkcjaLaduj(this,bazaFirm));
		mnOpcje.add(mntmZaladuj);
		
		JMenuItem mntmWyjdz = new JMenuItem("Wyjdz");
		mntmWyjdz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		mnOpcje.add(mntmWyjdz);
		
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
		//contentPane.add(panel);
		
	}

	public GlPanel getPanel() {
		return panel;
	}

	public void setPanel(GlPanel panel) {
		this.panel = panel;
	}

}
