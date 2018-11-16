import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;

class Bomb extends JButton
{int i,j;
  boolean isBomb;
  int roundBombNum;
  boolean isVisited;

 public Bomb(int i,int j){
   this.i=i;
   this.j=j;
   isBomb=false;
   isVisited=false;
   roundBombNum=0;
 }

}


class MyFrame extends JFrame  implements ActionListener,MouseListener
{   
	Bomb b[][]=new Bomb[9][9];
	public MyFrame(){
     super("扫雷9*9");
	
	long startTime;
	long endTime;
	
	for(int i=0;i<9;i++)
	for(int j=0;j<9;j++)	
           b[i][j]=new Bomb(i,j);
 
       for(int i=0;i<9;i++)
		for(int j=0;j<9;j++)
		{add(b[i][j]);
	      b[ i ][ j ].addActionListener(this);
		   b[ i ][ j ].addMouseListener(this);
		}

        setBomb(10);

	setSize(500,500);
   	setVisible(true);
	setLayout(new GridLayout(9,9));

	}
  
    public void setBomb(int n){
		while(n>0){
	     int x =(int)(Math.random()*(9));  
             int y =(int)(Math.random()*(9));  
	     if (b[x][y].isBomb==false)
	       {  n--;
	        b[x][y].isBomb=true;
	       }
	    }
	countRoundBombNum();
	}
 public void replay(){
	  for(int i=0;i<9;i++)
	   for(int j=0;j<9;j++)	
	 { 	b[i][j].isBomb=false;
  		b[i][j].isVisited=false;
   	        b[i][j].roundBombNum=0;
   	        b[i][j].setText("");
	}
	 setBomb(10);
  }

	public void countRoundBombNum(){
	   for(int i=0;i<9;i++)
	   for(int j=0;j<9;j++)	{
         if(((i-1>=0)&&(j-1>=0))&&(b[i-1][j-1].isBomb==true))
                 b[i][j].roundBombNum++;
		 if(((i-1>=0)&&(j>=0))&&(b[i-1][j].isBomb==true))
                 b[i][j].roundBombNum++;
		 if(((i-1>=0)&&(j+1<=8))&&(b[i-1][j+1].isBomb==true))
                 b[i][j].roundBombNum++;
         if(((i>=0)&&(j-1>=0))&&(b[i][j-1].isBomb==true))
                 b[i][j].roundBombNum++;
		 if(((i>=0)&&(j+1<=8))&&(b[i][j+1].isBomb==true))
                 b[i][j].roundBombNum++;
		 if(((i+1<=8)&&(j-1>=0))&&(b[i+1][j-1].isBomb==true))
                 b[i][j].roundBombNum++;
		 if(((i+1<=8)&&(j>=0))&&(b[i+1][j].isBomb==true))
                 b[i][j].roundBombNum++;
		 if(((i+1<=8)&&(j+1<=8))&&(b[i+1][j+1].isBomb==true))
                 b[i][j].roundBombNum++;
	   }
		  
	}

