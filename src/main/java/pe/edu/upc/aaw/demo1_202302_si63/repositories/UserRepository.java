package pe.edu.upc.aaw.demo1_202302_si63.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.aaw.demo1_202302_si63.entities.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	public Users findByRasousername(String rasousername);


}