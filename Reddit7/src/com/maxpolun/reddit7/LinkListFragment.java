package com.maxpolun.reddit7;

import java.util.HashMap;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LinkListFragment extends ListFragment {
	private String _subreddit;
	private ArrayAdapter<String> _adapter;
	private static HashMap<String, String[]> _links;

	static {
		_links = new HashMap<String, String[]>();
		String[] fpLinks = { "cat picture", "repost", "repost", "repost" };
		_links.put("front page", fpLinks);
		String[] allLinks = { "cat picture", "circlejerk",
				"hey guys, I finally got my gf to pose nude!!!", "repost" };
		_links.put("all", allLinks);
		String[] tlLinks = { "original content", "best talk ever",
				"architechture the lost years",
				"how to write android reddit clients" };
		_links.put("techlectures", tlLinks);
	}

	public interface OnLinkClickedListener {
		void onLinkClicked(String id);
	}

	@Override
	public void setArguments(Bundle args) {
		_subreddit = args.getString("subreddit");
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setEmptyText("There seems to be nothing here");
		_adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1);
		_adapter.addAll(_links.get(_subreddit));
		setListAdapter(_adapter);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		((OnLinkClickedListener) getActivity()).onLinkClicked(_adapter
				.getItem(position));
	}
}
