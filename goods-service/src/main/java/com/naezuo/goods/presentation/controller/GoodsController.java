package com.naezuo.goods.presentation.controller;

import com.naezuo.goods.application.service.GoodsService;
import com.naezuo.goods.presentation.dto.ApiResponse;
import com.naezuo.goods.presentation.dto.GoodsRegisterRequest;
import com.naezuo.goods.presentation.dto.GoodsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class GoodsController {
    private final GoodsService goodsService;

    @GetMapping("")
    public ResponseEntity<ApiResponse> test(){
        return ApiResponse.response(HttpStatus.OK, "goods service 정상 작동중입니다." );
    }
    @GetMapping("/list")
    public ResponseEntity<ApiResponse> getGoodsList(){
        return ApiResponse.response(HttpStatus.OK, "goodsList 입니다" ,goodsService.getGoodsING());
    }

    @GetMapping("/detail/{goodsId}")
    public ResponseEntity<ApiResponse> getGoodsDetail(@PathVariable("goodsId") Long goodsId){
        Optional<GoodsResponse> goodsResponse = goodsService.getGoodsById(goodsId);
        return goodsResponse
                .map(value -> ApiResponse.response(HttpStatus.OK, "해당 상품의 상세정보입니다.", goodsResponse))
                .orElseGet(() -> ApiResponse.response(HttpStatus.NOT_FOUND, "해당 상품이 존재하지 않습니다."));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerGoods(@RequestBody GoodsRegisterRequest goodsRegisterRequest){
        goodsService.saveGoods(goodsRegisterRequest);
        return ApiResponse.response(HttpStatus.OK, "상품이 등록되었습니다.");
    }
}
