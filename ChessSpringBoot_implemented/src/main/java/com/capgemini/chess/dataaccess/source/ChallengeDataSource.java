package com.capgemini.chess.dataaccess.source;

import java.util.Map;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;


public interface ChallengeDataSource {
	Map<Long, ChallengeEntity> getChallenge();

}
