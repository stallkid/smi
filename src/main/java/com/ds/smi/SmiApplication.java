package com.ds.smi;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ds.smi.model.Categoria;
import com.ds.smi.model.Fornecedor;
import com.ds.smi.model.Funcionario;
import com.ds.smi.model.Lote;
import com.ds.smi.model.Produto;
import com.ds.smi.model.SetorFuncionario;
import com.ds.smi.model.Usuario;
import com.ds.smi.repositories.CategoriaRepository;
import com.ds.smi.repositories.EstoqueRepository;
import com.ds.smi.repositories.FornecedorRepository;
import com.ds.smi.repositories.FuncionarioRepository;
import com.ds.smi.repositories.LoteRepository;
import com.ds.smi.repositories.ProdutoRepository;
import com.ds.smi.repositories.SetorFuncionarioRepository;
import com.ds.smi.repositories.UsuarioRepository;

@SpringBootApplication
public class SmiApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository catRepo;
	
	@Autowired
	private ProdutoRepository prodRepo;
	
	@Autowired
	private FornecedorRepository fornRepo;
	
	@Autowired
	private LoteRepository loteRepo;
	
	@Autowired
	private EstoqueRepository estoqueRepo;
	
	@Autowired
	private UsuarioRepository userRepo;
	
	@Autowired
	private SetorFuncionarioRepository setorRepo;
	
	@Autowired
	private FuncionarioRepository funcRepo;

	public static void main(String[] args) {
		SpringApplication.run(SmiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Date date1 = new Date();
		Categoria cat1 = new Categoria(null, "pereciveis");
		Categoria cat2 = new Categoria(null, "enlatados");
		Categoria cat3 = new Categoria(null, "panificados");
		
		Produto prod1 = new Produto(null, "produto 1", "marca 1", "descrição 1", 17.99);
		Produto prod2 = new Produto(null, "produto 2", "marca 2", "descrição 2", 15.99);
		
		Fornecedor forn1 = new Fornecedor(null, "nome 1", "cnpj 1");
		
		Lote lote1 = new Lote(null, date1, date1, 19.99, forn1);
		
		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2));
		cat2.getProdutos().addAll(Arrays.asList(prod1));
		cat3.getProdutos().addAll(Arrays.asList(prod2));
		
		prod1.getCategorias().addAll(Arrays.asList(cat1,cat2));
		prod2.getCategorias().addAll(Arrays.asList(cat1,cat3));
		
		prod1.getFornecedores().addAll(Arrays.asList(forn1));
		prod2.getFornecedores().addAll(Arrays.asList(forn1));
		
		forn1.getProdutos().addAll(Arrays.asList(prod1, prod2));
		forn1.getLotes().addAll(Arrays.asList(lote1));
		
		catRepo.saveAll(Arrays.asList(cat1, cat2, cat3));
		prodRepo.saveAll(Arrays.asList(prod1, prod2));
		fornRepo.saveAll(Arrays.asList(forn1));
		loteRepo.saveAll(Arrays.asList(lote1));
		
		Usuario user1 = new Usuario(null, "renan@test.com", "1234");
		Usuario user2 = new Usuario(null, "paulo@test.com", "2341");
		Usuario user3 = new Usuario(null, "manu@test.com", "3412");
		
		userRepo.saveAll(Arrays.asList(user1, user2, user3));
		
		SetorFuncionario setor1 = new SetorFuncionario(null, "Estoque");
		SetorFuncionario setor2 = new SetorFuncionario(null, "Administração");
		SetorFuncionario setor3 = new SetorFuncionario(null, "Logistica");
		SetorFuncionario setor4 = new SetorFuncionario(null, "Açougue");
		SetorFuncionario setor5 = new SetorFuncionario(null, "Padaria");
		
		setorRepo.saveAll(Arrays.asList(setor1, setor2, setor3, setor4, setor5));
		
		Funcionario func1 = new Funcionario(null, "Renan", "Luis Bianchini", user1, setor2);
		Funcionario func2 = new Funcionario(null, "Manu", "Vegas", user3, setor2);
		Funcionario func3 = new Funcionario(null, "Paulo", "Rivera", user2, setor5);

		funcRepo.saveAll(Arrays.asList(func1, func2, func3));
		
		
		
	}

}
