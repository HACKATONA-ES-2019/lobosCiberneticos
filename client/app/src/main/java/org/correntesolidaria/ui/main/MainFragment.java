package org.correntesolidaria.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import org.correntesolidaria.R;
import org.correntesolidaria.WebViewClientOverride;

public class MainFragment extends Fragment implements IOnBackPressed{

    //private MainViewModel mViewModel;
    private WebView mWebView;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.main_fragment, container, false);


        View view = inflater.inflate(R.layout.main_fragment, container, false);

        mWebView = (WebView) view.findViewById(R.id.webViewMain);
        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Stop local links and redirects from opening in browser instead of WebView
        mWebView.setWebViewClient(new WebViewClientOverride());

        //if(CheckInternetConnection.simpleServerCheck()){
        //mWebView.loadUrl("https://www.google.com");
        mWebView.loadUrl("https://lobosciberneticos-ed171.firebaseapp.com/src/html");
        //    Toast.makeText(GlobalApplication.getAppContext(), "Versão web carregada!", Toast.LENGTH_LONG).show();
        //}
        //else {
        //    mWebView.loadUrl("file:///android_asset/www/home.html");
        //    Toast.makeText(GlobalApplication.getAppContext(), "Não foi possivel acessar o servidor. Versão local carregada!", Toast.LENGTH_LONG).show();
        //}

        //Toast.makeText(GlobalApplication.getAppContext(), "Servidor remoto: " + CheckInternetConnection.simpleServerCheck(), Toast.LENGTH_LONG).show();
        return view;
    }

    //@Override
    //public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    //    super.onActivityCreated(savedInstanceState);
    //    //mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    //    // TODO: Use the ViewModel
    //}

    @Override
    public boolean onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
            //action not popBackStack
            return true;
        } else {
            return false;
        }
    }
}
