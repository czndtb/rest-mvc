package com.ccc.restmvc.entity.enumvalue;

public enum StatusCode {

	OK(0, "ok"), ERROR(1, "error"), PARAM_ERROR(1000, "param error");

	private int code;
	private String msg;

	private StatusCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
