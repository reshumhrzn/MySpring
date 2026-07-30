package io.herald.myspringweb.Repository;

import io.herald.myspringweb.Model.ImageTable2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository2 extends JpaRepository<ImageTable2,Integer> {

}
