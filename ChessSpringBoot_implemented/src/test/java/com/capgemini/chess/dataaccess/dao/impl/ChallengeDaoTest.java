package com.capgemini.chess.dataaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.dataaccess.source.ChallengeDataSource;
import com.capgemini.chess.enums.Status;
import com.capgemini.chess.service.to.ChallengeTO;


@RunWith(MockitoJUnitRunner.class)
public class ChallengeDaoTest {
	private static final UUID EXISTING_ID = UUID.randomUUID();
	private static final UUID EXISTING_ID2 = UUID.randomUUID();
	private static final UUID EXISTING_ID3 = UUID.randomUUID();
	private static final UUID NON_EXISTING_ID = UUID.randomUUID();
	
	private static final Long Player1Id = 1l;
	private static final Long Player2Id = 2l;
	private static final Long Player3Id = 3l;
	private static final Long Player4Id = 4l;
	
	private static List<ChallengeTO> challenges = new ArrayList<ChallengeTO>();;
	
	@InjectMocks
	ChallengeDaoImpl challengeDao;

	@Mock
	ChallengeDataSource challengeData;

	@Test
	public void shouldFoundExistingChallengeById() {
		// given
		Mockito.when(challengeData.getChallenge()).thenReturn(giveChallengeBase());

		// when
		ChallengeTO challengeTO = challengeDao.findChallenge(EXISTING_ID);

		// then

		Assert.assertEquals(EXISTING_ID, challengeTO.getId());
	}
	@Test
	public void shouldNotFoundNonExistingChallengeById() {
		// given
		Mockito.when(challengeData.getChallenge()).thenReturn(giveChallengeBase());

		// when
		ChallengeTO challengeTO = challengeDao.findChallenge(NON_EXISTING_ID);

		// then

		Assert.assertNull(challengeTO);
	}
	
	@Test
	public void shouldFindAllChallegesOf1L() {
		// given
		Mockito.when(challengeData.getChallenge()).thenReturn(giveChallengeBase());

		// when
		List<ChallengeTO> challengeTO = new ArrayList<ChallengeTO>();
		challengeTO.addAll(challengeDao.findChallengeSent(Player1Id));

		// then
		Assert.assertTrue(challengeTO.get(0).getId().equals(EXISTING_ID));
	}
	@Test
	public void shouldFindNoChallengesSendBy4l() {
		// given
		Mockito.when(challengeData.getChallenge()).thenReturn(giveChallengeBase());

		// when
		List<ChallengeTO> challengeTO = new ArrayList<ChallengeTO>();
		challengeTO.addAll(challengeDao.findChallengeSent(Player4Id));

		// then
		Assert.assertTrue(challengeTO.isEmpty());
	}
	
	@Test
	public void shouldFindAllChallegesRecivedBy1L() {
		// given
		Mockito.when(challengeData.getChallenge()).thenReturn(giveChallengeBase());

		// when
		List<ChallengeTO> challengeTO = new ArrayList<ChallengeTO>();
		challengeTO.addAll(challengeDao.findChallengeGot(Player1Id));

		// then
		Assert.assertTrue(challengeTO.isEmpty());
	}
	
	@Test
	public void shouldFindAllChallegesRecivedBy4L() {
		// given
		Mockito.when(challengeData.getChallenge()).thenReturn(giveChallengeBase());

		// when
		List<ChallengeTO> challengeTO = new ArrayList<ChallengeTO>();
		challengeTO.addAll(challengeDao.findChallengeGot(Player4Id));

		// then
		Assert.assertTrue(challengeTO.get(0).getId().equals(EXISTING_ID3));
	}
	
	@Test
	public void shouldChangeStatusOfFirstChallenge() {
		// given
		Mockito.when(challengeData.getChallenge()).thenReturn(giveChallengeBase());

		// when
		ChallengeTO challengeTO = new ChallengeTO();
		challengeDao.changeStatus(EXISTING_ID, Status.ACCEPTED);
		challengeTO = challengeDao.findChallenge(EXISTING_ID);

		// then
		Assert.assertTrue(challengeTO.getStatus().equals(Status.ACCEPTED));
	}
	
	@Test(expected=IllegalStateException.class)
	public void shouldThrowExceptionWhenChangeStatusOfNotExestingChallenge() {
		// given
		Mockito.when(challengeData.getChallenge()).thenReturn(giveChallengeBase());
		ChallengeTO challengeTO = new ChallengeTO();
		
		// when
		
		challengeDao.changeStatus(NON_EXISTING_ID, Status.ACCEPTED);

		// then
	}
	
	@Test
	public void shouldAddChallenge() {
		// given
		Mockito.when(challengeData.getChallenge()).thenReturn(giveChallengeBase());
		ChallengeTO challengeTO = new ChallengeTO();
		ChallengeTO challenge = new ChallengeTO();
		challengeTO.setId(NON_EXISTING_ID);
		challengeTO.setP1id(Player2Id);
		challengeTO.setP2id(Player4Id);
		challengeTO.setStatus(Status.SENT);
		
		
		// when
		
		challengeDao.addChallenge(challengeTO);
		challenge = challengeDao.findChallenge(NON_EXISTING_ID);

		// then
		Assert.assertTrue(challenge.getId().equals(NON_EXISTING_ID));
	}
	
	
	private List<ChallengeTO> challengesOf1l(){
		ChallengeTO challenge1 = new ChallengeTO();
		ChallengeTO challenge3 = new ChallengeTO();
		challenge1.setId(EXISTING_ID);
		challenge1.setP1id(Player1Id);
		challenge1.setP2id(Player2Id);
		challenge1.setStatus(Status.SENT);

		challenge3.setId(EXISTING_ID3);
		challenge3.setP1id(Player1Id);
		challenge3.setP2id(Player4Id);
		challenge3.setStatus(Status.SENT);
		
		challenges.add(challenge1);
		challenges.add(challenge3);
	
		return challenges;
	}
	private Map<Long, ChallengeEntity> giveChallengeBase() {
		HashMap<Long, ChallengeEntity> challengeBase = new HashMap<Long, ChallengeEntity>();
		ChallengeEntity challenge1 = new ChallengeEntity();
		ChallengeEntity challenge2 = new ChallengeEntity();
		ChallengeEntity challenge3 = new ChallengeEntity();
		challenge1.setId(EXISTING_ID);
		challenge1.setP1id(Player1Id);
		challenge1.setP2id(Player2Id);
		challenge1.setStatus(Status.SENT);

		challenge2.setId(EXISTING_ID2);
		challenge2.setP1id(Player2Id);
		challenge2.setP2id(Player3Id);
		challenge2.setStatus(Status.ACCEPTED);

		challenge3.setId(EXISTING_ID3);
		challenge3.setP1id(Player2Id);
		challenge3.setP2id(Player4Id);
		challenge3.setStatus(Status.SENT);
		
		
		
		challengeBase.put(Player1Id, challenge1);
		challengeBase.put(Player2Id, challenge2);
		challengeBase.put(Player3Id, challenge3);
		return challengeBase;
	}

}
