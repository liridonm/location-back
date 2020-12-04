package com.test.location.repository;

import com.test.location.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Modifying
    @Query(value = "DELETE FROM locations WHERE id = :id", nativeQuery = true)
    void removeLocation(@Param("id") Integer id);
}
