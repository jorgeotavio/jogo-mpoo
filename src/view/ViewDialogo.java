package view;

import java.awt.Font;

import javax.swing.JLabel;

public class ViewDialogo extends AbstractView{

	private JLabel mensagemLabel;
	private JLabel fecharLabel;
	private JLabel tentarNovamente;
	
	public ViewDialogo() {
		setSize(300, 300);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		
		fecharLabel = new JLabel("X - ESC");
		fecharLabel.setBounds(240, 10, 50, 20);
		
		tentarNovamente = new JLabel("Tentar novamente!");
		tentarNovamente.setBounds(100, 250, 150, 20);
		
		mensagemLabel = new JLabel();
		mensagemLabel.setFont(new Font("Impact", Font.TRUETYPE_FONT, 20));
		mensagemLabel.setBounds(90, 120, 200,50);
		
		add(mensagemLabel);
		add(fecharLabel);
		add(tentarNovamente);
		
		setVisible(false);
	}

	public void setMensagem(String mensagem) {
		this.mensagemLabel.setText(mensagem);
	}

	public JLabel getFecharLabel() {
		return fecharLabel;
	}

	public void setFecharLabel(JLabel fecharLabel) {
		this.fecharLabel = fecharLabel;
	}

	public JLabel getTentarNovamente() {
		return tentarNovamente;
	}

	public void setTentarNovamente(JLabel tentarNovamente) {
		this.tentarNovamente = tentarNovamente;
	}
}
