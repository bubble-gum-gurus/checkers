package org.soen387.tools;

import java.sql.SQLException;

import org.dsrg.soenea.service.threadLocal.DbRegistry;
import org.soen387.app.AbstractPageController;
import org.soen387.domain.checkerboard.tdg.CheckerBoardTDG;
import org.soen387.domain.model.checkerboard.GameStatus;
import org.soen387.domain.player.tdg.PlayerTDG;
import org.soen387.domain.user.tdg.UserTDG;

public class DBDestroy {

	public static void main(String[] args) throws InterruptedException {
		AbstractPageController.setupDb();
		try {
			CheckerBoardTDG.dropTable();
			UserTDG.dropTable();
			PlayerTDG.dropTable();
			DbRegistry.getDbConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
