package com.qingtai.login;

import org.json.JSONArray;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class LoginActivity extends MyActivity implements OnClickListener {
	
	private Button buttonLogin;
	private Button buttonRegister;
	private EditText inputIdText;
	private EditText inputPasswordText;
	
	
	
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
		/*********登录按钮按下******************/
		case R.id.button_login:			
			String url="http://10.0.2.2/users.json";
			RequestQueue mqueue=Volley.newRequestQueue(LoginActivity.this);
			Request request=new JsonArrayRequest(url,new Listener<JSONArray>(){

				@Override
				public void onResponse(JSONArray response) {
					/*************获取输入的用户名，密码************************/
					inputIdText=(EditText) findViewById(R.id.input_id);
					inputPasswordText=(EditText) findViewById(R.id.input_password);
					String inputId=inputIdText.getText().toString();
					String inputPassword=inputPasswordText.getText().toString();
					/******************************************************/
					
					try{
						for(int i=0;i<response.length();i++){
							/******************解析JSON数据**************************/
							JSONObject jsonObject=response.getJSONObject(i);
							String id=jsonObject.getString("id");
							String password=jsonObject.getString("password");
							/******************************************************/
							
							/***********判断输入的用户名，密码是否在users文件中****************/
							if(inputId.equals(id)&&inputPassword.equals(password)){
								Intent intent=new Intent(LoginActivity.this,LoginSuccessActivity.class);
								startActivity(intent);
								break;
							}else{
								Toast.makeText(LoginActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
							}
							/******************************************************/
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
				
			},new ErrorListener(){
				@Override
				public void onErrorResponse(VolleyError error) {
					//Log.d("TAG","服务器错误");
					Toast.makeText(LoginActivity.this,"服务器错误",Toast.LENGTH_SHORT).show();
				}				
			});
			mqueue.add(request);
			break;
		/*********注册按钮按下******************/
		case R.id.button_register:			
			Toast.makeText(LoginActivity.this,"注册功能还没有准备好",Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
		
	}
	
	
	
	
	
}
