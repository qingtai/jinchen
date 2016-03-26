package com.qingtai.login;

import android.os.Bundle;
import android.view.Window;

public class LoginSuccessActivity extends MyActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_loginsuccess);
	}
	

}
