package br.com.caelum.livraria.service;

import static java.time.LocalDate.now;

import java.util.HashSet;
import java.util.Set;

import br.com.caelum.livraria.dominio.*;
import org.javamoney.moneta.Money;

public class SelecaoDeLivro {
	
	private final TodosLivros todosLivros;
	private final CalculadoraFrete calculadoraFrete;
//	private final Set<CarrinhoDeCompras> carrinhos;
	private final CarrinhoDeComprasFactory carrinhoFactory;

	
	
	public SelecaoDeLivro(TodosLivros todosLivros, CalculadoraFrete calculadoraFrete) {
		this.todosLivros = todosLivros;
		this.calculadoraFrete = calculadoraFrete;
//		this.carrinhos = new HashSet<>();
		this.carrinhoFactory = new CarrinhoDeComprasFactory();
	}

	public CarrinhoDeCompras adicionarLivroNoCarrinhoDoCliente(ISBN isbn, Cliente cliente) {
		Livro livro = todosLivros.por(isbn);
		Money valorFrete = calculadoraFrete.baseadoEm(cliente.getCep());

		CarrinhoDeCompras carrinho = carrinhoFactory.obterCarrinho(cliente, livro, valorFrete);
		return carrinho;
	}


//	private CarrinhoDeCompras obterCarrinho(Cliente cliente, Livro livro, Money valorFrete) {
//		CarrinhoDeCompras carrinho = new CarrinhoDeCompras(cliente, livro, valorFrete, now());
//		if(carrinhos.contains(carrinho)) {
//			carrinho = carrinhos.stream()
//					.filter(umCarrinho -> umCarrinho.doCliente(cliente))
//					.findFirst().orElse(null);
//			if(carrinho != null)carrinho.getLivros().adicionar(livro);
//		}
//		else carrinhos.add(carrinho);
//		return carrinho;
//	}
}
