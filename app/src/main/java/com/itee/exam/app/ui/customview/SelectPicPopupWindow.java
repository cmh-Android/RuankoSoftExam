package com.itee.exam.app.ui.customview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.itee.exam.R;
import com.itee.exam.app.ui.event.PopEvent;

import de.greenrobot.event.EventBus;


public class SelectPicPopupWindow extends PopupWindow {

	private View mMenuView;
	private TextView popTel;
	private ImageView ivTel;
	private ImageView ivSaveNumber;

	public SelectPicPopupWindow(Activity context,OnClickListener itemsOnClick) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mMenuView = inflater.inflate(R.layout.popwindow_custom_dialog, null);
		//设置SelectPicPopupWindow的View
		this.setContentView(mMenuView);
		//设置SelectPicPopupWindow弹出窗体的宽
		this.setWidth(LayoutParams.FILL_PARENT);
		//设置SelectPicPopupWindow弹出窗体的高
		this.setHeight(LayoutParams.WRAP_CONTENT);
		//设置SelectPicPopupWindow弹出窗体可点击
		this.setFocusable(true);
		//设置SelectPicPopupWindow弹出窗体动画效果
		this.setAnimationStyle(R.style.AnimBottom);
		//实例化一个ColorDrawable颜色为半透明
//		ColorDrawable dw = new ColorDrawable(0xb0000000);
		//设置SelectPicPopupWindow弹出窗体的背景
//		this.setBackgroundDrawable(dw);
		this.getBackground().setAlpha(0);
		//mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
		mMenuView.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				int height = mMenuView.findViewById(R.id.pop_layout).getTop();
				int y=(int) event.getY();
				if(event.getAction()==MotionEvent.ACTION_UP){
					if(y<height){
						dismiss();
					}
				}				
				return true;
			}
		});

		EventBus.getDefault().registerSticky(this);
		popTel = (TextView) mMenuView.findViewById(R.id.pop_tel);
		ivTel = (ImageView) mMenuView.findViewById(R.id.iv_tel);
		ivSaveNumber = (ImageView) mMenuView.findViewById(R.id.iv_save_number);
		ivTel.setOnClickListener(itemsOnClick);
		ivSaveNumber.setOnClickListener(itemsOnClick);

	}

	public void onEventMainThread(PopEvent textTel){
		popTel.setText(textTel.getText());
	}

}
