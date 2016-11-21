import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

public class Gui implements ActionListener
{
	Random randomGenerator = new Random();
	int tr = randomGenerator.nextInt(4);
	public static int []getitnow={};
	JPanel matrix=new JPanel();
	private JButton button,b3,b0,b1,b2,b4,a[];
	JFrame frame=new JFrame();
	JTextField text=new JTextField();
	int v=0,r=1,d=0;
	Timer timer,t;
	String val="OX";
	String[] nam=new String[2];
	private char []m={val.charAt(tr%2),val.charAt((tr+1)%2)};

	public static void main(String[] args){
		SimpleGui gui=new SimpleGui();
		gui.go();
	} 

	public void go()
	{
		int gap=140;
		JPanel panel=new JPanel(new GridLayout(gap,gap,gap,gap));
		JLabel label=new JLabel("Tic-Tac-Toe",SwingConstants.CENTER);
		panel.setBorder(BorderFactory.createEmptyBorder(gap,gap,0,gap));
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		button=new JButton("Start Game");
		button.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e)
	    {
	        mainScreen();
	    }
		});
		Font font=new Font("serif",Font.PLAIN,200);
		panel.setFont(font);
		label.setFont(new Font("serif",Font.PLAIN,20));
		b3 = new JButton("      Exit        ");
		b3.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e)
	    {
	    	button.setBackground(Color.RED);
	        System.exit(0);
	    }
		});
		frame.setUndecorated(true);
		panel.add(label);
		panel.add(Box.createVerticalStrut(30));
		panel.add(button);
		panel.add(Box.createVerticalStrut(10));
		panel.add(b3);
		b3.setPreferredSize(button.getPreferredSize());	
		panel.setBackground(new Color(199,0,57));
		b3.setBackground(new Color(255,87,51));
		button.setBackground(new Color(255,87,51));  
		frame.getContentPane().add(BorderLayout.CENTER,panel);
		frame.setSize(400,400);
		frame.setVisible(true);
		frame.setTitle("Tic Tac Toe");
	}

	public void mainScreen()
	{
		int gap=10;
		frame=new JFrame();
		GridLayout exp=new GridLayout(3,3);
		text=new JTextField();
		text.setEditable(false);
		text.setBounds(160,320,230,40);
		text.setBackground(Color.white);
		matrix.setLayout(exp);
		a= new JButton[9];
		text.setText("Output Box");
		for(int i=0;i<9;i++)
		{
			a[i]=new JButton();
			a[i].addActionListener(this);
			matrix.add(a[i]);
		}
	
		matrix.setPreferredSize(new Dimension(250,100));
		matrix.setBorder(BorderFactory.createEmptyBorder(gap+20,gap,100,gap));
		
		JPanel panel=new JPanel(new GridLayout(gap,gap,gap,gap));
		panel.setBorder(BorderFactory.createEmptyBorder(gap+20,gap,gap,gap));
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.setBackground(new Color(100,30,22));
		matrix.setBackground(new Color(236,112,99));
		b4 = new JButton("          Exit          ");
		b4.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e)
	    {
	        System.exit(0);
	    }
		});

		b3= new JButton(" User vs AI Bot ");
		b3.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e)
	    {
	    	v=0;
	    	for(int i=0;i<9;i++)
	    	{
	    		a[i].setText("");
	    		a[i].setBackground(new JButton().getBackground());
	    		getitnow[i]=0;
	    	}
	    	b3.setBackground(new Color(155, 89, 182));
	    	b0.setBackground(Color.PINK);
	    	b1.setBackground(Color.PINK);
	    	b2.setBackground(Color.PINK);
	    	d=4;
	        pop(1);
	        nam[1]="AI Bot";
	        text.setText(nam[v%2]+"\'s turn");
			v++;
	    }
		});

		b2 = new JButton("  CPU vs AI Bot ");
		b2.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e)
	    {
	    	Random randomGenerator = new Random();
	    	v = randomGenerator.nextInt(2);
	    	for(int i=0;i<9;i++)
	    	{
	    		a[i].setText("");
	    		a[i].setBackground(new JButton().getBackground());
	    		getitnow[i]=0;
	    	}
	    	d=3;
	    	b2.setBackground(new Color(155, 89, 182));
	    	b0.setBackground(Color.PINK);
	    	b1.setBackground(Color.PINK);
	    	b3.setBackground(Color.PINK);
	    	nam[1]="CPU";
	    	nam[0]="AI Bot";
	    	text.setText(nam[v%2]+"\'s turn");
			timer=new Timer(2000,new TimerClass());
			timer.start(); 
	    }
		});

		b1 = new JButton("   User vs CPU  ");
		b1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e)
	    {
	    	v=0;
	    	for(int i=0;i<9;i++)
	    	{
	    		a[i].setText("");
	    		a[i].setBackground(new JButton().getBackground());
	    		getitnow[i]=0;
	    	}
	    	d=2;
	    	b1.setBackground(new Color(155, 89, 182));
	    	b0.setBackground(Color.PINK);
	    	b3.setBackground(Color.PINK);
	    	b2.setBackground(Color.PINK);;
	        pop(1);
	        nam[1]="CPU";
	        text.setText(nam[v%2]+"\'s turn");
			v++;
	    }
		});

		b0 = new JButton("User1 vs User2");
		b0.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e)
	    {
	    	v=0;
	    	for(int i=0;i<9;i++)
	    	{
	    		a[i].setText("");
	    		a[i].setBackground(new JButton().getBackground());
	    		getitnow[i]=0;
	    	}
	    	d=1;
	    	b0.setBackground(new Color(155, 89, 182));
	    	b3.setBackground(Color.PINK);
	    	b1.setBackground(Color.PINK);
	    	b2.setBackground(Color.PINK);;
	        pop(2);
			text.setText(nam[v%2]+"\'s turn");
			v++;
	    }
		});

		frame.setUndecorated(true);
		panel.add(b0);
		panel.add(Box.createVerticalStrut(40));
		panel.add(b1);
		panel.add(Box.createVerticalStrut(40));
		panel.add(b2);
		panel.add(Box.createVerticalStrut(40));
		panel.add(b3);
		panel.add(Box.createVerticalStrut(100));
		panel.add(b4);
		frame.setBackground(Color.white);
		b0.setBackground(Color.pink);
		b1.setBackground(Color.pink);
		b2.setBackground(Color.pink);
		b3.setBackground(Color.pink);
		b4.setBackground(Color.pink);
		frame.getContentPane().add(BorderLayout.WEST,panel);
		frame.getContentPane().add(BorderLayout.EAST,text);
		frame.getContentPane().add(BorderLayout.EAST,matrix);
		frame.setSize(400,400);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event)
	{
		text.setText(nam[v%2]+"\'s turn");
		else if (d==2)
		{	
			Object btn=event.getSource();
			for(int i=0;i<9;i++)
			{	
				if(a[i]==btn && getitnow[i]==0)
				{
					getitnow[i]=1;
					a[i].setText(m[v%2]+"");
					v++;
					if(check()==1){
						text.setText(nam[v%2]+" won");
						return;
					}
				}
			}
			int m=0;
			for(int i=0;i<9;i++)
				if(getitnow[i]==1) 
					m++;
			if(m==9)
			{
				text.setText("It is a tie");
				return;
			}
			generate();
		}
		else if (d==4)
		{	
			Object btn=event.getSource();
			for(int i=0;i<9;i++)
			{	
				if(a[i]==btn && getitnow[i]==0)
				{
					getitnow[i]=1;
					a[i].setText(m[v%2]+"");
					v++;
					if(check()==1){
						text.setText(nam[v%2]+" won");
						return;
					}
				}
			}
			int m=0;
			for(int i=0;i<9;i++)
				if(getitnow[i]==1) 
					m++;
			if(m==9)
			{
				text.setText("It is a tie");
				return;
			}
			aigenerate();
		}
	}

	public void pop(int f)
	{
		JPanel p = new JPanel(new BorderLayout(5,5));
        JPanel labels = new JPanel(new GridLayout(0,1,2,2));
        JTextField pr=new JTextField();
        JTextField u2 = new JTextField("gfe");
      	pr.setText("Enter User names");
      	pr.setEditable(false);
        labels.add(new JLabel("User 1", SwingConstants.RIGHT));
        if(f>5)
        {
        	pr.setText("Enter correct User names");
        	f-=5;
        }
       
        if(f==2)
        {
        	labels.add(new JLabel("User 2", SwingConstants.RIGHT));
        }
        p.add(labels, BorderLayout.WEST);

        JPanel controls = new JPanel(new GridLayout(0,1,2,2));
        JTextField u1 = new JTextField("");
        controls.add(Box.createVerticalStrut(10));
        controls.add(u1);
        if(f==2)
        {
        	controls.add(Box.createVerticalStrut(10));
	        u2 = new JTextField("");
	        controls.add(u2);
        }
        
      	controls.add(pr);
        p.add(controls, BorderLayout.CENTER);
        JOptionPane.showMessageDialog(frame, p, "Enter name", JOptionPane.QUESTION_MESSAGE);
        if (u1.getText().equals("")||u2.getText().equals("")) 
        {
        	pop(f+5);  
		}  
		nam[0]=u1.getText();
		nam[1]=u2.getText();
		//System.out.println(u1.getText()+u2.getText());	
	}

	public class TimerClass implements ActionListener
	{
		public void actionPerformed(ActionEvent j)
		{
			int q=0;
			for(int i=0;i<9;i++)
				if(getitnow[i]==1) 
					q++;
			if(check()==1 || q==9)
			{
				//System.out.println("jeet gaya bc");
				timer.stop();
			}
			if(v%2==0 && (check()!=1 && q!=9))
			{
				text.setText(nam[v%2]+"\'s turn");
				aigenerate();
			}
			else if(v%2==1 && (check()!=1 && q!=9))
			{
				text.setText(nam[v%2]+"\'s turn");
				generate();
			}
			
			if(check()==1 || q==9)
			{
				timer.stop();
			}
		}
	}
}