  public void extend(int f,int g){
     
  if((f-1>=0)&&(g-1>=0)&&b[f-1][g-1].isVisited==false)   { b[f-1][g-1].setText( String.valueOf(b[f-1][g-1].roundBombNum) );b[f-1][g-1].isVisited=true;}
  if((f-1>=0)&&(g>=0)&&b[f-1][g].isVisited==false)     { b[f-1][g].setText( String.valueOf(b[f-1][g].roundBombNum) );b[f-1][g].isVisited=true;}
  if((f-1>=0)&&(g+1<=8)&&b[f-1][g+1].isVisited==false)    {b[f-1][g+1].setText( String.valueOf(b[f-1][g+1].roundBombNum) );b[f-1][g+1].isVisited=true;}
  if((f>=0)&&(g-1>=0)&&b[f][g-1].isVisited==false)     { b[f][g-1].setText( String.valueOf(b[f][g-1].roundBombNum) );b[f][g-1].isVisited=true;}
  if((f>=0)&&(g+1<=8)&&b[f][g+1].isVisited==false)     { b[f][g+1].setText( String.valueOf(b[f][g+1].roundBombNum) );b[f][g+1].isVisited=true;}
  if((f+1<=8)&&(g-1>=0)&&b[f+1][g-1].isVisited==false)  {  b[f+1][g-1].setText( String.valueOf(b[f+1][g-1].roundBombNum) );b[f+1][g-1].isVisited=true;}
  if((f+1<=8)&&(g>=0)&&b[f+1][g].isVisited==false)     { b[f+1][g].setText( String.valueOf(b[f+1][g].roundBombNum) );b[f+1][g].isVisited=true;}
  if((f+1<=8)&&(g+1<=8)&&b[f+1][g+1].isVisited==false)  {  b[f+1][g+1].setText( String.valueOf(b[f+1][g+1].roundBombNum) );b[f+1][g+1].isVisited=true;}



     if(((f-1>=0)&&(g-1>=0))&&(b[f-1][g-1].roundBombNum==0))      { extend(f-1,g-1);} 
     
     if(((f-1>=0)&&(g>=0))&&(b[f-1][g].roundBombNum==0))          { extend(f-1,g); }

     if(((f-1>=0)&&(g+1<=8))&&(b[f-1][g+1].roundBombNum==0))      { extend(f-1,g+1); }
	
     if(((f>=0)&&(g-1>=0))&&(b[f][g-1].roundBombNum==0))	  { extend(f,g-1);}
	
     if(((f>=0)&&(g+1<=8))&&(b[f][g+1].roundBombNum==0))	  { extend(f,g+1); }
	 
     if(((f+1<=8)&&(g-1>=0))&&(b[f+1][g-1].roundBombNum==0))      { extend(f+1,g-1);}
	
     if(((f+1<=8)&&(g>=0))&&(b[f+1][g].roundBombNum==0))	  { extend(f+1,g);}
	
     if(((f+1<=8)&&(g+1<=8))&&(b[f+1][g+1].roundBombNum==0))      { extend(f+1,g+1);}
	
}

   public void isWin(){
      int countNotBomb=0;
      for(int i=0;i<9;i++)
	   for(int j=0;j<9;j++)	{
	     if(b[i][j].isVisited==true) countNotBomb++;
	  if (countNotBomb==71)
	  {  JOptionPane msg = new JOptionPane(); 
         JOptionPane.showMessageDialog(this,"您挖完了所有的雷，您胜利了!","您胜利了",2); 
		replay();
	  }
	}
	  
 }

  public void listBomb(){
     for(int i=0;i<9;i++)
	  {for(int j=0;j<9;j++)	{
       if(b[i][j].isBomb==true) b[i][j].setText("雷" );} }
	    JOptionPane.showMessageDialog(this,"你踩到地雷了，按确定重来","你踩到地雷了",2);  
 
	   replay();
}


   public void actionPerformed(ActionEvent e) 
  { 
   if (((Bomb)e.getSource()).isBomb==true)
   {((Bomb)e.getSource()).setText("雷" );
   
    listBomb();
   }
   else {
    ((Bomb)e.getSource()).setText( String.valueOf(((Bomb)e.getSource()).roundBombNum) ); 
	   ((Bomb)e.getSource()).isVisited=true;

       isWin();
     if (((Bomb)e.getSource()).roundBombNum==0)
     { int   f=((Bomb)e.getSource()).i;
	   int   g=((Bomb)e.getSource()).j;
		 b[f][g].setText( String.valueOf(0));
		 extend(f,g);
     }

    } 
  }

  public void mouseClicked(MouseEvent e) 
 {
	  Boolean right=SwingUtilities.isRightMouseButton(e);
	  if (right==true&&((Bomb)e.getSource()).isVisited==false)
	  ((Bomb)e.getSource()).setText("雷" );
 
  }
   public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
public void mousePressed(MouseEvent e) {}
public void mouseReleased(MouseEvent e) {}
}

public class Abc5 
{
	public static void main(String[] args) 
	{
		MyFrame my=new MyFrame();
		
	}
}
