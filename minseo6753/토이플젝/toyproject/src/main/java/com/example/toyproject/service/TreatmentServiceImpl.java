package com.example.toyproject.service;

import com.example.toyproject.apiPayLoad.code.error.ReservationErrorCode;
import com.example.toyproject.apiPayLoad.exception.ReservationException;
import com.example.toyproject.converter.TreatmentConverter;
import com.example.toyproject.domain.Reservation;
import com.example.toyproject.domain.Treatment;
import com.example.toyproject.dto.req.TreatmentReqDTO;
import com.example.toyproject.dto.res.TreatmentResDTO;
import com.example.toyproject.repository.ReservationRepository;
import com.example.toyproject.repository.TreatmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class TreatmentServiceImpl implements TreatmentService {

    private final ReservationRepository reservationRepository;
    private final TreatmentRepository treatmentRepository;

    @Override
    public TreatmentResDTO.RegisterDTO register(TreatmentReqDTO.RegisterDTO dto) {
        Reservation reservation = reservationRepository.findById(dto.reservationId())
                .orElseThrow(() -> new ReservationException(ReservationErrorCode.NOT_FOUND));

        Treatment treatment = TreatmentConverter.toTreatment(dto, reservation);
        treatmentRepository.save(treatment);
        return TreatmentConverter.toRegisterDTO(treatment);
    }
}
