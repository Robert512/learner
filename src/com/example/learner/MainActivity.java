package com.example.learner;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learner.view.SlidingMenu;



public class MainActivity extends Activity
{

	private SlidingMenu mLeftMenu ; 
	
	private ViewPager viewPager;//页卡内容  
  
    private TextView textView1,textView2,textView3;  
    private List<View> views;// Tab页面列表  

    private int currIndex = 0;// 当前页卡编号  

    private View view1,view2,view3;//各个页卡  
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		InitTextView();  
        InitViewPager();  
		
		mLeftMenu = (SlidingMenu) findViewById(R.id.id_menu);
	}
	
	public void toggleMenu(View view)
	{
		mLeftMenu.toggle();
	}

	private void InitViewPager() {  
	        viewPager=(ViewPager) findViewById(R.id.vPager);  
	        views=new ArrayList<View>();  
	        LayoutInflater inflater=getLayoutInflater();  
	        view1=inflater.inflate(R.layout.lay1, null);  
	        view2=inflater.inflate(R.layout.lay2, null);  
	        view3=inflater.inflate(R.layout.lay3, null);  
	        views.add(view1);  
	        views.add(view2);  
	        views.add(view3);  
	        viewPager.setAdapter(new MyViewPagerAdapter(views));  
	        viewPager.setCurrentItem(0);  
	        viewPager.setOnPageChangeListener(new MyOnPageChangeListener());  
   }  
	     /** 
	      *  初始化头标 
	      */  
	  
    private void InitTextView() {  
        textView1 = (TextView) findViewById(R.id.text1);  
        textView2 = (TextView) findViewById(R.id.text2);  
        textView3 = (TextView) findViewById(R.id.text3);  
        
        textView1.setTextColor(Color.parseColor("#008000"));
  
        textView1.setOnClickListener(new MyOnClickListener(0));  
        textView2.setOnClickListener(new MyOnClickListener(1));  
        textView3.setOnClickListener(new MyOnClickListener(2));  
    }  
    
    
    /**  
     *      
     * 头标点击监听 3 */  
    private class MyOnClickListener implements OnClickListener{  
        private int index=0;  
        public MyOnClickListener(int i){  
            index=i;  
        }  
        public void onClick(View v) {  
            viewPager.setCurrentItem(index);              
        }  
          
    }  
      
    public class MyViewPagerAdapter extends PagerAdapter{  
        private List<View> mListViews;  
          
        public MyViewPagerAdapter(List<View> mListViews) {  
            this.mListViews = mListViews;  
        }  
  
        @Override  
        public void destroyItem(ViewGroup container, int position, Object object)   {     
            container.removeView(mListViews.get(position));  
        }  
  
  
        @Override  
        public Object instantiateItem(ViewGroup container, int position) {            
             container.addView(mListViews.get(position), 0);  
             return mListViews.get(position);  
        }  
  
        @Override  
        public int getCount() {           
            return  mListViews.size();  
        }  
          
        @Override  
        public boolean isViewFromObject(View arg0, Object arg1) {             
            return arg0==arg1;  
        }  
    }  
  
    public class MyOnPageChangeListener implements OnPageChangeListener{  
  
     
        public void onPageScrollStateChanged(int arg0) {  
              
              
        }  
  
        public void onPageScrolled(int arg0, float arg1, int arg2) {  
              
              
        }  
  
        public void onPageSelected(int arg0) {  
           
            Toast.makeText(MainActivity.this, "您选择了"+ viewPager.getCurrentItem()+"页卡", Toast.LENGTH_SHORT).show(); 
            
            
            switch (viewPager.getCurrentItem())
			{
			case 0:
				

				textView1.setTextColor(Color.parseColor("#008000"));
				textView2.setTextColor(Color.BLACK);
				textView3.setTextColor(Color.BLACK);
				break;
			case 1:
				textView2.setTextColor(Color.parseColor("#008000"));
				textView1.setTextColor(Color.BLACK);
				textView3.setTextColor(Color.BLACK);
				break;
			case 2:
				textView3.setTextColor(Color.parseColor("#008000"));
				textView2.setTextColor(Color.BLACK);
				textView1.setTextColor(Color.BLACK);
				break;

			}
         
        }  
          
    }  


}