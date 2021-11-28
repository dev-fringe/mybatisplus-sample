package dev.fringe.entity;

import org.apache.ibatis.type.JdbcType;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * ?î®?à∑ÂÆû‰ΩìÂØπÂ∫îË°? user2 ÊµãËØïÊ≥®Ëß£?ù°‰ª?
 * </p>
 *
 * @author hubin
 * @since 2021-08-19
 */
@TableName(value = "MainModel")
public class MainModel {
    @TableField(condition = SqlCondition.LIKE, jdbcType = JdbcType.VARCHAR)
	private String model;
	private String type;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public MainModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MainModel [model=" + model + ", type=" + type + "]";
	}
	public MainModel(String model, String type) {
		super();
		this.model = model;
		this.type = type;
	}
}
