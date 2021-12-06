package dev.fringe.entity

import org.apache.ibatis.type.JdbcType

import com.baomidou.mybatisplus.annotation.SqlCondition
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName

@TableName(value = "MainModel")
class MainModel {
	@TableField(condition = SqlCondition.LIKE, jdbcType = JdbcType.VARCHAR)
	private String model;
	private String type;
	
	public String toString() {
		return "MainModel [model=" + model + ", type=" + type + "]";
	}
}
