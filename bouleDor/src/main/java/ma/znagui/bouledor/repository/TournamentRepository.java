package ma.znagui.bouledor.repository;

import ma.znagui.bouledor.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament,Long> {
}
