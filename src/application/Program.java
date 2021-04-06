package application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de funcionarios que serão cadastrados"));//numero de cadastros que serão feitos
		List<Funcionario> list = new ArrayList<>();//Foi criado um Array list de Funcionarios

		for (int i = 0; i < n; i++) {//foi criado um for que vai repetir o numero de vezes que seram feito cadastros 

			int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do funcionario: "));
			String name = JOptionPane.showInputDialog("Digite o nome do funcionario: ");
			double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salario do funcionario: "));
			list.add(new Funcionario(id, name, salario));//esta sendo passado os dados pela lista 

		}

		for (Funcionario f : list) {//Foi criado um forEach com os funcionarios cadastrados assim, ele ira mostrar todos os  dados na tela percorrendo o array
			System.out.println(f);
			System.out.println("================================");
		}

		int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do funcionario que recebera aumento salrial"));
		Funcionario fun = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);//Foi criado uma expressão lambid a qu e ira fazer uma pesquisa apartir do id, sendo encontrado ele ira trazer os dados se não enviara  null

		if (fun == null) {//vai verificar se a variavel 'fun' tem algum valor armazenado 
			System.out.println("Funcionario inesistente ");
		} else {
			double porCentagem = Double.parseDouble(JOptionPane.showInputDialog("Digite a porcentagem de aumento salarial: "));
			fun.aumentoSalarial(porCentagem);
			System.out.println(fun);
		}

	}

}
