package dev.bibuti.nimaptest

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.bibuti.easydb.EasyDB
import dev.bibuti.nimaptest.adapters.CustomAdapter
import dev.bibuti.nimaptest.models.CatelogueCategory
import dev.bibuti.nimaptest.models.NimapResponse
import dev.bibuti.nimaptest.network.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val customAdapter = CustomAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = customAdapter

        if ((isNetworkAvailable()) and (EasyDB.getObject("db", NimapResponse::class.java) == null) ) {
            RetrofitClient.endpoints.getResponse.enqueue(object: Callback<NimapResponse?> {
                override fun onFailure(call: Call<NimapResponse?>, t: Throwable) {
                    //Handle Local Failure..
                    Toast.makeText(this@MainActivity, "Local Error", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<NimapResponse?>, response: Response<NimapResponse?>) {
                    //Handle Success..

                    if (response.isSuccessful) {
                        EasyDB.put("db", response.body())
                        customAdapter.updateData(response.body()?.catelogueCategoryList!!)
                    } else {
                        //Hanlde Api Error
                        Toast.makeText(this@MainActivity, "Api Error", Toast.LENGTH_SHORT).show()
                    }

                }
            })
        } else {

            if (EasyDB.getObject("db", NimapResponse::class.java) == null) {
                Toast.makeText(this@MainActivity, "No Internet Connection", Toast.LENGTH_SHORT).show()
            } else {
                val nimapResponse = EasyDB.getObject("db", NimapResponse::class.java) as NimapResponse
                customAdapter.updateData(nimapResponse.catelogueCategoryList)
            }

        }


    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

}
