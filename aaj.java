import javax.swing.*;
import java.io.*;
import java.util.*;

interface DataIO
{
    void setData(int no );
    void display();
}

interface GetData
{
    int getNo();
    String getName();
}

interface ResultIO
{
    void setMarks();
    int size =5;
    int calcTotal();
    int calcAvg();
    void dispMarks();
}

class XStudent implements DataIO, GetData
{

    int no;
    String nm;
    XStudent()
    {
        no = 0;
        nm= new String();
    }

    public String toString()
    {
        String s = "Roll No : "+no+"\nName : "+nm;
        return s;
    }

    public void display()
    {
        JOptionPane.showMessageDialog(null,toString());

    }
    public int getNo()
    {
        return no;
    }
    public String getName()
    {
        return nm;
    }

    public void setData(int no)
    {
        this.no = no;  // In CPP "this" is pointer and in Java "this" is reference 
        nm = JOptionPane.showInputDialog(null,"Name");
    }
}

interface IState
{
    boolean getState();
    void setState(boolean b);
}

class XMarks extends XStudent implements ResultIO
{
    int []mrk ;
    XMarks()
    {
        super();
        mrk = new int [5];
    }
    public void setMarks()
    {
        int i = 0;
        while(i<size)
        {
            try{
                mrk[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Marks"));
            }
            catch(Exception e)
            {mrk[i]=0;}
            i++;
        }
    }
    public int calcTotal()
    {
        int i = 1 , tot = mrk[0];
        while(i<size)
        {
            tot+= mrk[i++];
            return tot;
        }
    }
    public int calcAvg()
    {
        return calcTotal()/size;
    }
    public String toString()
    {
        String s = super.toString()+"\nMarks :"+ Arrays.toString(mrk);
        return s;
    }

    public void dispMarks()
    {
        JOptionPane.showMessageDialog(null,toString());
    }
}


class XResult extends XMarks implements IState{

    int total;
    int avg;
    boolean state;
    XResult()
    {
        super();
        total = 0;
        avg= 0;
        state = true;
    }
}