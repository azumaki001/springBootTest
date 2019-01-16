package com.test.springTest.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.test.springTest.constraint.Memo;

public class AnimalForm {
	private long id;

	@NotBlank(message="动物名: 不能为空")
    private String oname;

	//@Range(min = 1, message="数量: 必须大于0")
	//@NotNull(message="数量: 不能为空")
	//@NotBlank(message="数量: 不能为空")
    @Pattern(regexp="[0-9]{1,3}", message="数量X: 必须为正整数，并且0<X<1000")
	private String ocount;

	@Size(max = 10, message="备注: 长度不能超过10个字符")
	@Memo(message = "备注不能为空，且只能填写\"圈养\"，或者\"散养\"")
    private String memo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public String getOcount() {
		return ocount;
	}

	public void setOcount(String ocount) {
		this.ocount = ocount;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}


}
