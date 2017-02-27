package com.capgemini.chess.dataaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.chess.dataaccess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.dataaccess.source.ChallengeDataSource;
import com.capgemini.chess.enums.Status;
import com.capgemini.chess.service.mapper.ChallengeMapper;
import com.capgemini.chess.service.to.ChallengeTO;

@Repository
public class ChallengeDaoImpl implements ChallengeDao {
	@Autowired
	ChallengeDataSource challengeDataSource;

	@Override
	public List<ChallengeTO> findChallengeSent(Long pid) {
		List<ChallengeTO> challenges = new ArrayList<ChallengeTO>();
		challenges.addAll(ChallengeMapper.map2TOs(challengeDataSource.getChallenge().values().stream()
				.filter(u -> u.getP1id().equals(pid)).collect(Collectors.toList())));
		return challenges;
	}

	@Override
	public List<ChallengeTO> findChallengeGot(Long pid) {
		List<ChallengeTO> challenges = new ArrayList<ChallengeTO>();
		challenges.addAll(ChallengeMapper.map2TOs(challengeDataSource.getChallenge().values().stream()
				.filter(u -> u.getP2id().equals(pid)).collect(Collectors.toList())));
		return challenges;
	}

	@Override
	public ChallengeTO findChallenge(UUID id) {
		ChallengeEntity challenge = challengeDataSource.getChallenge().values().stream()
				.filter(u -> u.getId().equals(id)).findFirst().orElse(null);
		return ChallengeMapper.map(challenge);
	}

	@Override
	public void addChallenge(ChallengeTO challengeTO) {
		ChallengeEntity entity = ChallengeMapper.map(challengeTO);
		challengeDataSource.getChallenge().put(generateNextId(), entity);
	}

	@Override
	public void changeStatus(UUID id, Status status) throws IllegalStateException{
		ChallengeEntity challenge = challengeDataSource.getChallenge().values().stream()
				.filter(u -> u.getId().equals(id)).findFirst().orElse(null);
		if (challenge == null) {
			throw new IllegalStateException();
		} else {
			challenge.setStatus(status);
		}

	}

	private long generateNextId() {
		Optional<Long> max = challengeDataSource.getChallenge().keySet().stream().max((i1, i2) -> i1.compareTo(i2));
		return max.orElse(0L) + 1;
	}

}
