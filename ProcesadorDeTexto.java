package ies.procesador;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ProcesadorDeTexto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoProcesador m=new MarcoProcesador();
		
		m.setVisible(true);
		
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

	}

}
//dasdasdasdadasd
class MarcoProcesador extends JFrame{
	
	public MarcoProcesador() {
		
		setTitle("Procesador de Texto");
		
		Toolkit miPantalla=Toolkit.getDefaultToolkit();
		
		Dimension tamano=miPantalla.getScreenSize();
		
		int ancho=tamano.width;
		
		int alto=tamano.height;
		
		setBounds(ancho/4,alto/4,ancho/2,alto/2);
		
		LaminaProcesador l=new LaminaProcesador();
		
		add(l);
	}
	
	
}

class LaminaProcesador extends JPanel{
	
	private JTextArea area;
	
	private JMenuItem courier,arial,times,veinte,treinta,cuarenta,cincuenta;
	
	private JCheckBoxMenuItem negrita,cursiva;
	
	private int tipo=0;
	
	private String fuente="helvetica";
	
	private int tamano=20;
	
	public LaminaProcesador() {
		
		setLayout(new BorderLayout());
		
		//Lamina para el texto
		
		area=new JTextArea();
		
		JScrollPane laminaTexto=new JScrollPane(area);
		
		add(laminaTexto,BorderLayout.CENTER);
		
		//Lamina para el menu
		
		JPanel menu=new JPanel();
		
		add(menu,BorderLayout.NORTH);
		
		//barra de menu
		
		JMenuBar barra=new JMenuBar();
		
		//Items de la barra
		
		JMenu fuente=new JMenu("Fuente");
		
		JMenu estilo=new JMenu("Estilo");
		
		JMenu tamano=new JMenu("Tamano");
		
		//Items del menu para el estilo
		
		courier=new JMenuItem("Courier");
		
		courier.addActionListener(new EscogerFuente());
		
		arial=new JMenuItem("Arial");
		
		arial.addActionListener(new EscogerFuente());
		
		times=new JMenuItem("Times New Roman");
		
		times.addActionListener(new EscogerFuente());
		
		//Items del menu para el tipo de letra
		
		negrita=new JCheckBoxMenuItem("Bold");
		
		negrita.addActionListener(new EscogerFuente());
		
		cursiva=new JCheckBoxMenuItem("Italic");
		
		cursiva.addActionListener(new EscogerFuente());
		
		//Items para los tamaños
		
		veinte=new JMenuItem("20");
		
		veinte.addActionListener(new EscogerFuente());
		
		treinta=new JMenuItem("30");
		
		treinta.addActionListener(new EscogerFuente());
		
		cuarenta=new JMenuItem("40");
		
		cuarenta.addActionListener(new EscogerFuente());
		
		cincuenta=new JMenuItem("50");
		
		cincuenta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_DOWN_MASK));
		
		cincuenta.addActionListener(new EscogerFuente());
		
		tamano.add(veinte);
		
		tamano.add(treinta);
		
		tamano.add(cuarenta);
		
		tamano.add(cincuenta);
		
		estilo.add(negrita);
		
		estilo.add(cursiva);
		
		fuente.add(courier);
		
		fuente.add(arial);
		
		fuente.add(times);
		
		menu.add(barra);
		
		barra.add(fuente);
		
		barra.add(estilo);
		
		barra.add(tamano);
		
		
		
	}
	
	public void aniadirOyente(JMenuItem e) {
		
		e.addActionListener(new EscogerFuente());
		
	}
	
	private class EscogerFuente implements ActionListener{
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			Object botonPulsado=e.getSource();
			
			
			
			if(botonPulsado==negrita) {
				
				tipo=Font.BOLD;
				
			}else if(botonPulsado==cursiva) {
				
				tipo=Font.ITALIC;
				
			}
			
			
			if(botonPulsado==courier) {
				
				fuente="Courier";
				
				
				
			}else if(botonPulsado==arial) {
				
				fuente="Arial";
				
				
				
			}else if(botonPulsado==times) {
				
				fuente="Times New Roman";
				
			}
			
			if(botonPulsado==veinte) {
				
				tamano=20;
			}else if(botonPulsado==treinta) {
				
				tamano=30;
			}else if(botonPulsado==cuarenta) {
				
				tamano=40;
				
			}else if(botonPulsado==cincuenta) {
				
				tamano=50;
			}
			
			Font miFuente=new Font(fuente,tipo,tamano);
			
			area.setFont(miFuente);
			
		}
	}
	
}


	
