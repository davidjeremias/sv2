package br.gov.camara.ditec.adm.sivis.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.camara.ditec.adm.sivis.controller.servico.BaseServico;
import br.gov.camara.ditec.adm.sivis.exception.NegocioException;
import br.gov.camara.ditec.adm.sivis.service.AuthenticationService;
import br.gov.camara.ditec.adm.sivis.service.dto.LoginDTO;
import br.gov.camara.ditec.adm.sivis.service.dto.UsuarioDTO;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/login")
@Api(value = "API REST Login - Sivis-Backend")
public class AuthenticationController extends BaseServico{

	@Autowired
	private AuthenticationService service;
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> logon(@Valid @RequestBody LoginDTO loginDTO) throws NegocioException{
		UsuarioDTO retorno = service.logon(loginDTO);
		return retorno != null ? new ResponseEntity<UsuarioDTO>(retorno, HttpStatus.OK)
				: new ResponseEntity<UsuarioDTO>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/verificarUsuarioAgenteAutorizador")
	public ResponseEntity<UsuarioDTO> verificarUsuarioAgenteAutorizador(@Valid @RequestBody LoginDTO loginDTO) throws NegocioException{
		UsuarioDTO retorno = service.verificarUsuarioAgenteAutorizador(loginDTO);
		return retorno != null ? new ResponseEntity<UsuarioDTO>(retorno, HttpStatus.OK)
				: new ResponseEntity<UsuarioDTO>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/refreshToken")
	public ResponseEntity<AccessTokenResponse> getRefreshToken(ServletRequest request) throws NegocioException{
		HttpServletRequest req = (HttpServletRequest) request;
		String refreshToken = null;
		for(Cookie cookie: req.getCookies()) {
			if(cookie.getName().equals("refreshToken")) {
				refreshToken = cookie.getValue();
			}
		}
		System.out.println(refreshToken);
		AccessTokenResponse retorno = service.getNewAccessTokenRefreshToken(refreshToken);
		return retorno != null ? new ResponseEntity<AccessTokenResponse>(retorno, HttpStatus.OK)
				: new ResponseEntity<AccessTokenResponse>(HttpStatus.NO_CONTENT);
	}	
}
