package com.wtf.core.domain.model;

import lombok.Getter;
import lombok.Setter;

/**
 * The type User order.
 */
@Setter
@Getter
public class UserOrder extends BaseModel{
    /**
     * The Order count.
     */
   private Integer orderCount;
    /**
     * The Success count.
     */
  private Integer successCount;

  private Long userId;
}
