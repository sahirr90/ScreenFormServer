package com.screenForm.screen.domain.screenForm.services;

import com.screenForm.screen.domain.core.exceptions.ResourceCreationException;
import com.screenForm.screen.domain.core.exceptions.ResourceNotFoundException;
import com.screenForm.screen.domain.screenForm.models.ScreenForm;

import java.util.List;

public interface ScreenFormService {
    ScreenForm create(ScreenForm screenForm) throws ResourceCreationException;
    ScreenForm getById(Long id) throws ResourceNotFoundException;
    ScreenForm getByEmail(String email) throws ResourceNotFoundException;
    List<ScreenForm> getAll();
    ScreenForm update(Long id, ScreenForm screenFormDetail) throws ResourceNotFoundException;
    void delete(Long id);
}
