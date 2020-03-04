package com.ds.smi;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ds.smi.model.Categoria;
import com.ds.smi.model.Estoque;
import com.ds.smi.model.Fornecedor;
import com.ds.smi.model.Funcionario;
import com.ds.smi.model.Lote;
import com.ds.smi.model.Produto;
import com.ds.smi.model.SetorFuncionario;
import com.ds.smi.model.Usuario;
import com.ds.smi.model.enums.EstoqueStatus;
import com.ds.smi.repositories.CategoriaRepository;
import com.ds.smi.repositories.EstoqueRepository;
import com.ds.smi.repositories.FornecedorRepository;
import com.ds.smi.repositories.FuncionarioRepository;
import com.ds.smi.repositories.LoteRepository;
import com.ds.smi.repositories.ProdutoRepository;
import com.ds.smi.repositories.SetorRepository;
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
	private SetorRepository setorRepo;
	
	@Autowired
	private FuncionarioRepository funcRepo;

	public static void main(String[] args) {
		SpringApplication.run(SmiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(1, "pereciveis");
		Categoria cat2 = new Categoria(2, "enlatados");
		Categoria cat3 = new Categoria(3, "panificados");
		
		Produto prod1 = new Produto(1, "produto 1", "marca 1", "descrição 1", cat1, 17.99);
		Produto prod2 = new Produto(2, "produto 2", "marca 2", "descrição 2", cat2, 15.99);
		
		Fornecedor forn1 = new Fornecedor(1, "nome 1", "cnpj 1");
		
		prod1.getFornecedores().addAll(Arrays.asList(forn1));
		prod2.getFornecedores().addAll(Arrays.asList(forn1));
		forn1.getProdutos().addAll(Arrays.asList(prod1, prod2));
		
		catRepo.saveAll(Arrays.asList(cat1, cat2, cat3));
		prodRepo.saveAll(Arrays.asList(prod1, prod2));
		fornRepo.saveAll(Arrays.asList(forn1));
		
		Date date1 = new Date();
		
		Lote lote1 = new Lote(1, forn1, 19.99, date1, date1);
		
		loteRepo.save(lote1);
		
		Estoque estoque1 = new Estoque(1, prod1, lote1, EstoqueStatus.EM_ESTOQUE, null);
		
		estoqueRepo.save(estoque1);
		
		Usuario user1 = new Usuario(1, "renan@test.com", "1234");
		Usuario user2 = new Usuario(2, "paulo@test.com", "2341");
		Usuario user3 = new Usuario(3, "manu@test.com", "3412");
		
		userRepo.saveAll(Arrays.asList(user1, user2, user3));
		
		SetorFuncionario setor1 = new SetorFuncionario(1, "Estoque");
		SetorFuncionario setor2 = new SetorFuncionario(2, "Administração");
		SetorFuncionario setor3 = new SetorFuncionario(3, "Logistica");
		SetorFuncionario setor4 = new SetorFuncionario(4, "Açougue");
		SetorFuncionario setor5 = new SetorFuncionario(5, "Padaria");
		
		setorRepo.saveAll(Arrays.asList(setor1, setor2, setor3, setor4, setor5));
		
		Funcionario func1 = new Funcionario(1, "Renan", "Luis Bianchini", user1, setor1);
		Funcionario func2 = new Funcionario(2, "Manu", "Vegas", user3, setor2);
		Funcionario func3 = new Funcionario(3, "Paulo", "Rivera", user2, setor4);
		
		funcRepo.saveAll(Arrays.asList(func1, func2, func3));
		
		
		
	}

}
