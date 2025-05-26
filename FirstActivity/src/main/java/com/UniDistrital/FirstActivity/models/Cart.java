package com.UniDistrital.FirstActivity.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private int id;
    private int userId;
    private LocalDate date;
    private List<CartItem> items;


    public Cart(com.UniDistrital.FirstActivity.dto.CartDto dto) {
        this.id     = dto.getId();
        this.userId = dto.getUserId();
       
        this.date   = LocalDate.parse(dto.getDate().substring(0, 10));
        
        this.items = dto.getProducts().stream()
            .map(p -> new CartItem(p.getProductId(), p.getQuantity()))
            .collect(Collectors.toList());
    }

    
    public int totalItems() {
        return items.stream().mapToInt(CartItem::getQuantity).sum();
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CartItem {
        private int productId;
        private int quantity;
    }
}
