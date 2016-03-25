package com.qingtai.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;



public class LoginActivity extends MyActivity implements OnClickListener {
	
	private Button buttonLogin;
	private Button buttonRegister;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		
		buttonLogin=(Button) findViewById(R.id.button_login);
		buttonRegister=(Button) findViewById(R.id.button_register);
		buttonLogin.setOnClickListener(this);
		buttonRegister.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.button_login:
			//Toast.makeText(LoginActivity.this,"登录功能还没有准备好。。。",Toast.LENGTH_SHORT).show();
			Intent intent=new Intent(LoginActivity.this,LoginSuccessActivity.class);
			startActivity(intent);
			break;
		case R.id.button_register:
			Toast.makeText(LoginActivity.this,"注册功能还没有准备好",Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
		
	}
	
	
	
}
