package com.github.ksks2211.app.user.auth;

import jakarta.servlet.http.HttpServletRequest;
import lombok.*;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import java.io.Serializable;

/**
 * @author rival
 * @since 2024-02-28
 */




@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class RefreshDetails {

    private boolean autoRefresh;

}
