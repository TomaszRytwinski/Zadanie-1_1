package com.capgemini.chess.service;

import java.util.List;
import java.util.UUID;
import com.capgemini.chess.service.to.ChallengeTO;

public interface ChallangeService {
	ChallengeTO createChallenge(Long p1id, Long p2id);
	ChallengeTO changeStatus(UUID id);
}
