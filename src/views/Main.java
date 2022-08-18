package views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField infoCopy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JEditorPane welcome = new JEditorPane();
		welcome.setBounds(67, 0, 602, 66);
		welcome.setEditable(false);
		welcome.setFont(new Font("Bitstream Charter", Font.BOLD | Font.ITALIC, 16));
		welcome.setText("Esta es una aplicación diseñada a medida para mi querido abuelo Mario Serrat. Espero sea de tu agrado y te evite alguna que otra puteada.");
		contentPane.add(welcome);
		
		JButton btnCopy = new JButton("Iniciar copia de Terminología Discapacidad");
		btnCopy.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		btnCopy.setBounds(216, 138, 335, 66);
		btnCopy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					copyTerminologiaDiscapacidad();
					infoCopy.setText("La copia fue realizada con exito!");					
				}catch(Exception ex){
					infoCopy.setText("Algo en la copia no salio como se esperaba" + ex.getMessage());
				}
			}
		});
		contentPane.add(btnCopy);
		
		infoCopy = new JTextField();
		infoCopy.setBounds(83, 293, 586, 75);
		infoCopy.setFont(new Font("DialogInput", Font.BOLD, 15));
		infoCopy.setHorizontalAlignment(SwingConstants.CENTER);
		infoCopy.setText("");
		infoCopy.setEditable(false);
		contentPane.add(infoCopy);
		infoCopy.setColumns(10);
	}

	public void copyTerminologiaDiscapacidad(){
		
		File sourceFile = new File("C:/Users/Administrador/Documents/terminologia discapacidad");

	    // Check weather source exists and it is folder.
	    if (sourceFile.exists() && sourceFile.isDirectory())
	    {
	        // Get list of the files and iterate over them
	        File[] listOfFiles = sourceFile.listFiles();
//	        File[] listOfFiles1 = destinationFile.listFiles();

	        if (listOfFiles != null)
	        {
	            for (File child : listOfFiles )
	            {
	            	Path sourceFolder = Path.of("C:/Users/Administrador/Documents/terminologia discapacidad/"+child.getName());
	                Path destinationFolder =Path.of("D:/terminologia discapacidad") ;
	            	try {
	            		Path copyTo = Files.copy(sourceFolder, destinationFolder.resolve(child.getName()), StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						 e.printStackTrace();
					}
	            }
	        }
	    }
	    else
	    {
	        System.out.println(sourceFile + "  Folder does not exists");
	    }
	}
}
