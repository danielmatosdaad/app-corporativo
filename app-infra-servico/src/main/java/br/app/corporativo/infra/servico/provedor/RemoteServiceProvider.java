package br.app.corporativo.infra.servico.provedor;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.app.corporativo.integracao.interfaces.IServicoAssinaturaRemote;
import br.app.corporativo.integracao.interfaces.IServicoContaRemote;
import br.app.corporativo.integracao.interfaces.IServicoContratoRemote;
import br.app.corporativo.integracao.interfaces.IServicoParametroRemote;
import br.app.corporativo.integracao.interfaces.IServicoUsuarioRemote;
import br.app.corporativo.integracao.interfaces.IServicoUsuarioSenhaRemote;

@ApplicationScoped
@Named
public class RemoteServiceProvider implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(lookup = "java:global/app-corporativo/app-corporativo-pmt/ParametroServiceImp!br.app.corporativo.integracao.IServicoParametroRemote", beanName = "ParametroServiceImp", beanInterface = IServicoParametroRemote.class)
	private IServicoParametroRemote parametroService;

	@EJB(lookup = "java:global/app-corporativo/app-corporativo-cta/AssinaturaServiceImp!br.app.corporativo.integracao.IServicoAssinaturaRemote", beanName = "AssinaturaServiceImp", beanInterface = IServicoAssinaturaRemote.class)
	private IServicoAssinaturaRemote assinaturaService;

	@EJB(lookup = "java:global/app-corporativo/app-corporativo-cta/ContaServiceImp!br.app.corporativo.integracao.IServicoContaRemote", beanName = "ContaServiceImp", beanInterface = IServicoContaRemote.class)
	private IServicoContaRemote contaService;

	@EJB(lookup = "java:global/app-corporativo/app-corporativo-cta/ContratoServiceImp!br.app.corporativo.integracao.IServicoContratoRemote", beanName = "ContratoServiceImp", beanInterface = IServicoContratoRemote.class)
	private IServicoContratoRemote contratoService;

	@EJB(lookup = "java:global/app-corporativo/app-corporativo-usr/SenhaServiceImp!br.app.corporativo.integracao.IServicoUsuarioSenhaRemote", beanName = "SenhaServiceImp", beanInterface = IServicoUsuarioSenhaRemote.class)
	private IServicoUsuarioSenhaRemote senhaService;

	@EJB(lookup = "java:global/app-corporativo/app-corporativo-usr/UsuarioServiceImp!br.app.corporativo.integracao.IServicoUsuarioRemote", beanName = "UsuarioServiceImp", beanInterface = IServicoUsuarioRemote.class)
	private IServicoUsuarioRemote usuarioService;

	
	@Default
	@Produces
	public IServicoParametroRemote getParametroService() {
		System.out.println("Injetando Servico parametroService");
		return parametroService;
	}

	@Default
	@Produces
	public IServicoAssinaturaRemote getAssinaturaService() {
		return assinaturaService;
	}

	@Default
	@Produces
	public IServicoContaRemote getContaService() {
		return contaService;
	}

	@Default
	@Produces
	public IServicoContratoRemote getContratoService() {
		return contratoService;
	}



	@Default
	@Produces
	public IServicoUsuarioSenhaRemote getSenhaService() {
		return senhaService;
	}

	@Default
	@Produces
	public IServicoUsuarioRemote getUsuarioService() {
		return usuarioService;
	}
	
	

	/**
	 * Carrega instância da service passada como parâmetro do contexto
	 * 
	 * @param clazz
	 * @return
	 */
	private static Object carregaService(Class clazz) {
		Object service = null;
		BeanManager beanManager = getBeanManager();
		try {
			for (Bean<?> bean : beanManager.getBeans(clazz)) {
				try {
					CreationalContext contexto = beanManager.createCreationalContext(bean);
					service = bean.create(contexto);
					break;
				} catch (Exception e) {
				}
			}
		} catch (Exception e) {
		}

		return service;
	}

	/**
	 * @return
	 */
	public static final BeanManager getBeanManager() {
		try {
			InitialContext initialContext = new InitialContext();
			return (BeanManager) initialContext.lookup("java:comp/BeanManager");
		} catch (NamingException e) {
			return null;
		}
	}
}
