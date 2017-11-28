package shafin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import shafin.web.dao.SquadDao;
import shafin.web.entity.*;

/**
 * @author SHAFIN
 * @since 12/11/2016
 */
@Controller
public class UserController {

    @Autowired
    private SquadDao squadDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHome(Model model) {

        Post post = new Post();
        post.setTitle("Hello Talk");

        Comment comment1 = new Comment();
        comment1.setReview("Nice One");
        post.addComment(comment1);

        Comment comment2 = new Comment();
        comment2.setReview("Keep up");
        post.addComment(comment2);

        //postDao.save(post);
        //model.addAttribute("postList", postDao.findAll());

        Squad squad = new Squad();
        squad.setName("Test squad");
        squad.setDescription("This is test team");
        squad.setPrimaryFormation("1-0-3-1");

        Player player1 = new Player();
        player1.setName("messi");
        player1.setClub("barcelona");
        player1.setCountry("Spain");
        player1.setPosition("defense");

        PlayerStat pstat1 = new PlayerStat();
        pstat1.setPerformance(10);

        Player player2 = new Player();
        player2.setName("messi");
        player2.setClub("barcelona");
        player2.setCountry("Spain");
        player2.setPosition("defense");

        PlayerStat pstat2 = new PlayerStat();
        pstat2.setPerformance(10);

        SquadPlayer sp1 = new SquadPlayer();
        sp1.setPlayer(player1);
        sp1.setGenericPlayerId(101);
        sp1.setSquad(squad);
        sp1.setPlayerStat(pstat1);

        SquadPlayer sp2 = new SquadPlayer();
        sp2.setPlayer(player2);
        sp2.setGenericPlayerId(201);
        sp2.setSquad(squad);
        sp2.setPlayerStat(pstat2);

        squad.getPlayerSet().add(sp1);
        squad.getPlayerSet().add(sp2);

        squadDao.saveSquad(squad);

        return "home";
    }
}
