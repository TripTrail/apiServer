package com.company.application.config;

import static com.company.application.constants.Constant.*;
import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        return ADMIN_USER;
    }
}
