package com.screenForm.screen.domain.screenForm.services;

import com.screenForm.screen.domain.core.exceptions.ResourceCreationException;
import com.screenForm.screen.domain.core.exceptions.ResourceNotFoundException;
import com.screenForm.screen.domain.screenForm.models.ScreenForm;
import com.screenForm.screen.domain.screenForm.repos.ScreenFormRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreenFormServiceImpl implements ScreenFormService {

    private ScreenFormRepo screenFormRepo;

    @Autowired
    public ScreenFormServiceImpl(ScreenFormRepo screenFormRepo) {
        this.screenFormRepo = screenFormRepo;
    }


    @Override
    public ScreenForm create(ScreenForm screenForm) throws ResourceCreationException {
        String email = screenForm.getEmail();
        Optional<ScreenForm> optional = screenFormRepo.findByEmail(email);
        if(optional.isPresent()){
        throw new ResourceCreationException(" Email exist: " + screenForm.getEmail());
        }
        screenForm = screenFormRepo.save(screenForm);

        return screenForm;
    }

    @Override
    public ScreenForm getById(Long id) throws ResourceNotFoundException {
        ScreenForm screenForm = screenFormRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No Screen Form with id: " + id));
        return screenForm;
    }

    @Override
    public ScreenForm getByEmail(String email) throws ResourceNotFoundException {
        ScreenForm screenForm = screenFormRepo.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("No Screen Form with email: " + email));
        return screenForm;
    }

    @Override
    public List<ScreenForm> getAll() {
        return screenFormRepo.findAll();
    }

    @Override
    public ScreenForm update(Long id, ScreenForm screenFormDetail) throws ResourceNotFoundException {
        ScreenForm screenForm = getById(id);
        screenForm.setFirstName(screenFormDetail.getFirstName());
        screenForm.setLastName(screenFormDetail.getLastName());
        screenForm.setEmail(screenFormDetail.getEmail());
        screenForm = screenFormRepo.save(screenForm);
        return screenForm;    }

    @Override
    public void delete(Long id) {
        ScreenForm screenForm = getById(id);
        screenFormRepo.delete(screenForm);
    }
}
