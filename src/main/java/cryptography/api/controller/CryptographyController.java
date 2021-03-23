package cryptography.api.controller;

import cryptography.api.model.TBCryptography;
import cryptography.api.service.CryptographyServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "API REST Cryptography")
@RequestMapping(value = "/cryptography")
@CrossOrigin(origins = "*")
public class CryptographyController {

    @Autowired
    private CryptographyServiceImpl cryptographyService;

    @GetMapping("")
    @ApiOperation(value = "Retorna a lista de mensagens criptografadas")
    public List<TBCryptography> index(){
        return cryptographyService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "mostra a mensagem descriptografada")
    public String decryptById(@PathVariable(value = "id") Long id){
        return cryptographyService.decryptById(id);
    }

    @PostMapping("")
    @ApiOperation(value = "criar uma mensagem criptografada")
    public TBCryptography create(@RequestBody TBCryptography tbCryptography){
        return cryptographyService.create(tbCryptography);
    }

}
