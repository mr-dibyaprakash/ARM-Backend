package com.armapp.service;

import com.armapp.exception.InvalidIdException;
import com.armapp.model.Talent;
import com.armapp.repository.TalentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class TalentServiceImpl implements ITalentService {

    private TalentRepo talentRepo;

    @Autowired
    public void setTalentRepo(TalentRepo talentRepo) {
        this.talentRepo = talentRepo;
    }

    /**
     * @param talents
     * @author - AkashKanaparthi
     */
    @Override
    public void addTalent(Set<Talent> talents) {
        talentRepo.saveAll(talents);
    }

    /**
     * @param talent
     * @author - AkashKanaparthi
     */
    @Override
    public void updateTalent(Talent talent) {
        Talent talent1 = talentRepo.findById(talent.getTalentId()).get();
        talent1.setUpdatedAt(LocalDateTime.now());
        talentRepo.save(talent1);
    }

    /**
     * @param talentId
     * @throws InvalidIdException
     * @author - AkashKanaparthi
     */
    @Override
    public void deleteTalent(int talentId) throws InvalidIdException {
        Talent talent = talentRepo.findById(talentId).get();
        talent.setDeleted(true);
        talentRepo.save(talent);
    }

    /**
     * @param talentId
     * @return
     * @throws InvalidIdException
     * @author - AkashKanaparthi
     */
    @Override
    public Talent getById(int talentId) throws InvalidIdException {
        return talentRepo.findById(talentId).get();
    }

    /**
     * @return
     * @author - AkashKanaparthi
     */
    @Override
    public List<Talent> getAll() {
        return talentRepo.findAll()
                .stream()
                .filter(talent -> !talent.isDeleted())
                .sorted(Comparator.comparing(Talent::getTalentName))
                .collect(Collectors.toList());
    }


    @Override
    public List<Talent> getByTalentNameLike(String keyword) {

        return talentRepo.findByTalentNameLike("%"+keyword+"%");
    }
}
