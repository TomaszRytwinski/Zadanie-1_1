package com.capgemini.chess.dataaccess.source;

import java.util.Map;
import com.capgemini.chess.dataaccess.entities.PlayerEntity;


public interface PlayerDataSource {
	Map<Long, PlayerEntity> getPlayers();
}
