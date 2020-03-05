package com.example.demo4.sys.error;

/**
 * @ClassName CustomException
 * @Description TODO 自定义异常类
 * @Author xzl
 * @Date
 * @Version V1.0
 **/
public class CustomException extends RuntimeException{

    /**
	 * 序列號
	 */
	private static final long serialVersionUID = 7391562782521893020L;
	private String code;
    public CustomException() {
        super();
    }
    public CustomException(String msg) {
        super(msg);
    }
    public CustomException(String code, String msg) {
        super(msg);
        this.setCode(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}


