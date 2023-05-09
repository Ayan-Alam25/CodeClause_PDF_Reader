package com.example.pdfreader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {
    private Context context;
    private List<File> pdfFiles;
    private OnPdfSelectListner listner;

    public MainAdapter(Context context, List<File> pdfFiles, MainActivity mainActivity) {
        this.context = context;
        this.pdfFiles = pdfFiles;
        this.listner = listner;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_item,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtName.setText(pdfFiles.get(position).getName());
        holder.txtName.setSelected(true);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.onPdfSelected(pdfFiles.get(position));
            }
        });
    }



    @Override
    public int getItemCount() {
        return pdfFiles.size();
    }
}
