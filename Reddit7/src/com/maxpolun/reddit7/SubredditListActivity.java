package com.maxpolun.reddit7;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.maxpolun.reddit7.LinkListFragment.OnLinkClickedListener;
import com.maxpolun.reddit7.SubredditListFragment.OnSubredditClickedListener;

public class SubredditListActivity extends Activity implements
		OnSubredditClickedListener, OnLinkClickedListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.subreddit_list);

	}

	private int numPanes() {
		int[] ids = { R.id.subreddit_list, R.id.link_list_frame,
				R.id.link_frame };
		int count = 0;
		for (int id : ids) {
			if (findViewById(id) != null)
				count++;
		}
		return count;
	}

	@Override
	public void onSubredditClicked(String subreddit) {
		LinkListFragment frag = new LinkListFragment();
		Bundle b = new Bundle();
		b.putString("subreddit", subreddit);
		frag.setArguments(b);
		frag.setRetainInstance(true);
		putOrReplaceFragment(frag, R.id.link_list_frame);
	}

	private void putOrReplaceFragment(Fragment frag, int frameId) {
		FragmentManager fm = this.getFragmentManager();
		FragmentTransaction trans = fm.beginTransaction();

		trans.replace(frameId, frag);
		trans.addToBackStack(null);
		trans.commit();
	}

	@Override
	public void onLinkClicked(String id) {
		if (numPanes() > 2) {
			setLinkFragment(id);
		} else {
			launchLinkActivity(id);
		}
	}

	private void launchLinkActivity(String id) {
		Intent intent = new Intent(this, LinkActivity.class);
		intent.putExtra("id", id);
		startActivity(intent);

	}

	private void setLinkFragment(String id) {
		LinkFragment frag = new LinkFragment();
		Bundle b = new Bundle();
		b.putString("link", id);
		frag.setArguments(b);
		putOrReplaceFragment(frag, R.id.link_frame);
	}
}
