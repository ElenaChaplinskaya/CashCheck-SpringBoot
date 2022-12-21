package com.chaplinskaya.cashCheck.controller;

import com.chaplinskaya.cashCheck.dto.request.ProductsDTO;
import com.chaplinskaya.cashCheck.model.entity.Check;
import com.chaplinskaya.cashCheck.service.CheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class CheckController {
    private final CheckService checkService;

    @PostMapping("/check")
    public Check getCheck(@RequestBody ProductsDTO productsDTO) {

        return checkService.getCheck(productsDTO);
    }
}
