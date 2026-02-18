package com.lostin.users.exception;

import com.lostin.users.request_response.ErrorResponse;

public class ServerError extends RuntimeException {
    String error;
    String message;

    /* For internal use only and will be appeared in logs,
        used to understand where exactly the error happened
     */
//    String errorDetails;

    public ServerError(String error, String message) {
        super(message);
        this.error = error;
        this.message = message;
    }

    public ServiceResponseException toServiceResponseException(int errorCode){
        return new ServiceResponseException(errorCode,error,message);
    }

    public ErrorResponse toErrorResponse(){
        return new ErrorResponse(error,message);
    }
}
