package com.UniDistrital.FirstActivity.models;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.UniDistrital.FirstActivity.dto.CartDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private int id;
    private int userId;
    private LocalDate date;
    private List<CartItem> items;

    public Cart(CartDTO cartDTO) {
        this.id = cartDTO.getId();
        this.userId = cartDTO.getUserId();
        this.date = LocalDate.parse(cartDTO.getDate().substring(0, 10));
        this.items = cartDTO.getProducts().stream()
            .map(p -> new CartItem(p.getProductId(), p.getQuantity()))
            .collect(Collectors.toList());
    }

    public int getTotalQuantityOfItems() {
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
