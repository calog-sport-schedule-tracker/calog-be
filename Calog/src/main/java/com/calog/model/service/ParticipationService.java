package com.calog.model.service;

import com.calog.model.dto.Participation;

import java.util.List;

public interface ParticipationService {
    public List<Participation> getAllParticipationByUserId(int userId);
    public List<Participation> getParticipationBySport(int userId, int eventId);
    public List<Participation> getParticipationByMonth(int userId, int eventId);
    public List<Participation> getParticipationByCity(int userId, int eventId);

    public boolean writeParticipation(Participation participation, int userId);
}
