package org.azamat.component;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.azamat.repository.UserRepository;
import org.azamat.service.UserService;
import org.azamat.service.impl.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    @Autowired
    private HttpSession session;

    @Autowired
    private UserService userService;


    private static final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessHandlerImpl.class);
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        String userName = "";
        Collection<GrantedAuthority> authorities = null;
        if (authentication.getPrincipal() instanceof Principal) {
            userName = ((Principal)authentication.getPrincipal()).getName();
            session.setAttribute("role", "none");
        } else {
            userName = ((UserDetailsImpl)authentication.getPrincipal()).getUsername();
            UserDetailsImpl authUser = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            session.setAttribute("role", String.valueOf( authUser.getAuthorities()));
            session.setAttribute("connectedUser" , userService.findByUsername( authUser.getUsername()));
        }
        logger.info("userName: " + userName);
        session.setAttribute("userId", userName);
        response.sendRedirect("/home");

    }

}

