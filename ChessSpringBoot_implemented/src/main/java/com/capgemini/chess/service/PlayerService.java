package com.capgemini.chess.service;

import com.capgemini.chess.service.to.PlayerTO;

public interface PlayerService {
	PlayerTO searchPlayer(Long id);
	int getLevel(Long id);
	int getPoint(Long id);
}
