package com.ovais.tshirtsproject.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.ovais.tshirtsproject.DetailsActivity;
import com.ovais.tshirtsproject.R;
import com.ovais.tshirtsproject.model.Shirt;
import com.ovais.tshirtsproject.utils.ImageUtils;

import java.util.List;

public class ShirtAdapter extends RecyclerView.Adapter<ShirtAdapter.ViewHolder> {
    private List<Shirt> shirts;
    private OnProductClickListener myListener;

    public interface OnProductClickListener {

        void OnProductClick(int position);

    }

    public void setOnItemClickListener(OnProductClickListener myListener) {

        myListener = myListener;

    }

    //constructor
    public ShirtAdapter(List<Shirt> shirts) {
        this.shirts = shirts;
    }

    //creates the view holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rows, parent, false);

        return new ViewHolder(view);
    }

    //updates the recycler view data
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Shirt myShirts = shirts.get(position);
        holder.name.setText(myShirts.getPName());
        holder.price.setText(myShirts.getPrice());
        ImageUtils.setImage(myShirts.getPicture(), holder.image);

    }

    //return total number of items hold by adapter
    @Override
    public int getItemCount() {
        return shirts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, price;
        CircularImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.shirt_name);
            price = itemView.findViewById(R.id.shirt_price);
            image = itemView.findViewById(R.id.shirt_image);
        }

        @Override
        public void onClick(View v) {

            int position=getAdapterPosition();
            Shirt myShirts=shirts.get(position);
            Intent intent=new Intent(v.getContext(), DetailsActivity.class);
            intent.putExtra("name",myShirts.getPName());
            intent.putExtra("price",myShirts.getPrice());
            intent.putExtra("pic",myShirts.getPicture());
            intent.putExtra("desc",myShirts.getDescription());
            v.getContext().startActivity(intent);


        }
    }
}
