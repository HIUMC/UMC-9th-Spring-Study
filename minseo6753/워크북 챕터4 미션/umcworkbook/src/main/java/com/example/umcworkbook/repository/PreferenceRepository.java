package com.example.umcworkbook.repository;

import com.example.umcworkbook.entity.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferenceRepository extends JpaRepository<Preference, Integer> {
}
