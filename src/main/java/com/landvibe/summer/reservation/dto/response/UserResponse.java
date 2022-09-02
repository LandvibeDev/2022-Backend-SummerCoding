package com.landvibe.summer.reservation.dto.response;

import com.landvibe.summer.reservation.entity.User;
import lombok.*;

@AllArgsConstructor
@Builder
@Data
@Getter
@Setter
public class UserResponse {
    private String name;
    private Long id;
}
