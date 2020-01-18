import javax.swing.text.*;
import javax.swing.*;


class FixedSizeDocument extends PlainDocument{
	private int max = 10;
	public FixedSizeDocument(int max){
		this.max = max;
		}
	@Override
	public void insertString(int offs, String str, AttributeSet a)throws BadLocationException{
		if (getLength()+str.length()>max){
			str = str.substring(0, max - getLength());
		}

		super.insertString(offs, str, a);

	}

}

public class MyTextField extends JTextField{
  MyTextField(int i){
    super(i);
    this.setDocument(new FixedSizeDocument(256));	
    }
    
  MyTextField(int i, int j){
		super(i);
		this.setDocument(new FixedSizeDocument(j));	
	  }		
	}

