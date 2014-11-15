package com.example.dao.brand;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.content.Context;

public class Utility {


	public static String getDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		Date date = new Date();
		return dateFormat.format(date);
	}
	
		public static String readJsonData(String fileName,Context ctx){

			StringBuilder data = new StringBuilder();
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(
						new InputStreamReader(ctx.getAssets().open(fileName)));


				String mLine = reader.readLine();
				while (mLine != null) {
					data.append(mLine);
					mLine = reader.readLine(); 
					
				}
				
				
				
			} catch (IOException e) {
				//log the exception
			}
		
			return 	data.toString();
			
		}
	}

