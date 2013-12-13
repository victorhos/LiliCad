// DefPoly.java: Drawing a polygon.

// Copied from Section 1.5 of
// Ammeraal, L. and K. Zhang (2007). Computer Graphics for Java Programmers, 2nd Edition,
// Chichester: John Wiley.

import java.awt.*;

import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class DefPoly extends Frame {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	//Rotação
	Checkbox checkRotacao = new Checkbox("Rotação", false);
	CheckboxGroup checkSentidoHorarioAnti = new CheckboxGroup();
	TextField textGrau = new TextField();
	
	//Translação
	Checkbox checkTranslacao = new Checkbox("Translação", false);
	TextField textX = new TextField();
	TextField textY = new TextField();

	//Cisalhamento
	Checkbox checkCisalhamento = new Checkbox("Cisalhamento", false);
	TextField textXCi = new TextField();
	TextField textYCi = new TextField();

	//Escalonamento
	Checkbox checkEscalonamento = new Checkbox("Escalonamento", false);
	TextField textXEs = new TextField();
	TextField textYEs = new TextField();
	
	//Espelhamento
	Checkbox checkEspelhamento = new Checkbox("Espelhamento", false);
	CheckboxGroup checkGroupEspelhamento = new CheckboxGroup();
	
	
	public static void main(String[] args) {
		new DefPoly();
	}

	@SuppressWarnings("deprecation")
	DefPoly() {
		super("LiliCad");

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		CvDefPoly cvDefPolyObj = new CvDefPoly();
		ActionListener action = new MyActionListener();
		((MyActionListener) action).setCvDefPoly(cvDefPolyObj);

		Panel panelButtons = new Panel(new GridLayout(4, 2));
		panelButtons.setBackground(new Color(216, 216, 191));

		/* Box Rotação */

		Panel boxRotacao = new Panel(new FlowLayout(0, 20, 10));
		Panel panelRotacao = new Panel(new GridLayout(4, 1));
		Panel panelCheckboxGroup = new Panel(new GridLayout(1, 2));

		Label labelRotacao = new Label("___________Rotação___________");

		panelCheckboxGroup.add(new Checkbox("Horário", checkSentidoHorarioAnti, true));
		panelCheckboxGroup.add(new Checkbox("Anti-Horário", checkSentidoHorarioAnti, false));

		panelRotacao.add(labelRotacao);
		panelRotacao.add(checkRotacao);
		panelRotacao.add(panelCheckboxGroup);
		panelRotacao.add(textGrau);

		boxRotacao.add(panelRotacao);
		panelButtons.add(boxRotacao);

		/* Box Translação */

		Panel boxTranslacao = new Panel(new FlowLayout(0, 20, 10));
		Panel panelTranslacao = new Panel(new GridLayout(3, 1));
		Panel panelTextXY = new Panel(new GridLayout(2, 2));

		Label labelTranslacao = new Label("___________Translação___________");

		panelTextXY.add(new Label("X: "));
		panelTextXY.add(textX);
		panelTextXY.add(new Label("Y: "));
		panelTextXY.add(textY);

		panelTranslacao.add(labelTranslacao);
		panelTranslacao.add(checkTranslacao);
		panelTranslacao.add(panelTextXY);

		boxTranslacao.add(panelTranslacao);
		panelButtons.add(boxTranslacao);

		/* Box Cisalhamento */

		Panel boxCisalhamento = new Panel(new FlowLayout(0, 20, 10));
		Panel panelCisalhamento = new Panel(new GridLayout(3, 1));
		Panel panelTextXYCi = new Panel(new GridLayout(2, 2));

		Label labelCisalhamento = new Label("__________Cisalhamento__________");

		panelTextXYCi.add(new Label("X: "));
		panelTextXYCi.add(textXCi);
		panelTextXYCi.add(new Label("Y: "));
		panelTextXYCi.add(textYCi);

		panelCisalhamento.add(labelCisalhamento);
		panelCisalhamento.add(checkCisalhamento);
		panelCisalhamento.add(panelTextXYCi);

		boxCisalhamento.add(panelCisalhamento);
		panelButtons.add(boxCisalhamento);

		/* Box Escalonamento */

		Panel boxEscalonamento = new Panel(new FlowLayout(0, 10, 10));
		Panel panelEscalonamento = new Panel(new GridLayout(3, 1));
		Panel panelTextXYEs = new Panel(new GridLayout(2, 2));

		Label labelEscalonamento = new Label("___________Escalonamento___________");

		panelTextXYEs.add(new Label("X: "));
		panelTextXYEs.add(textXEs);
		panelTextXYEs.add(new Label("Y: "));
		panelTextXYEs.add(textYEs);

		panelEscalonamento.add(labelEscalonamento);
		panelEscalonamento.add(checkEscalonamento);
		panelEscalonamento.add(panelTextXYEs);

		boxEscalonamento.add(panelEscalonamento);
		panelButtons.add(boxEscalonamento);

		/* Box Espelhamento */

		Panel boxEspelhamento = new Panel(new FlowLayout(0, 20, 10));
		Panel panelEspelhamento = new Panel(new GridLayout(3, 1));
		Panel panelCheckboxGroupEsp = new Panel(new GridLayout(1, 2));

		Label labelEspelhamento = new Label("___________Espelhamento___________");

		panelCheckboxGroupEsp.add(new Checkbox("X", checkGroupEspelhamento, true));
		panelCheckboxGroupEsp.add(new Checkbox("Y", checkGroupEspelhamento, false));

		panelEspelhamento.add(labelEspelhamento);
		panelEspelhamento.add(checkEspelhamento);
		panelEspelhamento.add(panelCheckboxGroupEsp);

		boxEspelhamento.add(panelEspelhamento);
		panelButtons.add(boxEspelhamento);

		/* Botão transformar */

		Panel boxButtonTransformar = new Panel(new GridLayout(2, 1));
		boxButtonTransformar.setBackground(new Color(0, 0, 0));
		Button buttonTransformar = new Button("Transformar");
		buttonTransformar.setBackground(new Color(254, 254, 254));
		boxButtonTransformar.add(new Label(""));
		boxButtonTransformar.add(buttonTransformar);
		panelButtons.add(boxButtonTransformar);

		/* Ação botão */
		buttonTransformar.addActionListener(action);

		add("Center", cvDefPolyObj);
		add(panelButtons, BorderLayout.WEST);

		setSize(1340, 650);
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		show();
	}

	public Checkbox getCheckRotacao() {
		return checkRotacao;
	}

	public void setCheckRotacao(Checkbox checkRotacao) {
		this.checkRotacao = checkRotacao;
	}

	public CheckboxGroup getCheckSentidoHorarioAnti() {
		return checkSentidoHorarioAnti;
	}

	public void setCheckSentidoHorarioAnti(CheckboxGroup checkSentidoHorarioAnti) {
		this.checkSentidoHorarioAnti = checkSentidoHorarioAnti;
	}

	public TextField getTextGrau() {
		return textGrau;
	}

	public void setTextGrau(TextField textGrau) {
		this.textGrau = textGrau;
	}

	public Checkbox getCheckTranslacao() {
		return checkTranslacao;
	}

	public void setCheckTranslacao(Checkbox checkTranslacao) {
		this.checkTranslacao = checkTranslacao;
	}

	public TextField getTextX() {
		return textX;
	}

	public void setTextX(TextField textX) {
		this.textX = textX;
	}

	public TextField getTextY() {
		return textY;
	}

	public void setTextY(TextField textY) {
		this.textY = textY;
	}

	public Checkbox getCheckCisalhamento() {
		return checkCisalhamento;
	}

	public void setCheckCisalhamento(Checkbox checkCisalhamento) {
		this.checkCisalhamento = checkCisalhamento;
	}

	public TextField getTextXCi() {
		return textXCi;
	}

	public void setTextXCi(TextField textXCi) {
		this.textXCi = textXCi;
	}

	public TextField getTextYCi() {
		return textYCi;
	}

	public void setTextYCi(TextField textYCi) {
		this.textYCi = textYCi;
	}

	public Checkbox getCheckEscalonamento() {
		return checkEscalonamento;
	}

	public void setCheckEscalonamento(Checkbox checkEscalonamento) {
		this.checkEscalonamento = checkEscalonamento;
	}

	public TextField getTextXEs() {
		return textXEs;
	}

	public void setTextXEs(TextField textXEs) {
		this.textXEs = textXEs;
	}

	public TextField getTextYEs() {
		return textYEs;
	}

	public void setTextYEs(TextField textYEs) {
		this.textYEs = textYEs;
	}

	public Checkbox getCheckEspelhamento() {
		return checkEspelhamento;
	}

	public void setCheckEspelhamento(Checkbox checkEspelhamento) {
		this.checkEspelhamento = checkEspelhamento;
	}

	public CheckboxGroup getCheckGroupEspelhamento() {
		return checkGroupEspelhamento;
	}

	public void setCheckGroupEspelhamento(CheckboxGroup checkGroupEspelhamento) {
		this.checkGroupEspelhamento = checkGroupEspelhamento;
	}

}
//-----------------------------------trata as acoes-------------------------------------
class MyActionListener implements ActionListener {
	
