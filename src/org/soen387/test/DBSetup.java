package org.soen387.test;

import java.sql.SQLException;

import org.dsrg.soenea.service.threadLocal.DbRegistry;
import org.soen387.app.AbstractPageController;
import org.soen387.domain.challenge.tdg.ChallengeTDG;
import org.soen387.domain.checkerboard.tdg.CheckerBoardTDG;
import org.soen387.domain.user.tdg.UserTDG;
import org.soen387.domain.player.tdg.PlayerTDG;
import org.soen387.domain.model.checkerboard.GameStatus;

public class DBSetup {

	public static void main(String[] args) throws InterruptedException {
		run();
	}
			
	public static void run () throws InterruptedException {
		AbstractPageController.setupDb();
		try {
			CheckerBoardTDG.createTable();
			UserTDG.createTable();
			PlayerTDG.createTable();
			ChallengeTDG.createTable();
			DbRegistry.getDbConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
