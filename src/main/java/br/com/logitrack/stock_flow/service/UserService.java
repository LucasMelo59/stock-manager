package br.com.logitrack.stock_flow.service;

import br.com.logitrack.stock_flow.entity.User;
import br.com.logitrack.stock_flow.form.UserForm;
import br.com.logitrack.stock_flow.repository.UserDocumentationRepository;
import br.com.logitrack.stock_flow.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserDocumentationRepository userDocumentationRepository;

    public UserService(UserRepository userRepository, UserDocumentationRepository userDocumentationRepository) {
        this.userRepository = userRepository;
        this.userDocumentationRepository = userDocumentationRepository;
    }

    @Transactional
    public Long registerUser(UserForm form) {
        User user = userRepository.save(form.toEntity());

        form.documentation().forEach(doc -> {
            userDocumentationRepository.save(doc.toEntity(user));
        });

        return user.getId();
    }

}
