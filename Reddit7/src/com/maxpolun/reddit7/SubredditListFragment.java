package com.maxpolun.reddit7;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SubredditListFragment extends ListFragment {
	ArrayAdapter<String> _adapter;
	private static final String[] reddits = { "front page", "all",
			"techlectures" };

	public interface OnSubredditClickedListener {
		void onSubredditClicked(String subreddit);
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setEmptyText("No Subreddits");
		_adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1);

		_adapter.addAll(reddits);
		setListAdapter(_adapter);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		OnSubredditClickedListener listener = (OnSubredditClickedListener) getActivity();
		listener.onSubredditClicked(reddits[position]);
	}
}
