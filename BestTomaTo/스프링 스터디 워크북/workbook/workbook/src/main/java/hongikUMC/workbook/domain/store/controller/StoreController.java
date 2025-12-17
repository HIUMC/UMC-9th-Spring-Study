package hongikUMC.workbook.domain.store.controller;

import hongikUMC.workbook.domain.store.dto.req.StoreReqDTO;
import hongikUMC.workbook.domain.store.dto.res.StoreResDTO;
import hongikUMC.workbook.domain.store.exception.code.StoreSuccessCode;
import hongikUMC.workbook.domain.store.service.StoreCommandService;
import hongikUMC.workbook.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreController {

    private final StoreCommandService storeCommandService;

    // 8주차 - 특정 지역에 가게 추가하기 API
    @PostMapping("/save")
    public ApiResponse<StoreResDTO.saveStoreDTO> saveStore(
            @RequestBody StoreReqDTO.saveStoreDTO storeDTO
            ){
        return ApiResponse.onSuccess(StoreSuccessCode.OK, storeCommandService.saveStore(storeDTO));
    }
}
