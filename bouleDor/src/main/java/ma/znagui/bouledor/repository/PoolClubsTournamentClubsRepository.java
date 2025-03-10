package ma.znagui.bouledor.repository;

import ma.znagui.bouledor.entity.PoolClubsTournamentClubs;
import ma.znagui.bouledor.entity.PoolClubsTournamentClubsKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoolClubsTournamentClubsRepository extends JpaRepository<PoolClubsTournamentClubs, PoolClubsTournamentClubsKey> {
}
