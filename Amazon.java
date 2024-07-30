package part_3;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import java.text.*;

public class Amazon extends JFrame implements ActionListener{
	
	JLabel l1 , l2 , l3 , l4 , l5 ;
	JButton b1 , b2 , b3;
	JTextField t1 , t2 , t3;
	JTextArea outputArea;
	JPanel p1 , p2 ;
	String display = "";
	double sum = 0;
	Book b[];
	int count = 0;
	DecimalFormat fmt = new DecimalFormat("#.###");
	
	public Amazon() {
		super("Amazon");
		b = new Book[10];
		
		Container c = getContentPane();
		
		p1 = new JPanel();

		b1 = new JButton("ADD");
		
		b2 = new JButton("Display all");
		
		b3 = new JButton("Calculate Total");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		p1.setLayout(new GridLayout(3 , 1));
		
		p1.add(b1);	p1.add(b2); p1.add(b3);
		
		c.add(p1 , BorderLayout.WEST);
		
		l1 = new JLabel("Title: ");
		
		l2 = new JLabel("Author: ");
				
		l3 = new JLabel("Price: ");
				
		l4 = new JLabel("Total Price: ");
		
		l5 = new JLabel();
		
		t1 = new JTextField(10);
		
		t2 = new JTextField(10);
		
		t3 = new JTextField(10);
		
		p2 = new JPanel();
		
		p2.setLayout(new GridLayout(4 , 2));
		
		p2.add(l1);
		
		p2.add(t1);
		
		p2.add(l2);
		
		p2.add(t2);
		
		p2.add(l3);
		
		p2.add(t3);
		
		p2.add(l4);
		
		p2.add(l5);
		
		c.add(p2 , BorderLayout.EAST);
		
		outputArea = new JTextArea(10 , 15);
		outputArea.setEditable(false);
		c.add(new JScrollPane(outputArea) , BorderLayout.SOUTH);
		
		setSize(500,400);
		setVisible(true);
	}




	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			
			
			String author = t2.getText(); 
			
			double price = Double.parseDouble(t3.getText());
			
			b[count++] = new Book(t1.getText(), author ,price );
			
			t1.setText("");
			t2.setText("");
			t3.setText("");
			
		}
		else if(e.getSource() == b2) {
			sort(b);
			for (int i = 0 ; i < count ; i++) {
				
			display += b[i].toString();
			
			outputArea.setText(display);
			
		}}
		
		else if(e.getSource() == b3) {
			
			for(int i = 0; i < count ; i++) {
				sum += b[i].getPrice();
			}
			
			l5.setText("$" + fmt.format(sum));
		}
	}
	public void sort(Book b[]) {
		for(int j = 1 ; j < count ; j++) {
			for(int i = 0; i < count - 1 ; i++) {
				if(b[i].getPrice() > b[i + 1].getPrice() ) {
					Book hold = b[i];
					b[i] = b[i + 1];
					b[i + 1] = hold;}
			
			}
		}
	}
	public static void main(String[] args) {
		Amazon app = new Amazon();
	}
}


class Book{
	
	private String name , author;
	private double price;
	private DecimalFormat fmt = new DecimalFormat("#.###");
	
	
	public Book(String n , String a , double p) {
		name = n; 
		author = a; 
		price = p;
	}
	
	public String getName() {return name;}
	public String getAuthor() {return author;}
	public double getPrice() {return price;}
	
	public String toString() {return "Title: " + name + " ,\t" + "Author: " + author + " ,\t" + "Price to Purchase " + fmt.format(price) + "\n";}
}


