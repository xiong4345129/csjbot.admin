package com.csjbot.admin.data.scs.model;
/**
 * 
 * @author Zhangyangyang
 *
 */

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ScsDish {
	private String id;
	private int dish_type;
	private String name;
	private BigDecimal price;
	private String memo;
	private Integer valid;
	private String updater_fk;
	private String creator_fk;
	private Timestamp date_update;
	private Timestamp date_create;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getDish_type() {
		return dish_type;
	}
	public void setDish_type(int dish_type) {
		this.dish_type = dish_type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Integer getValid() {
		return valid;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}
	public String getUpdater_fk() {
		return updater_fk;
	}
	public void setUpdater_fk(String updater_fk) {
		this.updater_fk = updater_fk;
	}
	public String getCreator_fk() {
		return creator_fk;
	}
	public void setCreator_fk(String creator_fk) {
		this.creator_fk = creator_fk;
	}
	public Timestamp getDate_update() {
		return date_update;
	}
	public void setDate_update(Timestamp date_update) {
		this.date_update = date_update;
	}
	public Timestamp getDate_create() {
		return date_create;
	}
	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}
	
	
}
