package com.cts.exception;

import org.springframework.web.servlet.ModelAndView;

public class CustomGenericException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomGenericException() {
		// TODO Auto-generated constructor stub
	}
	
    private String errCode;
    //private String errMsg;
    private ModelAndView view;
  
    public String getErrCode() {
        return errCode;
    }
  
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
  
/*    public String getErrMsg() {
        return errMsg;
    }
  
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }*/
  
   /* public CustomGenericException(String errCode, String errMsg,ModelAndView view) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.view = view;
    }*/
    
    public CustomGenericException(String errCode, ModelAndView view) {
        this.errCode = errCode;
        this.view = view;
    }

	public ModelAndView getView() {
		return view;
	}

	public void setView(ModelAndView view) {
		this.view = view;
	}

}
