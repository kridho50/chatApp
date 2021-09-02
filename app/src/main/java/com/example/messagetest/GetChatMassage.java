package com.example.messagetest;

import com.google.gson.annotations.SerializedName;

import java.util.List;
public class GetChatMassage {

    @SerializedName("limit")
    private Integer limit;
    @SerializedName("page")
    private Integer page;
    @SerializedName("totalMessage")
    private Integer totalMessage;
    @SerializedName("totalPage")
    private Integer totalPage;
    @SerializedName("messages")
    private List<MessagesDTO> messages;
    
    public static class MessagesDTO {
        @SerializedName("id")
        private String id;
        @SerializedName("body")
        private String body;
        @SerializedName("type")
        private String type;
        @SerializedName("senderName")
        private String senderName;
        @SerializedName("fromMe")
        private String fromMe;
        @SerializedName("author")
        private String author;
        @SerializedName("last_time")
        private String lastTime;
        @SerializedName("chatId")
        private String chatId;
        @SerializedName("quotedMessageId")
        private String quotedMessageId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSenderName() {
            return senderName;
        }

        public void setSenderName(String senderName) {
            this.senderName = senderName;
        }

        public String getFromMe() {
            return fromMe;
        }

        public void setFromMe(String fromMe) {
            this.fromMe = fromMe;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getLastTime() {
            return lastTime;
        }

        public void setLastTime(String lastTime) {
            this.lastTime = lastTime;
        }

        public String getChatId() {
            return chatId;
        }

        public void setChatId(String chatId) {
            this.chatId = chatId;
        }

        public String getQuotedMessageId() {
            return quotedMessageId;
        }

        public void setQuotedMessageId(String quotedMessageId) {
            this.quotedMessageId = quotedMessageId;
        }
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalMessage() {
        return totalMessage;
    }

    public void setTotalMessage(Integer totalMessage) {
        this.totalMessage = totalMessage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<MessagesDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessagesDTO> messages) {
        this.messages = messages;
    }
}
