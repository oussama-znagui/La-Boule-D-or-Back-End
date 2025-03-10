package ma.znagui.bouledor.service.impl;

import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.poolClubsTournamentClubs.PoolClubsTournamentClubsRequestDTO;
import ma.znagui.bouledor.dto.poolClubsTournamentClubs.PoolClubsTournamentClubsResponseDTO;
import ma.znagui.bouledor.entity.Club;
import ma.znagui.bouledor.entity.ClubsTournament;
import ma.znagui.bouledor.entity.PoolClubsTournamentClubs;
import ma.znagui.bouledor.enums.TournamentType;
import ma.znagui.bouledor.exception.ClubNotInTournamentZoneException;
import ma.znagui.bouledor.exception.TournamentMaxClubsReachedException;
import ma.znagui.bouledor.mapper.PoolClubsTournamentClubsMapper;
import ma.znagui.bouledor.repository.PoolClubsTournamentClubsRepository;
import ma.znagui.bouledor.service.ClubService;
import ma.znagui.bouledor.service.ClubsTournamentService;
import ma.znagui.bouledor.service.PoolClubsTournamentClubsService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PoolClubsTournamentClubsServiceImpl implements PoolClubsTournamentClubsService {
    private final PoolClubsTournamentClubsRepository repository;
    private final PoolClubsTournamentClubsMapper mapper;
    private final ClubsTournamentService clubsTournamentService;
    private ClubService clubService;


    public PoolClubsTournamentClubsResponseDTO addClubToTournament(PoolClubsTournamentClubsRequestDTO dto) {

        PoolClubsTournamentClubs poolClubsTournamentClubs = mapper.toEntity(dto);
        System.out.println(poolClubsTournamentClubs);

        Club club = clubService.getClubEntityById(poolClubsTournamentClubs.getClub().getId());
        ClubsTournament clubsTournament = clubsTournamentService.getClubsTournamentEntityById(poolClubsTournamentClubs.getTournament().getId());

        if (clubsTournament.getClubs().size() == clubsTournament.getNumberOfTeams()){
          throw new  TournamentMaxClubsReachedException(clubsTournament.getNumberOfTeams());
        }

        if (clubsTournament.getType()  == TournamentType.CITY_LEVEL && club.getCity() != clubsTournament.getHostingClub().getCity()){
            throw new ClubNotInTournamentZoneException(club.getName(),clubsTournament.getHostingClub().getCity().getName());

        }

        switch (clubsTournament.getType()){
            case CITY_LEVEL:
                if (club.getCity() != clubsTournament.getHostingClub().getCity()){
                    throw new ClubNotInTournamentZoneException(club.getName(),clubsTournament.getHostingClub().getCity().getName());
                }
                break;
            case REGIONAL:
                if (club.getCity().getRegion() != clubsTournament.getHostingClub().getCity().getRegion()){
                    throw new ClubNotInTournamentZoneException(club.getName(),clubsTournament.getHostingClub().getCity().getRegion().name());
                }
                break;
            default:
                break;
        }


        return mapper.toResponseDTO(repository.save(poolClubsTournamentClubs));
    }
}
