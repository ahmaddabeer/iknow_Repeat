package com.example.iknow_repeat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class myadapterr extends RecyclerView.Adapter<myadapterr.ViewHolder> implements Filterable {

    Context context;
    List<model> data;
    List<model> bakup;


    public myadapterr(Context context, List<model> data) {
        this.context = context;
        this.data = data;
        bakup = new ArrayList<>(data);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_line, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        final model flag = data.get(position);

        holder.name.setText(data.get(position).getName());
        holder.date.setText(data.get(position).getData());


        Glide.with(holder.img.getContext())
                .load(flag.getImage())
                .into(holder.img);

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,Detail.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("number",position +1);
                context.startActivity(intent);


            }
        });

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,Detail.class);
                intent.putExtra("number",position +1);
                Toast.makeText(context, "Loading...", Toast.LENGTH_SHORT).show();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);


            }
        });

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence keyword) {
            ArrayList<model> filtered = new ArrayList<>();

            if (keyword.toString().isEmpty())

                filtered.addAll(bakup);

            else {

                for (model obj : bakup) {

                    if (obj.getName().toString().toLowerCase().contains(keyword.toString().toLowerCase())) {

                        filtered.add(obj);

                    } else if (obj.getData().toString().toLowerCase().contains(keyword.toString().toLowerCase())) {

                        filtered.add(obj);

                    }


                }


            }
            FilterResults results = new FilterResults();
            results.values = filtered;
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            data.clear();
            data.addAll((ArrayList<model>) results.values);
            notifyDataSetChanged();

        }
    };


    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView img;
        TextView name, date;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
        }
    }
}
