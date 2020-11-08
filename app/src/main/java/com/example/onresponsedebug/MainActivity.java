package com.example.onresponsedebug;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.onresponsedebug.models.Contact;
import com.example.onresponsedebug.models.ContactsResponse;
import com.example.onresponsedebug.rest.ApiClient;
import com.example.onresponsedebug.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Contact> retrievedContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.tv);

        ApiInterface apiService = ApiClient.getClient("https://api.androidhive.info/contacts/").create(ApiInterface.class);
        Call<ContactsResponse> callContacts = apiService.getPhones();
        callContacts.enqueue(new Callback<ContactsResponse>() {
            @Override
            public void onResponse(Call<ContactsResponse> call, Response<ContactsResponse> response) {
                retrievedContacts =  response.body().getContacts();
                tv.setText(retrievedContacts.get(1).getName());
            }
            @Override
            public void onFailure(Call<ContactsResponse> call, Throwable t) { }
        });
    }
}