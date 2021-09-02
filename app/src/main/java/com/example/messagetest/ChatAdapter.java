package com.example.messagetest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private Context context;
    private List<GetChatMassage.MessagesDTO> chatMessages = new ArrayList<>();

    public ChatAdapter(Context contex) {
        this.context = contex;
    }

    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent,false));
    }

    @Override
    public void onBindViewHolder( ChatAdapter.ViewHolder holder, int position) {
        GetChatMassage.MessagesDTO getChatMassage = chatMessages.get(position);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        holder.tvChat.setText(getChatMassage.getBody());
        if(getChatMassage.getFromMe().equals("1")){
            params.gravity = Gravity.END;
            holder.llParent.setGravity(Gravity.END);
            holder.llChat.setBackground(ContextCompat.getDrawable(context, R.drawable.rounded_form));

        } else {
            params.gravity = Gravity.START;
            holder.llParent.setGravity(Gravity.START);
            holder.llChat.setBackground(ContextCompat.getDrawable(context, R.drawable.chat_sender));

        }
    }

    public void setData(List<GetChatMassage.MessagesDTO> chatMessages) {
        this.chatMessages = chatMessages;
        notifyDataSetChanged();
    }

    public void clearData() {
        chatMessages.clear();
    }


    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvChat, tvDate;
        LinearLayout llParent, llChat;

        ViewHolder(View view){
            super(view);
            tvChat = view.findViewById(R.id.tv_chat);
            tvDate = view.findViewById(R.id.tv_date);
            llParent = view.findViewById(R.id.ll_parent);
            llChat = view.findViewById(R.id.ll_chat);

        }
    }
}
