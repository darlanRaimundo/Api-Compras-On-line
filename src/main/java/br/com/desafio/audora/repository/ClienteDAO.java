package br.com.desafio.audora.repository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.audora.model.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Id>{

	public static boolean checarEmailValido(String email) {
		boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
	}
	
	
	
}
