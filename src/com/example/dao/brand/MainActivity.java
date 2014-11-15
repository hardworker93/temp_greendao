package com.example.dao.brand;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);     

        BrandDao brandDao = SingletonDatabase.getInstance(this).getDaoSessionForUI().getBrandDao();
		Intent intent = new Intent(this, BrandDownloadService.class);
		startService(intent);
        
     
 
		
	}
}
