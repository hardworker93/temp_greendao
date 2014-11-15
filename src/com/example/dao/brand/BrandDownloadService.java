package com.example.dao.brand;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.IntentService;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.SystemClock;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;




public class BrandDownloadService extends IntentService {
	
	public BrandDownloadService() {
		super("BrandDownloadService");

	}
	@Override
	protected void onHandleIntent(Intent intent) {

		String response = Utility.readJsonData("json.txt", this);
		
		final GsonBuilder gsonBuilder = new GsonBuilder();
		final Gson gson = gsonBuilder.create();
		final BrandResponse branListResponse = gson.fromJson(response,BrandResponse.class);
		List<BrandResponse.BrandWrapper> brandListWrapper = new ArrayList<BrandResponse.BrandWrapper>();
		brandListWrapper = branListResponse.getBrandWrapper();
		List<Brand> brandList = new ArrayList<Brand>();
		for(BrandResponse.BrandWrapper bw : brandListWrapper){
			bw.getBrand().setLastDownloadedTime(Utility.getDateTime());
			brandList.add(bw.getBrand());
		}

		BrandDao brandDao = SingletonDatabase.getInstance(this).getDaoSeesion().getBrandDao();
		brandDao.insertOrReplaceInTx(brandList,true);

		SystemClock.sleep(5000);
		
		brandList.clear();
		brandList = brandDao.loadAll();
	}

	

}
