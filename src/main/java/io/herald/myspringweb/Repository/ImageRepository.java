package io.herald.myspringweb.Repository;

import io.herald.myspringweb.Model.ImageTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageTable, Integer> {

}
