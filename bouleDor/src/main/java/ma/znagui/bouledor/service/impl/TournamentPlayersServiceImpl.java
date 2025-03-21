package ma.znagui.bouledor.service.impl;

import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.tournamentPlayers.TournamentPlayersRequestDTO;
import ma.znagui.bouledor.dto.tournamentPlayers.TournamentPlayersResponseDTO;
import ma.znagui.bouledor.entity.ClubsTournament;
import ma.znagui.bouledor.entity.IndividualTournament;
import ma.znagui.bouledor.entity.Tournament;
import ma.znagui.bouledor.entity.TournamentPlayers;
import ma.znagui.bouledor.exception.PlayerDoesNotBelongToAnyClubInTournamentException;
import ma.znagui.bouledor.exception.PlayerWithoutClubException;
import ma.znagui.bouledor.exception.TournamentMaxPlayersReachedException;
import ma.znagui.bouledor.mapper.TournamentPlayersMapper;
import ma.znagui.bouledor.repository.TournamentPlayersRepository;
import ma.znagui.bouledor.service.PlayerService;
import ma.znagui.bouledor.service.TournamentPlayersService;
import ma.znagui.bouledor.service.TournamentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class TournamentPlayersServiceImpl  implements TournamentPlayersService {
    private final TournamentPlayersMapper tournamentPlayersMapper;
    private final TournamentPlayersRepository tournamentPlayersRepository;
    private final TournamentService tournamentService;
    private final PlayerService playerService;





    public TournamentPlayersResponseDTO addPlayerToTournament(TournamentPlayersRequestDTO dto) {
        TournamentPlayers tournamentPlayers = tournamentPlayersMapper.requestDTOtoTournamentPlayers(dto);

        tournamentPlayers.setPlayer(playerService.getPlayerEntityById(dto.getPlayer_id()));
        Tournament tournament = tournamentService.getTournamentEntityById(dto.getTournement_id());
        tournamentPlayers.setTournament(tournament);


        System.out.println(tournament instanceof ClubsTournament);

        if (tournament instanceof ClubsTournament){

            if (tournamentPlayers.getPlayer().getClub() == null){
                throw new PlayerWithoutClubException(tournamentPlayers.getPlayer().getFirstname() + " " + tournamentPlayers.getPlayer().getLastname());
            }else{
                System.out.println("kaayn");

           int a =     ((ClubsTournament) tournament).getClubs().stream().filter(c -> c.getClub().getId() == tournamentPlayers.getPlayer().getClub().getId()).toList().size();
                System.out.println(a);
                if (a == 0){
                        throw new PlayerDoesNotBelongToAnyClubInTournamentException(tournamentPlayers.getPlayer().getFirstname() + tournamentPlayers.getPlayer().getLastname(),tournamentPlayers.getPlayer().getClub().getName());
                }



            }

        }else {

        }

        if (tournament.getPlayers().size() == tournament.getNumberOfPlayers()){
            throw new TournamentMaxPlayersReachedException(tournament.getNumberOfPlayers());
        }






        return tournamentPlayersMapper.tournementPlayersToResponseDTO(tournamentPlayers);
    }

    @Override
    public List<TournamentPlayersResponseDTO> addplayersToTournament(List<TournamentPlayersRequestDTO> dtos) {
        System.out.println("allooooooooooooooooooo");
        List<TournamentPlayersResponseDTO> resp = new ArrayList<TournamentPlayersResponseDTO>();
        dtos.forEach((dto -> resp.add(addPlayerToTournament(dto))));
        return resp;
    }
}
