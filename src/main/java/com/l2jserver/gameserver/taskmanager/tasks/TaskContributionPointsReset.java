package com.l2jserver.gameserver.taskmanager.tasks;

import com.l2jserver.commons.database.ConnectionFactory;
import com.l2jserver.gameserver.GeoData;
import com.l2jserver.gameserver.taskmanager.Task;
import com.l2jserver.gameserver.taskmanager.TaskManager;
import com.l2jserver.gameserver.taskmanager.TaskTypes;
import com.l2jserver.gameserver.taskmanager.TaskManager.ExecutedTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Task to reset Contribution Points (CP) for all players daily at 1:00 PM server time.
 */
public class TaskContributionPointsReset extends Task {
    private static final Logger LOG = LoggerFactory.getLogger(TaskContributionPointsReset.class);
    private static final String NAME = "contribution_points_reset";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void onTimeElapsed(ExecutedTask task) {
        LOG.info("[SYSTEM] Resetting all players' Contribution Points...");
        try (Connection con = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE characters SET contribution_points = 0")) {
            int affectedRows = ps.executeUpdate();
            LOG.info("[SYSTEM] Contribution Points reset for {} {}", affectedRows, " players.");
        } catch (SQLException e) {
            LOG.error("[ERROR] Failed to reset Contribution Points: {}",e.getMessage());
        }
    }

    @Override
    public void initializate() {
        TaskManager.addUniqueTask(NAME, TaskTypes.TYPE_GLOBAL_TASK, "1", "13:00:00", "");
    }
}
