package com.mani.kotlinsample

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView


class WebviewActivity : AppCompatActivity() {
    var mywebview: WebView? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        val tvtext: TextView = findViewById(R.id.tvtext) as TextView
        val ss: String = intent.getStringExtra("values")
        tvtext.text = ss

        mywebview = findViewById(R.id.webViewGyrix) as WebView
        val webSettings = mywebview!!.getSettings()
        webSettings.setJavaScriptEnabled(true)
        mywebview!!.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url);
                return true
            }
        })
        mywebview!!.loadUrl("http://www.influx.co.in/")
       // loadWebviewUrl(" https://apps.novocinemas.com/payment/CyberSourceRequest?cardNumber=4111111111111111&cardcvn=123&cardExpiryMonth=09&cardExpiryYear=2017&SavedcardType=1&bookinginfoid=98337&PGtoken=")
    }

    /*Webview payment call */
    private fun loadWebviewUrl(url: String) {

        try {
            mywebview!!.loadUrl(url)
            mywebview!!.getSettings().setJavaScriptEnabled(true)
            mywebview!!.clearFormData()
            mywebview!!.addJavascriptInterface(JavaScriptInterface(this), "Android")
        } catch (exception: Exception) {
            exception.printStackTrace()
        }

        mywebview!!.setWebViewClient(object : WebViewClient() {
            override fun onPageStarted(view: WebView, url: String, icon: Bitmap) {
                // TODO show you progress image

                //    Utility.showDialog(this@RechargePayment, "")
                super.onPageStarted(view, url, icon)
            }

            override fun onPageFinished(view: WebView, url: String) {
                // TODO hide your progress image
                //  Utility.dismissDialog()
                super.onPageFinished(view, url)
            }
        })

    }


    inner class JavaScriptInterface internal constructor(internal var mContext: Context) {

        @android.webkit.JavascriptInterface
        fun paymentResponse(response: String, pagename: String) {

            Log.e("Tag", "Payment Complete=$response-pagename-$pagename")

            val intent = Intent(mContext, Main2Activity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
