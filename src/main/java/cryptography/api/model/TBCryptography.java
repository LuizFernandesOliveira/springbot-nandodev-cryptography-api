package cryptography.api.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class TBCryptography implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String message;

    private Integer key_crypt;

    public Integer getKey_crypt() {
        return key_crypt;
    }

    public void setKey_crypt(Integer key_crypt) {
        this.key_crypt = key_crypt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
