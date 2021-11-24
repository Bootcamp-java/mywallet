package com.rst.mywallet.dto;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.spi.Status;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.rst.mywallet.model.AccountStatus;
import com.rst.mywallet.model.Customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {

	private Customer customerId;
	private AccountStatus status;
	private T payload ;
	private Object errors;
	private Object metadata;
	
	
	public static <T> Response<T> badRequest(){
		Response<T> response = new Response<>();
		response.setStatus(AccountStatus.BAD_REQUEST);
		return response;
	}
	
	private String setStatus(AccountStatus status) {
		
		return setStatus(status); 
	}

	public static <T> Response<T> ok() {
        Response<T> response = new Response<>();
        response.setStatus(AccountStatus.OK);
        return response;
    }
	
	 public static <T> Response<T> unauthorized() {
	        Response<T> response = new Response<>();
	        response.setStatus(AccountStatus.UNAUTHORIZED);
	        return response;
	    }

	    public static <T> Response<T> validationException() {
	        Response<T> response = new Response<>();
	        response.setStatus(AccountStatus.VALIDATION_EXCEPTION);
	        return response;
	    }

	    public static <T> Response<T> wrongCredentials() {
	        Response<T> response = new Response<>();
	        response.setStatus(AccountStatus.WRONG_CREDENTIALS);
	        return response;
	    }

	    public static <T> Response<T> accessDenied() {
	        Response<T> response = new Response<>();
	        response.setStatus(AccountStatus.ACCESS_DENIED);
	        return response;
	    }

	    public static <T> Response<T> exception() {
	        Response<T> response = new Response<>();
	        response.setStatus(AccountStatus.EXCEPTION);
	        return response;
	    }

	    public static <T> Response<T> notFound() {
	        Response<T> response = new Response<>();
	        response.setStatus(AccountStatus.NOT_FOUND);
	        return response;
	    }

	    public static <T> Response<T> duplicateEntity() {
	        Response<T> response = new Response<>();
	        response.setStatus(AccountStatus.DUPLICATE_ENTITY);
	        return response;
	    }
	    
	    public ResponseError addErrorMsgToResponse(String errorMsg, Exception ex) {
	        ResponseError error = new ResponseError();
	        error.setDetails(errorMsg);
	        error.setMessage(ex.getMessage());
	        error.setTimestamp(new Date());
			return error;
	        	         	 
	    }
	    
	    
	    public Customer getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Customer customerId) {
			this.customerId = customerId;
		}

		public T getPayload() {
			return payload;
		}

		public Response setPayload(T payload) {
			this.payload = payload;
			return (Response) payload;
		}

		public Object getErrors() {
			return errors;
		}

		public void setErrors(Object errors) {
			this.errors = errors;
		}

		public Object getMetadata() {
			return metadata;
		}

		public void setMetadata(Object metadata) {
			this.metadata = metadata;
		}

		public AccountStatus getStatus() {
			return status;
		}



		@Getter
	    @Accessors(chain = true)
	    @JsonInclude(JsonInclude.Include.NON_NULL)
	    @JsonIgnoreProperties(ignoreUnknown = true)
	    public static class PageMetadata {
	        private int size;
	        private long totalElements;
	        private int totalPages;
	        private int number;

	        public PageMetadata(int size, long totalElements, int totalPages, int number) {
	            this.size = size;
	            this.totalElements = totalElements;
	            this.totalPages = totalPages;
	            this.number = number;
	        }
	    }


}
