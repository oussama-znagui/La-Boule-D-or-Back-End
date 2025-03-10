package ma.znagui.bouledor.service;

import ma.znagui.bouledor.entity.Tournament;

public interface TournamentService {
    Tournament getTournamentEntityById(Long id);
    int isTournamentDurationValid(Tournament tournament);
}
