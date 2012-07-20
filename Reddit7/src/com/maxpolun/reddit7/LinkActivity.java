package com.maxpolun.reddit7;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

public class LinkActivity extends Activity {
	private String _id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.link_activity);
		Intent intent = getIntent();
		_id = intent.getStringExtra("id");

		LinkFragment frag = new LinkFragment();
		Bundle b = new Bundle();
		b.putString("id", _id);
		frag.setArguments(b);

		loadFragment(frag);
	}

	private void loadFragment(LinkFragment frag) {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction trans = fm.beginTransaction();
		trans.replace(R.id.link_frame_solo, frag);
		trans.commit();
	}
}
