package br.gov.camara.ditec.adm.sivis.config.seguranca.token;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class RefreshTokenPostProcessor implements ResponseBodyAdvice<AccessTokenResponse>{

	private static final String METHOD = "getRefreshToken";
	
	private static final String COOKIE_NAME = "refreshToken";
	
	@Value("${config.domain}")
	private String domain;
	
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return returnType.getMethod().getName().equals(METHOD);
	}

	@Override
	public AccessTokenResponse beforeBodyWrite(AccessTokenResponse body, MethodParameter returnType,
			MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
			ServerHttpRequest request, ServerHttpResponse response) {
				
		HttpServletRequest req = ((ServletServerHttpRequest)request).getServletRequest();
		HttpServletResponse res = ((ServletServerHttpResponse)response).getServletResponse();
		
		String refreshToken = body.getRefreshToken();
		
		adicionarRefreshTokenNoCookie(refreshToken, req, res);
		removeRefreshTokenDoBody(body);
		
		return body;
	}

	private void removeRefreshTokenDoBody(AccessTokenResponse accessToken) {
		accessToken.setRefreshToken(null);
	}

	private void adicionarRefreshTokenNoCookie(String refreshToken, HttpServletRequest req, HttpServletResponse res) {
		Cookie refreshTokenCookie = new Cookie(COOKIE_NAME, refreshToken);
		refreshTokenCookie.setHttpOnly(true); // APENAS COOKIE DE HTTP
		refreshTokenCookie.setSecure(true); // TODO: MUDAR PARA TRUE QUANDO FOR PRODUCAO
		refreshTokenCookie.setPath(req.getContextPath()); //PATH QUE SERA CRIADO O COOKIE
		refreshTokenCookie.setMaxAge(2592000); // TEMPO DE VIDA DO COOKIE
		refreshTokenCookie.setDomain(domain);
		res.addCookie(refreshTokenCookie);
	}

}
