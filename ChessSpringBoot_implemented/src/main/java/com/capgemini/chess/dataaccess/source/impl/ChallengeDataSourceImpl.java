package com.capgemini.chess.dataaccess.source.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.dataaccess.source.ChallengeDataSource;

@Component
public class ChallengeDataSourceImpl implements ChallengeDataSource {
	private Map<Long, ChallengeEntity> challenges = new HashMap<Long, ChallengeEntity>();
	
	@Override
	public Map<Long, ChallengeEntity> getChallenge() {
		return challenges;
	}

}
