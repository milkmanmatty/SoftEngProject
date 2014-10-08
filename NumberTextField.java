import javax.swing.text.AttributeSet;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class NumberTextField extends JTextField {
	private static final long serialVersionUID = 1L;

	public NumberTextField(int cols) {
		super(cols);
	}

	protected Document createDefaultModel() {
		return new NumberTextDocument();
	}

	static class NumberTextDocument extends PlainDocument {
		private static final long serialVersionUID = 1L;

		public void insertString(int offs, String str, AttributeSet a)throws BadLocationException {

			if (str == null) {
				return;
			}
			char[] upper = str.toCharArray();
			String nums = "";
			for (int i = 0; i < upper.length; i++) {
				try{
					Integer.parseInt(""+upper[i]);
					nums += upper[i];
				} catch(NumberFormatException ex){
					continue;
				}
			}
			super.insertString(offs, nums, a);
		}
	}
}
