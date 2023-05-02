/**
 * 
 */
package com.shz.formatter.model;

import java.util.Objects;

/**
 * @author shenazz
 *
 */
public class FormatterResult<T> {

	private T result;

	private FormatResultStatus status;

	private String msg;

	/**
	 * @return the result
	 */
	public T getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(T result) {
		this.result = result;
	}

	/**
	 * @return the resultStatus
	 */
	public FormatResultStatus getStatus() {
		return status;
	}

	/**
	 * @param resultStatus
	 *            the resultStatus to set
	 */
	public void setStatus(FormatResultStatus status) {
		this.status = status;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public int hashCode() {
		return Objects.hash(msg, result, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		FormatterResult other = (FormatterResult) obj;
		return Objects.equals(msg, other.msg) && Objects.equals(result, other.result) && status == other.status;
	}

	@Override
	public String toString() {
		return "ParseResult [result=" + result + ", resultStatus=" + status + ", msg=" + msg + "]";
	}

}
