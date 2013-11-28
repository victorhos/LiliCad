// DefPoly.java: Drawing a polygon.

// Copied from Section 1.5 of
//    Ammeraal, L. and K. Zhang (2007). Computer Graphics for Java Programmers, 2nd Edition,
//       Chichester: John Wiley.

// Uses: CvDefPoly (discussed below).
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DefPoly extends Frame {

	public static void main(String[] args) {
		new DefPoly();
	}

	DefPoly() {
		super("LiliCad");

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		CvDefPoly cvDefPolyObj = new CvDefPoly();
		ActionListener action = new MyActionListener();
		
		
		Panel panelButtons = new Panel(new GridLayout(6, 1));
		panelButtons.setBackground(new Color(216, 216, 191));
		
		/* Box Rotação */

		Panel boxRotacao = new Panel(new FlowLayout(0, 20, 10));
		Panel panelRotacao = new Panel(new GridLayout(4, 1));
		Panel panelCheckboxGroup = new Panel(new GridLayout(1, 2));
		
		Label labelRotacao = new Label ("___________Rotação___________");
		Checkbox checkRotacao = new Checkbox ("Rotação", false);
		CheckboxGroup checkSentidoHorarioAnti = new CheckboxGroup();
		TextField textGrau = new TextField();  
		
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
		Panel panelTranslacao = new Panel(new GridLayout(6, 1));
		Panel panelTextXY = new Panel(new GridLayout(2, 2));
		
		Label labelTranslacao = new Label ("___________Translação___________");
		Checkbox checkTranslacao = new Checkbox ("Translação", false);
		TextField textX = new TextField();
		TextField textY = new TextField();
		
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
		Panel panelCisalhamento = new Panel(new GridLayout(6, 1));
		Panel panelTextXYCi = new Panel(new GridLayout(2, 2));
		
		Label labelCisalhamento = new Label ("__________Cisalhamento__________");
		Checkbox checkCisalhamento = new Checkbox ("Cisalhamento", false);
		TextField textXCi = new TextField();
		TextField textYCi = new TextField();
		
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
		Panel panelEscalonamento = new Panel(new GridLayout(6, 1));
		Panel panelTextXYEs = new Panel(new GridLayout(2, 2));
		
		Label labelEscalonamento = new Label ("___________Escalonamento___________");
		Checkbox checkEscalonamento = new Checkbox ("Escalonamento", false);
		TextField textXEs = new TextField();
		TextField textYEs = new TextField();
		
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
		Panel panelEspelhamento = new Panel(new GridLayout(4, 1));
		Panel panelCheckboxGroupEsp = new Panel(new GridLayout(1, 2));
		
		Label labelEspelhamento = new Label ("___________Espelhamento___________");
		Checkbox checkEspelhamento = new Checkbox ("Espelhamento", false);
		CheckboxGroup checkGroupEspelhamento = new CheckboxGroup();  
		
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
		buttonTransformar.setBackground(new Color(254,254,254));
		boxButtonTransformar.add(new Label(""));
		boxButtonTransformar.add(buttonTransformar);
		panelButtons.add(boxButtonTransformar);

		/* Ação botão */
		buttonTransformar.addActionListener(action);
		
		/*
		Checkbox checkTranslacao = new Checkbox ("Translação", false);
		Checkbox checkCisalhamento = new Checkbox ("Cisalhamento", false);
		Checkbox checkEscalonamento = new Checkbox ("Escalonamento", false);
		Checkbox checkEspelhamento = new Checkbox ("Espelhamento", false);
		
		
		panelButtons.add(checkTranslacao);
		panelButtons.add(checkCisalhamento);
		panelButtons.add(checkEscalonamento);
		panelButtons.add(checkEspelhamento);
		*/
		
		/*
		 
		Button checkRotacao = new Button("Rotação");
		Button checkTranslacao = new Button("Translação");
		Button checkCisalhamento = new Button("Cisalhamento");
		Button checkEscalonamento = new Button("Escalonamento");
		Button checkEspelhamento = new Button("Espelhamento");

		Button botaoRotacao = new Button("Rotação");
		Button botaoTranslacao = new Button("Translação");
		Button botaoCisalhamento = new Button("Cisalhamento");
		Button botaoEscalonamento = new Button("Escalonamento");
		Button botaoEspelhamento = new Button("Espelhamento");


		add(BorderLayout.WEST, botaoRotacao);
		add(BorderLayout.WEST, botaoTranslacao);
		add(BorderLayout.WEST, botaoCisalhamento);
		add(BorderLayout.WEST, botaoEscalonamento);
		add(BorderLayout.EAST, botaoEspelhamento);

		botaoRotacao.addActionListener(action);
		botaoTranslacao.addActionListener(action);
		botaoCisalhamento.addActionListener(action);
		botaoEscalonamento.addActionListener(action);
		botaoEspelhamento.addActionListener(action);
		*/
		
		add("Center", cvDefPolyObj);
		add(panelButtons, BorderLayout.WEST);

		setSize(1040, 650);
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		show();
	}

}

class MyActionListener implements ActionListener {
	
	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();
	
		if (s.equals("Exit")) {
		
			System.exit(0);
		
		} else if (s.equals("Transformar")) {
		
			System.out.println("AQUI!!!!");
			cvDefPolyObj
		
		} else {
			
			System.out.println(s + " clicked");
		
		}
	}
	
	public void setCvDefPoly(CvDefPoly cvDefPolyObj){
		return 
	}
}