	//Matriz de dados para armazenar os pontos
		public static double matPontos[][];
		
		public static double[][] getMatPontos(){
			return matPontos;
		}
	CvDefPoly pontos = new CvDefPoly();
	public static int mat;
	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();

		if (s.equals("Exit")) {

			System.exit(0);

		} else if (s.equals("Transformar")) {

			double novaMat[][] = new double[3][pontos.getVetorDeMatriz().size()];//declarando matriz Double

			for (int x = 0; x < pontos.getVetorDeMatriz().size() ; x++){
				 
				 double[][] arrayPonto = pontos.getVetorDeMatriz().get(x);
				 
				 //----convertendo de Float para double-------------
				 
				 
				 novaMat[0][x]= arrayPonto[0][0];
				 novaMat[1][x]= arrayPonto[0][1];
				 novaMat[2][x]= 1;

			}

			DecimalFormat format_ = new DecimalFormat("0.000");

			JOptionPane.showMessageDialog(null, "Matriz de entrada");
			Calculos.exibeMatriz(novaMat);	

			JOptionPane.showMessageDialog(null, "Escala");	
			int valor = Integer.parseInt(JOptionPane.showInputDialog("Valor de escala: "));
			Calculos.exibeMatriz(Operacoes.escala( valor,  novaMat));	

			JOptionPane.showMessageDialog(null, "Espelhamento");
			JOptionPane.showMessageDialog(null, "Espelhamento em X: ");
			Calculos.exibeMatriz(Operacoes.espelhamento(true, false, novaMat));

			JOptionPane.showMessageDialog(null, "Espelhamento em Y: ");
			Calculos.exibeMatriz(Operacoes.espelhamento(false, true, novaMat));

			JOptionPane.showMessageDialog(null, "Espelhamento em X e Y: ");
			Calculos.exibeMatriz(Operacoes.espelhamento(true, true, novaMat));

			//TRANSLAÇÃO - ***IMPORTANTE - NA CHAMADA DESSE MÉTODO CASO NÃO HAJA TRANSLÇÃO EM UM DOS PONTOS (X OU Y) PASSAR 0
			JOptionPane.showMessageDialog(null, "Translação");

			valor = Integer.parseInt(JOptionPane.showInputDialog("Valor da translação em X: ")); 
			Calculos.exibeMatriz(Operacoes.translacao(valor, 0, novaMat));

			valor = Integer.parseInt(JOptionPane.showInputDialog("Valor da translação em Y: "));
			Calculos.exibeMatriz(Operacoes.translacao(0, valor, novaMat));

			valor = Integer.parseInt(JOptionPane.showInputDialog("Valor da translação em X: "));
			int valor_ = Integer.parseInt(JOptionPane.showInputDialog("Valor da translação em Y: "));
			Calculos.exibeMatriz(Operacoes.translacao(valor, valor_, novaMat));

			JOptionPane.showMessageDialog(null, "Cisalhamento");
			//CISALHAMENTO - ***IMPORTANTE - NA CHAMADA DESSE MÉTODO, CASO NÃO HAJA CISALHAMENTO EM UM DOS PONTOS (X OU Y) PASSAR O ANGULO DESTE COMO ???
			JOptionPane.showMessageDialog(null, "Cisalhamento em X");
			valor = Integer.parseInt(JOptionPane.showInputDialog("Angulo: "));
			Calculos.exibeMatriz(Operacoes.cisalhamento(valor, 0, true, false, novaMat));

			JOptionPane.showMessageDialog(null, "Cisalhamento em Y");
			valor = Integer.parseInt(JOptionPane.showInputDialog("Angulo: "));
			Calculos.exibeMatriz(Operacoes.cisalhamento(0, valor, false, true, novaMat));

			JOptionPane.showMessageDialog(null, "Cisalhamento em X e Y");
			valor = Integer.parseInt(JOptionPane.showInputDialog("Angulo: "));
			Calculos.exibeMatriz(Operacoes.cisalhamento(valor, valor, true, true, novaMat));

			JOptionPane.showMessageDialog(null, "Rotação");
			valor = Integer.parseInt(JOptionPane.showInputDialog("Angulo rotação: "));
			Calculos.exibeMatriz(Operacoes.rotacao(valor, novaMat));
		} else {

			System.out.println(s + " clicked");

		}
	}

	public void setCvDefPoly(CvDefPoly cvDefPolyObj) {
		this.pontos = cvDefPolyObj;
	}

	public CvDefPoly getCvDefPoly() {
		return this.pontos;
	}
}
