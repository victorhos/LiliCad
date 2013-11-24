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

		Panel panelButtons = new Panel(new GridLayout(6, 1));
		panelButtons.setBackground(new Color(216, 216, 191));
		
		/* Box Rotação */

		Panel boxRotacao = new Panel(new FlowLayout(0, 20, 10));
		Panel panelRotacao = new Panel(new GridLayout(6, 1));
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
		Panel panelTranslacao = new Panel(new GridLayout(6, 6));
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

		ActionListener action = new MyActionListener();

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

		add("Center", new CvDefPoly());
		add(panelButtons, BorderLayout.WEST);

		setSize(1040, 600);
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		show();
	}

}

class MyActionListener implements ActionListener {
	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();
		if (s.equals("Exit")) {
			System.exit(0);
		} else if (s.equals("Rotação")) {
			System.out.println("Good Morning");
		} else {
			System.out.println(s + " clicked");
		}
	}
}
