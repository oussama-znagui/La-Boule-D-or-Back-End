package ma.znagui.bouledor.service.impl;

import lombok.AllArgsConstructor;
import ma.znagui.bouledor.entity.ClubsTournament;
import ma.znagui.bouledor.entity.IndividualTournament;
import ma.znagui.bouledor.entity.PoolTable;
import ma.znagui.bouledor.entity.Tournament;
import ma.znagui.bouledor.enums.Level;
import ma.znagui.bouledor.enums.TournamentFormat;
import ma.znagui.bouledor.exception.ResourceNotFoundExeption;
import ma.znagui.bouledor.repository.TournamentRepository;
import ma.znagui.bouledor.service.TournamentService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Service
public class TournamentServiceImpl implements TournamentService {
    private final TournamentRepository tournamentRepository;

    @Override
    public Tournament getTournamentEntityById(Long id) {

        return tournamentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Tournament",id));
    }


    public   int isTournamentDurationValid(Tournament tournament){

        int totalTable = tournament.getHostingClub().getTables().stream().filter((PoolTable::getAvailableForTournaments)).toList().size();
//        int totaltournamentMatches


//        System.out.println(Arrays.toString(splitMode();


        int matchPerHour = 0;
        switch (tournament.getLevel().name()){
            case "ADVANCED":
                matchPerHour = 14;
                break;
            case "INTERMEDIATE", "ALL":
                matchPerHour = 10;
                break;
            case "BEGINNER":
                matchPerHour = 8;
                break;
            default:
                break;
        }

        int possibleMatchsForOneDay = matchPerHour * 10 * totalTable;

        System.out.println(getTotalMatchs(tournament));
        System.out.println(possibleMatchsForOneDay);

        double days = (double) getTotalMatchs(tournament) / possibleMatchsForOneDay;
        System.out.println( days);





        return (int) Math.ceil(days);

    }

    private int getTotalChalleges(Tournament tournament){
        int totalChallenges = 0;
        if (tournament instanceof ClubsTournament && tournament.getFormat() == TournamentFormat.POINT_BASED){
            totalChallenges = (((ClubsTournament) tournament).getNumberOfTeams() * (((ClubsTournament) tournament).getNumberOfTeams() - 1))/2;
        }
        if (tournament instanceof ClubsTournament && tournament.getFormat() == TournamentFormat.KNOCKOUT){
            totalChallenges = ((ClubsTournament) tournament).getNumberOfTeams();
        }
        if (tournament instanceof IndividualTournament && tournament.getFormat() == TournamentFormat.POINT_BASED){
            totalChallenges = (((IndividualTournament) tournament).getNumberOfPlayers() * (((IndividualTournament) tournament).getNumberOfPlayers() - 1))/2;
        }
        if (tournament instanceof IndividualTournament && tournament.getFormat() == TournamentFormat.KNOCKOUT){
            totalChallenges = ((IndividualTournament) tournament).getNumberOfPlayers();
        }

        return totalChallenges;
    }

    private  int[] splitMode(String mode) {
        String[] parts = mode.split("_");
        int[] result = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            result[i] = Integer.parseInt(parts[i].substring(1));
        }

        return result;
    }

    private int getTotalMatchs(Tournament tournament){
        int totalMatches = 0;
        int[] races = splitMode(tournament.getMode().name());
        int totalChalenges = getTotalChalleges(tournament);
        if (tournament.getFormat() == TournamentFormat.KNOCKOUT){
            System.out.println("chalengs : " + totalChalenges);
            if (totalChalenges > 8){
                totalMatches = (races[2] * 2) + (races[1] * 6) + (races[0] * (totalChalenges - 8));
            }
            if (totalChalenges == 8){
                totalMatches = (races[2] * 2) + (races[1] * 6);
            }
            if (totalChalenges == 4){
                totalMatches = (races[2] * 2) + (races[1] * 2);
            }

        } else if (tournament.getFormat() == TournamentFormat.POINT_BASED) {
            System.out.println("chalengs : " + totalChalenges);
            int stages = 0;
            if (tournament instanceof ClubsTournament){
                stages = ((ClubsTournament) tournament).getNumberOfTeams() -1;
            }
            if (tournament instanceof IndividualTournament){
                stages = tournament.getNumberOfPlayers() - 1;
            }
//            System.out.println(stages);
            totalMatches = (races[2]) + (races[1] * 2) + (races[0] * (totalChalenges - 3));

        }

        return totalMatches;

    }
}
