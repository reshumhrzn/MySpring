package io.herald.myspringweb.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ImageTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

}
