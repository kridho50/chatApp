package com.example.messagetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ChatAdapter chatAdapter;
    SharedPreferences sharedPreferences;
    List<GetChatMassage.MessagesDTO> getChatMassages = new ArrayList<>();
    String url, token, phone;
    Api api;
    EditText massage;
    ImageView btnSend, ivRefresh;

    public static final String mypreference = "mypref";
    public static final String myUrl = "urlKey";
    public static final String myToken = "tokenKey";
    public static final String myPhone = "phoneKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        url = sharedPreferences.getString(myUrl,"");
        token = sharedPreferences.getString(myToken, "");
        phone = sharedPreferences.getString(myPhone, "");

        RecyclerView rvChat = findViewById(R.id.rv_chat);
        chatAdapter = new ChatAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        rvChat.setLayoutManager(layoutManager);
        rvChat.setAdapter(chatAdapter);
        getMessage(url, token, phone);

        ivRefresh = findViewById(R.id.iv_refresh);
        ivRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
            }
        });
        btnSend = findViewById(R.id.iv_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                massage = findViewById(R.id.et_chat);
                sendMassage(url, token, phone, massage.getText().toString());
            }
        });
    }

    private void getMessage(String path, String token, String phone) {
        api = APIClient.getClient().create(Api.class);
        Call<GetChatMassage> call =
                api.getListChat(path, token, phone);
        call.enqueue(new Callback<GetChatMassage>() {
            @Override
            public void onResponse(Call<GetChatMassage> call, Response<GetChatMassage> response) {
               setAdapter(response.body().getMessages());
            }

            @Override
            public void onFailure(Call<GetChatMassage> call, Throwable t) {

            }
        });
    }

    private void sendMassage(String path , String token, String phone, String body){
        SendMassage sendMassage = new SendMassage();
        sendMassage.setPhone(phone);
        sendMassage.setBody(body);
        massage = findViewById(R.id.et_chat);
        massage.setText("");

        api = APIClient.getClient().create(Api.class);
        Call<ChatMassage> call =
                api.sendMassage(path, token, sendMassage);
        call.enqueue(new Callback<ChatMassage>() {
            @Override
            public void onResponse(Call<ChatMassage> call, Response<ChatMassage> response) {
                GetChatMassage.MessagesDTO messagesDTO = new GetChatMassage.MessagesDTO();
                List<GetChatMassage.MessagesDTO> messagesDTOList = new ArrayList<>();
                messagesDTO.setBody(body);
                messagesDTO.setFromMe("1");
                    messagesDTOList.add(messagesDTO);
                    setAdapter(messagesDTOList);
            }
            @Override
            public void onFailure(Call<ChatMassage> call, Throwable t) {

            }
        });
    }

    private void setAdapter(List<GetChatMassage.MessagesDTO> betul) {
        Collections.reverse(betul);
        getChatMassages.addAll(betul);
        chatAdapter.setData(getChatMassages);
    }

    private void refresh() {
        getChatMassages.clear();
        chatAdapter.clearData();
        getMessage(url, token, phone);
    }

}