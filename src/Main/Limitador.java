package Main;

import javax.swing.text.AttributeSet;
import javax.swing.text.PlainDocument;
import javax.swing.text.BadLocationException;

public class Limitador extends PlainDocument{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int lim;

	public Limitador(int lim) { //construtor
		super();
		this.lim = lim;
	}
	
	public void insertString(int ofs, String str, AttributeSet a) throws BadLocationException {
		if((getLength() + str.length() <= lim)) {
			super.insertString(ofs, str, a);
		}
		
	}
	
	

	}
