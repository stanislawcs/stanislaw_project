package by.stanislaw.it.service;

import by.stanislaw.it.encoder.PasswordEncoder;
import by.stanislaw.it.entity.SecurityGuard;
import by.stanislaw.it.repository.GuardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuardService {
    @Autowired
    private GuardRepository guardRepository;

    private void save(SecurityGuard securityGuard) {
        guardRepository.save(securityGuard);
    }

    public void save(String name, String passportNumber, String password, String role) {
        SecurityGuard securityGuard = new SecurityGuard();
        securityGuard.setName(name);
        securityGuard.setPassportNumber(passportNumber);
        securityGuard.setPassword(PasswordEncoder.encodePassword(password));
        securityGuard.setRole(role);
        save(securityGuard);
    }

    public Optional<SecurityGuard> getSecurityGuardByPassportNumber(String passportNumber) {
        return guardRepository.findSecurityGuardByPassportNumber(passportNumber);
    }

    public Optional<SecurityGuard> getSecurityGuardById(String id) {
        return guardRepository.findById(id);
    }

    public Optional<SecurityGuard> getSecurityGuardByName(String name) {
        return guardRepository.findSecurityGuardByName(name);
    }

    public List<SecurityGuard> getAllGuards() {
        return guardRepository.findAll();
    }

    public void deleteGuardById(String id) {
        guardRepository.deleteById(id);
    }

    public void updatePathToGuardImageById(String path,String id){
        guardRepository.updatePathToGuardImageById(path,id);
    }

    public List<SecurityGuard> searchSecurityGuardNameByInputText(String inputText){
        return guardRepository.searchSecurityGuardNameByInputText(inputText);
    }


}