package com.armapp.service;

import com.armapp.exception.InvalidIdException;
import com.armapp.model.Talent;
import com.armapp.repository.TalentRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author - Akash Kanaparthi
 * @date - 08-07-2022
 * @project - Acheron-Training-AUDIT-REQUEST-MANAGEMENT-BACKEND
 */
public class TalentServiceImpl implements ITalentService{

    private TalentRepo talentRepo;
    @Autowired
    public void setTalentRepo(TalentRepo talentRepo) {
        this.talentRepo = talentRepo;
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param talents
     */
    @Override
    public void addTalent(Set<Talent> talents) {
        talentRepo.saveAll(talents);
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param talent
     */
    @Override
    public void updateTalent(Talent talent) {
        Talent talent1 = talentRepo.findById(talent.getTalentId()).get();
        talent1.setUpdatedAt(LocalDateTime.now());
        talentRepo.save(talent1);
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param talentId
     * @throws InvalidIdException
     */
    @Override
    public void deleteTalent(int talentId) throws InvalidIdException {
        Talent talent = talentRepo.findById(talentId).get();
        talent.setDeleted(true);
        talentRepo.save(talent);
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param talentId
     * @return
     * @throws InvalidIdException
     */
    @Override
    public Talent getById(int talentId) throws InvalidIdException {
        return talentRepo.findById(talentId).get();
    }

    /**
     * @author - AkashKanaparthi
     * @return
     */
    @Override
    public List<Talent> getAll() {
        return talentRepo.findAll()
                .stream()
                .filter(talent -> !talent.isDeleted())
                .sorted(Comparator.comparing(Talent::getTalentName))
                .collect(Collectors.toList());
    }
}
