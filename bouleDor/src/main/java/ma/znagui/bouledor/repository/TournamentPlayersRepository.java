package ma.znagui.bouledor.repository;

import ma.znagui.bouledor.entity.TournamentPlayers;
import ma.znagui.bouledor.entity.TournamentPlayersKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentPlayersRepository extends JpaRepository<TournamentPlayers, TournamentPlayersKey> {
}
