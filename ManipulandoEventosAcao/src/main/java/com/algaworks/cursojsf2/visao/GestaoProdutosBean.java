package com.algaworks.cursojsf2.visao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.algaworks.cursojsf2.dominio.Produto;

@ManagedBean
@SessionScoped
public class GestaoProdutosBean {

	private List<Produto> produtos;
	private Produto produto;
	
	private Produto produtoSelecionado;
	
	public GestaoProdutosBean() {
		this.produtos = new ArrayList<Produto>();
		this.produto = new Produto();
	}
	
	public String obterAjuda() {
		
		if (this.produtos.isEmpty()) {
			
			return "AjudaGestaoProdutos?faces-redirect=true";
		} else {
			return "AjudaGestaoProdutosTelefone?faces-redirect=true";

		}
		
	}
	
	public void verificarInclusao(ActionEvent event) {
		System.out.println("Verificando...");
		if ("".equals(this.produto.getNome()) ){
			this.produto.setNome("Sem nome");
		}
		
		if ("".equals(this.produto.getFabricante())){
			this.produto.setFabricante("Sem fabricante");
		}

		if ("".equals(this.produto.getCategoria())){
			this.produto.setCategoria("Sem fabricante");
		}
	}

	public void incluir() {
		System.out.println("incluindo...");
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}
	
	public void excluir() {
		this.produtos.remove(this.produtoSelecionado);
	}
	
	
	
	@PostConstruct
	public void inicializar() {
		System.out.println("Inicializou Bean");
	}

	@PreDestroy
	public void finalizar() {
		System.out.println("Finalizou Bean");
	}
	
	
	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	
}
