package hello.umc9th.domain.mission.service;

import hello.umc9th.domain.mission.entity.MemberMission;
import hello.umc9th.domain.mission.enums.Status;
import hello.umc9th.domain.mission.repository.MemberMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;

    public Page<MemberMission> getOngoingAndCompletedMissions(Long memberId, int page, int size) {
        List<Status> statuses = Arrays.asList(Status.IN_PROGRESS, Status.COMPLETED);
        PageRequest pageRequest = PageRequest.of(page, size);

        return memberMissionRepository.findByMemberIdAndStatusInOrderByUpdatedAtDesc(
                memberId, statuses, pageRequest
        );
    }
}