package org.consul.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author gaorun
 * @Description
 * @create 2021-11-03 17:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

	private Integer id;
	private String productName;
	private Integer productNum;
	private Double productPrice;
}
