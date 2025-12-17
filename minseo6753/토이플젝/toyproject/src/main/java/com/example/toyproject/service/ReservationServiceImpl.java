package com.example.toyproject.service;

import com.example.toyproject.apiPayLoad.code.error.DoctorErrorCode;
import com.example.toyproject.apiPayLoad.code.error.PatientErrorCode;
import com.example.toyproject.apiPayLoad.exception.DoctorException;
import com.example.toyproject.apiPayLoad.exception.PatientException;
import com.example.toyproject.converter.ReservationConverter;
import com.example.toyproject.domain.Doctor;
import com.example.toyproject.domain.Patient;
import com.example.toyproject.domain.Reservation;
import com.example.toyproject.dto.req.ReservationReqDTO;
import com.example.toyproject.dto.res.ReservationResDTO;
import com.example.toyproject.repository.DoctorRepository;
import com.example.toyproject.repository.PatientRepository;
import com.example.toyproject.repository.ReservationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationServiceImpl implements ReservationService {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final ReservationRepository reservationRepository;

    @Override
    public ReservationResDTO.RegisterDTO register(ReservationReqDTO.RegisterDTO dto) {

        Patient patient = patientRepository.findById(dto.patientId())
                .orElseThrow(() -> new PatientException(PatientErrorCode.NOT_FOUND));

        Doctor doctor = doctorRepository.findById(dto.doctorId())
                .orElseThrow(() -> new DoctorException(DoctorErrorCode.NOT_FOUND));

        Reservation reservation = ReservationConverter.toReservation(dto, patient, doctor);

        reservationRepository.save(reservation);

        return ReservationConverter.toRegisterDTO(reservation);
    }
}
