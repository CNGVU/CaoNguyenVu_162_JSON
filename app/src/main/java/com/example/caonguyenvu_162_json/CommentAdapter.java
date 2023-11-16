package com.example.caonguyenvu_162_json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CommentAdapter extends ArrayAdapter<Comment> {
    Context context;
    int resource;
    ArrayList<Comment> listComment;
    public CommentAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Comment> listComment) {
        super(context, resource, listComment);
        this.context = context;
        this.resource = resource;
        this.listComment = listComment;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.layout_custom_listview,parent,false);
        Comment comment = listComment.get(position);
        TextView tv_id = convertView.findViewById(R.id.tv_id);
        tv_id.setText(comment.getId());
        TextView tv_content = convertView.findViewById(R.id.tv_content);
        tv_content.setText(comment.getContent());
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        tv_name.setText(comment.getName());
        TextView tv_email = convertView.findViewById(R.id.tv_email);
        tv_email.setText(comment.getEmail());

        return convertView;
    }
}