package org.azamat.component;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.azamat.service.UserService;
import org.azamat.service.impl.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationSuccessHandlerImpl.class);

    private final UserService userService;

    @Autowired
    public AuthenticationSuccessHandlerImpl(@Lazy final UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request,
                                        final HttpServletResponse response,
                                        final Authentication authentication) throws IOException, ServletException {
        final HttpSession session = request.getSession(true);
        final UserDetailsImpl authUser = (UserDetailsImpl) SecurityContextHolder.getContext()
                                                                                .getAuthentication()
                                                                                .getPrincipal();
        final String userName = authUser.getUsername();
        session.setAttribute("role", String.valueOf(authUser.getAuthorities()));
        session.setAttribute("connectedUser", this.userService.findByUsername(userName));
        LOGGER.info("userName: {}", userName);
        LOGGER.debug("userName: {}", userName);
        session.setAttribute("userName ", userName);
        response.sendRedirect("/home");
    }
}

