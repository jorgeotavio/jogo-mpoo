package view;

import javax.swing.JLabel;

public class ViewWin extends AbstractView {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel mensagem;
	
	public ViewWin() {
		setSize(300, 300);
		mensagem = new JLabel("Você venceu!");
		mensagem.setBounds(200, 200, 100, 100);
		add(mensagem);
		setVisible(true);
	}

}
