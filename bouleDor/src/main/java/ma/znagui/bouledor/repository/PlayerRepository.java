package ma.znagui.bouledor.repository;

import ma.znagui.bouledor.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {
}
