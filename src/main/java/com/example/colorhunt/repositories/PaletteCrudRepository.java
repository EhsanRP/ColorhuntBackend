package com.example.colorhunt.repositories;

import com.example.colorhunt.domain.Palette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface PaletteCrudRepository extends JpaRepository<Palette,Long> {

    Set<Palette> findAllByIdIn(Collection<Long> id);
}
