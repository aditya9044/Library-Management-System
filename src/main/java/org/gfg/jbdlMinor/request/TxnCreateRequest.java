package org.gfg.jbdlMinor.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TxnCreateRequest {
    @NotBlank(message = "Book Number cannot be blank")
    private String bookNo;

    @Positive(message = "The amount must be positive")
    private Integer amount;
}
