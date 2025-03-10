package ma.znagui.bouledor.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class DebugFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        filterChain.doFilter(request,response);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("DEBUG FILTER - AUTH AFTER CHAIN: " + (authentication != null ? authentication.getAuthorities() : "NULL"));

    }
}
