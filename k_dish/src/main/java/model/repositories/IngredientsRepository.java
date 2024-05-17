package model.repositories;

import model.entity.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Integer> {
    List<Ingredients> findByName(String name);
}
