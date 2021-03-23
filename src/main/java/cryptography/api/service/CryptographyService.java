package cryptography.api.service;

import cryptography.api.model.TBCryptography;

import java.util.List;

public interface CryptographyService  {
    List<TBCryptography> findAll();

    TBCryptography create(TBCryptography tbCryptography);

    String decryptById(Long id);
}