package com.monika.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        final RecyclerView recyclerView=findViewById ( R.id.activity_main_recycler_view );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );

        Retrofit retrofit=new Retrofit.Builder ()
                .baseUrl ( RetrofitApiInterface.BASE_URL )
                .addConverterFactory ( GsonConverterFactory.create () ).build ();

        RetrofitApiInterface retrofitApiInterface=retrofit.create ( RetrofitApiInterface.class );

        Call<List<RetrofitModel>> call=retrofitApiInterface.getMarvels ();
        call.enqueue ( new Callback<List<RetrofitModel>> () {
            @Override
            public void onResponse(Call<List<RetrofitModel>> call, Response<List<RetrofitModel>> response) {

                List<RetrofitModel> models=response.body ();

             InformationAdapter informationAdapter= new InformationAdapter(models);
              recyclerView.setAdapter ( informationAdapter );

            }

            @Override
            public void onFailure(Call<List<RetrofitModel>> call, Throwable t) {
                Toast.makeText ( getApplicationContext (),t.getMessage (),Toast.LENGTH_SHORT).show ();

            }
        } );
    }
}
