package Odyseo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;



public class PrincipalVacacional extends JFrame implements ActionListener
{
	private LinkedList<String> ListCadenas = new LinkedList<String>();
	private LinkedList<String> ListLexico = new LinkedList<String>();
	private LinkedList<String> ListSinta = new LinkedList<String>();
	private LinkedList<Integer> Fila = new LinkedList<Integer>();
	private CpiladorVacacional obc = new CpiladorVacacional();
	private JPanel contentPane;
	JButton btnVali,btnSalir,btnBorrar,btnGuardar;
	JTextArea text1, text2, text3, text4;
	int orden;
	public PrincipalVacacional() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 150, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.darkGray);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSalir = new JButton("Salir 2");
		btnSalir.setBackground(Color.black);
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnSalir.setBounds(435, 400, 110, 20);
		contentPane.add(btnSalir);
		
		btnVali = new JButton("Analizar");
		btnVali.setForeground(Color.WHITE);
		btnVali.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnVali.setBackground(Color.black);
		btnVali.setBounds(435, 250, 110, 20);
		contentPane.add(btnVali);
		
		btnBorrar= new JButton("Abrir Archivo");
		btnBorrar.setBackground(Color.black);
		btnBorrar.setForeground(Color.WHITE);
		btnBorrar.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnBorrar.setBounds(435, 300, 110, 20);
		contentPane.add(btnBorrar);
		
		btnGuardar= new JButton("Guardar Archivo");
		btnGuardar.setBackground(Color.black);
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnGuardar.setBounds(435, 350, 110, 20);
		contentPane.add(btnGuardar);
		
		JLabel lblNewLabel_1 = new JLabel("Programacion");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setBounds(20, 10, 300, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Analizador Lexico");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.white);
		lblNewLabel_2.setBounds(590, 120, 300, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Analizador Sintactico");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblNewLabel_3.setForeground(Color.white);
		lblNewLabel_3.setBounds(795, 120, 300, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Errores Encontrados");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblNewLabel_4.setForeground(Color.white);
		lblNewLabel_4.setBounds(460, 20, 500, 14);
		contentPane.add(lblNewLabel_4);
		
		text1 = new JTextArea();
		text1.setBounds(30, 40, 370, 590);
		contentPane.add(text1);

		text2 = new JTextArea();
		text2.setBounds(560, 150, 200, 480);
		contentPane.add(text2);
		
		text3 = new JTextArea();
		text3.setBounds(780, 150, 200, 480);
		contentPane.add(text3);
		
		text4 = new JTextArea();
		text4.setBounds(460, 50, 520, 50);
		contentPane.add(text4);
		
		JScrollPane scroll = new JScrollPane(text3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(780, 150, 200, 480);
		contentPane.add(scroll);
		
		for(int i=1;i<38;i++) 
		{
			if(i<10)
			{
				JLabel textlin = new JLabel(i+"");
				textlin.setBounds(10, 5+(i*16), 20, 55);
				textlin.setForeground(Color.WHITE);
				contentPane.add(textlin);
			}
			else
			{
				JLabel textlin = new JLabel(i+"");
				textlin.setBounds(10, 5+(i*16), 20, 55);
				textlin.setForeground(Color.WHITE);
				contentPane.add(textlin);
			}
		}	
		/*JLabel lblNewLabel = new JLabel("");		
		lblNewLabel.setBackground(Color.blue);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 500, 500, 250);
		contentPane.add(lblNewLabel);*/
		setUndecorated(true);
	    this.setLocationRelativeTo(null);
	    
	    //Acciones de botones
	    btnVali.addActionListener(this);
	    btnSalir.addActionListener(this);
	    btnBorrar.addActionListener(this);
	    btnGuardar.addActionListener(this);
	    
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException
	{ 
		PrincipalVacacional oba=new PrincipalVacacional();
		//System.out.println("hola");
		oba.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		LinkedList<String> ListLexico = new LinkedList<String>();
		String caderror ="";
		
		if(e.getSource()==btnVali)
		{
			ListCadenas.clear();///SE LIMPIAN LAS VARIABLES PARA EVITAR QUE TOME DATOS ANTERIORES
			this.ListLexico.clear();
			text2.setText("");
			Fila.clear();
			
			ListCadenas = obc.SepararN(text1.getText());
			for(String T:this.ListCadenas)
			{
				System.out.println(T+"LC");
			}
			for(int x=0;x<ListCadenas.size();x++)
			{
				//text2.append(LisTemp.get(x)+"\n");
				ListLexico = obc.Transformar(obc.Separar(ListCadenas.get(x)));
				if(obc.ErrorLexico())
				{
					text4.setText("Error:"+"Lexico->"+(x+1)+"->Un error lexico es generado por una mala escritura");
					return;
				}
				this.ListLexico.addAll(ListLexico);
				for(int y =0;y<ListLexico.size();y++)
				{
					text2.append(ListLexico.get(y)+" ");
					Fila.add(x);
					
				}
				text2.append("\n");
				
			}
			for(String T:this.ListLexico)
			{
				System.out.println(T+"->");
			}
			for(Integer T:this.Fila)
			{
				System.out.println("("+T+")");
			}
			System.out.println("///////////////////////////////////////////////////");

			ListSinta.clear();//SE LIMPIAN LAS VARIABLES PARA EVITAR QUE TOME DATOS ANTERIORES
			text3.setText("");
			text4.setText("");
			caderror="";
			
			obc.LecturaList(this.ListLexico);//envia valores lexicos
			caderror=obc.Validad2();//recupera el error
			if(caderror.isBlank())//detecta errores
			{
				text4.setText("0 errores encontrados");
			}else
			{
				text4.setText("Error:"+"Sintactico->"+ (Fila.get(obc.Contador())+1) + "->"+caderror+obc.Ultipila());//si quieres saber o detectar la palabra con error basta con ver los valores de ListLexico
			}
			ListSinta = obc.Sinta();//obitene valores sintacticos 
			for(String T:ListSinta)
			{
				text3.append(T+"\n");//los muestra en el text Area
			}
		}
			
		if(e.getSource()==btnSalir)
		{
			System.exit(0);
		}
		
		if(e.getSource()==btnBorrar)
		{
			File obf = null;
			 JFileChooser chooser = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "TXT","txt","BSO","bso");
			    chooser.setFileFilter(filter);
			    int returnVal = chooser.showOpenDialog(getParent());
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	//El archivo abierto lo almacenara en nuestra clase Txt y asi la devuelve para mostrarla en nuestra interfaz
			    	text1.setText("");
			    	obf=chooser.getSelectedFile();
			    	Txt obx=new Txt(obf.getAbsolutePath());
			    	//System.out.println(obf);
			    	//Almacenamos tambien la ruta del rachivo para no sebreescribir archivos incorrectos
			    	text1.setText(obx.getTexto());
			    }
			    else{
			    	//si no se elige ningun archivo o se cierra la ventana para elegir archivo se arrojara el siguiente mensaje
			    	text1.setText("");
			    	text1.setText(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> No se abrio ning�n archivo <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			    	
			    }
		}
		
		if(e.getSource()==btnGuardar)
		{
			try 
			{
				String nameArch = JOptionPane.showInputDialog("Nombre del archivo");
				FileWriter f=new FileWriter("C:\\Users\\3traisus\\Documents\\Universidad\\TXT\\"+nameArch+".txt");
				f.write(text1.getText());
				f.close();
			}catch(IOException e1) 
			{
			}
		}
	}


}
