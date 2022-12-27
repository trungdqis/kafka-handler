package uit.trungdq.springboot.converter;

import uit.trungdq.springboot.dto.OrderDetailDTO;
import uit.trungdq.springboot.payload.OrderDetail;

public class OrderDetailConverter {
    public static OrderDetailDTO toDTO(OrderDetail orderDetail) {
        OrderDetailDTO dto = new OrderDetailDTO();

        dto.setOrderId(orderDetail.getOrder().getId());
        dto.setProductId(orderDetail.getProduct().getId());
        dto.setQuantity(orderDetail.getQuantity());
        dto.setUnitPrice(orderDetail.getUnitPrice());
        dto.setShippingCost(orderDetail.getShippingCost());
        dto.setSubtotal(orderDetail.getSubtotal());

        return dto;
    }
}
