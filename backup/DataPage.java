package com.leandrosantino.service_orders.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataPage {
    private String id;
    private String machineTag;
    private String nature;
    private Integer weekCode;
    private Integer year;
    private Integer duration;

    private List<Itens> itens;

    @Data
    @AllArgsConstructor
    public static class Itens {
        private String id;
        private String description;
        private String excution;
    }
}
