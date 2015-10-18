/*
 * Copyright (c) 2015-2015 by Shanghai shootbox Information Technology Co., Ltd.
 * Create: 2015/10/13 3:36:39
 * Project: ReadSd
 * File: MainActivity.java
 * Class: MainActivity
 * Module: app
 * Author: yangyankai
 * Version: 1.0
 */

package com.shootbox.readsd;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		Button btn = (Button) findViewById(R.id.button1);



		btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0)
			{
				createSDCardDir();

			}
		});
	}


	public void createSDCardDir(){

		if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
			// 创建一个文件夹对象，赋值为外部存储器的目录
			File sdcardDir =Environment.getExternalStorageDirectory();

			//得到一个路径，内容是sdcard的文件夹路径和名字
			String path=sdcardDir.getPath()+"/shootbox";
			File path1 = new File(path);
			if (!path1.exists()) {
				//若不存在，创建目录，可以在应用启动的时候创建
				path1.mkdirs();
//				setTitle("create path successful"+path);
			}
			else {
//				setTitle("exit");
				final String FILE_NAME = path+ "/007.txt";
				byte[] buf;
				String str="88log9101112";
				buf = str.getBytes();
				try
				{
					FileOutputStream fout = new FileOutputStream(FILE_NAME, true);
					BufferedOutputStream bout = new BufferedOutputStream(fout);
					bout.write(buf);
					bout.flush();
					bout.close();
				} catch (FileNotFoundException e)
				{
					Log.e("aaa", "no no");
					e.printStackTrace();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		else{
//			setTitle("false");
			return;
		}
	}

}
