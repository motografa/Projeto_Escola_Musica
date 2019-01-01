package escola.musica.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import escola.musica.dao.GenericDAO;
import escola.musica.modelo.Aluno;
import escola.musica.modelo.Cidade;
import escola.musica.modelo.Estado;
import escola.musica.servico.AlunoServico;
import escola.musica.servico.CidadeServico;

@Controller("alunoBean")
@Scope("session")
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = -1919440022785814835L;
	
	private Aluno aluno;
	private List<Aluno> alunos;
	private List<Estado> estados;
//	private Integer idCidade;
//	private UploadedFile file;
	@Autowired private AlunoServico alunoServico;
	
	@Autowired private CidadeServico cidadeServico;
	
	public String getDataAtual() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -6);
		return new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime());
	}
	
	public List<Cidade> getCidadesDoEstado(){
		return cidadeServico.obterCidadesDoEstado(aluno.getEndereco().getCidade().getEstado());
//		return CidadeDAO.obterCidadesDoEstado(aluno.getEndereco().getCidade().getEstado());
	}
	
	public void iniciarBean() {
		alunos = alunoServico.listarTodos();
		setEstados(Arrays.asList(Estado.values()));
	}

	public void voltar() {
		this.aluno = null;
	}
	
	public void novoAluno() {
		aluno = new Aluno();
	}

	public void salvar() {
//		aluno.getEndereco().setCidade(new GenericDAO<Cidade>(Cidade.class).obterPorId(idCidade));
		alunoServico.salvar(aluno);

		FacesContext.getCurrentInstance().addMessage(null, //
				new FacesMessage("Aluno cadastrado com sucesso!"));
		alunos = alunoServico.listarTodos();
		aluno = null;
	}

	public void editar(Aluno aluno) {
		this.aluno = aluno;
//		idCidade = aluno.getEndereco().getCidade().getId();
//		if (aluno.getEndereco().getCidade() == null) {
//			aluno.getEndereco().setCidade(new Cidade());
//		}
	}
	
	public void enviarFoto(FileUploadEvent event) {
		//https://stackoverflow.com/questions/20492015/primefaces-fileupload-with-prettyfaces-and-jsf-2-2-3/20617462#20617462
		try {
//			this.file = event.getFile();
			byte[] foto = IOUtils.toByteArray(event.getFile().getInputstream());
			aluno.setFoto(foto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public StreamedContent getImagemAluno() {
		Map<String, String> mapaParametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String idAluno = mapaParametros.get("id_aluno");
		
		if (idAluno != null) {
			Aluno alunoBanco = new GenericDAO<Aluno>(Aluno.class).obterPorId(new Integer(idAluno));
			return alunoBanco.getImagem();
		}
		return new DefaultStreamedContent();
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

//	public UploadedFile getFile() {
//		return file;
//	}
//
//	public void setFile(UploadedFile file) {
//		this.file = file;
//	}
//	
//	public Integer getIdCidade() {
//		return idCidade;
//	}
//
//	public void setIdCidade(Integer idCidade) {
//		this.idCidade = idCidade;
//	}

}
