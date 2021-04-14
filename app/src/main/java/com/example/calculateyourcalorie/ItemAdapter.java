package com.example.calculateyourcalorie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calculateyourcalorie.RoomDataBase.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {
    private List<Item> items = new ArrayList<>();


    private OnItemIsClickListener listener;

    public class ItemHolder extends RecyclerView.ViewHolder {
        private TextView textViewFoodName, textViewCal;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            textViewFoodName = itemView.findViewById(R.id.TextView_ItemFoodName);
            textViewCal = itemView.findViewById(R.id.TextView_ItemCal);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if ( listener != null && position != RecyclerView.NO_POSITION) {
                        Toast.makeText(view.getContext(), "Item" + position + 1, Toast.LENGTH_SHORT).show();
                        listener.onItemClick(items.get(position));
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        // set item show乜
        Item currentItem = items.get(position);
        holder.textViewFoodName.setText(currentItem.getFoodname());
        holder.textViewCal.setText(String.valueOf(currentItem.getCalories()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public Item getItemAt(int position) {
        return items.get(position);
    }

    // onclick listener when click recyclerview item
    public interface OnItemIsClickListener {
        void onItemClick(Item item);
    }

    public void setOnItemClickListener(OnItemIsClickListener listener) {
        this.listener = listener;
    }
}
