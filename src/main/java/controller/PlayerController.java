package controller;

import service.PlayerService;
import util.annotation.Controller;
import util.annotation.RequestMapping;

@Controller
public class PlayerController {
	private PlayerService playerService;

	public PlayerController() {
		this.playerService = new PlayerService();
	}

	@RequestMapping(name = "선수목록")
	public String getPlayersByTeam(int teamId) {
		return playerService.getPlayersByTeam(teamId);
	}
}
