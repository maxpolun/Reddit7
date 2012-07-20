package com.maxpolun.reddit7;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class LinkFragment extends Fragment {
	private static String _title = "Imgur gallery";
	private static String _url = "http://imgur.com/gallery";

	private TextView _titleView;
	private WebView _linkView;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.link, container, false);
		if (v != null) {
			_titleView = (TextView) v.findViewById(R.id.link_title);
			_titleView.setText(_title);

			_linkView = (WebView) v.findViewById(R.id.link_content);
			_linkView.setWebViewClient(new WebViewClient() {
				@Override
				public boolean shouldOverrideUrlLoading(WebView view, String url) {
					view.loadUrl(url);
					return false;
				}
			});
			WebSettings settings = _linkView.getSettings();
			settings.setJavaScriptEnabled(true);
			_linkView.loadUrl(_url);
		}
		return v;
	}
}
