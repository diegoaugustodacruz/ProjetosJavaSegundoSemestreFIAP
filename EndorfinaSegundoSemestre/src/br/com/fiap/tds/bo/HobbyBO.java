package br.com.fiap.tds.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.tds.bean.Hobby;
import br.com.fiap.tds.bean.Usuario;
import br.com.fiap.tds.dao.HobbyDAO;
import br.com.fiap.tds.exception.DadosInvalidosException;
import br.com.fiap.tds.exception.IdNotFoundException;

/**
 * Classe que contem as regras de negocios e validacoes do hobby
 * @author Endorfina
 *
 */
public class HobbyBO {
	
	private HobbyDAO dao;
	
	/**
	 * Construtor que recebe a conexao
	 * @param conexao
	 */
	public HobbyBO(Connection conexao) {
		dao = new HobbyDAO(conexao);
	}

	public void cadastrar(Hobby hobby) throws SQLException, DadosInvalidosException{
		validar(hobby);
		dao.cadastrarHobby(hobby);
	}
	
	public List<Hobby> buscarPorNome(String nome) throws SQLException{
		return dao.buscarPorNome(nome);
	}
	
	public void atualizar(Hobby hobby) throws SQLException, IdNotFoundException{
		dao.atualizar(hobby);
	}
	
	public Hobby pesquisar(int codigo) throws SQLException, IdNotFoundException{
		return dao.pesquisar(codigo);
	}
	
	public List<Hobby> listar() throws SQLException{
		return dao.listar();
	}
	
	public void remover(int codigo) throws SQLException, IdNotFoundException{
		dao.remover(codigo);
	}
	
	public void validar(Hobby hobby) throws SQLException, DadosInvalidosException{
		if(hobby.getNomeHobby()==null || hobby.getNomeHobby().length()>40) {
			throw new DadosInvalidosException("Nome é obrigatorio e deve conter menos de 40 caracteres");
		}
	}
}
