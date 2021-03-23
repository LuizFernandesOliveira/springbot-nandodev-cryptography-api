package cryptography.api.service;

import cryptography.api.model.TBCryptography;
import cryptography.api.repository.CryptographyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CryptographyServiceImpl implements CryptographyService {

    @Autowired
    private CryptographyRepository cryptographyRepository;

    @Override
    public List<TBCryptography> findAll() {
        return (List<TBCryptography>) this.cryptographyRepository.findAll();
    }

    @Override
    public TBCryptography create(TBCryptography tbCryptography) {
        tbCryptography
                .setMessage(processing(tbCryptography.getMessage(), tbCryptography.getKey_crypt()));
        return this.cryptographyRepository.save(tbCryptography);
    }

    @Override
    public String decryptById(Long id) {
        TBCryptography message = cryptographyRepository.findById(id).get();
        return  processing(message.getMessage(), -message.getKey_crypt());
    }

    private String processing(String message, int key) {
        return String.join("", Arrays.stream(message.split(""))
                .map(String::toLowerCase)
                .map((letter) -> {
                    if(!letter.equals(" ") && !Character.isDigit(letter.charAt(0))){
                        return String.valueOf((char) (letter.charAt(0) + key));
                    }else{
                        return letter;
                    }
                }).toArray(String[]::new));
    }

}
