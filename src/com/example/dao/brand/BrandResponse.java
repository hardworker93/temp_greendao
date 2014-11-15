package com.example.dao.brand;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class BrandResponse {
	

	@SerializedName("message")
	private String mMessage;
	@SerializedName("status")
	private String mStatus;
	
	@SerializedName("brands")
    private List<BrandWrapper> mBrandWrapper;
	
	public class BrandWrapper {
	    @SerializedName("brand")
	    private Brand mbrand;

		public Brand getBrand() {
			return mbrand;
		}

		public void setBrand(Brand mbrand) {
			this.mbrand = mbrand;
		}
	    
	}

	public String getMessage() {
		return mMessage;
	}

	public void setMessage(String message) {
		mMessage = message;
	}

	public String getStatus() {
		return mStatus;
	}

	public void setStatus(String status) {
		mStatus = status;
	}

	public List<BrandWrapper> getBrandWrapper() {
		return mBrandWrapper;
	}

	public void setBrandWrapper(List<BrandWrapper> brandWrapper) {
		mBrandWrapper = brandWrapper;
	}
	
	

	
	
	
}
