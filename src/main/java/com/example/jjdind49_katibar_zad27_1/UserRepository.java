package com.example.jjdind49_katibar_zad27_1;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserRepository extends CrudRepository<User, Long> {
}
