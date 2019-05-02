package sc.swagger2.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class User implements Serializable {

	private static final long serialVersionUID = 4639927446947303736L;

	@ApiModelProperty(name="id", dataType="Long", value="主键ID")
	private Long id;

	@ApiModelProperty(name="userName", dataType="String", value="姓名", required=true)
	private String userName;

	@ApiModelProperty(name="age", dataType="String", value="年龄", required=true)
	private Integer age;

	@ApiModelProperty(name="position", dataType="String", value="职位")
	private String position;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
