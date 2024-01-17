package com.screenForm.screen.domain.screenForm.repos;

import com.screenForm.screen.domain.screenForm.models.ScreenForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScreenFormRepo extends JpaRepository <ScreenForm, Long> {
    Optional<ScreenForm> findByEmail(String email);
}
