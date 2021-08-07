package br.com.fiap.tdss.view;

import javax.swing.JOptionPane;

import br.com.fiap.tdss.bean.Produto;

public class Ex01 {
	
	public static void main(String[] args) {
		
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de produtos: "));
		
		
		Produto[] vetor = new Produto[n];
		
		for(int i = 0; i<vetor.length; i++) {
			
			String nome = JOptionPane.showInputDialog("Digite o nome do produto: ");
			int qtd = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto: "));
			float preco = Float.parseFloat(JOptionPane.showInputDialog("Digite o preco do produto: "));
			float desconto = Float.parseFloat(JOptionPane.showInputDialog("Digite o desconto do produto: "));
			
			vetor[i] = new Produto(nome, qtd, preco, desconto); 

			
		}
		
		float valorTotal =0;
		
		for(Produto churros: vetor) {
			valorTotal = valorTotal + churros.getQuantidade()*(churros.getPreco() - churros.getDesconto()) ;
			System.out.println("Nome: " + churros.getNome() + "\nQuantidade: " + churros.getQuantidade() + "\nPreço: " + churros.getPreco() + "\nDesconto: " + churros.getDesconto());
			
			
			
			
			
		}
		
		System.out.println("O valor total é: " + valorTotal);
		
		
		
		
	}
}