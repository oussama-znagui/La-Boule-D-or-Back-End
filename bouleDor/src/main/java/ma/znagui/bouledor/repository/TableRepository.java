package ma.znagui.bouledor.repository;

import ma.znagui.bouledor.entity.PoolTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<PoolTable, Long> {

}
